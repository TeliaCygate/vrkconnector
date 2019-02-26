package com.propentus.vrkconnector.interfaces.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.datacontract.schemas._2004._07.tekla_gis.Custodian;
import org.datacontract.schemas._2004._07.tekla_gis.Dependent;
import org.datacontract.schemas._2004._07.tekla_gis.PersonAdditionalInfo;
import org.datacontract.schemas._2004._07.tekla_gis.PersonProperties;
import org.datacontract.schemas._2004._07.tekla_gis.PersonPropertiesResult;
import org.datacontract.schemas._2004._07.tekla_gis.PersonRelations;
import org.datacontract.schemas._2004._07.tekla_gis.PersonRelationsResult;
import org.datacontract.schemas._2004._07.tekla_gis.PersonSearch;
import org.datacontract.schemas._2004._07.tekla_gis.PersonSearchResult;

import com.propentus.vrkconnector.constants.ApiUserSetting;
import com.propentus.vrkconnector.entities.GetPersonRelationsRequest;
import com.propentus.vrkconnector.entities.PersonInformation;
import com.propentus.vrkconnector.entities.PersonInformation.PersonType;
import com.propentus.vrkconnector.interfaces.PersonInformationProvider;
import com.propentus.vrkconnector.interfaces.PersonInformationProvider.ProviderType;
import com.propentus.vrkconnector.service.LoggingService;
import com.propentus.vrkconnector.service.SettingService;
import com.tekla.webservices._2015._05.person.IPerson;

/**
 * Provider to get person information from Trimble.
 */
public class TrimbleProvider extends PersonInformationProvider<IPerson> {

	private static final Log logger = LogFactory.getLog(TrimbleProvider.class);

	protected String username = "";
	protected String password = "";
	protected String key = "";
	
	
	public TrimbleProvider() {
		super();
		loadConfiguration();
		this.soapService = createSoapService();
		provider = ProviderType.TRIMBLE;
	}

	/**
	 * Load configuration for the requester api-user.
	 * Loads password, username, key and serviceUrl
	 * details from the database.
	 */
	private void loadConfiguration() {

		this.password = SettingService.getApiUserSettingValue(ApiUserSetting.TRIMBLE_PASSWORD);
		this.username = SettingService.getApiUserSettingValue(ApiUserSetting.TRIMBLE_USERNAME);
		this.key = SettingService.getApiUserSettingValue(ApiUserSetting.TRIMBLE_KEY);
		this.serviceUrl = SettingService.getApiUserSettingValue(ApiUserSetting.TRIMBLE_URL);
		
	}

	/**
	 * Fetches user information from three different Trimble API's: 
	 * GetPersonsByIdentityCode,
	 * GetPersonPropertiesByIdentityCode and 
	 * GetPersonRelationsByIdentityCode
	 * and combines data from those to one common object (PersonInformation).
	 */
	@Override
	public PersonInformation findPersonInformation(String ssn, PersonType personType, boolean getRelations) {
		
		PersonSearch personInformation = findPersonInformationBySsn(ssn);
		PersonProperties personProperties = findPersonPropertiesBySsn(ssn);
		PersonRelations personRelations = null;
		
		if (getRelations) {
			personRelations = findPersonRelationsBySsn(ssn);
		}
		
		PersonInformation personInfo = transform(personInformation, personProperties, personRelations, personType, ssn);
		
		return personInfo;
	}
	
	/**
	 * Transform information received from Trimble to PersonInformation object
	 * @param trimbleResponse
	 * @param personProperties
	 * @param personRelations
	 * @param personType
	 * @param ssn
	 * @return
	 */
	private PersonInformation transform(PersonSearch trimbleResponse, PersonProperties personProperties, PersonRelations personRelations, PersonType personType, String ssn) {
		
		PersonInformation information = new PersonInformation();		
		information.setSsn(ssn);
		information.setProvider(provider);
		information.setPersonType(personType);
		
		//	User was not found from Trimble, log error ApiLog and return information
		if (trimbleResponse == null) {
			logger.info("User not found from Trimble");
			LoggingService.setInformationFetchErrorLog(provider, ssn);
			return information;
		}
				
		information.setFirstNames(trimbleResponse.getFirstName().getValue());
		information.setSurname(trimbleResponse.getSurname().getValue());
		information.setPostalCode(trimbleResponse.getPostalCode().getValue());
		information.setPostalOffice(trimbleResponse.getPostalOffice().getValue());
		information.setStreetAddress(trimbleResponse.getStreetAddress().getValue());
		information.setFound(true);
		
		//	User was found from Trimble, log success ApiLog
		LoggingService.setInformationFetchSuccessLog(provider, ssn);
		
		//Set additional information
		information.setDeathDate(personProperties.getDeathDate().getValue());
		this.setAddressReleaseDenial(information, personProperties);
		
		if (personRelations != null) {
			if (personType.equals(PersonType.CUSTODIAN)) {
				
				for (Dependent dp : personRelations.getDependents().getValue().getDependent()) {
					
					if (dp.getIdentityCode().getValue() != "" && dp.getIdentityCode().getValue() != null) {
						PersonInformation dependant = new PersonInformation();
						dependant.setSsn(dp.getIdentityCode().getValue());
						dependant.setPersonType(PersonType.DEPENDANT);
						dependant.setRelatedPersons(null);	//	Removes relatedPersons-key from response
						dependant.setProvider(provider);	//	Shows provider in response
						information.addRelatedPerson(dependant);
					}					
				}
				
			}
			else if (personType.equals(PersonType.DEPENDANT)) {
				
				for (Custodian c : personRelations.getCustodians().getValue().getCustodian()) {
					
					PersonInformation custodian = new PersonInformation();
					custodian.setSsn(c.getIdentityCode().getValue());
					custodian.setPersonType(PersonType.CUSTODIAN);
					custodian.setRelatedPersons(null);	//	Removes relatedPersons-key from response
					custodian.setProvider(provider);	//	Shows provider in response
					information.addRelatedPerson(custodian);
				}
			}
		}
		
		return information;
	}
	
	
	/**
	 * Find basic information about person:
	 * surname, first name and address information
	 * @param ssn
	 * @return
	 */
	public PersonSearch findPersonInformationBySsn(String ssn) {
		//Get person details
		PersonSearchResult result = soapService.getPersonsByIdentityCode(key, ssn);
		
		if(result.getPersonSearches().getValue() == null || result.getPersonSearches().getValue().getPersonSearch().isEmpty()) {

			return null;
		}
		
		PersonSearch ps = result.getPersonSearches().getValue().getPersonSearch().get(0);

		return ps;	
	}
	
	/**
	 * Find relations for main person:
	 * custodians and dependents
	 * @param ssn
	 * @return
	 */
	private PersonRelations findPersonRelationsBySsn(String ssn) {
		
		//	Get relations
		PersonRelationsResult result = soapService.getPersonRelationsByIdentityCode(key, ssn);
		PersonRelations pr = result.getPersonRelations().getValue();
		
		return pr;
	}
	
	/**
	 * Find additional information from person:
	 * address release denial info and its end date
	 * @param ssn
	 * @return
	 */
	public PersonProperties findPersonPropertiesBySsn(String ssn) {
		PersonPropertiesResult result = soapService.getPersonPropertiesByIdentityCode(key, ssn);
		PersonProperties personProperties = result.getPersonProperties().getValue();
		return personProperties;
	}
	
	private void setAddressReleaseDenial(PersonInformation information, PersonProperties personProperties) {
		if(!personProperties.getSecurityRestrStartDate().getValue().equals("") && !personProperties.getSecurityRestrEndDate().getValue().equals("")) {
			information.setAddressReleaseDenial("true");
			information.setAddressReleaseDenialEndDate(personProperties.getSecurityRestrEndDate().getValue());
		}
		else {
			information.setAddressReleaseDenial("false");
			information.setAddressReleaseDenialEndDate("");
		}
	}
	
	/**
	 * Initialize Trimble person service
	 * @return
	 */
	@Override
	protected IPerson createSoapService() {
		
		IPerson service = super.createSoapService();
		Client client = ClientProxy.getClient(service);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		
		//Disable DNS check because of invalid certificate
		TLSClientParameters conf = new TLSClientParameters();
		conf.setDisableCNCheck(true);
		conf.setUseHttpsURLConnectionDefaultSslSocketFactory(true);
		
		http.setTlsClientParameters(conf);
		http.getAuthorization().setUserName(username);
		http.getAuthorization().setPassword(password);
		
		return service;
	}
	
}

package com.propentus.vrkconnector.interfaces.impl;

import java.io.StringWriter;
import javax.xml.bind.JAXBException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.tempuri.SoSoSoap;
import org.tempuri.TeeHenkilonTunnusKyselyResponse.TeeHenkilonTunnusKyselyResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.propentus.sp2.componentlibrary.utils.EntityUtil;
import com.propentus.vrkconnector.constants.ApiUserSetting;
import com.propentus.vrkconnector.entities.PersonInformation;
import com.propentus.vrkconnector.entities.PersonInformation.PersonType;
import com.propentus.vrkconnector.interfaces.PersonInformationProvider;
import com.propentus.vrkconnector.service.LoggingService;
import com.propentus.vrkconnector.service.SettingService;
import fi.vrk.xml.schema.vtjkysely.VTJHenkiloVastaussanoma;

/**
 * Provider to get person information from VRK.
 */
public class VrkProvider extends PersonInformationProvider<SoSoSoap> {

	private static final Log logger = LogFactory.getLog(VrkProvider.class);

	protected String PASSWORD = "";
	protected String USERNAME = "";
	protected String END_USER = "";
	
	public VrkProvider() {
		super();
		loadConfiguration();
		this.soapService = createSoapService();
		provider = ProviderType.VRK;
	}
	
	public VrkProvider(String s) {
		super(s);
	}
	
	/**
	 * Load configuration for the requester api-user.
	 * Loads password, username, end_user and serviceUrl
	 * details from the database.
	 */
	private void loadConfiguration() {
		
		this.PASSWORD = SettingService.getApiUserSettingValue(ApiUserSetting.VRK_PASSWORD);
		this.USERNAME = SettingService.getApiUserSettingValue(ApiUserSetting.VRK_USERNAME);
		this.END_USER = SettingService.getApiUserSettingValue(ApiUserSetting.VRK_ENDUSER);
		this.serviceUrl = SettingService.getApiUserSettingValue(ApiUserSetting.VRK_URL);

	}


	/**
	 * Creates request to VRK-service and returns PersonInformation with details from response.
	 * If PersonType is CUSTODIAN, use "HUOLTAJA-HUOLLETTAVAT" as a method name
	 * If PersonType is DEPENDANT, use "HUOLLETTAVA-HUOLTAJAT" as a method name
	 * Otherwise use "PERUSSANOMA 2" that gives only the details to that person.
	 * @param ssn
	 * @param personType
	 * @param getRelations
	 * @return
	 */
	@Override
	public PersonInformation findPersonInformation(String ssn, PersonType personType, boolean getRelations) {
		
		String soSoNimi = ""; //VRK method name, "PERUSSANOMA 2", "HUOLLETTAVA-HUOLTAJAT" or "HUOLTAJA-HUOLLETTAVAT"
		
		if (!getRelations) {
			soSoNimi = "PERUSSANOMA 2";
		}
		else if (personType.equals(PersonType.CUSTODIAN)) {
			soSoNimi = "HUOLTAJA-HUOLLETTAVAT";
		}
		else if (personType.equals(PersonType.DEPENDANT)) {
			soSoNimi = "HUOLLETTAVA-HUOLTAJAT";
		}
		
		VTJHenkiloVastaussanoma vrkResponse = doSearch(soSoNimi, ssn);
		PersonInformation personInformation = transform(vrkResponse, personType, ssn);
		
		return personInformation;
		
	}

	/**
	 * Transform information received from VRK to common response
	 * @param vrkResponse
	 * @param personType
	 * @param ssn
	 * @return
	 */
	protected PersonInformation transform(VTJHenkiloVastaussanoma vrkResponse, PersonType personType, String ssn) {
		
		PersonInformation information = new PersonInformation();
		
		VTJHenkiloVastaussanoma.Henkilo vrkUser = vrkResponse.getHenkilo();
		
		//	If user was not found, return PersonInformation with its basic info
		if (vrkUser == null) {

			logger.info("User not found.");

			information.setSsn(ssn);
			information.setPersonType(personType);
			information.setProvider(provider);
			LoggingService.setInformationFetchErrorLog(provider, ssn);	//	User was not found from VRK log error ApiLog
			return information;
		}
			
		
		VTJHenkiloVastaussanoma.Henkilo.VakinainenKotimainenLahiosoite vrkUserAddress = vrkUser.getVakinainenKotimainenLahiosoite();
		String postalCode = !Integer.toString(vrkUserAddress.getPostinumero()).equals("0") ? Integer.toString(vrkUserAddress.getPostinumero()) : "";
		String addressReleaseDenial = vrkUser.getTurvakielto().getTurvakieltoTieto().equals("1") ? "true" : "false";
		
		//	Set information
		information.setFirstNames(vrkUser.getNykyisetEtunimet().getEtunimet());
		information.setSurname(vrkUser.getNykyinenSukunimi().getSukunimi());
		information.setPostalCode(postalCode);
		information.setPostalOffice(vrkUserAddress.getPostitoimipaikkaS());
		information.setStreetAddress(vrkUserAddress.getLahiosoiteS());
		information.setSsn(vrkUser.getHenkilotunnus().getValue());
		information.setPersonType(personType);
		information.setProvider(provider);
		information.setFound(true);
		information.setDeathDate(vrkUser.getKuolintiedot().getKuolinpvm());
		information.setAddressReleaseDenial(addressReleaseDenial);
		LoggingService.setInformationFetchSuccessLog(provider, ssn);	//	User was found from VRK, log success ApiLog
		
		if (personType == null) {
			return information;
		}
		
		//	Set relatedPersons, if main person is CUSTODIAN, loop DEPENDANTS otherwise loop CUSTODIANS
		if (personType.equals(PersonType.CUSTODIAN)) {
			for (VTJHenkiloVastaussanoma.Henkilo.Huollettava huollettava : vrkResponse.getHenkilo().getHuollettava()) {
				if (!huollettava.getHenkilotunnus().isEmpty()) {
					PersonInformation dependant = new PersonInformation();
					dependant.setSsn(huollettava.getHenkilotunnus());
					dependant.setPersonType(PersonType.DEPENDANT);
					dependant.setRelatedPersons(null);	//	Removes relatedPersons-key from response
					dependant.setProvider(provider);	//	Just for debugging, shows provider in response
					information.addRelatedPerson(dependant);
				}
			}
		}
		else if (personType.equals(PersonType.DEPENDANT)) {	
			for (VTJHenkiloVastaussanoma.Henkilo.Huoltaja huoltaja : vrkResponse.getHenkilo().getHuoltaja()) {
				if (!huoltaja.getHenkilotunnus().isEmpty()) {
					PersonInformation custodian = new PersonInformation();
					custodian.setSsn(huoltaja.getHenkilotunnus());
					custodian.setPersonType(PersonType.CUSTODIAN);
					custodian.setRelatedPersons(null);	//	Removes relatedPersons-key from response
					custodian.setProvider(provider);	//	Just for debugging, shows provider in response
					information.addRelatedPerson(custodian);
				}
			}
		}
		
		return information;
	}
	
	/**
	 * Parse <VTJHenkiloVastaussanoma> from XML document, and transform it to Java Object.
	 * @param doc
	 * @return
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 * @throws JAXBException
	 */
	protected VTJHenkiloVastaussanoma getVTJHenkiloVastausSanoma(Document doc) throws TransformerFactoryConfigurationError, TransformerException, JAXBException {
		
		//Get inner element and transform back to XML
		NodeList nodes = doc.getElementsByTagName("VTJHenkiloVastaussanoma");
		Node elem = nodes.item(0);//Your Node
		StringWriter buf = new StringWriter();
		Transformer xform = TransformerFactory.newInstance().newTransformer();
		xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		xform.setOutputProperty(OutputKeys.INDENT, "yes");
		xform.transform(new DOMSource(elem), new StreamResult(buf));
		String xml = buf.toString();
		System.out.println(xml); // your string
		
		//Parse to Java Object now
		VTJHenkiloVastaussanoma response = EntityUtil.XMLtoObject(VTJHenkiloVastaussanoma.class, xml);
		return response;
	}
	
	@Override
	public SoSoSoap createSoapService() { 
		SoSoSoap service = super.createSoapService();
		Client client = ClientProxy.getClient(service);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		
		//Disable DNS check because of invalid certificate
		TLSClientParameters conf = new TLSClientParameters();
		conf.setDisableCNCheck(true);
		conf.setUseHttpsURLConnectionDefaultSslSocketFactory(true);
		http.setTlsClientParameters(conf);

		return service;
	}
	
	protected VTJHenkiloVastaussanoma doSearch(String soSoNimi, String ssn) {
		
		//Request params
		String kayttajatunnus = USERNAME;
		String salasana = PASSWORD;
		String loppukayttaja = END_USER;
		String laskutustiedot = "";
		String henkilotunnus = ssn;
		String sahkoinenAsiointitunnus = "";
		String varmenteenMyontaja = "";
		String x509Certificate = "";
		String varmenteenVoimassaolotarkistus = "";
		String varmenteenSulkulistatarkistus = "";
		String tunnistusportaali = "";
		String vara1 = "";
		VTJHenkiloVastaussanoma personDetails = new VTJHenkiloVastaussanoma();
		
		//Parse response
		try {
			
			TeeHenkilonTunnusKyselyResult response = soapService.teeHenkilonTunnusKysely(soSoNimi, kayttajatunnus, salasana, 
					loppukayttaja, laskutustiedot, henkilotunnus, 
					sahkoinenAsiointitunnus, varmenteenMyontaja, 
					x509Certificate, varmenteenVoimassaolotarkistus, 
					varmenteenSulkulistatarkistus, tunnistusportaali, vara1);
			
			String xml = EntityUtil.ObjectToXML(response);
			Document document = EntityUtil.createXMLDoc(xml);
			personDetails = getVTJHenkiloVastausSanoma(document);
			
		} catch (Exception e) {
			logger.error("Couldn't parse response from VRK", e);
		}
		
		return personDetails;
	}
	
}

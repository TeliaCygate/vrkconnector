package com.propentus.vrkconnector.processor;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.propentus.vrkconnector.constants.StatusCode;
import com.propentus.vrkconnector.entities.GetPersonRelationsRequest;
import com.propentus.vrkconnector.entities.PersonInformation;
import com.propentus.vrkconnector.entities.PersonInformation.PersonType;
import com.propentus.vrkconnector.entities.PersonsInformation;
import com.propentus.vrkconnector.entities.GetPersonRelationsRequest.Person;
import com.propentus.vrkconnector.interfaces.PersonInformationProvider;
import com.propentus.vrkconnector.service.ErrorService;
import com.propentus.vrkconnector.service.SettingService;

/**
 * ApiRequestProcessor is used to load configured providers and
 * process through the GetPersonRelationsRequest which contains
 * persons and its relatedPersons.
 */
public class ApiRequestProcessor {
	
	private List<PersonInformationProvider<?>> providers = new ArrayList<PersonInformationProvider<?>>();
	private static final Log logger = LogFactory.getLog(ApiRequestProcessor.class);
	
	public ApiRequestProcessor() {
		setConfiguredProviders();
	}
	
	/**
	 * Loop thru all of the persons that were given in request and try to find their details from providers
	 * that were configured to requester. If all details are found from the first provider, move to next person.
	 * Then we add all persons to PersonsInformation-object that is rendered as JSON to response.
	 * 
	 * @param request
	 * @return
	 */
	public PersonsInformation process(GetPersonRelationsRequest request) {
		
		PersonsInformation personsInformation = new PersonsInformation();
		for(GetPersonRelationsRequest.Person person : request.persons) {
			
			PersonInformation personInformation = new PersonInformation();
			
			//	Loop thru all configured providers and get PersonInformation from each
			for (PersonInformationProvider<?> provider : providers) {
				
				//	If all details were found, then don't try to fetch from other providers
				if (personInformation.allDetailsAreFound()) {
					break;
				}
				
				//	If mainDetails were found, it means that not all relatedPersons were found
				if (!personInformation.isFound()) {
					personInformation = provider.findPersonAndRelations(person);
				}
				
				//	If no related persons were found
				if (personInformation.getRelatedPersons() == null) {
					break;
				}
				
				for (PersonInformation relatedPerson : personInformation.getRelatedPersons()) {
					
					//	If related person is already found, go to next relatedPerson
					if (relatedPerson.isFound()) {
						break;
					}
					
					//	If related person was not found from request, go to next relatedPerson
					if (!personRequestContainsRelatedPerson(relatedPerson, person)) {
						break;
					}
					
					//	Loop thru providers again, so we can prioritize the related person search
					for (PersonInformationProvider<?> provider2 : providers) {
						if (!relatedPerson.isFound()) {
							relatedPerson.copyValues(provider2.findPersonInformation(relatedPerson.getSsn(), relatedPerson.getPersonType(), false));
						}
					}
				}
			}
			
			//	Add personInformation to response-object that is converted to JSON in response.
			personsInformation.getPersons().add(personInformation);
			
		}
		return personsInformation;
	}
	
	/**
	 * Check if related person found from provider is requested in API-call,
	 * then return true
	 * 
	 * If related person is custodian, return true
	 * 
	 * If no relatedPersons-object was given in request, return false
	 * 
	 * @param relatedPerson
	 * @param person
	 * @return
	 */
	private boolean personRequestContainsRelatedPerson(PersonInformation relatedPerson, Person person) {
		
		//	If relatedPerson is custodian, it is automatically found from request
		if (relatedPerson.getPersonType().equals(PersonType.CUSTODIAN)) {
			logger.info("Related person is CUSTODIAN, find its details from provider");
			return true;
		}
		
		//	If no relatedPersons were given
		if (person.relatedPersons == null) {
			logger.info("No related persons given in request with ssn: " + person.ssn);
			return false;
		}
		
		for (Person p : person.relatedPersons) {
			
			if (p.ssn.equalsIgnoreCase(relatedPerson.getSsn())) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Gets configured providers from db using recurringQuery parameter and requester (ApiUser).
	 * Adds configured providers to providers-list
	 */
	private void setConfiguredProviders() {
		
		//	Get providers for this ApiUser and RecurringQuery-value
		String configuredProviders = SettingService.getProviders();
		
		try {
			
			for (String provider : configuredProviders.split(";")) {
			
				//	All of the implementations need to be in the same package
				String className = "com.propentus.vrkconnector.interfaces.impl." + provider + "Provider";
				Class<?> c = Class.forName(className);
				Constructor<?> constructor = null;
				
				for (Constructor<?> ctor : c.getConstructors()) {
					
					if (ctor.getParameterCount() == 0) {
						constructor = ctor;
						break;
					}
				}
				
				Object object = constructor.newInstance();
				this.providers.add((PersonInformationProvider<?>) object);
			}
			
		} catch (Exception e) {
			
			logger.error("Error loading configured providers: " + configuredProviders, e);
			ErrorService.setStatusCode(StatusCode.INTERNAL_SERVER_ERROR);
			ErrorService.setErrorText("PersonInformationProvider not found with configured values. Please fix values before trying again.");
			throw new RuntimeException("PersonInformationProvider not found with configured values. Please fix values before trying again.");
		}
		
		logger.info("Using providers: " + this.providers);
	}
	
}

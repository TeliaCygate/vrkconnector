package com.propentus.vrkconnector.interfaces.impl;

import com.propentus.vrkconnector.entities.PersonInformation;
import com.propentus.vrkconnector.entities.PersonInformation.PersonType;
import com.propentus.vrkconnector.interfaces.PersonInformationProvider;
import com.propentus.vrkconnector.interfaces.PersonInformationProvider.ProviderType;
import com.propentus.vrkconnector.mock.utilities.PersonProviderMock;
import com.propentus.vrkconnector.service.LoggingService;
import com.tekla.webservices._2015._05.person.IPerson;

/**
 * Trimble provider for VRKConnector
 * Returns PersonInformation from PersonProviderMock that handles creating the mock data.
 */
public class TrimbleMockProvider extends PersonInformationProvider<IPerson> {
	
	public TrimbleMockProvider() {
		provider = ProviderType.TRIMBLE;
	}

	@Override
	public PersonInformation findPersonInformation(String ssn, PersonType personType, boolean getRelations) {
		PersonInformation person = PersonProviderMock.getMockData(ssn, provider);
		
		if (person.isFound())
			LoggingService.setInformationFetchSuccessLog(provider, ssn);
		else
			LoggingService.setInformationFetchErrorLog(provider, ssn);
		
		return person;
	}

}

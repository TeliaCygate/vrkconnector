package com.propentus.vrkconnector.mock.utilities;

import java.util.ArrayList;
import java.util.List;

import com.propentus.vrkconnector.entities.PersonInformation;
import com.propentus.vrkconnector.entities.PersonInformation.PersonType;
import com.propentus.vrkconnector.interfaces.PersonInformationProvider.ProviderType;

public class PersonProviderMock {
	
	private static ProviderType PROVIDER;

	private PersonProviderMock() {
		
	}
	
	public static PersonInformation getMockData(String ssn, ProviderType provider) {
		
		PROVIDER = provider;
		
		PersonInformation person = new PersonInformation();
		
		if (ssn.equals("123456A1234") || ssn.equals("987654A9876")) {
			person = getDependant(ssn, true, true);
		}
		else if (ssn.equals("123456-4567") || ssn.equals("123456-7894") || ssn.equals("123456-9872")) {
			person = getCustodian(ssn, true);
		}
		else {
			person = getDependant(ssn, false, true);
		}
		
		return person;
	}
	
	private static PersonInformation getDependant(String ssn, boolean getRelations, boolean moreDetails) {

		String firstNames = "Testi Test";
		String surname = "Testinen";
		String postalCode = "";
		String streetAddress = "";
		String postalOffice = "";
		String ard = "true";
		
		if (ssn.equals("123456A1234")) {
			firstNames = "Testaaja Testo";
			surname = "Testinen";
			postalCode = "00140";
			streetAddress = "Testikatu 10 A 4";
			postalOffice = "Testikaupunki";
			ard = "false";
		}
		else if (ssn.equals("987654A9876")) {
			firstNames = "Teemu Testi";
			surname = "Testinen";
			postalCode = "00140";
			streetAddress = "Testikatu 10 A 4";
			postalOffice = "Testikaupunki";
			ard = "false";
		}
		
		PersonInformation dependant = new PersonInformation();
		dependant.setPersonType(PersonType.DEPENDANT);
		dependant.setSsn(ssn);
		dependant.setProvider(PROVIDER);
		dependant.setRelatedPersons(null);
		
		if (moreDetails) {
			dependant.setFirstNames(firstNames);
			dependant.setSurname(surname);
			dependant.setPostalCode(postalCode);
			dependant.setPostalOffice(postalOffice);
			dependant.setStreetAddress(streetAddress);
			dependant.setAddressReleaseDenial(ard);
			dependant.setFound(true);
			dependant.setDeathDate("");
			dependant.setAddressReleaseDenialEndDate("");
		}
		
		if (getRelations) 
			dependant.setRelatedPersons(getCustodiansForDependant());
		
		return dependant;
	}
	
	private static PersonInformation getCustodian(String ssn, boolean getRelations) {
		
		String firstNames = "Tiina Testi";
		String surname = "Testaaja";
		String postalCode = "";
		String streetAddress = "";
		String postalOffice = "";
		String ard = "true";
		boolean found = true;
		
		
		if (ssn.equals("123456-4567")) {
			
			firstNames = "Kalle Testi";
			surname = "Testaaja";
			postalCode = "00140";
			streetAddress = "Testi 11";
			postalOffice = "Helsinki";
			ard = "false";
			
		}
		else if (ssn.equals("123456-7894")) {
			firstNames = "Kirsi Testi";
			surname = "Testaaja";
			postalCode = "00140";
			streetAddress = "Testi 11";
			postalOffice = "Helsinki";
			ard = "false";
		}
		else if (ssn.equals("123456-9872")) {
			firstNames = null;
			surname = null;
			postalCode = null;
			streetAddress = null;
			postalOffice = null;
			ard = null;
			found = false;
		}
		
		PersonInformation custodian = new PersonInformation();
		custodian.setPersonType(PersonType.CUSTODIAN);
		custodian.setFirstNames(firstNames);
		custodian.setSurname(surname);
		custodian.setPostalCode(postalCode);
		custodian.setPostalOffice(postalOffice);
		custodian.setStreetAddress(streetAddress);
		custodian.setSsn(ssn);
		custodian.setAddressReleaseDenial(ard);
		custodian.setProvider(PROVIDER);
		custodian.setRelatedPersons(null);
		custodian.setFound(found);
		custodian.setDeathDate("");
		custodian.setAddressReleaseDenialEndDate("");
		
		if (getRelations) 
			custodian.setRelatedPersons(getDependantsForCustodian());
		
		return custodian;
	}

	private static List<PersonInformation> getDependantsForCustodian() {
		List<PersonInformation> dependants = new ArrayList<PersonInformation>();
		PersonInformation d1 = getDependant("123456A1234", false, false);
		PersonInformation d2 = getDependant("987654A9876", false, false);
		
		dependants.add(d1);
		dependants.add(d2);
		
		return dependants;
	}

	private static List<PersonInformation> getCustodiansForDependant() {
		
		List<PersonInformation> custodians = new ArrayList<PersonInformation>();
		PersonInformation c1 = getCustodian("123456-4567", false);
		PersonInformation c2 = getCustodian("123456-7894", false);
		
		custodians.add(c1);
		custodians.add(c2);
		
		return custodians;
	}	
}

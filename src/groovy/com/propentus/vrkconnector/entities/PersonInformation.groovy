package com.propentus.vrkconnector.entities

import java.lang.reflect.Field
import com.propentus.vrkconnector.interfaces.PersonInformationProvider.ProviderType
import java.lang.reflect.Modifier;

/**
 * Describes the data model that we are using to show the person information.
 */
class PersonInformation {
	
	public static enum PersonType {
		DEPENDANT,
		CUSTODIAN
	}
	
	private String ssn
	private PersonType type
	private String surname
	private String firstNames
	private String streetAddress
	private String postalCode
	private String postalOffice
	private String deathDate
	private String addressReleaseDenial
	private String addressReleaseDenialEndDate
	private ProviderType provider
	private transient boolean found

	//	Contains related persons info
	private List<PersonInformation> relatedPersons = new ArrayList<PersonInformation>()
	
	public PersonInformation() {
		
	}
	
	public void copyValues(PersonInformation personInfo) {
		this.surname = personInfo.getSurname()
		this.firstNames = personInfo.getFirstNames()
		this.streetAddress = personInfo.getStreetAddress()
		this.postalCode = personInfo.getPostalCode()
		this.postalOffice = personInfo.getPostalOffice()
		this.deathDate = personInfo.getDeathDate()
		this.addressReleaseDenial = personInfo.getAddressReleaseDenial()
		this.addressReleaseDenialEndDate = personInfo.getAddressReleaseDenialEndDate()
		this.found = personInfo.isFound()
		this.provider = personInfo.getProvider()
	}
	
	public String getSsn() {
		return ssn;
	}
	
	public String setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstNames() {
		return firstNames;
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPostalOffice() {
		return postalOffice;
	}

	public void setPostalOffice(String postalOffice) {
		this.postalOffice = postalOffice;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public String getAddressReleaseDenial() {
		return addressReleaseDenial;
	}

	public void setAddressReleaseDenial(String addressReleaseDenial) {
		this.addressReleaseDenial = addressReleaseDenial;
	}

	public List<PersonInformation> getRelatedPersons() {
		return relatedPersons;
	}

	public void setRelatedPersons(
			List<PersonInformation> relatedPersons) {
		this.relatedPersons = relatedPersons;
	}
			
	public void addRelatedPerson(PersonInformation person) {
		this.relatedPersons.add(person);
	}
			
	public String getAddressReleaseDenialEndDate() {
		return addressReleaseDenialEndDate;
	}

	public void setAddressReleaseDenialEndDate(String addressReleaseDenialEndDate) {
		this.addressReleaseDenialEndDate = addressReleaseDenialEndDate;
	}
	
	public PersonType getPersonType() {
		return type;
	}
	
	public void setPersonType(PersonType type) {
		this.type = type;
	}
	
	public ProviderType getProvider() {
		return provider;
	}

	public void setProvider(ProviderType provider) {
		this.provider = provider;
	}
	
	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}
	
	/**
	 * Check if all of the details are found
	 * @return
	 */
	public boolean allDetailsAreFound() {
		
		if (!this.isFound())
			return false
		
		for (PersonInformation person : this.relatedPersons) {
			if (!person.isFound())
				return false
		}
		
		return true
		
	}
	
	/**
	 * Get parameters for logging
	 * @return
	 */
	public String getParameters() {
		Field[] fields = this.getClass().getDeclaredFields()
		
		String parameters = ""
		
		for(Field f : fields){
			
			boolean isTransient = Modifier.isTransient(f.getModifiers());
			
			if (isTransient)
				break
				
			parameters += f.getName() + ","
		}
		
		return parameters
	}
}

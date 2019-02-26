package com.propentus.vrkconnector.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Request object for getPersonRelations method. Parsed from JSON request.
 */
public class GetPersonRelationsRequest {
	
	public boolean recurringQuery = true;
	public List<Person> persons = new ArrayList<Person>();
	
	public class Person {
		public PersonInformation.PersonType type;
		public String ssn;
		
		public List<Person> relatedPersons = new ArrayList<Person>();
	}
	
}

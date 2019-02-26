package com.propentus.vrkconnector.entities

import groovy.json.JsonBuilder

/**
 * Main response object returned by GetPersonRelations method.
 */
class PersonsInformation {
	
	List<PersonInformation> persons = new ArrayList<PersonInformation>();	
}

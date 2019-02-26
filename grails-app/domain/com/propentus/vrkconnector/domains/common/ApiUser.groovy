package com.propentus.vrkconnector.domains.common

/**
 * Defines the structure of the ApiUser
 *
 * Sha1 is used to authenticate the user using client certificate.
 */
class ApiUser {
	
	String sha1
	String organization
	List<Setting> settings

	static transients = ['settings']
	
    static constraints = {
    }
}

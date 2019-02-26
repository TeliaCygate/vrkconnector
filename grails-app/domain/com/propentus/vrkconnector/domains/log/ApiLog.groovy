package com.propentus.vrkconnector.domains.log

import com.propentus.vrkconnector.domains.common.ApiUser
import com.propentus.vrkconnector.interfaces.PersonInformationProvider.ProviderType

/**
 * ApiLog is used to log queries that are done to the API
 */
class ApiLog {
	
	ApiUser apiUser
	Date dateCreated
	String ssn
	String parameters
	ProviderType provider
	Boolean success
	int requestId

    static constraints = {
		parameters(nullable: true)
    }
}

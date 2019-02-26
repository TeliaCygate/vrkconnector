package com.propentus.vrkconnector.domains.common

/**
 * Model to setting
 */
class Setting {

	String name
	String value
	Boolean global = false

	static hasMany = [apiUsers: ApiUser]

	static constraints = {
    }
}

package com.propentus.vrkconnector.service

import com.propentus.vrkconnector.constants.StatusCode

/**
 * Contains information about this request's errors.
 * 
 * When error is thrown somewhere in program that terminates execution, you give error and statusCode
 * to ErrorService. Then we use those informations to render response to requester.
 */
class ErrorService {
	
	static scope = "request"
	
	private static String error = "Something went wrong."
	private static StatusCode statusCode = StatusCode.INTERNAL_SERVER_ERROR
	
	public static void setErrorText(String error) {
		this.error = error
	}
	
	public static String getError() {
		return error
	}
	
	public static void setStatusCode(StatusCode code) {
		statusCode = code
	}
	
	public static StatusCode getStatusCode() {
		return statusCode
	}
}

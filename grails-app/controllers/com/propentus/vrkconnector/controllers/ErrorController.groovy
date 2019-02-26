package com.propentus.vrkconnector.controllers

import com.propentus.vrkconnector.constants.StatusCode
import com.propentus.vrkconnector.entities.api.ErrorResponse
import com.propentus.vrkconnector.service.ErrorService

/**
 * If error is caught while running the program, it gets sent here.
 * ErrorService is used to get correct status code, description of 
 * status code and error that was thrown.
 */
class ErrorController {

    def index() {
		
    	//	Set response to JSON
		response.contentType = "application/json"
		
		//	Get StatusCode that is given to ErrorService in this request
		//	If error is unexpected, StatusCode defaults to INTERNAL_SERVER_ERROR
		StatusCode sc = ErrorService.getStatusCode()
		
		//	Set StatusCode.code to response.status so requester gets the right status code
		response.status = sc.code
		
		//	Build new ErrorResponse to show as a response
		render new ErrorResponse(sc.code + " " + sc.description, ErrorService.getError()).toJson()
		return false
	}
}

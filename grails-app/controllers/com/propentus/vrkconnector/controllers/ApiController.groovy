package com.propentus.vrkconnector.controllers

import com.propentus.vrkconnector.service.LoggingService
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonElement
import com.propentus.vrkconnector.entities.PersonInformation
import com.propentus.vrkconnector.entities.PersonsInformation
import com.propentus.vrkconnector.entities.api.ErrorResponse

import grails.converters.JSON
import groovy.json.JsonSlurper

import com.propentus.vrkconnector.processor.ApiRequestProcessor
import com.propentus.vrkconnector.utilities.ResponseBuilder

/**
 * ApiController contains personRelations-API and loggingStatistics-API
 * 
 * Extends ApiInterceptor which handles authentication and testing of data if its valid.
 */
class ApiController extends ApiInterceptorController {

	/**
	 * Fetches person information from configured providers
	 * Processes data to PersonsInformation-object and then renders it
	 * back to requester as JSON. For example:
	 * 
	 * Input:
	 * 	{
			"recurringQuery": "true",
			"persons": [
				{
					"type": "CUSTODIAN",
					"ssn": "123456-4567"
				}
			]
		}
	 * 
	 * Output:
	 * 	{
			"persons": [
				{
					"ssn": "123456-4567",
					"type": "CUSTODIAN",
					"surname": "Testaaja",
					"firstNames": "Kalle Testi",
					"streetAddress": "Testi 11",
					"postalCode": "00140",
					"postalOffice": "Helsinki",
					"deathDate": "",
					"addressReleaseDenial": "false",
					"addressReleaseDenialEndDate": "",
					"relatedPersons": [
						{
							"ssn": "123456A1234",
							"type": "DEPENDANT"
						},
						{
							"ssn": "987654A9876",
							"type": "DEPENDANT"
						}
					]
				}
			]
		}
	 * @return
	 */
	def getPersonRelations() {

		ApiRequestProcessor processor = new ApiRequestProcessor()
		PersonsInformation personsInformation = processor.process(requestObj)
		
		//Render response back to client as JSON
		render ResponseBuilder.buildResponse(personsInformation)		
	}
	
	/**
	 * Fetches ApiLogging-data from DB using certificate in request
	 * 
	 * If certificate-value is given in JSON-request, we try to fetch ApiUser using that.
	 * If ApiUser is found, set it to LoggingService so we get its ApiLogs instead of the main requester.
	 * 
	 * Returns full count of ApiLogs for requester-ApiUser
	 * and also returns ApiLogs for different providers
	 * 
	 * Input:
	 * 	{
			"startDate": "2016-06-20 08:04:57",
			"endDate": "2017-09-20 08:04:57",
			"certificate": ""
		}
	 * 
	 * Output:
	 * 	{
			"count": "9",
			"providersLogs": [
				{
					"provider": "VRK",
					"successCount": "3",
					"failCount": "0"
				},
				{
					"provider": "TRIMBLE",
					"successCount": "6",
					"failCount": "0"
				}
			]
		}
	 * @return
	 */
	def getLoggingStatistics() {		
		render ResponseBuilder.buildResponse(LoggingService.getLoggingStatistics(logsRequestObj))
	}
}

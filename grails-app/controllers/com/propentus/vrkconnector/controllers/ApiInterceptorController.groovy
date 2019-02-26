package com.propentus.vrkconnector.controllers

import com.google.gson.Gson
import com.propentus.vrkconnector.domains.common.ApiUser
import com.propentus.vrkconnector.entities.GetLogsRequest
import com.propentus.vrkconnector.entities.GetPersonRelationsRequest;
import com.propentus.vrkconnector.entities.GetPersonRelationsRequest.Person
import com.propentus.vrkconnector.entities.PersonInformation.PersonType
import com.propentus.vrkconnector.entities.PersonInformation;
import com.propentus.vrkconnector.entities.api.ErrorResponse
import com.propentus.vrkconnector.service.SettingService
import com.propentus.vrkconnector.service.LoggingService
import com.propentus.vrkconnector.security.CertificateUtil
import com.propentus.vrkconnector.constants.SystemSetting

import groovy.json.JsonSlurper

import java.security.cert.X509Certificate

import javax.servlet.http.HttpServletRequest

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

/**
 * Interceptor for all ApiController actions. Request can be parsed and error messages can be returned here
 */
class ApiInterceptorController {
	
	private static final Log logger = LogFactory.getLog(this)
	
	static scope = "request"
	
	GetPersonRelationsRequest requestObj
	GetLogsRequest logsRequestObj
	
	public ApiUser activeUser
	
    def beforeInterceptor = {
		
		logger.info("Got request to action: " + actionName)
		
		response.contentType = "application/json"
		
		/**
		 * Find out what style of certificate check we are using.
		 * 
		 * If value of Setting.LOAD_BALANCER_CERTIFICATE_CHECK is true:
		 * it means that the certificate information comes from the loadbalancer (HAProxy) in a "X-SSL-Client-SHA1" header.
		 * 
		 * Otherwise it comes as a "javax.servlet.request.X509Certificate" attribute in request.
		 * 
		 */
		
		String SHA1;
		boolean loadbalancerCertificateCheck = Boolean.parseBoolean(
			SettingService.getGlobalSettingValue(SystemSetting.LOAD_BALANCER_CERTIFICATE_CHECK))
		
		if (loadbalancerCertificateCheck) {
			SHA1 = request.getHeader("X-SSL-Client-SHA1")
			
			if (SHA1 == null) {
				logger.error("No certificate found from request")
				response.status = 401
				render new ErrorResponse("401 Unauthorized", "No certificate found from request").toJson()
				return false
			}
		} 
		
		else {
			//	Get certificate from request and test if its null
			X509Certificate cert = CertificateUtil.getClientCertificateFromHttpRequest((HttpServletRequest) request)
			
			if (cert == null) {
				logger.error("No certificate found from request")
				response.status = 401
				render new ErrorResponse("401 Unauthorized", "No certificate found from request").toJson()
				return false
			}
			
			//	Get SHA1-fingerprint from certificate so we can identify ApiUser
			SHA1 = CertificateUtil.getFingerprint(cert)
		}
		
		activeUser = ApiUser.findBySha1(SHA1)
		
		if (!activeUser) {
			logger.error("Couldn't find matching user for certificate: ${SHA1}")
			response.status = 401
			render new ErrorResponse("401 Unauthorized", "Couldn't find matching user for certificate: ${SHA1}").toJson()
			return false
		}
		
		if (!SettingService.settingsConfigured(activeUser)) {
			logger.error("No settings configured for user")
			response.status = 500
			render new ErrorResponse("500 Internal Server Error", "No settings configured for user").toJson()
			return false
		}
		
		String body = request.reader.text	// Get JSON content from body
		
		if (!body) {
			response.status = 400
			render new ErrorResponse("400 Bad Request", "No body found from the request").toJson()
			return false
		}
		
		if (actionName.equals("getPersonRelations")) {
		
			//Try to parse request
			Gson parser = new Gson()
			try {
				requestObj = parser.fromJson(body, GetPersonRelationsRequest.class)
				
				boolean validationError = false
				
				//Validate person type input
				for(Person person : requestObj.persons) {
					if(person.type == null) {
						validationError = true
						break;
					}
				}
				if(validationError) {
					response.status = 400
					render new ErrorResponse("400 Bad Request", "Invalid person type received. Correct values are: 'DEPENDANT' or 'CUSTODIAN'").toJson()
					return false
				}
			}
			catch(Exception e) {
				logger.error("Couldn't parse request received", e)
				
				response.status = 400
				render new ErrorResponse("400 Bad Request", "Invalid request received").toJson()
				return false
			}
			
			if(!checkSsnValidity(requestObj)) {
				response.status = 400
				render new ErrorResponse("400 Bad Request", "Empty SSN found from request").toJson()
				return false;
			}
			
			//	Sets ApiUser and recurringQuery for this request so we don't need to worry about those in method calls
			SettingService.setApiUser(activeUser)
			SettingService.setRecurringQuery(requestObj.recurringQuery)
		}
		else {
			Gson parser = new Gson()
			
			try {
			
				logsRequestObj = parser.fromJson(body, GetLogsRequest.class)
				
				if (logsRequestObj.certificate) {
					activeUser = ApiUser.findBySha1(logsRequestObj.certificate)
					
					if (!activeUser) {
						response.status = 401
						render new ErrorResponse("401 Unauthorized", "Couldn't find matching user for certificate: ${SHA1}").toJson()
						return false
					}
				}
					
			} catch (Exception e) {
				 logger.error("Couldn't parse request received", e)
				 response.status = 400
				 render new ErrorResponse("400 Bad Request", "Invalid request received.").toJson()
				 return false
			}
		}
		
		//	Set user for logging service
		//	Also set requestId that combines fetches from external person information services to each other.
		LoggingService.setApiUser(activeUser)
		LoggingService.setRequestId()
	}
	
	/**
	 * Check request for empty SSN's
	 * @return
	 */
	boolean checkSsnValidity(GetPersonRelationsRequest request) {
		
		boolean valid = true;
		request.persons.each {
			
			List<String> ssns = new ArrayList<String>()
			
			if (it.ssn == null || "".equals(it.ssn) || !it.ssn) {
				valid = false
				return
			}
			
			if (it.relatedPersons) {

				it.relatedPersons.each { ap ->
					if(it.ssn == null || "".equals(it.ssn) || !it.ssn) {
						valid = false
						return
					}
				}
			}		
		}
		
		return valid
	}
}

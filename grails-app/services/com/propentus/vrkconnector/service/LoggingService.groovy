package com.propentus.vrkconnector.service

import com.propentus.vrkconnector.domains.common.ApiUser
import com.propentus.vrkconnector.domains.log.ApiLog
import com.propentus.vrkconnector.entities.ApiLogs
import com.propentus.vrkconnector.entities.GetLogsRequest
import com.propentus.vrkconnector.entities.ProviderLog
import com.propentus.vrkconnector.interfaces.PersonInformationProvider.ProviderType
import grails.transaction.Transactional
import java.text.DateFormat
import java.text.SimpleDateFormat
import com.propentus.vrkconnector.constants.StatusCode
import com.propentus.vrkconnector.entities.PersonInformation

/**
 * Service for logging API-requests.
 * 
 * Contains methods for fetching ApiLogs from DB
 * and setting of the ApiLogs.
 */
@Transactional
class LoggingService {
	
	static scope = "request"

	private static ApiUser apiUser
	private static int requestId
	
    public static void setApiUser(ApiUser apiUser) {
		this.apiUser = apiUser;
	}

	/**
	 * Create success log for provider data fetch
	 * @param provider
	 * @param ssn
	 */
	public static void setInformationFetchSuccessLog(ProviderType provider, String ssn) {
		
		ApiLog al = new ApiLog()
		al.apiUser = apiUser
		al.success = true
		al.provider = provider
		al.ssn = ssn
		al.parameters = new PersonInformation().getParameters()
		al.requestId = requestId
		al.save()	
		
	}

	/**
	 * Create error log for provider data fetch
	 * @param provider
	 * @param ssn
	 */
	public static void setInformationFetchErrorLog(ProviderType provider, String ssn) {
		ApiLog al = new ApiLog()
		al.apiUser = apiUser
		al.success = false
		al.provider = provider
		al.requestId = requestId
		al.ssn = ssn
		al.save()
	}

	/**
	 * Returns count of logs found for requester (ApiUser)
	 * 
	 * Parses startDate and endDate from the request
	 * If something went wrong when parsing dates, set error message and StatusCode for ErrorService
	 * Otherwise do a query to DB and find out how many logs are between startDate and endDate
	 * And also do queries for different provider statistics
	 * 
	 * @param logRequest
	 * @return
	 */
	public static ApiLogs getLoggingStatistics(GetLogsRequest logRequest) {
		
		String startDate = logRequest.startDate
		String endDate = logRequest.endDate
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
		Date start
		Date end
		
		try {
			start = df.parse(startDate)
			end = df.parse(endDate)
		} catch (Exception e) {
			ErrorService.setStatusCode(StatusCode.BAD_REQUEST)
			ErrorService.setErrorText("Parsing error with given dates: '${ startDate }', '${ endDate }'. Right format for dates is: 'yyyy-MM-dd HH:mm:ss'")
			throw new RuntimeException("Parsing error with given dates: '${ startDate }', '${ endDate }'. Right format for dates is: 'yyyy-MM-dd HH:mm:ss'")
		}
		
		//	Find count of all logs for ApiUser
		String logCount = ApiLog.findAllByApiUserAndDateCreatedBetween(apiUser, start, end).size().toString()
		
		//	Create new instance of ApiLogs and populate it
		ApiLogs al = new ApiLogs()
		al.count = logCount
		
		for (ProviderType pt : ProviderType.values()) {
			
			String failCount = ApiLog.findAllByApiUserAndDateCreatedBetweenAndSuccessAndProvider(apiUser, start, end, false, pt).size().toString()
			String successCount = ApiLog.findAllByApiUserAndDateCreatedBetweenAndSuccessAndProvider(apiUser, start, end, true, pt).size().toString()
			
			ProviderLog pl = new ProviderLog()
			pl.provider = pt
			pl.failCount = failCount
			pl.successCount = successCount
			al.providersLogs.add(pl)
		}
		
		return al
    }
	
	/**
	 * Find the highest requestId from DB and add 1 to it to get the next requestId
	 * @return
	 */
	public static Integer setRequestId() {
		
		Integer requestId = ApiLog.createCriteria().get {
			projections {
				max "requestId"
			}
		} as Integer
	
		if (!requestId) {
			requestId = 0
		}
		
		this.requestId = requestId + 1
	}
}

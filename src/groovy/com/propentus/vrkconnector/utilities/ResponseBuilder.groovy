package com.propentus.vrkconnector.utilities

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.propentus.vrkconnector.entities.ApiLogs
import com.propentus.vrkconnector.entities.PersonInformation
import com.propentus.vrkconnector.entities.PersonsInformation
import groovy.json.JsonBuilder

class ResponseBuilder {
	
	/**
	 * Build final JSON response for client
	 * @param persons
	 * @return
	 */
	public static String buildResponse(Object o) {
		
		//Convert to JSON with pretty printing enabled
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		return gson.toJson(o)
	}
}

package com.propentus.vrkconnector.entities.api

class ErrorResponse {

	public String status
	public String message
	
	public ErrorResponse(String status, String message) {
		this.status = status
		this.message = message
	}
	
	public String toJson() {
		return """
				{
					"status": "${status}",
					"message": "${message}"
				}"""
	}
}

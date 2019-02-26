package com.propentus.vrkconnector.constants;

/**
 * Enum-class that contains information about the status codes that we need.
 * Contains code (200, 400, 401..) and description ("OK", "Bad Request"..)
 */
public enum StatusCode {
	OK(200, "OK"),
	BAD_REQUEST(400, "Bad Request"),
	UNAUTHORIZED(401, "Unauthorized"),
	FORBIDDEN(403, "Forbidden"),
	NOT_FOUND(404, "Not Found"),
	INTERNAL_SERVER_ERROR(500, "Internal Server Error");
	
	private int code;
	private String description;
	
	StatusCode(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getStatusCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
}

package com.propentus.vrk.connector.exception;

/**
 * Generic VRKConnector configuration error
 */
public class ConfigurationException extends Exception {
	
	private static final long serialVersionUID = -5611655324626584782L;

	public ConfigurationException(String message) {
		super(message);
	}
	
}

package com.propentus.vrkconnector.controllers

/**
 * Simple controller that is used to check if application is alive
 */
class PingController {

    def index() {
		render "pong"
	}
	
	/**
	 * Render current application version, read from application.properties file.
	 * @return
	 */
	def version() {
		def version = grails.util.Metadata.current.'app.version'
		String resp = "Version: ${version} <br>"
		render resp
	}
	
}

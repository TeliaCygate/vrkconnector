package com.propentus.vrkconnector.controllers

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory


class ConfigurationInterceptorController {
	
	private static final Log logger = LogFactory.getLog(this)

	def beforeInterceptor = {
		
		if (!session.getAttribute("authed")) {
			logger.warn("User not authenticated")
			redirect(controller: 'login', action: 'index', params: [forbidden: true])
			return false;
		}
	}
}

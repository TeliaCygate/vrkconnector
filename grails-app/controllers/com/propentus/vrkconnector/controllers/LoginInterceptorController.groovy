package com.propentus.vrkconnector.controllers

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

/**
 * Interceptor handles checking if user is authenticated or not
 * 
 * Index- and auth-action doesn't need login checks because they
 * are supposed to be used before login
 * 
 * If user is trying to get to some other action without authentication
 * he is redirected to login/index with forbidden message.
 */
class LoginInterceptorController {

	private static final Log logger = LogFactory.getLog(this)

    def beforeInterceptor = {
				
		if (!actionName.equals("index") && !actionName.equals("auth")) {
			if (!session.getAttribute("authed")) {
				logger.warn("User not authenticated")
				redirect(controller: 'login', action: 'index', params: [forbidden: true])
				return false
			}
		}
	}
}

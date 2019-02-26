package com.propentus.vrkconnector.controllers

import com.propentus.vrkconnector.service.SettingService
import com.propentus.vrkconnector.constants.SystemSetting

/**
 * Handles login and logout for configuration UI.
 * If user isn't logged in, he gets always redirected to login page.
 * 
 * Authentication requirement is only in configuration UI, in API there is only
 * client certificate authentication.
 */
class LoginController extends LoginInterceptorController {
	
	/**
	 * Renders login view for user.
	 * 
	 * Contains username- and password input for login.
	 * 
	 * If user tries to get into configuration UI without authentication
	 * he is greeted with forbidden message.
	 * 
	 * If user tries to login, but his credentials are wrong, he is
	 * given error message that tells him about wrong credentials.
	 * 
	 * @return
	 */
    def index() {}
	
	/**
	 * Checks if given credentials are correct.
	 * 
	 * Takes username and password as a parameter from request.
	 * Compares given values to values from database.
	 * 
	 * If username and password are correct, set authed-parameter to session
	 * and redirect user to configuration/index
	 * 
	 * Otherwise redirect user back to login/index with error-parameter that
	 * renders error message for user.
	 * @return
	 */
	def auth() {
		
		String username = params.username
		String password = params.password
		
		String configUsername = SettingService.getGlobalSettingValue(SystemSetting.CONFIGURATION_USERNAME)
		String configPassword = SettingService.getGlobalSettingValue(SystemSetting.CONFIGURATION_PASSWORD)
		
		if (username.equals(configUsername) && password.equals(configPassword)) {
			session.setAttribute("authed", true)
			redirect(controller: 'configuration', action: 'index')
			return
		}
		else {
			redirect(controller: 'login', action: 'index', params: [error: true])
			return
		}
	}
	
	/**
	 * Logout-action that removes authed-attribute from session to mark
	 * that user is logged out.
	 * 
	 * Redirects user to login/index with logout-parameter that
	 * renders logout success notification.
	 * @return
	 */
	def logout() {
		session.removeAttribute("authed")
		redirect(controller: 'login', action: 'index', params: [logout: true])
		return
	}
}

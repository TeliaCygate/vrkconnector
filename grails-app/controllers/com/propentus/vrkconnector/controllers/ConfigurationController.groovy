package com.propentus.vrkconnector.controllers

import com.propentus.vrkconnector.configuration.ConfigurationLoader;
import com.propentus.vrkconnector.domains.common.ApiUser
import com.propentus.vrkconnector.domains.common.Setting
import com.propentus.vrkconnector.service.SettingService

import com.propentus.vrkconnector.constants.SettingKey
import com.propentus.vrkconnector.constants.SystemSetting
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

import java.security.cert.X509Certificate

import org.springframework.web.multipart.commons.CommonsMultipartFile

import com.propentus.vrkconnector.security.CertificateUtil

/**
 * Contains configuration-related methods
 * 
 * Changing settings,
 * adding ApiUser's and
 * adding SHA1 for ApiUser with certificate upload
 */
class ConfigurationController extends ConfigurationInterceptorController {

	private static final Log logger = LogFactory.getLog(this)

	/**
	 * Main page for configuration.
	 * Gets global settings from database (username, password)
	 * 
	 * Get all ApiUser's and their settings.
	 * @return
	 */
    def index() {
		
		//	Get global settings
		List<SystemSetting> globalSettings = SettingService.getGlobalSettings()
		
		List<ApiUser> users = ApiUser.list(sort: 'organization')
		
		for (ApiUser au : users) {
			au.settings = SettingService.getApiUserSettings(au)
		}
		
		return [globalSettings: globalSettings, apiUsers: users]
	}
	
	/**
	 * Change setting for user, if setting with given name and value
	 * is not found, create new one
	 * @return
	 */
	def changeSetting() {
		
		try {
			
			String settingValue = params.value.trim()
			String oldValue = params.oldValue
			String userId = params.userId
			String settingName = params.setting
			ApiUser user = ApiUser.get(userId)
			
			Setting setting = Setting.findOrCreateByNameAndValue(settingName, settingValue)
			Setting oldSetting = Setting.findByNameAndValue(settingName, oldValue)
			
			if (user) {
				
				if (oldSetting) {
					oldSetting.removeFromApiUsers(user)

					if (oldSetting.apiUsers.isEmpty()) {
						oldSetting.delete()
					} 
				}
				
				setting.addToApiUsers(user)
				setting.save()
			}
			
		} catch (Exception e) {
			logger.error("Something went wrong when changing setting: " + params.setting, e)
			response.status = 400
			render "FAIL"
			return false
		}
		
		render "OK"
	}
	
	/**
	 * Change global settings like GUI username and password
	 * @return
	 */
	def changeGlobalSetting() {
		
		try {
			
			String settingValue = params.value.trim()
			String settingName = params.setting
			
			Setting setting = Setting.findOrCreateByName(settingName)
			setting.value = settingValue
			setting.save()
			
		} catch (Exception e) {
			logger.error("Something went wrong when changing global setting", e)
			response.status = 400
			render "FAIL"
			return
		}
		
		render "OK"
	}
	
	/**
	 * Get certificate from params, cast it to X509Certificate
	 * and get its fingerprint using CertificateUtil.
	 * 
	 * If everything is ok, redirect to configuration/index and open ApiUser-tab
	 * 
	 * Otherwise redirect to configuration/index and show error message
	 * @return
	 */
	def setFingerprint() {
		
		//	Get information from params
		String userId = params.userId
		CommonsMultipartFile cmf = params.certificate
		
		//	Convert X509Certificate from CommonsMultipartFile
		X509Certificate cert = CertificateUtil.getCertificateFromCommonsMultipartFile(cmf)
		
		//	Get fingerprint from certificate
		String fingerprint = CertificateUtil.getFingerprint(cert)
		
		ApiUser apiUser = ApiUser.findBySha1(fingerprint)
		
		//	Find user to which certificate was uploaded
		ApiUser user = ApiUser.get(userId)
		
		//	If apiUser is already found with fingerprint
		if (apiUser) {
			flash.errorMessage = "User \"${ apiUser.organization }\" already has fingerprint \"${ fingerprint }\""
			redirect(action: 'index', params: [tab: "apiuser", user: user.id])
			return
		}
		
		//	Set new fingerprint to user's sha1
		user.sha1 = fingerprint
		
		flash.successMessage = "Changing of fingerprint was successful"
		
		redirect(action: 'index', params: [tab: "apiuser", user: user.id])
	}
	
	/**
	 * Creates new ApiUser to system.
	 * 
	 * Gets organization name as a parameter and then creates a new ApiUser.
	 * 
	 * Redirects user back to ApiUser-list with just created ApiUser opened
	 * so user can give configurations to new ApiUser.
	 * 
	 * @return
	 */
	def newUser() {
		
		String organization = params.organization
		ApiUser user = new ApiUser()
		user.organization = organization
		user.sha1 = ""
		user.save()
		
		redirect(action: 'index', params: [tab: "apiuser", user: user.id ])
	}
	
	def validateView() {
		return[users: ApiUser.all]
	}
	
	def validate() {
		int orgId = Integer.parseInt(params.orgId)
		String provider = params.provider
		
		ConfigurationLoader loader = new ConfigurationLoader()
		try {
			loader.getConfigurationGroup(SettingKey.CATEGORY_XROAD)
		}
		catch(Exception e) {
			logger.error("Something went wrong", e)
			render "VALIDATE FAILED!"
			return
		}
		render "Configurations OK!"
	}
}

package com.propentus.vrkconnector.service

import java.util.Arrays;

import com.propentus.vrkconnector.constants.ApiUserSetting;
import com.propentus.vrkconnector.constants.SettingKey
import com.propentus.vrkconnector.domains.common.ApiUser
import com.propentus.vrkconnector.constants.SystemSetting

import grails.transaction.Transactional

import com.propentus.vrkconnector.domains.common.Setting

/**
 * Service to make it easier to handle settings.
 * 
 * When request is made to API, we get the ApiUser that requested and use it to identify
 * settings.
 */
class SettingService {
	
	static scope = "request"
	
	private static ApiUser apiUser
	private static boolean recurringQuery

	public static void setApiUser(ApiUser apiUser) {
		this.apiUser = apiUser
	}
	
	public static void setRecurringQuery(boolean recurringQuery) {
		this.recurringQuery = recurringQuery
	}
	
	/**
	 * Get setting-value only with SettingKey
	 * @param key
	 * @return
	 */
	public static String getApiUserSettingValue(SettingKey key) {
		
		def query
		
		query = Setting.where {
			apiUsers.id == this.apiUser.id
			name == key.toString()
		}
		
		String value = query.find().value
		
		return value
	}
	
	/**
	 * Get setting-value only with SettingKey
	 * @param key
	 * @return
	 */
	public static Setting getApiUserSetting(SettingKey key) {
		
		def query
		
		query = Setting.where {
			apiUsers.id == this.apiUser.id
			name == key.toString()
		}
		
		Setting value = query.find()
		
		return value
	}
	
	public static String getGlobalSettingValue(SettingKey key) {
		return Setting.findByName(key.toString())?.value
	}
	
	/**
	 * Get configured providers depending of apiUser and recurringQuery
	 * @return
	 */
	public static String getProviders() {
		
		String providerKey = "PROVIDERS_RECURRING_FALSE"
		def query
		
		if (recurringQuery) {
			providerKey = "PROVIDERS_RECURRING_TRUE"
		}
		
		query = Setting.where {
			apiUsers.id == this.apiUser.id
			name == providerKey
		}
		
		String value = query.find().value
		
		return value
	}
	
	/**
	 * Finds out if ApiUser has any settings configured.
	 * 
	 * Returns false if there is none.
	 * Otherwise returns true
	 * 
	 * @param user
	 * @return
	 */
	public static boolean settingsConfigured(ApiUser user) {
		
		def query
		
		query = Setting.where {
			apiUsers.id == user.id
		}
		
		if (!query.findAll()) {
			return false
		}
		
		return true
	}
	
	/**
	 * Get settings for globalsettings-tab
	 * @return
	 */
	public static List<SystemSetting> getGlobalSettings() {
		
		List<SystemSetting> settingKeys = Arrays.asList(SystemSetting.values())
		List<Setting> settings = new ArrayList<Setting>();
		//Loop all setting keys and find values for those if exists
		for (SystemSetting key : settingKeys) {
			
			Setting setting = new Setting()
			setting.name = key.toString()
			String value = SettingService.getGlobalSettingValue(key)	
			if(value != null) {
				setting.value = value
			}		
			settings.add(setting)
		}
		
		return settings;
	}
	
	
	/**
	 * Get non-global list of settings
	 * @param user
	 * @return
	 */
	public static List<Setting> getApiUserSettings(ApiUser user) {
		
		//	Find keys of setting
		List<ApiUserSetting> settings = Arrays.asList(ApiUserSetting.values());
		List<Setting> userSet = new ArrayList<Setting>()
		List<Setting> userSettings = new ArrayList<Setting>()
				
		def query = Setting.where {
			apiUsers.id == user.id
		}
		
		if (query.findAll()) {
			userSettings = query.findAll()
		}
		
		//Loop all setting keys and find values for those if exists
		for (ApiUserSetting settingKey : settings) {
			
			Setting setting = new Setting()
			setting.name = settingKey.toString()
			
			for (Setting userSetting : userSettings) {
				
				if (userSetting.name.equals(settingKey.toString())) {
					setting.value = userSetting.value
				}
			}
			
			userSet.add(setting)
		}
		
		return userSet
	}
	
}

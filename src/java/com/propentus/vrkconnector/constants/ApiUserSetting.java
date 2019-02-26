package com.propentus.vrkconnector.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ApiUserSetting implements SettingKey {
	
	//	VTJ configuration
	VRK_PASSWORD(CATEGORY_VRK),
	VRK_USERNAME(CATEGORY_VRK),
	VRK_ENDUSER(CATEGORY_VRK),
	VRK_URL(CATEGORY_VRK),
	
	//	Trimble configuration
	TRIMBLE_USERNAME(CATEGORY_TRIMBLE),
	TRIMBLE_PASSWORD(CATEGORY_TRIMBLE),
	TRIMBLE_KEY(CATEGORY_TRIMBLE),
	TRIMBLE_URL(CATEGORY_TRIMBLE),
	
	//	Providers configuration
	PROVIDERS_RECURRING_TRUE,
	PROVIDERS_RECURRING_FALSE,//	Vrk;Trimble
	
	//Keystore configurations
	KEYSTORE_PATH(CATEGORY_XROAD, false),
	KEYSTORE_PASSWORD(CATEGORY_XROAD, false),
	
	//XRoad configurations
	XROAD_URL(CATEGORY_XROAD),
	XROAD_CLIENT_CERTIFICATE(CATEGORY_XROAD, false),
	//Client
	XROAD_INSTANCE(CATEGORY_XROAD),
	XROAD_MEMBER_CLASS(CATEGORY_XROAD),
	XROAD_MEMBER_CODE(CATEGORY_XROAD),
	XROAD_SUBSYSTEM_CODE(CATEGORY_XROAD),
	
	//XRoad VRK configurations
	XROAD_VRK_INSTANCE(CATEGORY_XROAD),
	XROAD_VRK_MEMBER_CLASS(CATEGORY_XROAD),
	XROAD_VRK_MEMBER_CODE(CATEGORY_XROAD),
	XROAD_VRK_SUBSYSTEM_CODE(CATEGORY_XROAD),
	XROAD_VRK_SERVICE_CODE(CATEGORY_XROAD),
	XROAD_VRK_SERVICE_VERSION(CATEGORY_XROAD);
	
	
	String category = "";
	boolean required = false;
	
	ApiUserSetting() {
		
	}
	
	ApiUserSetting(String category) {
		this.category = category;
		this.required = true;
	}
	
	ApiUserSetting(String category, boolean required) {
		this.category = category;
		this.required = required;
	}
	
	public boolean getRequired() {
		return required;
	}
	
	/**
	 * Get enums from specific category
	 * @param category
	 * @return
	 */
	public static List<ApiUserSetting> getAllKeysFromCategory(String category) {
		List<ApiUserSetting> allKeys = Arrays.asList(ApiUserSetting.values());
		List<ApiUserSetting> keys = new ArrayList<ApiUserSetting>();
		for(ApiUserSetting key: allKeys) {
			if(key.category.equals(category)) {
				keys.add(key);
			}
		}
		return keys;
	}
	
	
}

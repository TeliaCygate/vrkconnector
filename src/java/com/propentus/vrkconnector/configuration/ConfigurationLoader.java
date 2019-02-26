package com.propentus.vrkconnector.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.propentus.vrk.connector.exception.ConfigurationException;
import com.propentus.vrkconnector.constants.ApiUserSetting;
import com.propentus.vrkconnector.constants.SettingKey;
import com.propentus.vrkconnector.domains.common.Setting;
import com.propentus.vrkconnector.service.SettingService;

/**
 * Utility class for loading configurations from different groups.
 */
public class ConfigurationLoader {
	
	/**
	 * Load all XRoad related configurations
	 * @return Configurations in HashMap
	 * @throws ConfigurationException if not all required configurations were not configured
	 */
	public Map<ApiUserSetting, String> getXRoadRelatedConfigurations() throws ConfigurationException {
		Map<ApiUserSetting, String> xroadConfigs = this.getConfigurationGroup(SettingKey.CATEGORY_XROAD);
		xroadConfigs.put(ApiUserSetting.VRK_PASSWORD, SettingService.getApiUserSetting(ApiUserSetting.VRK_PASSWORD).getValue());
		xroadConfigs.put(ApiUserSetting.VRK_USERNAME, SettingService.getApiUserSetting(ApiUserSetting.VRK_USERNAME).getValue());
		xroadConfigs.put(ApiUserSetting.VRK_ENDUSER, SettingService.getApiUserSetting(ApiUserSetting.VRK_ENDUSER).getValue());
		return xroadConfigs;
	}
	
	/**
	 * Load all configuration values from specific configuration group
	 * @param groupName
	 * @return
	 * @throws ConfigurationException
	 */
	private Map<ApiUserSetting, String> getConfigurationGroup(String groupName) throws ConfigurationException {
		Map<ApiUserSetting, String> configs = new HashMap<ApiUserSetting, String>();
		List<ApiUserSetting> groupKeys = ApiUserSetting.getAllKeysFromCategory(groupName);
		for(ApiUserSetting key : groupKeys) {
			Setting setting = SettingService.getApiUserSetting(key);
			if(setting != null) {
				configs.put(key, setting.getValue());
			}
		}
		//Compare enum key size to actual configured values
		if(configs.values().size() != groupKeys.size()) {
			StringBuilder sb = new StringBuilder();
			sb.append("All '" + groupName +  "' related configurations were not set! \n");
			sb.append("Missing configurations: \n");
			
			List<ApiUserSetting> temp = new ArrayList<ApiUserSetting>(configs.keySet());		
			Collection<ApiUserSetting> missingConfigs = filterMissingConfigurations(groupKeys, temp);
			//Loop missing configurations
			for(ApiUserSetting missing : missingConfigs) {
				sb.append(missing.toString() + "\n");
			}
			
			if(!missingConfigs.isEmpty()) {
				throw new ConfigurationException(sb.toString());
			}
		}
		
		return configs;
	}
	
	public Map<ApiUserSetting, String> getTrimbleConfigurations() throws ConfigurationException {
		return this.getConfigurationGroup(SettingKey.CATEGORY_TRIMBLE);
	}
	
	public Map<ApiUserSetting, String> getVrkConfigurations() throws ConfigurationException {
		return this.getConfigurationGroup(SettingKey.CATEGORY_VRK);
	}
	
	public Map<ApiUserSetting, String> loadMockConfigs() {
		
		
		//Get XRoad related configs
		Map<ApiUserSetting, String> xroadConfigs = new HashMap<ApiUserSetting, String>();

		xroadConfigs.put(ApiUserSetting.KEYSTORE_PASSWORD, "changeme");
		xroadConfigs.put(ApiUserSetting.KEYSTORE_PATH, "changeme");
		xroadConfigs.put(ApiUserSetting.XROAD_URL, "changeme");
		
		xroadConfigs.put(ApiUserSetting.XROAD_INSTANCE, "changeme");
		xroadConfigs.put(ApiUserSetting.XROAD_MEMBER_CLASS, "changeme");
		xroadConfigs.put(ApiUserSetting.XROAD_MEMBER_CODE, "changeme");
		xroadConfigs.put(ApiUserSetting.XROAD_SUBSYSTEM_CODE, "changeme");
		
		xroadConfigs.put(ApiUserSetting.XROAD_VRK_INSTANCE, "changeme");
		xroadConfigs.put(ApiUserSetting.XROAD_VRK_MEMBER_CLASS, "changeme");
		xroadConfigs.put(ApiUserSetting.XROAD_VRK_MEMBER_CODE, "changeme");
		xroadConfigs.put(ApiUserSetting.XROAD_VRK_SUBSYSTEM_CODE, "changeme");
		xroadConfigs.put(ApiUserSetting.XROAD_VRK_SERVICE_CODE, "changeme");
		xroadConfigs.put(ApiUserSetting.XROAD_VRK_SERVICE_VERSION, "changeme");
		
		return xroadConfigs;
	}
	
	
	private Collection<ApiUserSetting> filterMissingConfigurations(Collection<ApiUserSetting> needed, Collection<ApiUserSetting> from) {
		List<ApiUserSetting> missing = new ArrayList<ApiUserSetting>();
		for(ApiUserSetting configured : needed) {
			
			if(!configured.getRequired()) {
				continue;
			}
			
			if(!from.contains(configured)) {
				missing.add(configured);
			}
		}
		return missing;
	}
	
}

package com.propentus.vrkconnector.bootstrap

import com.propentus.vrkconnector.domains.common.ApiUser
import com.propentus.vrkconnector.domains.common.Setting
import com.propentus.sp2.componentlibrary.utils.HttpsSSLUtil
import com.propentus.vrkconnector.constants.*

class BootStrapDevelopment {
	
	public static void init() {
		
		//Disable all SSL verifications to we don't need to keep storage of external provider certificates
		HttpsSSLUtil.disableSSLVerificationGlobally()
		
		//	Load settings
		if (Setting.count() == 0) {
			
			ApiUser test = new ApiUser()
			test.sha1 = "test"
			test.organization = "Testiorganisaatio"
			test.save()
			
			ApiUser test2 = new ApiUser()
			test2.sha1 = "test2"
			test2.organization = "Testiorganisaatio 2"
			test2.save()
			
			Setting vrkPassword = new Setting()
			vrkPassword.name = ApiUserSetting.VRK_PASSWORD
			vrkPassword.value = "changeme"
			vrkPassword.addToApiUsers(test)
			vrkPassword.save()
			
			Setting vrkUsername = new Setting()
			vrkUsername.name = ApiUserSetting.VRK_USERNAME
			vrkUsername.value = "changeme"
			vrkUsername.addToApiUsers(test)
			vrkUsername.save()
			
			Setting vrkEndUser = new Setting()
			vrkEndUser.name = ApiUserSetting.VRK_ENDUSER
			vrkEndUser.value = "changeme"
			vrkEndUser.addToApiUsers(test)
			vrkEndUser.save()
			
			Setting vrkUrl = new Setting()
			vrkUrl.name = ApiUserSetting.VRK_URL
			vrkUrl.value = "changeme"
			vrkUrl.addToApiUsers(test)
			vrkUrl.save()
			
			Setting providers = new Setting()
			providers.name = ApiUserSetting.PROVIDERS_RECURRING_FALSE
			providers.value = "VrkMock"
			providers.addToApiUsers(test)
			providers.save()
			
			Setting providers2 = new Setting()
			providers2.name = ApiUserSetting.PROVIDERS_RECURRING_TRUE
			providers2.value = "TrimbleMock"
			providers2.addToApiUsers(test)
			providers2.save()
			
			Setting trimblePassword = new Setting()
			trimblePassword.name = ApiUserSetting.TRIMBLE_PASSWORD
			trimblePassword.value = "changeme"
			trimblePassword.addToApiUsers(test)
			trimblePassword.save()
			
			Setting trimbleUsername = new Setting()
			trimbleUsername.name = ApiUserSetting.TRIMBLE_USERNAME
			trimbleUsername.value = "changeme"
			trimbleUsername.addToApiUsers(test)
			trimbleUsername.save()
			
			Setting trimbleKey = new Setting()
			trimbleKey.name = ApiUserSetting.TRIMBLE_KEY
			trimbleKey.value = "changeme"
			trimbleKey.addToApiUsers(test)
			trimbleKey.save()
			
			Setting trimbleUrl = new Setting()
			trimbleUrl.name = ApiUserSetting.TRIMBLE_URL
			trimbleUrl.value = "changeme"
			trimbleUrl.addToApiUsers(test)
			trimbleUrl.save()
			
			Setting configPass = new Setting()
			configPass.name = SystemSetting.CONFIGURATION_PASSWORD
			configPass.value = "changeme"
			configPass.global = true
			configPass.save()
			
			Setting configUsername = new Setting()
			configUsername.name = SystemSetting.CONFIGURATION_USERNAME
			configUsername.value = "admin"
			configUsername.global = true
			configUsername.save()
			
			Setting loadbalancerCertificateCheck = new Setting()
			loadbalancerCertificateCheck.name = SystemSetting.LOAD_BALANCER_CERTIFICATE_CHECK
			loadbalancerCertificateCheck.value = "true"
			loadbalancerCertificateCheck.global = true
			loadbalancerCertificateCheck.save()
		}
		
	}
}

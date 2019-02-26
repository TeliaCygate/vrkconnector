package com.propentus.vrkconnector.bootstrap

import com.propentus.vrkconnector.domains.common.ApiUser
import com.propentus.vrkconnector.domains.common.Setting
import com.propentus.sp2.componentlibrary.utils.HttpsSSLUtil
import com.propentus.vrkconnector.constants.*

class BootStrapProduction {

	public static void init() {
		
		//Disable all SSL verifications to we don't need to keep storage of external provider certificates
		HttpsSSLUtil.disableSSLVerificationGlobally()
		
		//	Load settings
		if (Setting.count() == 0) {
			
			//Global settings
			Setting configPass = new Setting()
			configPass.name = SystemSetting.CONFIGURATION_PASSWORD
			configPass.value = "changeme"
			configPass.global = true
			configPass.save()
			
			Setting configUsername = new Setting()
			configUsername.name = SystemSetting.CONFIGURATION_USERNAME
			configUsername.value = "changeme"
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

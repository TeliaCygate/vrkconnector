package com.propentus.vrkconnector.xroad.controllers

import com.propentus.vrkconnector.xroad.XRoadMetaserviceProvider;
import com.propentus.vrkconnector.domains.common.ApiUser
import com.propentus.vrkconnector.service.SettingService

class XRoadController {

    def index() { }
	
	def listClients() {
		setUser()
		XRoadMetaserviceProvider provider = new XRoadMetaserviceProvider()
		render(text: provider.listClients(), contentType: "text/xml", encoding: "UTF-8")
	}
	
	def listCentralServices() {
		setUser()
		XRoadMetaserviceProvider provider = new XRoadMetaserviceProvider()
		render(text: provider.listCentralServices(), contentType: "text/xml", encoding: "UTF-8")
	}
	
	def listMethods() {
		setUser()
		XRoadMetaserviceProvider provider = new XRoadMetaserviceProvider()
		render(text: provider.listMethods(), contentType: "text/xml", encoding: "UTF-8")
	}
	
	def allowedMethods() {
		setUser()
		XRoadMetaserviceProvider provider = new XRoadMetaserviceProvider()
		render(text: provider.allowedMethods(), contentType: "text/xml", encoding: "UTF-8")
	}
	
	def getWSDL() {
		
		def instance = ""
		def memberClass = ""
		def memberCode = ""
		def subsystemCode = ""
		def serviceCode = ""
		def version = ""
		
		XRoadMetaserviceProvider provider  = new XRoadMetaserviceProvider()
		render(text: provider.getWSDL(instance, memberClass, memberCode, subsystemCode, serviceCode, version), contentType: "text/xml", encoding: "UTF-8")
	}
	
	//Hardcoded test user
	def setUser() {
		ApiUser activeUser = ApiUser.findBySha1("1234")
		SettingService.setApiUser(activeUser)
	}
}

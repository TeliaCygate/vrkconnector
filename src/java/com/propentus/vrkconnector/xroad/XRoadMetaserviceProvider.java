package com.propentus.vrkconnector.xroad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.transport.http.HTTPConduit;
import org.xroad.metadata.MetaServicesPort;
import org.xroad.xml.xrd.XRoadServiceIdentifierType;

import com.propentus.sp2.componentlibrary.utils.URLUtil;
import com.propentus.vrk.connector.exception.ConfigurationException;
import com.propentus.vrkconnector.configuration.ConfigurationLoader;
import com.propentus.vrkconnector.constants.ApiUserSetting;
import com.propentus.vrkconnector.interfaces.SoapClientProvider;
import com.propentus.vrkconnector.soap.XRoadMetaServiceInterceptor;

public class XRoadMetaserviceProvider extends SoapClientProvider<MetaServicesPort> {
	
	protected String PASSWORD = "";
	protected String USERNAME = "";
	protected String END_USER = "";
	
	private static final String LIST_CLIENTS_PATH = "/listClients";
	private static final String LIST_CENTRAL_SERVICES = "/listCentralServices";
	
	//Some VRK settings are also required on this provider, but they are contained in same map as XROAD configs.
	private Map<ApiUserSetting, String> xroadConfigs = new HashMap<ApiUserSetting, String>();
	
	public XRoadMetaserviceProvider() {
		loadConfiguration();
		this.soapService = this.createSoapService();
	}
	
	private void loadConfiguration() {
		ConfigurationLoader loader = new ConfigurationLoader();
		try {
			xroadConfigs = loader.getXRoadRelatedConfigurations();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		
		this.PASSWORD = xroadConfigs.get(ApiUserSetting.VRK_PASSWORD);
		this.USERNAME = xroadConfigs.get(ApiUserSetting.VRK_USERNAME);
		this.END_USER = xroadConfigs.get(ApiUserSetting.VRK_ENDUSER);
		this.serviceUrl = xroadConfigs.get(ApiUserSetting.XROAD_URL);
	}
	
	/**
	 * Does GET request to fetch list of clients in liityntäpalvelin
	 * @return
	 */
	public String listClients() {
		String requestUrl = this.serviceUrl + LIST_CLIENTS_PATH;
		String response = URLUtil.getContentFromUrlIgnoreSSL(requestUrl);
		return response;
	}
	
	/**
	 * Does GET request to fetch list of central services in XRoad
	 * @return
	 */
	public String listCentralServices() {
		String requestUrl = this.serviceUrl + LIST_CENTRAL_SERVICES;
		String response = URLUtil.getContentFromUrlIgnoreSSL(requestUrl);
		return response;
	}
	
	/**
	 * Does SOAP request to fetch list of methods for specific service in XRoad
	 * @return
	 */
	public List<XRoadServiceIdentifierType> listMethods() {
		return this.soapService.listMethods();
	}
	
	/**
	 * Does SOAP request to fetch list of allowed methods for specific client to specific service
	 * @return
	 */
	public List<XRoadServiceIdentifierType> allowedMethods() {
		return this.soapService.allowedMethods();
	}
	
	@Override
	protected MetaServicesPort createSoapService() {
		
		MetaServicesPort service = super.createSoapService();
		Client client = ClientProxy.getClient(service);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		
		//Disable DNS check because of invalid certificate
		TLSClientParameters conf = new TLSClientParameters();
		conf.setDisableCNCheck(true);
		conf.setUseHttpsURLConnectionDefaultSslSocketFactory(true);
		
		http.setTlsClientParameters(conf);
		
		//Add XRoad interceptor to client
		XRoadMetaServiceInterceptor interceptor = new XRoadMetaServiceInterceptor(xroadConfigs);
		ClientProxy.getClient(service).getOutInterceptors().add(interceptor);
		
		//Optional logging interceptor
		ClientProxy.getClient(service).getOutInterceptors().add(new LoggingOutInterceptor());
		ClientProxy.getClient(service).getInInterceptors().add(new LoggingInInterceptor());
		
		return service;
	}
	
}

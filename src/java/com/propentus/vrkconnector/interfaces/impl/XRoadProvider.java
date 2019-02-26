package com.propentus.vrkconnector.interfaces.impl;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Holder;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.log4j.BasicConfigurator;
import org.w3c.dom.Document;

import com.propentus.sp2.componentlibrary.utils.EntityUtil;
import com.propentus.vrk.connector.exception.ConfigurationException;
import com.propentus.vrkconnector.configuration.ConfigurationLoader;
import com.propentus.vrkconnector.constants.ApiUserSetting;
import com.propentus.vrkconnector.soap.XRoadInterceptor;
import com.propentus.vrkconnector.ssl.XRoadSSLSocketFactory;

import fi.vrk.xml.schema.vtjkysely.VTJHenkiloVastaussanoma;
import fi.vrk.xml.ws.vtj.vtjkysely._1.HenkiloTunnusKyselyReqBodyTiedot;
import fi.vrk.xml.ws.vtj.vtjkysely._1.HenkiloTunnusKyselyResType;
import fi.vrk.xml.ws.vtj.vtjkysely._1.ISoSoAdapterService60;
import fi.vrk.xml.ws.vtj.vtjkysely._1.ObjectFactory;

/**
 *
 *
 */
public class XRoadProvider extends VrkProvider {
		
	private ISoSoAdapterService60 soap;
	
	//Some VRK settings are also required on this provider, but they are contained in same map as XROAD configs.
	private Map<ApiUserSetting, String> xroadConfigs = new HashMap<ApiUserSetting, String>();
	
	public XRoadProvider() {
		super("");
		loadConfiguration();
		this.soap = initializeSoap();
		provider = ProviderType.VRK;
	}
	
	/**
	 * Load configuration for the requester api-user.
	 * Loads password, username, end_user and serviceUrl
	 * details from the database.
	 */
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
	
	@Override
	protected VTJHenkiloVastaussanoma doSearch(String soSoNimi, String ssn) {
		Holder<HenkiloTunnusKyselyResType> response = createResponse();
		this.soap.henkilonTunnusKysely(createRequest(soSoNimi, ssn), response);
		
		//Check for not found response
		HenkiloTunnusKyselyResType value = response.value;
		//If size is more than 1 we got empty response
		int size = value.getAny().size();
		if(size > 1) {
			VTJHenkiloVastaussanoma personDetails = new VTJHenkiloVastaussanoma();
			return personDetails;
		}
		
		//Parse response
		VTJHenkiloVastaussanoma personDetails = null;
		try {
			String xml = EntityUtil.ObjectToXML(response.value);
			Document document = EntityUtil.createXMLDoc(xml);
			personDetails = getVTJHenkiloVastausSanoma(document);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return personDetails;
	}
	
	private Holder<HenkiloTunnusKyselyReqBodyTiedot> createRequest(String soSoNimi, String ssn) {
		ObjectFactory factory = new ObjectFactory();
		HenkiloTunnusKyselyReqBodyTiedot request = factory.createHenkiloTunnusKyselyReqBody().getRequest();
		request.setSoSoNimi(soSoNimi);
		request.setKayttajatunnus(USERNAME);
		request.setSalasana(PASSWORD);
		request.setLaskutustiedot("");
		request.setLoppukayttaja(USERNAME);
		request.setHenkilotunnus(ssn);
		request.setSahkoinenAsiointitunnus("");
		request.setVarmenteenMyontaja("");
		request.setX509Certificate("");
		request.setVarmenteenVoimassaolotarkistus("");
		request.setVarmenteenSulkulistatarkistus("");
		request.setTunnistusportaali("");
		request.setVara1("");
		Holder<HenkiloTunnusKyselyReqBodyTiedot> requestHolder = new Holder<HenkiloTunnusKyselyReqBodyTiedot>(request);
		return requestHolder;
	}
	
	private Holder<HenkiloTunnusKyselyResType> createResponse() {
		ObjectFactory factory = new ObjectFactory();
		HenkiloTunnusKyselyResType response = factory.createHenkiloTunnusKyselyResType();
		Holder<HenkiloTunnusKyselyResType> responseHolder = new Holder<HenkiloTunnusKyselyResType>(response);
		return responseHolder;
	}
	
	private ISoSoAdapterService60 initializeSoap() {
			
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(ISoSoAdapterService60.class);
		factory.setAddress(serviceUrl);
		
		ISoSoAdapterService60 service = (ISoSoAdapterService60)factory.create();		

		Client client = ClientProxy.getClient(service);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		
		//Disable DNS check because of invalid certificate
		TLSClientParameters conf = new TLSClientParameters();
		conf.setDisableCNCheck(true);
		
		//Client certificate configured, load keystores
		if(xroadConfigs.containsKey(ApiUserSetting.XROAD_CLIENT_CERTIFICATE)) {
			//Create socket factory for SSL authentication
			String keystore = xroadConfigs.get(ApiUserSetting.KEYSTORE_PATH);
			String password = xroadConfigs.get(ApiUserSetting.KEYSTORE_PASSWORD);
			XRoadSSLSocketFactory sslFactory = new XRoadSSLSocketFactory(keystore, password);
			//conf.setSSLSocketFactory(javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory());
			conf.setSSLSocketFactory(sslFactory.createSocketFactory());
		}
		else {
			//Use default SSLSocket factory, which disables certificate validation
			conf.setUseHttpsURLConnectionDefaultSslSocketFactory(true);
		}
		
		http.setTlsClientParameters(conf);
		
		//Add XRoad interceptor to client
		XRoadInterceptor interceptor = new XRoadInterceptor(xroadConfigs);
		ClientProxy.getClient(service).getOutInterceptors().add(interceptor);
		
		//Optional logging interceptor
		ClientProxy.getClient(service).getOutInterceptors().add(new LoggingOutInterceptor());
		ClientProxy.getClient(service).getInInterceptors().add(new LoggingInInterceptor());

		return service;
	}
	
		

}

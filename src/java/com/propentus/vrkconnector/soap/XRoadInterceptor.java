package com.propentus.vrkconnector.soap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.policy.builder.jaxb.JaxbAssertionBuilder;
import org.xroad.xml.xrd.ObjectFactory;
import org.xroad.xml.xrd.XRoadClientIdentifierType;
import org.xroad.xml.xrd.XRoadObjectType;
import org.xroad.xml.xrd.XRoadServiceIdentifierType;

import com.propentus.vrkconnector.constants.ApiUserSetting;

/**
 * Interceptor for XRoad SOAP-messages. Reads XROAD related configurations and configured information
 * to SOAP-message header before sending the request.
 */
public class XRoadInterceptor extends AbstractSoapInterceptor  {
	
	private static final Log logger = LogFactory.getLog(XRoadInterceptor.class);
	
	private static final String XROAD_PROTOCOL_VERSION = "4.0";
	private static final String XROAD_USER_ID = "";
	private static final String XROAD_CREATE_ID = "";
	
	private static Map<ApiUserSetting, String> XROAD_CONFIGS = new HashMap<ApiUserSetting, String>();
	
	public XRoadInterceptor(Map<ApiUserSetting, String> xroadConfigs) {
		super(Phase.WRITE);
		XROAD_CONFIGS = xroadConfigs;
	}

	@Override
	public void handleMessage(SoapMessage outgoingMsg) throws Fault {
		
		//Add XRoad headers to Soap message
		List<Header> headers = outgoingMsg.getHeaders();
		addXRoadHeaders(headers, createXRoadHeaders());
		
		logger.info("headers:" + headers);
	}
	
	private List<JAXBElement<?>> createXRoadHeaders() {
		
		
		List<JAXBElement<?>> headers = new ArrayList<JAXBElement<?>>();
		org.xroad.xml.xrd.ObjectFactory factory = new ObjectFactory();
		
		//Client information
		XRoadClientIdentifierType client = new XRoadClientIdentifierType();
		client.setXRoadInstance(XROAD_CONFIGS.get(ApiUserSetting.XROAD_INSTANCE));
		client.setMemberClass(XROAD_CONFIGS.get(ApiUserSetting.XROAD_MEMBER_CLASS));
		client.setMemberCode(XROAD_CONFIGS.get(ApiUserSetting.XROAD_MEMBER_CODE));
		client.setSubsystemCode(XROAD_CONFIGS.get(ApiUserSetting.XROAD_SUBSYSTEM_CODE));
		client.setObjectType(XRoadObjectType.SUBSYSTEM);
		
		JAXBElement<XRoadClientIdentifierType> clientElem = factory.createClient(client);
		headers.add(clientElem);
		
		//Service information
		XRoadServiceIdentifierType service = new XRoadServiceIdentifierType();
		service.setXRoadInstance(XROAD_CONFIGS.get(ApiUserSetting.XROAD_VRK_INSTANCE));
		service.setMemberClass(XROAD_CONFIGS.get(ApiUserSetting.XROAD_VRK_MEMBER_CLASS));
		service.setMemberCode(XROAD_CONFIGS.get(ApiUserSetting.XROAD_VRK_MEMBER_CODE));
		service.setSubsystemCode(XROAD_CONFIGS.get(ApiUserSetting.XROAD_VRK_SUBSYSTEM_CODE));
		service.setServiceCode(XROAD_CONFIGS.get(ApiUserSetting.XROAD_VRK_SERVICE_CODE));
		service.setServiceVersion(XROAD_CONFIGS.get(ApiUserSetting.XROAD_VRK_SERVICE_VERSION));
		service.setObjectType(XRoadObjectType.SERVICE);
		
		JAXBElement<XRoadServiceIdentifierType> serviceElem = factory.createService(service);
		headers.add(serviceElem);
		
		//Other information
		headers.add(factory.createUserId(XROAD_USER_ID));
		headers.add(factory.createId(XROAD_CREATE_ID));
		headers.add(factory.createProtocolVersion(XROAD_PROTOCOL_VERSION));
		
		return headers;
	}
	
	private void addXRoadHeaders(List<Header> headers, List<JAXBElement<?>> elements) {
		try {
			for(JAXBElement<?> element : elements) {
				Header header = new Header(element.getName(), element.getValue(), new JAXBDataBinding(element.getDeclaredType()));
				headers.add(header);
			}
		}
		catch (Exception e) {
			logger.error("Error while writing headers to Soap Response!", e);
		}
	}

}

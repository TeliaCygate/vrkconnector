package com.propentus.vrkconnector.soap;

import javax.xml.stream.XMLStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.Soap11FaultInInterceptor;
import org.apache.cxf.interceptor.Fault;

public class SoapErrorInterceptor extends Soap11FaultInInterceptor  {
	
	private static final Log logger = LogFactory.getLog(SoapErrorInterceptor.class);
	
	public SoapErrorInterceptor() {
		super();
	}

	public void handleMessage(SoapMessage message) throws Fault {
		XMLStreamReader reader = message.getContent(XMLStreamReader.class);
		SoapFault fault =  super.unmarshalFault(message, reader);
		if(fault != null) {
			logger.error("Received fault when invoking SOAP-service! Fault message:" + fault.getMessage());
			throw fault;
		}
		
	}

}

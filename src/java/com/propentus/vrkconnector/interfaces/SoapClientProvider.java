package com.propentus.vrkconnector.interfaces;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.datacontract.schemas._2004._07.tekla_gis.PersonSearch;

import com.propentus.vrkconnector.entities.GetPersonRelationsRequest;
import com.propentus.vrkconnector.entities.PersonInformation;
import com.propentus.vrkconnector.entities.GetPersonRelationsRequest.Person;
import com.propentus.vrkconnector.entities.PersonInformation.PersonType;

public abstract class SoapClientProvider<T> {
	
	protected String serviceUrl;
	
	protected T soapService;
	protected Class<T> serviceClazz;
	
	public SoapClientProvider() {
		this.serviceClazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	/**
	 * Create SOAP-client service for specific generated SOAP-client implementation
	 * @return
	 */
	protected T createSoapService() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(serviceClazz);
		factory.setAddress(serviceUrl);
		
		T service = (T)factory.create();		
		return service;
	}
}

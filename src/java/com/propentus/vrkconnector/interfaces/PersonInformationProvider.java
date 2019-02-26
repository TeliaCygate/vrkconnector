package com.propentus.vrkconnector.interfaces;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.datacontract.schemas._2004._07.tekla_gis.PersonSearch;

import com.propentus.vrkconnector.entities.GetPersonRelationsRequest;
import com.propentus.vrkconnector.entities.PersonInformation;
import com.propentus.vrkconnector.entities.GetPersonRelationsRequest.Person;
import com.propentus.vrkconnector.entities.PersonInformation.PersonType;

/**
 * Abstract class for new providers to extend.
 * @param <T>
 */
public abstract class PersonInformationProvider<T> {
	
	protected String serviceUrl;
	
	protected T soapService;
	protected Class<T> serviceClazz;
	protected ProviderType provider;
	
	public enum ProviderType {
		VRK,
		TRIMBLE,
		XROAD
	}
	
	public PersonInformationProvider() {
		this.serviceClazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
		//this.soapService = createSoapService();
	}
	
	/**
	 * Dummy constructor to avoid calling base constructor on XRoadProvider
	 * @param s
	 */
	public PersonInformationProvider(String s) {

	}
	
	protected T createSoapService() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(serviceClazz);
		factory.setAddress(serviceUrl);
		
		T service = (T)factory.create();		
		return service;
	}
	
	/**
	 * Finds details and relations for main person.
	 * 
	 * Uses findPersonInformation-method with getRelations-parameter as true
	 * 
	 * @param person
	 * @return
	 */
	public PersonInformation findPersonAndRelations(GetPersonRelationsRequest.Person person) {
	
		//	Get main user details
		PersonInformation personInfo = findPersonInformation(person.ssn, person.type, true);
		return personInfo;
	}
	
	/**
	 * 
	 * @param ssn
	 * @param personType
	 * @param getRelations
	 * @return
	 */
	public abstract PersonInformation findPersonInformation(String ssn, PersonType personType, boolean getRelations);
}

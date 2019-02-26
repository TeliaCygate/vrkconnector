package com.tekla.webservices._2015._05.person;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.3
 * 2017-06-27T12:42:34.694+03:00
 * Generated source version: 3.0.3
 * 
 */
@WebService(targetNamespace = "http://tekla.com/webservices/2015/05/Person", name = "IPerson")
@XmlSeeAlso({ObjectFactory.class, com.microsoft.schemas._2003._10.serialization.ObjectFactory.class, org.datacontract.schemas._2004._07.tekla_gis.ObjectFactory.class})
public interface IPerson {

    @WebMethod(operationName = "GetPersonSpouseByIdentityCode", action = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonSpouseByIdentityCode")
    @Action(input = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonSpouseByIdentityCode", output = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonSpouseByIdentityCodeResponse")
    @RequestWrapper(localName = "GetPersonSpouseByIdentityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonSpouseByIdentityCode")
    @ResponseWrapper(localName = "GetPersonSpouseByIdentityCodeResponse", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonSpouseByIdentityCodeResponse")
    @WebResult(name = "GetPersonSpouseByIdentityCodeResult", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
    public org.datacontract.schemas._2004._07.tekla_gis.PersonSpouseResult getPersonSpouseByIdentityCode(
        @WebParam(name = "key", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String key,
        @WebParam(name = "identityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String identityCode
    );

    @WebMethod(operationName = "GetPersonsByAddress", action = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByAddress")
    @Action(input = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByAddress", output = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByAddressResponse")
    @RequestWrapper(localName = "GetPersonsByAddress", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonsByAddress")
    @ResponseWrapper(localName = "GetPersonsByAddressResponse", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonsByAddressResponse")
    @WebResult(name = "GetPersonsByAddressResult", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
    public org.datacontract.schemas._2004._07.tekla_gis.PersonSearchResult getPersonsByAddress(
        @WebParam(name = "key", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String key,
        @WebParam(name = "streetName", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String streetName,
        @WebParam(name = "addressNumberInt1", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String addressNumberInt1,
        @WebParam(name = "addressNumberInt2", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String addressNumberInt2
    );

    @WebMethod(operationName = "GetPersonAdditionalInfoByIdentityCode", action = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonAdditionalInfoByIdentityCode")
    @Action(input = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonAdditionalInfoByIdentityCode", output = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonAdditionalInfoByIdentityCodeResponse")
    @RequestWrapper(localName = "GetPersonAdditionalInfoByIdentityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonAdditionalInfoByIdentityCode")
    @ResponseWrapper(localName = "GetPersonAdditionalInfoByIdentityCodeResponse", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonAdditionalInfoByIdentityCodeResponse")
    @WebResult(name = "GetPersonAdditionalInfoByIdentityCodeResult", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
    public org.datacontract.schemas._2004._07.tekla_gis.PersonAdditionalInfoResult getPersonAdditionalInfoByIdentityCode(
        @WebParam(name = "key", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String key,
        @WebParam(name = "identityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String identityCode
    );

    @WebMethod(operationName = "GetPersonPropertiesByIdentityCode", action = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonPropertiesByIdentityCode")
    @Action(input = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonPropertiesByIdentityCode", output = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonPropertiesByIdentityCodeResponse")
    @RequestWrapper(localName = "GetPersonPropertiesByIdentityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonPropertiesByIdentityCode")
    @ResponseWrapper(localName = "GetPersonPropertiesByIdentityCodeResponse", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonPropertiesByIdentityCodeResponse")
    @WebResult(name = "GetPersonPropertiesByIdentityCodeResult", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
    public org.datacontract.schemas._2004._07.tekla_gis.PersonPropertiesResult getPersonPropertiesByIdentityCode(
        @WebParam(name = "key", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String key,
        @WebParam(name = "identityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String identityCode
    );

    @WebMethod(operationName = "GetPersonAddressByIdentityCode", action = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonAddressByIdentityCode")
    @Action(input = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonAddressByIdentityCode", output = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonAddressByIdentityCodeResponse")
    @RequestWrapper(localName = "GetPersonAddressByIdentityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonAddressByIdentityCode")
    @ResponseWrapper(localName = "GetPersonAddressByIdentityCodeResponse", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonAddressByIdentityCodeResponse")
    @WebResult(name = "GetPersonAddressByIdentityCodeResult", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
    public org.datacontract.schemas._2004._07.tekla_gis.PersonAddressResult getPersonAddressByIdentityCode(
        @WebParam(name = "key", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String key,
        @WebParam(name = "identityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String identityCode
    );

    @WebMethod(operationName = "GetPersonRelationsByIdentityCode", action = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonRelationsByIdentityCode")
    @Action(input = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonRelationsByIdentityCode", output = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonRelationsByIdentityCodeResponse")
    @RequestWrapper(localName = "GetPersonRelationsByIdentityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonRelationsByIdentityCode")
    @ResponseWrapper(localName = "GetPersonRelationsByIdentityCodeResponse", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonRelationsByIdentityCodeResponse")
    @WebResult(name = "GetPersonRelationsByIdentityCodeResult", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
    public org.datacontract.schemas._2004._07.tekla_gis.PersonRelationsResult getPersonRelationsByIdentityCode(
        @WebParam(name = "key", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String key,
        @WebParam(name = "identityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String identityCode
    );

    @WebMethod(operationName = "GetPersonsByName", action = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByName")
    @Action(input = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByName", output = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByNameResponse")
    @RequestWrapper(localName = "GetPersonsByName", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonsByName")
    @ResponseWrapper(localName = "GetPersonsByNameResponse", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonsByNameResponse")
    @WebResult(name = "GetPersonsByNameResult", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
    public org.datacontract.schemas._2004._07.tekla_gis.PersonSearchResult getPersonsByName(
        @WebParam(name = "key", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String key,
        @WebParam(name = "surname", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String surname,
        @WebParam(name = "firstName", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String firstName
    );

    @WebMethod(operationName = "GetPersonsByIdentityCode", action = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByIdentityCode")
    @Action(input = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByIdentityCode", output = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByIdentityCodeResponse")
    @RequestWrapper(localName = "GetPersonsByIdentityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonsByIdentityCode")
    @ResponseWrapper(localName = "GetPersonsByIdentityCodeResponse", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonsByIdentityCodeResponse")
    @WebResult(name = "GetPersonsByIdentityCodeResult", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
    public org.datacontract.schemas._2004._07.tekla_gis.PersonSearchResult getPersonsByIdentityCode(
        @WebParam(name = "key", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String key,
        @WebParam(name = "identityCode", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String identityCode
    );

    @WebMethod(operationName = "GetPersonsByUpdateDate", action = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByUpdateDate")
    @Action(input = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByUpdateDate", output = "http://tekla.com/webservices/2015/05/Person/IPerson/GetPersonsByUpdateDateResponse")
    @RequestWrapper(localName = "GetPersonsByUpdateDate", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonsByUpdateDate")
    @ResponseWrapper(localName = "GetPersonsByUpdateDateResponse", targetNamespace = "http://tekla.com/webservices/2015/05/Person", className = "com.tekla.webservices._2015._05.person.GetPersonsByUpdateDateResponse")
    @WebResult(name = "GetPersonsByUpdateDateResult", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
    public org.datacontract.schemas._2004._07.tekla_gis.PersonByUpdateDateSearchResult getPersonsByUpdateDate(
        @WebParam(name = "key", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String key,
        @WebParam(name = "startDate", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String startDate,
        @WebParam(name = "endDate", targetNamespace = "http://tekla.com/webservices/2015/05/Person")
        java.lang.String endDate
    );
}
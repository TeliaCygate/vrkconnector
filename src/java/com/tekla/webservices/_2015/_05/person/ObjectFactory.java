
package com.tekla.webservices._2015._05.person;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.tekla_gis.PersonAdditionalInfoResult;
import org.datacontract.schemas._2004._07.tekla_gis.PersonAddressResult;
import org.datacontract.schemas._2004._07.tekla_gis.PersonByUpdateDateSearchResult;
import org.datacontract.schemas._2004._07.tekla_gis.PersonPropertiesResult;
import org.datacontract.schemas._2004._07.tekla_gis.PersonRelationsResult;
import org.datacontract.schemas._2004._07.tekla_gis.PersonSearchResult;
import org.datacontract.schemas._2004._07.tekla_gis.PersonSpouseResult;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tekla.webservices._2015._05.person package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPersonsByAddressResponseGetPersonsByAddressResult_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "GetPersonsByAddressResult");
    private final static QName _GetPersonAddressByIdentityCodeIdentityCode_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "identityCode");
    private final static QName _GetPersonAddressByIdentityCodeKey_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "key");
    private final static QName _GetPersonAdditionalInfoByIdentityCodeResponseGetPersonAdditionalInfoByIdentityCodeResult_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "GetPersonAdditionalInfoByIdentityCodeResult");
    private final static QName _GetPersonsByUpdateDateResponseGetPersonsByUpdateDateResult_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "GetPersonsByUpdateDateResult");
    private final static QName _GetPersonAddressByIdentityCodeResponseGetPersonAddressByIdentityCodeResult_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "GetPersonAddressByIdentityCodeResult");
    private final static QName _GetPersonPropertiesByIdentityCodeResponseGetPersonPropertiesByIdentityCodeResult_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "GetPersonPropertiesByIdentityCodeResult");
    private final static QName _GetPersonsByAddressAddressNumberInt2_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "addressNumberInt2");
    private final static QName _GetPersonsByAddressAddressNumberInt1_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "addressNumberInt1");
    private final static QName _GetPersonsByAddressStreetName_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "streetName");
    private final static QName _GetPersonsByNameResponseGetPersonsByNameResult_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "GetPersonsByNameResult");
    private final static QName _GetPersonsByNameSurname_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "surname");
    private final static QName _GetPersonsByNameFirstName_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "firstName");
    private final static QName _GetPersonSpouseByIdentityCodeResponseGetPersonSpouseByIdentityCodeResult_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "GetPersonSpouseByIdentityCodeResult");
    private final static QName _GetPersonsByUpdateDateStartDate_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "startDate");
    private final static QName _GetPersonsByUpdateDateEndDate_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "endDate");
    private final static QName _GetPersonsByIdentityCodeResponseGetPersonsByIdentityCodeResult_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "GetPersonsByIdentityCodeResult");
    private final static QName _GetPersonRelationsByIdentityCodeResponseGetPersonRelationsByIdentityCodeResult_QNAME = new QName("http://tekla.com/webservices/2015/05/Person", "GetPersonRelationsByIdentityCodeResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tekla.webservices._2015._05.person
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPersonsByName }
     * 
     */
    public GetPersonsByName createGetPersonsByName() {
        return new GetPersonsByName();
    }

    /**
     * Create an instance of {@link GetPersonSpouseByIdentityCodeResponse }
     * 
     */
    public GetPersonSpouseByIdentityCodeResponse createGetPersonSpouseByIdentityCodeResponse() {
        return new GetPersonSpouseByIdentityCodeResponse();
    }

    /**
     * Create an instance of {@link GetPersonAdditionalInfoByIdentityCodeResponse }
     * 
     */
    public GetPersonAdditionalInfoByIdentityCodeResponse createGetPersonAdditionalInfoByIdentityCodeResponse() {
        return new GetPersonAdditionalInfoByIdentityCodeResponse();
    }

    /**
     * Create an instance of {@link GetPersonsByUpdateDate }
     * 
     */
    public GetPersonsByUpdateDate createGetPersonsByUpdateDate() {
        return new GetPersonsByUpdateDate();
    }

    /**
     * Create an instance of {@link GetPersonAdditionalInfoByIdentityCode }
     * 
     */
    public GetPersonAdditionalInfoByIdentityCode createGetPersonAdditionalInfoByIdentityCode() {
        return new GetPersonAdditionalInfoByIdentityCode();
    }

    /**
     * Create an instance of {@link GetPersonAddressByIdentityCodeResponse }
     * 
     */
    public GetPersonAddressByIdentityCodeResponse createGetPersonAddressByIdentityCodeResponse() {
        return new GetPersonAddressByIdentityCodeResponse();
    }

    /**
     * Create an instance of {@link GetPersonSpouseByIdentityCode }
     * 
     */
    public GetPersonSpouseByIdentityCode createGetPersonSpouseByIdentityCode() {
        return new GetPersonSpouseByIdentityCode();
    }

    /**
     * Create an instance of {@link GetPersonsByNameResponse }
     * 
     */
    public GetPersonsByNameResponse createGetPersonsByNameResponse() {
        return new GetPersonsByNameResponse();
    }

    /**
     * Create an instance of {@link GetPersonRelationsByIdentityCodeResponse }
     * 
     */
    public GetPersonRelationsByIdentityCodeResponse createGetPersonRelationsByIdentityCodeResponse() {
        return new GetPersonRelationsByIdentityCodeResponse();
    }

    /**
     * Create an instance of {@link GetPersonsByAddress }
     * 
     */
    public GetPersonsByAddress createGetPersonsByAddress() {
        return new GetPersonsByAddress();
    }

    /**
     * Create an instance of {@link GetPersonsByUpdateDateResponse }
     * 
     */
    public GetPersonsByUpdateDateResponse createGetPersonsByUpdateDateResponse() {
        return new GetPersonsByUpdateDateResponse();
    }

    /**
     * Create an instance of {@link GetPersonsByIdentityCode }
     * 
     */
    public GetPersonsByIdentityCode createGetPersonsByIdentityCode() {
        return new GetPersonsByIdentityCode();
    }

    /**
     * Create an instance of {@link GetPersonsByIdentityCodeResponse }
     * 
     */
    public GetPersonsByIdentityCodeResponse createGetPersonsByIdentityCodeResponse() {
        return new GetPersonsByIdentityCodeResponse();
    }

    /**
     * Create an instance of {@link GetPersonPropertiesByIdentityCode }
     * 
     */
    public GetPersonPropertiesByIdentityCode createGetPersonPropertiesByIdentityCode() {
        return new GetPersonPropertiesByIdentityCode();
    }

    /**
     * Create an instance of {@link GetPersonPropertiesByIdentityCodeResponse }
     * 
     */
    public GetPersonPropertiesByIdentityCodeResponse createGetPersonPropertiesByIdentityCodeResponse() {
        return new GetPersonPropertiesByIdentityCodeResponse();
    }

    /**
     * Create an instance of {@link GetPersonsByAddressResponse }
     * 
     */
    public GetPersonsByAddressResponse createGetPersonsByAddressResponse() {
        return new GetPersonsByAddressResponse();
    }

    /**
     * Create an instance of {@link GetPersonRelationsByIdentityCode }
     * 
     */
    public GetPersonRelationsByIdentityCode createGetPersonRelationsByIdentityCode() {
        return new GetPersonRelationsByIdentityCode();
    }

    /**
     * Create an instance of {@link GetPersonAddressByIdentityCode }
     * 
     */
    public GetPersonAddressByIdentityCode createGetPersonAddressByIdentityCode() {
        return new GetPersonAddressByIdentityCode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonSearchResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "GetPersonsByAddressResult", scope = GetPersonsByAddressResponse.class)
    public JAXBElement<PersonSearchResult> createGetPersonsByAddressResponseGetPersonsByAddressResult(PersonSearchResult value) {
        return new JAXBElement<PersonSearchResult>(_GetPersonsByAddressResponseGetPersonsByAddressResult_QNAME, PersonSearchResult.class, GetPersonsByAddressResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "identityCode", scope = GetPersonAddressByIdentityCode.class)
    public JAXBElement<String> createGetPersonAddressByIdentityCodeIdentityCode(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeIdentityCode_QNAME, String.class, GetPersonAddressByIdentityCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "key", scope = GetPersonAddressByIdentityCode.class)
    public JAXBElement<String> createGetPersonAddressByIdentityCodeKey(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeKey_QNAME, String.class, GetPersonAddressByIdentityCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonAdditionalInfoResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "GetPersonAdditionalInfoByIdentityCodeResult", scope = GetPersonAdditionalInfoByIdentityCodeResponse.class)
    public JAXBElement<PersonAdditionalInfoResult> createGetPersonAdditionalInfoByIdentityCodeResponseGetPersonAdditionalInfoByIdentityCodeResult(PersonAdditionalInfoResult value) {
        return new JAXBElement<PersonAdditionalInfoResult>(_GetPersonAdditionalInfoByIdentityCodeResponseGetPersonAdditionalInfoByIdentityCodeResult_QNAME, PersonAdditionalInfoResult.class, GetPersonAdditionalInfoByIdentityCodeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonByUpdateDateSearchResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "GetPersonsByUpdateDateResult", scope = GetPersonsByUpdateDateResponse.class)
    public JAXBElement<PersonByUpdateDateSearchResult> createGetPersonsByUpdateDateResponseGetPersonsByUpdateDateResult(PersonByUpdateDateSearchResult value) {
        return new JAXBElement<PersonByUpdateDateSearchResult>(_GetPersonsByUpdateDateResponseGetPersonsByUpdateDateResult_QNAME, PersonByUpdateDateSearchResult.class, GetPersonsByUpdateDateResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "identityCode", scope = GetPersonAdditionalInfoByIdentityCode.class)
    public JAXBElement<String> createGetPersonAdditionalInfoByIdentityCodeIdentityCode(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeIdentityCode_QNAME, String.class, GetPersonAdditionalInfoByIdentityCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "key", scope = GetPersonAdditionalInfoByIdentityCode.class)
    public JAXBElement<String> createGetPersonAdditionalInfoByIdentityCodeKey(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeKey_QNAME, String.class, GetPersonAdditionalInfoByIdentityCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonAddressResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "GetPersonAddressByIdentityCodeResult", scope = GetPersonAddressByIdentityCodeResponse.class)
    public JAXBElement<PersonAddressResult> createGetPersonAddressByIdentityCodeResponseGetPersonAddressByIdentityCodeResult(PersonAddressResult value) {
        return new JAXBElement<PersonAddressResult>(_GetPersonAddressByIdentityCodeResponseGetPersonAddressByIdentityCodeResult_QNAME, PersonAddressResult.class, GetPersonAddressByIdentityCodeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "identityCode", scope = GetPersonSpouseByIdentityCode.class)
    public JAXBElement<String> createGetPersonSpouseByIdentityCodeIdentityCode(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeIdentityCode_QNAME, String.class, GetPersonSpouseByIdentityCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "key", scope = GetPersonSpouseByIdentityCode.class)
    public JAXBElement<String> createGetPersonSpouseByIdentityCodeKey(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeKey_QNAME, String.class, GetPersonSpouseByIdentityCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonPropertiesResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "GetPersonPropertiesByIdentityCodeResult", scope = GetPersonPropertiesByIdentityCodeResponse.class)
    public JAXBElement<PersonPropertiesResult> createGetPersonPropertiesByIdentityCodeResponseGetPersonPropertiesByIdentityCodeResult(PersonPropertiesResult value) {
        return new JAXBElement<PersonPropertiesResult>(_GetPersonPropertiesByIdentityCodeResponseGetPersonPropertiesByIdentityCodeResult_QNAME, PersonPropertiesResult.class, GetPersonPropertiesByIdentityCodeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "key", scope = GetPersonsByAddress.class)
    public JAXBElement<String> createGetPersonsByAddressKey(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeKey_QNAME, String.class, GetPersonsByAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "addressNumberInt2", scope = GetPersonsByAddress.class)
    public JAXBElement<String> createGetPersonsByAddressAddressNumberInt2(String value) {
        return new JAXBElement<String>(_GetPersonsByAddressAddressNumberInt2_QNAME, String.class, GetPersonsByAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "addressNumberInt1", scope = GetPersonsByAddress.class)
    public JAXBElement<String> createGetPersonsByAddressAddressNumberInt1(String value) {
        return new JAXBElement<String>(_GetPersonsByAddressAddressNumberInt1_QNAME, String.class, GetPersonsByAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "streetName", scope = GetPersonsByAddress.class)
    public JAXBElement<String> createGetPersonsByAddressStreetName(String value) {
        return new JAXBElement<String>(_GetPersonsByAddressStreetName_QNAME, String.class, GetPersonsByAddress.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonSearchResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "GetPersonsByNameResult", scope = GetPersonsByNameResponse.class)
    public JAXBElement<PersonSearchResult> createGetPersonsByNameResponseGetPersonsByNameResult(PersonSearchResult value) {
        return new JAXBElement<PersonSearchResult>(_GetPersonsByNameResponseGetPersonsByNameResult_QNAME, PersonSearchResult.class, GetPersonsByNameResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "key", scope = GetPersonsByName.class)
    public JAXBElement<String> createGetPersonsByNameKey(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeKey_QNAME, String.class, GetPersonsByName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "surname", scope = GetPersonsByName.class)
    public JAXBElement<String> createGetPersonsByNameSurname(String value) {
        return new JAXBElement<String>(_GetPersonsByNameSurname_QNAME, String.class, GetPersonsByName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "firstName", scope = GetPersonsByName.class)
    public JAXBElement<String> createGetPersonsByNameFirstName(String value) {
        return new JAXBElement<String>(_GetPersonsByNameFirstName_QNAME, String.class, GetPersonsByName.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonSpouseResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "GetPersonSpouseByIdentityCodeResult", scope = GetPersonSpouseByIdentityCodeResponse.class)
    public JAXBElement<PersonSpouseResult> createGetPersonSpouseByIdentityCodeResponseGetPersonSpouseByIdentityCodeResult(PersonSpouseResult value) {
        return new JAXBElement<PersonSpouseResult>(_GetPersonSpouseByIdentityCodeResponseGetPersonSpouseByIdentityCodeResult_QNAME, PersonSpouseResult.class, GetPersonSpouseByIdentityCodeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "identityCode", scope = GetPersonsByIdentityCode.class)
    public JAXBElement<String> createGetPersonsByIdentityCodeIdentityCode(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeIdentityCode_QNAME, String.class, GetPersonsByIdentityCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "key", scope = GetPersonsByIdentityCode.class)
    public JAXBElement<String> createGetPersonsByIdentityCodeKey(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeKey_QNAME, String.class, GetPersonsByIdentityCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "key", scope = GetPersonsByUpdateDate.class)
    public JAXBElement<String> createGetPersonsByUpdateDateKey(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeKey_QNAME, String.class, GetPersonsByUpdateDate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "startDate", scope = GetPersonsByUpdateDate.class)
    public JAXBElement<String> createGetPersonsByUpdateDateStartDate(String value) {
        return new JAXBElement<String>(_GetPersonsByUpdateDateStartDate_QNAME, String.class, GetPersonsByUpdateDate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "endDate", scope = GetPersonsByUpdateDate.class)
    public JAXBElement<String> createGetPersonsByUpdateDateEndDate(String value) {
        return new JAXBElement<String>(_GetPersonsByUpdateDateEndDate_QNAME, String.class, GetPersonsByUpdateDate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "identityCode", scope = GetPersonRelationsByIdentityCode.class)
    public JAXBElement<String> createGetPersonRelationsByIdentityCodeIdentityCode(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeIdentityCode_QNAME, String.class, GetPersonRelationsByIdentityCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "key", scope = GetPersonRelationsByIdentityCode.class)
    public JAXBElement<String> createGetPersonRelationsByIdentityCodeKey(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeKey_QNAME, String.class, GetPersonRelationsByIdentityCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonSearchResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "GetPersonsByIdentityCodeResult", scope = GetPersonsByIdentityCodeResponse.class)
    public JAXBElement<PersonSearchResult> createGetPersonsByIdentityCodeResponseGetPersonsByIdentityCodeResult(PersonSearchResult value) {
        return new JAXBElement<PersonSearchResult>(_GetPersonsByIdentityCodeResponseGetPersonsByIdentityCodeResult_QNAME, PersonSearchResult.class, GetPersonsByIdentityCodeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonRelationsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "GetPersonRelationsByIdentityCodeResult", scope = GetPersonRelationsByIdentityCodeResponse.class)
    public JAXBElement<PersonRelationsResult> createGetPersonRelationsByIdentityCodeResponseGetPersonRelationsByIdentityCodeResult(PersonRelationsResult value) {
        return new JAXBElement<PersonRelationsResult>(_GetPersonRelationsByIdentityCodeResponseGetPersonRelationsByIdentityCodeResult_QNAME, PersonRelationsResult.class, GetPersonRelationsByIdentityCodeResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "identityCode", scope = GetPersonPropertiesByIdentityCode.class)
    public JAXBElement<String> createGetPersonPropertiesByIdentityCodeIdentityCode(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeIdentityCode_QNAME, String.class, GetPersonPropertiesByIdentityCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tekla.com/webservices/2015/05/Person", name = "key", scope = GetPersonPropertiesByIdentityCode.class)
    public JAXBElement<String> createGetPersonPropertiesByIdentityCodeKey(String value) {
        return new JAXBElement<String>(_GetPersonAddressByIdentityCodeKey_QNAME, String.class, GetPersonPropertiesByIdentityCode.class, value);
    }

}

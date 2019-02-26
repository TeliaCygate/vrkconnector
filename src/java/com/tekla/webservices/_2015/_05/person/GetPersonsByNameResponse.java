
package com.tekla.webservices._2015._05.person;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.tekla_gis.PersonSearchResult;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetPersonsByNameResult" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}PersonSearchResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getPersonsByNameResult"
})
@XmlRootElement(name = "GetPersonsByNameResponse")
public class GetPersonsByNameResponse {

    @XmlElementRef(name = "GetPersonsByNameResult", namespace = "http://tekla.com/webservices/2015/05/Person", type = JAXBElement.class, required = false)
    protected JAXBElement<PersonSearchResult> getPersonsByNameResult;

    /**
     * Gets the value of the getPersonsByNameResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonSearchResult }{@code >}
     *     
     */
    public JAXBElement<PersonSearchResult> getGetPersonsByNameResult() {
        return getPersonsByNameResult;
    }

    /**
     * Sets the value of the getPersonsByNameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonSearchResult }{@code >}
     *     
     */
    public void setGetPersonsByNameResult(JAXBElement<PersonSearchResult> value) {
        this.getPersonsByNameResult = value;
    }

}

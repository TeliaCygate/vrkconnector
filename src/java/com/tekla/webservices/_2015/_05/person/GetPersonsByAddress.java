
package com.tekla.webservices._2015._05.person;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressNumberInt1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressNumberInt2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "key",
    "streetName",
    "addressNumberInt1",
    "addressNumberInt2"
})
@XmlRootElement(name = "GetPersonsByAddress")
public class GetPersonsByAddress {

    @XmlElementRef(name = "key", namespace = "http://tekla.com/webservices/2015/05/Person", type = JAXBElement.class, required = false)
    protected JAXBElement<String> key;
    @XmlElementRef(name = "streetName", namespace = "http://tekla.com/webservices/2015/05/Person", type = JAXBElement.class, required = false)
    protected JAXBElement<String> streetName;
    @XmlElementRef(name = "addressNumberInt1", namespace = "http://tekla.com/webservices/2015/05/Person", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addressNumberInt1;
    @XmlElementRef(name = "addressNumberInt2", namespace = "http://tekla.com/webservices/2015/05/Person", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addressNumberInt2;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKey(JAXBElement<String> value) {
        this.key = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStreetName(JAXBElement<String> value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the addressNumberInt1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddressNumberInt1() {
        return addressNumberInt1;
    }

    /**
     * Sets the value of the addressNumberInt1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddressNumberInt1(JAXBElement<String> value) {
        this.addressNumberInt1 = value;
    }

    /**
     * Gets the value of the addressNumberInt2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddressNumberInt2() {
        return addressNumberInt2;
    }

    /**
     * Sets the value of the addressNumberInt2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddressNumberInt2(JAXBElement<String> value) {
        this.addressNumberInt2 = value;
    }

}

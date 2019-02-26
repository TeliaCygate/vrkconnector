
package org.datacontract.schemas._2004._07.tekla_gis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonAddressResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonAddressResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ResultBase">
 *       &lt;sequence>
 *         &lt;element name="PersonAddress" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}PersonAddress" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonAddressResult", propOrder = {
    "personAddress"
})
public class PersonAddressResult
    extends ResultBase
{

    @XmlElementRef(name = "PersonAddress", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<PersonAddress> personAddress;

    /**
     * Gets the value of the personAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonAddress }{@code >}
     *     
     */
    public JAXBElement<PersonAddress> getPersonAddress() {
        return personAddress;
    }

    /**
     * Sets the value of the personAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonAddress }{@code >}
     *     
     */
    public void setPersonAddress(JAXBElement<PersonAddress> value) {
        this.personAddress = value;
    }

}


package org.datacontract.schemas._2004._07.tekla_gis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonPropertiesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonPropertiesResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ResultBase">
 *       &lt;sequence>
 *         &lt;element name="PersonProperties" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}PersonProperties" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonPropertiesResult", propOrder = {
    "personProperties"
})
public class PersonPropertiesResult
    extends ResultBase
{

    @XmlElementRef(name = "PersonProperties", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<PersonProperties> personProperties;

    /**
     * Gets the value of the personProperties property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonProperties }{@code >}
     *     
     */
    public JAXBElement<PersonProperties> getPersonProperties() {
        return personProperties;
    }

    /**
     * Sets the value of the personProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonProperties }{@code >}
     *     
     */
    public void setPersonProperties(JAXBElement<PersonProperties> value) {
        this.personProperties = value;
    }

}

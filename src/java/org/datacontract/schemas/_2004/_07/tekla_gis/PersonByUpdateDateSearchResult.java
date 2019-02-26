
package org.datacontract.schemas._2004._07.tekla_gis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonByUpdateDateSearchResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonByUpdateDateSearchResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ResultBase">
 *       &lt;sequence>
 *         &lt;element name="PersonByUpdateDateProperties" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfPersonByUpdateDateProperties" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonByUpdateDateSearchResult", propOrder = {
    "personByUpdateDateProperties"
})
public class PersonByUpdateDateSearchResult
    extends ResultBase
{

    @XmlElementRef(name = "PersonByUpdateDateProperties", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfPersonByUpdateDateProperties> personByUpdateDateProperties;

    /**
     * Gets the value of the personByUpdateDateProperties property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPersonByUpdateDateProperties }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPersonByUpdateDateProperties> getPersonByUpdateDateProperties() {
        return personByUpdateDateProperties;
    }

    /**
     * Sets the value of the personByUpdateDateProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPersonByUpdateDateProperties }{@code >}
     *     
     */
    public void setPersonByUpdateDateProperties(JAXBElement<ArrayOfPersonByUpdateDateProperties> value) {
        this.personByUpdateDateProperties = value;
    }

}

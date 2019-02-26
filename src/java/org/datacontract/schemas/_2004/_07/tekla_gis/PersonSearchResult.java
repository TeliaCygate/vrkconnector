
package org.datacontract.schemas._2004._07.tekla_gis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonSearchResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonSearchResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ResultBase">
 *       &lt;sequence>
 *         &lt;element name="PersonSearches" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfPersonSearch" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonSearchResult", propOrder = {
    "personSearches"
})
public class PersonSearchResult
    extends ResultBase
{

    @XmlElementRef(name = "PersonSearches", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfPersonSearch> personSearches;

    /**
     * Gets the value of the personSearches property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPersonSearch }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPersonSearch> getPersonSearches() {
        return personSearches;
    }

    /**
     * Sets the value of the personSearches property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPersonSearch }{@code >}
     *     
     */
    public void setPersonSearches(JAXBElement<ArrayOfPersonSearch> value) {
        this.personSearches = value;
    }

}


package org.datacontract.schemas._2004._07.tekla_gis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonSpouseResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonSpouseResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ResultBase">
 *       &lt;sequence>
 *         &lt;element name="PersonSpouses" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfPersonSpouse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonSpouseResult", propOrder = {
    "personSpouses"
})
public class PersonSpouseResult
    extends ResultBase
{

    @XmlElementRef(name = "PersonSpouses", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfPersonSpouse> personSpouses;

    /**
     * Gets the value of the personSpouses property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPersonSpouse }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPersonSpouse> getPersonSpouses() {
        return personSpouses;
    }

    /**
     * Sets the value of the personSpouses property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPersonSpouse }{@code >}
     *     
     */
    public void setPersonSpouses(JAXBElement<ArrayOfPersonSpouse> value) {
        this.personSpouses = value;
    }

}


package org.datacontract.schemas._2004._07.tekla_gis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonAdditionalInfoResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonAdditionalInfoResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ResultBase">
 *       &lt;sequence>
 *         &lt;element name="PersonAdditionalInfo" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}PersonAdditionalInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonAdditionalInfoResult", propOrder = {
    "personAdditionalInfo"
})
public class PersonAdditionalInfoResult
    extends ResultBase
{

    @XmlElementRef(name = "PersonAdditionalInfo", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<PersonAdditionalInfo> personAdditionalInfo;

    /**
     * Gets the value of the personAdditionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonAdditionalInfo }{@code >}
     *     
     */
    public JAXBElement<PersonAdditionalInfo> getPersonAdditionalInfo() {
        return personAdditionalInfo;
    }

    /**
     * Sets the value of the personAdditionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonAdditionalInfo }{@code >}
     *     
     */
    public void setPersonAdditionalInfo(JAXBElement<PersonAdditionalInfo> value) {
        this.personAdditionalInfo = value;
    }

}

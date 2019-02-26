
package org.datacontract.schemas._2004._07.tekla_gis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonRelationsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonRelationsResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ResultBase">
 *       &lt;sequence>
 *         &lt;element name="PersonRelations" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}PersonRelations" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonRelationsResult", propOrder = {
    "personRelations"
})
public class PersonRelationsResult
    extends ResultBase
{

    @XmlElementRef(name = "PersonRelations", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<PersonRelations> personRelations;

    /**
     * Gets the value of the personRelations property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonRelations }{@code >}
     *     
     */
    public JAXBElement<PersonRelations> getPersonRelations() {
        return personRelations;
    }

    /**
     * Sets the value of the personRelations property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonRelations }{@code >}
     *     
     */
    public void setPersonRelations(JAXBElement<PersonRelations> value) {
        this.personRelations = value;
    }

}

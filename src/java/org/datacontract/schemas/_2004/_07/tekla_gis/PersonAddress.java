
package org.datacontract.schemas._2004._07.tekla_gis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Absences" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfAbsence" minOccurs="0"/>
 *         &lt;element name="Addresses" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfAddress" minOccurs="0"/>
 *         &lt;element name="ContactInfoPostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactInfoPostalOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactInfoStreetAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ForeignAddresses" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfForeignAddress" minOccurs="0"/>
 *         &lt;element name="HomeMunicipality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailingAddresses" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfMailingAddress" minOccurs="0"/>
 *         &lt;element name="Municipalities" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfMunicipality" minOccurs="0"/>
 *         &lt;element name="Residences" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfResidence" minOccurs="0"/>
 *         &lt;element name="YearTurnMunicipality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonAddress", propOrder = {
    "absences",
    "addresses",
    "contactInfoPostalCode",
    "contactInfoPostalOffice",
    "contactInfoStreetAddress",
    "foreignAddresses",
    "homeMunicipality",
    "mailingAddresses",
    "municipalities",
    "residences",
    "yearTurnMunicipality"
})
public class PersonAddress {

    @XmlElementRef(name = "Absences", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfAbsence> absences;
    @XmlElementRef(name = "Addresses", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfAddress> addresses;
    @XmlElementRef(name = "ContactInfoPostalCode", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contactInfoPostalCode;
    @XmlElementRef(name = "ContactInfoPostalOffice", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contactInfoPostalOffice;
    @XmlElementRef(name = "ContactInfoStreetAddress", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contactInfoStreetAddress;
    @XmlElementRef(name = "ForeignAddresses", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfForeignAddress> foreignAddresses;
    @XmlElementRef(name = "HomeMunicipality", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> homeMunicipality;
    @XmlElementRef(name = "MailingAddresses", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMailingAddress> mailingAddresses;
    @XmlElementRef(name = "Municipalities", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMunicipality> municipalities;
    @XmlElementRef(name = "Residences", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfResidence> residences;
    @XmlElementRef(name = "YearTurnMunicipality", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> yearTurnMunicipality;

    /**
     * Gets the value of the absences property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAbsence }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAbsence> getAbsences() {
        return absences;
    }

    /**
     * Sets the value of the absences property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAbsence }{@code >}
     *     
     */
    public void setAbsences(JAXBElement<ArrayOfAbsence> value) {
        this.absences = value;
    }

    /**
     * Gets the value of the addresses property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAddress }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAddress> getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAddress }{@code >}
     *     
     */
    public void setAddresses(JAXBElement<ArrayOfAddress> value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the contactInfoPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContactInfoPostalCode() {
        return contactInfoPostalCode;
    }

    /**
     * Sets the value of the contactInfoPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContactInfoPostalCode(JAXBElement<String> value) {
        this.contactInfoPostalCode = value;
    }

    /**
     * Gets the value of the contactInfoPostalOffice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContactInfoPostalOffice() {
        return contactInfoPostalOffice;
    }

    /**
     * Sets the value of the contactInfoPostalOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContactInfoPostalOffice(JAXBElement<String> value) {
        this.contactInfoPostalOffice = value;
    }

    /**
     * Gets the value of the contactInfoStreetAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContactInfoStreetAddress() {
        return contactInfoStreetAddress;
    }

    /**
     * Sets the value of the contactInfoStreetAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContactInfoStreetAddress(JAXBElement<String> value) {
        this.contactInfoStreetAddress = value;
    }

    /**
     * Gets the value of the foreignAddresses property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfForeignAddress }{@code >}
     *     
     */
    public JAXBElement<ArrayOfForeignAddress> getForeignAddresses() {
        return foreignAddresses;
    }

    /**
     * Sets the value of the foreignAddresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfForeignAddress }{@code >}
     *     
     */
    public void setForeignAddresses(JAXBElement<ArrayOfForeignAddress> value) {
        this.foreignAddresses = value;
    }

    /**
     * Gets the value of the homeMunicipality property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHomeMunicipality() {
        return homeMunicipality;
    }

    /**
     * Sets the value of the homeMunicipality property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHomeMunicipality(JAXBElement<String> value) {
        this.homeMunicipality = value;
    }

    /**
     * Gets the value of the mailingAddresses property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMailingAddress }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMailingAddress> getMailingAddresses() {
        return mailingAddresses;
    }

    /**
     * Sets the value of the mailingAddresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMailingAddress }{@code >}
     *     
     */
    public void setMailingAddresses(JAXBElement<ArrayOfMailingAddress> value) {
        this.mailingAddresses = value;
    }

    /**
     * Gets the value of the municipalities property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMunicipality }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMunicipality> getMunicipalities() {
        return municipalities;
    }

    /**
     * Sets the value of the municipalities property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMunicipality }{@code >}
     *     
     */
    public void setMunicipalities(JAXBElement<ArrayOfMunicipality> value) {
        this.municipalities = value;
    }

    /**
     * Gets the value of the residences property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResidence }{@code >}
     *     
     */
    public JAXBElement<ArrayOfResidence> getResidences() {
        return residences;
    }

    /**
     * Sets the value of the residences property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResidence }{@code >}
     *     
     */
    public void setResidences(JAXBElement<ArrayOfResidence> value) {
        this.residences = value;
    }

    /**
     * Gets the value of the yearTurnMunicipality property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getYearTurnMunicipality() {
        return yearTurnMunicipality;
    }

    /**
     * Sets the value of the yearTurnMunicipality property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setYearTurnMunicipality(JAXBElement<String> value) {
        this.yearTurnMunicipality = value;
    }

}

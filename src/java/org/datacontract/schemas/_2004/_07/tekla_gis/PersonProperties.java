
package org.datacontract.schemas._2004._07.tekla_gis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonProperties">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BirthMunicipality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BirthMunicipalityDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeathDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeathDeclarationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ForeignBirthPlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdentityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdentityCodeHistories" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfIdentityCodeHistory" minOccurs="0"/>
 *         &lt;element name="MaritalStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MaritalStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MotherTongue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MotherTongueDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameHistories" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfNameHistory" minOccurs="0"/>
 *         &lt;element name="Nationalities" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfNationality" minOccurs="0"/>
 *         &lt;element name="SecurityRestrEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecurityRestrStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sex" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SexDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonProperties", propOrder = {
    "birthMunicipality",
    "birthMunicipalityDescription",
    "deathDate",
    "deathDeclarationDate",
    "firstName",
    "foreignBirthPlace",
    "identityCode",
    "identityCodeHistories",
    "maritalStatus",
    "maritalStatusDescription",
    "motherTongue",
    "motherTongueDescription",
    "nameHistories",
    "nationalities",
    "securityRestrEndDate",
    "securityRestrStartDate",
    "sex",
    "sexDescription",
    "surname"
})
public class PersonProperties {

    @XmlElementRef(name = "BirthMunicipality", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> birthMunicipality;
    @XmlElementRef(name = "BirthMunicipalityDescription", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> birthMunicipalityDescription;
    @XmlElementRef(name = "DeathDate", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deathDate;
    @XmlElementRef(name = "DeathDeclarationDate", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deathDeclarationDate;
    @XmlElementRef(name = "FirstName", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> firstName;
    @XmlElementRef(name = "ForeignBirthPlace", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> foreignBirthPlace;
    @XmlElementRef(name = "IdentityCode", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> identityCode;
    @XmlElementRef(name = "IdentityCodeHistories", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIdentityCodeHistory> identityCodeHistories;
    @XmlElement(name = "MaritalStatus")
    protected Integer maritalStatus;
    @XmlElementRef(name = "MaritalStatusDescription", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> maritalStatusDescription;
    @XmlElementRef(name = "MotherTongue", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> motherTongue;
    @XmlElementRef(name = "MotherTongueDescription", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> motherTongueDescription;
    @XmlElementRef(name = "NameHistories", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfNameHistory> nameHistories;
    @XmlElementRef(name = "Nationalities", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfNationality> nationalities;
    @XmlElementRef(name = "SecurityRestrEndDate", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> securityRestrEndDate;
    @XmlElementRef(name = "SecurityRestrStartDate", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> securityRestrStartDate;
    @XmlElement(name = "Sex")
    protected Integer sex;
    @XmlElementRef(name = "SexDescription", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sexDescription;
    @XmlElementRef(name = "Surname", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> surname;

    /**
     * Gets the value of the birthMunicipality property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBirthMunicipality() {
        return birthMunicipality;
    }

    /**
     * Sets the value of the birthMunicipality property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBirthMunicipality(JAXBElement<String> value) {
        this.birthMunicipality = value;
    }

    /**
     * Gets the value of the birthMunicipalityDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBirthMunicipalityDescription() {
        return birthMunicipalityDescription;
    }

    /**
     * Sets the value of the birthMunicipalityDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBirthMunicipalityDescription(JAXBElement<String> value) {
        this.birthMunicipalityDescription = value;
    }

    /**
     * Gets the value of the deathDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeathDate() {
        return deathDate;
    }

    /**
     * Sets the value of the deathDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeathDate(JAXBElement<String> value) {
        this.deathDate = value;
    }

    /**
     * Gets the value of the deathDeclarationDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeathDeclarationDate() {
        return deathDeclarationDate;
    }

    /**
     * Sets the value of the deathDeclarationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeathDeclarationDate(JAXBElement<String> value) {
        this.deathDeclarationDate = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFirstName(JAXBElement<String> value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the foreignBirthPlace property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getForeignBirthPlace() {
        return foreignBirthPlace;
    }

    /**
     * Sets the value of the foreignBirthPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setForeignBirthPlace(JAXBElement<String> value) {
        this.foreignBirthPlace = value;
    }

    /**
     * Gets the value of the identityCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdentityCode() {
        return identityCode;
    }

    /**
     * Sets the value of the identityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdentityCode(JAXBElement<String> value) {
        this.identityCode = value;
    }

    /**
     * Gets the value of the identityCodeHistories property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIdentityCodeHistory }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIdentityCodeHistory> getIdentityCodeHistories() {
        return identityCodeHistories;
    }

    /**
     * Sets the value of the identityCodeHistories property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIdentityCodeHistory }{@code >}
     *     
     */
    public void setIdentityCodeHistories(JAXBElement<ArrayOfIdentityCodeHistory> value) {
        this.identityCodeHistories = value;
    }

    /**
     * Gets the value of the maritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaritalStatus(Integer value) {
        this.maritalStatus = value;
    }

    /**
     * Gets the value of the maritalStatusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMaritalStatusDescription() {
        return maritalStatusDescription;
    }

    /**
     * Sets the value of the maritalStatusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMaritalStatusDescription(JAXBElement<String> value) {
        this.maritalStatusDescription = value;
    }

    /**
     * Gets the value of the motherTongue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMotherTongue() {
        return motherTongue;
    }

    /**
     * Sets the value of the motherTongue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMotherTongue(JAXBElement<String> value) {
        this.motherTongue = value;
    }

    /**
     * Gets the value of the motherTongueDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMotherTongueDescription() {
        return motherTongueDescription;
    }

    /**
     * Sets the value of the motherTongueDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMotherTongueDescription(JAXBElement<String> value) {
        this.motherTongueDescription = value;
    }

    /**
     * Gets the value of the nameHistories property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNameHistory }{@code >}
     *     
     */
    public JAXBElement<ArrayOfNameHistory> getNameHistories() {
        return nameHistories;
    }

    /**
     * Sets the value of the nameHistories property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNameHistory }{@code >}
     *     
     */
    public void setNameHistories(JAXBElement<ArrayOfNameHistory> value) {
        this.nameHistories = value;
    }

    /**
     * Gets the value of the nationalities property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNationality }{@code >}
     *     
     */
    public JAXBElement<ArrayOfNationality> getNationalities() {
        return nationalities;
    }

    /**
     * Sets the value of the nationalities property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNationality }{@code >}
     *     
     */
    public void setNationalities(JAXBElement<ArrayOfNationality> value) {
        this.nationalities = value;
    }

    /**
     * Gets the value of the securityRestrEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecurityRestrEndDate() {
        return securityRestrEndDate;
    }

    /**
     * Sets the value of the securityRestrEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecurityRestrEndDate(JAXBElement<String> value) {
        this.securityRestrEndDate = value;
    }

    /**
     * Gets the value of the securityRestrStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecurityRestrStartDate() {
        return securityRestrStartDate;
    }

    /**
     * Sets the value of the securityRestrStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecurityRestrStartDate(JAXBElement<String> value) {
        this.securityRestrStartDate = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSex(Integer value) {
        this.sex = value;
    }

    /**
     * Gets the value of the sexDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSexDescription() {
        return sexDescription;
    }

    /**
     * Sets the value of the sexDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSexDescription(JAXBElement<String> value) {
        this.sexDescription = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSurname(JAXBElement<String> value) {
        this.surname = value;
    }

}

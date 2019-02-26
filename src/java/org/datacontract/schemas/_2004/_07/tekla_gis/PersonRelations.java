
package org.datacontract.schemas._2004._07.tekla_gis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonRelations complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonRelations">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Childs" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfChild" minOccurs="0"/>
 *         &lt;element name="Custodians" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfCustodian" minOccurs="0"/>
 *         &lt;element name="Dependents" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfDependent" minOccurs="0"/>
 *         &lt;element name="GuardianshipTrStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Parents" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfParent" minOccurs="0"/>
 *         &lt;element name="Supervisors" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}ArrayOfSupervisor" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonRelations", propOrder = {
    "childs",
    "custodians",
    "dependents",
    "guardianshipTrStartDate",
    "parents",
    "supervisors"
})
public class PersonRelations {

    @XmlElementRef(name = "Childs", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfChild> childs;
    @XmlElementRef(name = "Custodians", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfCustodian> custodians;
    @XmlElementRef(name = "Dependents", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDependent> dependents;
    @XmlElementRef(name = "GuardianshipTrStartDate", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guardianshipTrStartDate;
    @XmlElementRef(name = "Parents", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfParent> parents;
    @XmlElementRef(name = "Supervisors", namespace = "http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSupervisor> supervisors;

    /**
     * Gets the value of the childs property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfChild }{@code >}
     *     
     */
    public JAXBElement<ArrayOfChild> getChilds() {
        return childs;
    }

    /**
     * Sets the value of the childs property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfChild }{@code >}
     *     
     */
    public void setChilds(JAXBElement<ArrayOfChild> value) {
        this.childs = value;
    }

    /**
     * Gets the value of the custodians property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCustodian }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCustodian> getCustodians() {
        return custodians;
    }

    /**
     * Sets the value of the custodians property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCustodian }{@code >}
     *     
     */
    public void setCustodians(JAXBElement<ArrayOfCustodian> value) {
        this.custodians = value;
    }

    /**
     * Gets the value of the dependents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDependent }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDependent> getDependents() {
        return dependents;
    }

    /**
     * Sets the value of the dependents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDependent }{@code >}
     *     
     */
    public void setDependents(JAXBElement<ArrayOfDependent> value) {
        this.dependents = value;
    }

    /**
     * Gets the value of the guardianshipTrStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGuardianshipTrStartDate() {
        return guardianshipTrStartDate;
    }

    /**
     * Sets the value of the guardianshipTrStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGuardianshipTrStartDate(JAXBElement<String> value) {
        this.guardianshipTrStartDate = value;
    }

    /**
     * Gets the value of the parents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfParent }{@code >}
     *     
     */
    public JAXBElement<ArrayOfParent> getParents() {
        return parents;
    }

    /**
     * Sets the value of the parents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfParent }{@code >}
     *     
     */
    public void setParents(JAXBElement<ArrayOfParent> value) {
        this.parents = value;
    }

    /**
     * Gets the value of the supervisors property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSupervisor }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSupervisor> getSupervisors() {
        return supervisors;
    }

    /**
     * Sets the value of the supervisors property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSupervisor }{@code >}
     *     
     */
    public void setSupervisors(JAXBElement<ArrayOfSupervisor> value) {
        this.supervisors = value;
    }

}

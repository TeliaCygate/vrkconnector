
package org.datacontract.schemas._2004._07.tekla_gis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPersonSpouse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPersonSpouse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonSpouse" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}PersonSpouse" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPersonSpouse", propOrder = {
    "personSpouse"
})
public class ArrayOfPersonSpouse {

    @XmlElement(name = "PersonSpouse", nillable = true)
    protected List<PersonSpouse> personSpouse;

    /**
     * Gets the value of the personSpouse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personSpouse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonSpouse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonSpouse }
     * 
     * 
     */
    public List<PersonSpouse> getPersonSpouse() {
        if (personSpouse == null) {
            personSpouse = new ArrayList<PersonSpouse>();
        }
        return this.personSpouse;
    }

}
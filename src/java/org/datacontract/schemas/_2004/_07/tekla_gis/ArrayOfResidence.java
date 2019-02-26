
package org.datacontract.schemas._2004._07.tekla_gis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfResidence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfResidence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Residence" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}Residence" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfResidence", propOrder = {
    "residence"
})
public class ArrayOfResidence {

    @XmlElement(name = "Residence", nillable = true)
    protected List<Residence> residence;

    /**
     * Gets the value of the residence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the residence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResidence().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Residence }
     * 
     * 
     */
    public List<Residence> getResidence() {
        if (residence == null) {
            residence = new ArrayList<Residence>();
        }
        return this.residence;
    }

}

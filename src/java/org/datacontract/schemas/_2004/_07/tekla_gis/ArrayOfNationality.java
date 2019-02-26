
package org.datacontract.schemas._2004._07.tekla_gis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfNationality complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfNationality">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nationality" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}Nationality" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfNationality", propOrder = {
    "nationality"
})
public class ArrayOfNationality {

    @XmlElement(name = "Nationality", nillable = true)
    protected List<Nationality> nationality;

    /**
     * Gets the value of the nationality property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nationality property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNationality().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Nationality }
     * 
     * 
     */
    public List<Nationality> getNationality() {
        if (nationality == null) {
            nationality = new ArrayList<Nationality>();
        }
        return this.nationality;
    }

}

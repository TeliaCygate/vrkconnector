
package org.datacontract.schemas._2004._07.tekla_gis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfChild complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfChild">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Child" type="{http://schemas.datacontract.org/2004/07/Tekla.GIS.WebService}Child" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfChild", propOrder = {
    "child"
})
public class ArrayOfChild {

    @XmlElement(name = "Child", nillable = true)
    protected List<Child> child;

    /**
     * Gets the value of the child property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the child property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChild().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Child }
     * 
     * 
     */
    public List<Child> getChild() {
        if (child == null) {
            child = new ArrayList<Child>();
        }
        return this.child;
    }

}

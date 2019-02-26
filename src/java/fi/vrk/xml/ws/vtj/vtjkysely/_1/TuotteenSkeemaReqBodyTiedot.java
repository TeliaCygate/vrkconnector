
package fi.vrk.xml.ws.vtj.vtjkysely._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TuotteenSkeemaReqBodyTiedot complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TuotteenSkeemaReqBodyTiedot">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SoSoNimi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Laji" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TuotteenSkeemaReqBodyTiedot", propOrder = {
    "soSoNimi",
    "laji"
})
public class TuotteenSkeemaReqBodyTiedot {

    @XmlElement(name = "SoSoNimi")
    protected String soSoNimi;
    @XmlElement(name = "Laji")
    protected int laji;

    /**
     * Gets the value of the soSoNimi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoSoNimi() {
        return soSoNimi;
    }

    /**
     * Sets the value of the soSoNimi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoSoNimi(String value) {
        this.soSoNimi = value;
    }

    /**
     * Gets the value of the laji property.
     * 
     */
    public int getLaji() {
        return laji;
    }

    /**
     * Sets the value of the laji property.
     * 
     */
    public void setLaji(int value) {
        this.laji = value;
    }

}

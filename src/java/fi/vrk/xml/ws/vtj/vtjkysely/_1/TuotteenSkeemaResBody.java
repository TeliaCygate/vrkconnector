
package fi.vrk.xml.ws.vtj.vtjkysely._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TuotteenSkeemaResBody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TuotteenSkeemaResBody">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reguest" type="{http://xml.vrk.fi/ws/vtj/vtjkysely/1}TuotteenSkeemaReqBodyTiedot" minOccurs="0"/>
 *         &lt;element name="response" type="{http://xml.vrk.fi/ws/vtj/vtjkysely/1}TuotteenSkeemaResType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TuotteenSkeemaResBody", propOrder = {
    "reguest",
    "response"
})
public class TuotteenSkeemaResBody {

    protected TuotteenSkeemaReqBodyTiedot reguest;
    protected TuotteenSkeemaResType response;

    /**
     * Gets the value of the reguest property.
     * 
     * @return
     *     possible object is
     *     {@link TuotteenSkeemaReqBodyTiedot }
     *     
     */
    public TuotteenSkeemaReqBodyTiedot getReguest() {
        return reguest;
    }

    /**
     * Sets the value of the reguest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TuotteenSkeemaReqBodyTiedot }
     *     
     */
    public void setReguest(TuotteenSkeemaReqBodyTiedot value) {
        this.reguest = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link TuotteenSkeemaResType }
     *     
     */
    public TuotteenSkeemaResType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link TuotteenSkeemaResType }
     *     
     */
    public void setResponse(TuotteenSkeemaResType value) {
        this.response = value;
    }

}

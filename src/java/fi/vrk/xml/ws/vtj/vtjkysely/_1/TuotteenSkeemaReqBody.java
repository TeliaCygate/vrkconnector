
package fi.vrk.xml.ws.vtj.vtjkysely._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TuotteenSkeemaReqBody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TuotteenSkeemaReqBody">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="request" type="{http://xml.vrk.fi/ws/vtj/vtjkysely/1}TuotteenSkeemaReqBodyTiedot" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TuotteenSkeemaReqBody", propOrder = {
    "request"
})
public class TuotteenSkeemaReqBody {

    protected TuotteenSkeemaReqBodyTiedot request;

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link TuotteenSkeemaReqBodyTiedot }
     *     
     */
    public TuotteenSkeemaReqBodyTiedot getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link TuotteenSkeemaReqBodyTiedot }
     *     
     */
    public void setRequest(TuotteenSkeemaReqBodyTiedot value) {
        this.request = value;
    }

}

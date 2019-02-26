
package fi.vrk.xml.ws.vtj.vtjkysely._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HenkiloTunnusKyselyResBody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HenkiloTunnusKyselyResBody">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="request" type="{http://xml.vrk.fi/ws/vtj/vtjkysely/1}HenkiloTunnusKyselyReqBodyTiedot" minOccurs="0"/>
 *         &lt;element name="response" type="{http://xml.vrk.fi/ws/vtj/vtjkysely/1}HenkiloTunnusKyselyResType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HenkiloTunnusKyselyResBody", propOrder = {
    "request",
    "response"
})
public class HenkiloTunnusKyselyResBody {

    protected HenkiloTunnusKyselyReqBodyTiedot request;
    protected HenkiloTunnusKyselyResType response;

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link HenkiloTunnusKyselyReqBodyTiedot }
     *     
     */
    public HenkiloTunnusKyselyReqBodyTiedot getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link HenkiloTunnusKyselyReqBodyTiedot }
     *     
     */
    public void setRequest(HenkiloTunnusKyselyReqBodyTiedot value) {
        this.request = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link HenkiloTunnusKyselyResType }
     *     
     */
    public HenkiloTunnusKyselyResType getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link HenkiloTunnusKyselyResType }
     *     
     */
    public void setResponse(HenkiloTunnusKyselyResType value) {
        this.response = value;
    }

}

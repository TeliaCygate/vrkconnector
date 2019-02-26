
package fi.vrk.xml.ws.vtj.vtjkysely._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HenkiloTunnusKyselyReqBody complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HenkiloTunnusKyselyReqBody">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="request" type="{http://xml.vrk.fi/ws/vtj/vtjkysely/1}HenkiloTunnusKyselyReqBodyTiedot" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HenkiloTunnusKyselyReqBody", propOrder = {
    "request"
})
public class HenkiloTunnusKyselyReqBody {

    protected HenkiloTunnusKyselyReqBodyTiedot request;

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link HenkiloTunnusKyselyReqBodyTiedot }
     *     
     */
    public HenkiloTunnusKyselyReqBodyTiedot getRequest() {
    	if(request == null)
    		request = new HenkiloTunnusKyselyReqBodyTiedot();
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

}

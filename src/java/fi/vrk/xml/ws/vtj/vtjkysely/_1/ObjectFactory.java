
package fi.vrk.xml.ws.vtj.vtjkysely._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fi.vrk.xml.ws.vtj.vtjkysely._1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HaeTuotteenSkeemaResponse_QNAME = new QName("http://xml.vrk.fi/ws/vtj/vtjkysely/1", "HaeTuotteenSkeemaResponse");
    private final static QName _HenkilonTunnusKysely_QNAME = new QName("http://xml.vrk.fi/ws/vtj/vtjkysely/1", "HenkilonTunnusKysely");
    private final static QName _HaeTuotteenSkeema_QNAME = new QName("http://xml.vrk.fi/ws/vtj/vtjkysely/1", "HaeTuotteenSkeema");
    private final static QName _HenkilonTunnusKyselyResponse_QNAME = new QName("http://xml.vrk.fi/ws/vtj/vtjkysely/1", "HenkilonTunnusKyselyResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fi.vrk.xml.ws.vtj.vtjkysely._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TuotteenSkeemaReqBody }
     * 
     */
    public TuotteenSkeemaReqBody createTuotteenSkeemaReqBody() {
        return new TuotteenSkeemaReqBody();
    }

    /**
     * Create an instance of {@link TuotteenSkeemaResBody }
     * 
     */
    public TuotteenSkeemaResBody createTuotteenSkeemaResBody() {
        return new TuotteenSkeemaResBody();
    }

    /**
     * Create an instance of {@link HenkiloTunnusKyselyReqBody }
     * 
     */
    public HenkiloTunnusKyselyReqBody createHenkiloTunnusKyselyReqBody() {
        return new HenkiloTunnusKyselyReqBody();
    }

    /**
     * Create an instance of {@link HenkiloTunnusKyselyResBody }
     * 
     */
    public HenkiloTunnusKyselyResBody createHenkiloTunnusKyselyResBody() {
        return new HenkiloTunnusKyselyResBody();
    }

    /**
     * Create an instance of {@link HenkiloTunnusKyselyReqBodyTiedot }
     * 
     */
    public HenkiloTunnusKyselyReqBodyTiedot createHenkiloTunnusKyselyReqBodyTiedot() {
        return new HenkiloTunnusKyselyReqBodyTiedot();
    }

    /**
     * Create an instance of {@link TuotteenSkeemaResType }
     * 
     */
    public TuotteenSkeemaResType createTuotteenSkeemaResType() {
        return new TuotteenSkeemaResType();
    }

    /**
     * Create an instance of {@link HenkiloTunnusKyselyResType }
     * 
     */
    public HenkiloTunnusKyselyResType createHenkiloTunnusKyselyResType() {
        return new HenkiloTunnusKyselyResType();
    }

    /**
     * Create an instance of {@link TuotteenSkeemaReqBodyTiedot }
     * 
     */
    public TuotteenSkeemaReqBodyTiedot createTuotteenSkeemaReqBodyTiedot() {
        return new TuotteenSkeemaReqBodyTiedot();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TuotteenSkeemaResBody }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.vrk.fi/ws/vtj/vtjkysely/1", name = "HaeTuotteenSkeemaResponse")
    public JAXBElement<TuotteenSkeemaResBody> createHaeTuotteenSkeemaResponse(TuotteenSkeemaResBody value) {
        return new JAXBElement<TuotteenSkeemaResBody>(_HaeTuotteenSkeemaResponse_QNAME, TuotteenSkeemaResBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HenkiloTunnusKyselyReqBody }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.vrk.fi/ws/vtj/vtjkysely/1", name = "HenkilonTunnusKysely")
    public JAXBElement<HenkiloTunnusKyselyReqBody> createHenkilonTunnusKysely(HenkiloTunnusKyselyReqBody value) {
        return new JAXBElement<HenkiloTunnusKyselyReqBody>(_HenkilonTunnusKysely_QNAME, HenkiloTunnusKyselyReqBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TuotteenSkeemaReqBody }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.vrk.fi/ws/vtj/vtjkysely/1", name = "HaeTuotteenSkeema")
    public JAXBElement<TuotteenSkeemaReqBody> createHaeTuotteenSkeema(TuotteenSkeemaReqBody value) {
        return new JAXBElement<TuotteenSkeemaReqBody>(_HaeTuotteenSkeema_QNAME, TuotteenSkeemaReqBody.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HenkiloTunnusKyselyResBody }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.vrk.fi/ws/vtj/vtjkysely/1", name = "HenkilonTunnusKyselyResponse")
    public JAXBElement<HenkiloTunnusKyselyResBody> createHenkilonTunnusKyselyResponse(HenkiloTunnusKyselyResBody value) {
        return new JAXBElement<HenkiloTunnusKyselyResBody>(_HenkilonTunnusKyselyResponse_QNAME, HenkiloTunnusKyselyResBody.class, null, value);
    }

}

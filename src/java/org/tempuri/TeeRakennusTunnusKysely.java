
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SoSoNimi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Kayttajatunnus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Salasana" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Loppukayttaja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Laskutustiedot" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Rakennustunnus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Huoneistotunnus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Vara1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "soSoNimi",
    "kayttajatunnus",
    "salasana",
    "loppukayttaja",
    "laskutustiedot",
    "rakennustunnus",
    "huoneistotunnus",
    "vara1"
})
@XmlRootElement(name = "TeeRakennusTunnusKysely")
public class TeeRakennusTunnusKysely {

    @XmlElement(name = "SoSoNimi")
    protected String soSoNimi;
    @XmlElement(name = "Kayttajatunnus")
    protected String kayttajatunnus;
    @XmlElement(name = "Salasana")
    protected String salasana;
    @XmlElement(name = "Loppukayttaja")
    protected String loppukayttaja;
    @XmlElement(name = "Laskutustiedot")
    protected String laskutustiedot;
    @XmlElement(name = "Rakennustunnus")
    protected String rakennustunnus;
    @XmlElement(name = "Huoneistotunnus")
    protected String huoneistotunnus;
    @XmlElement(name = "Vara1")
    protected String vara1;

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
     * Gets the value of the kayttajatunnus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKayttajatunnus() {
        return kayttajatunnus;
    }

    /**
     * Sets the value of the kayttajatunnus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKayttajatunnus(String value) {
        this.kayttajatunnus = value;
    }

    /**
     * Gets the value of the salasana property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalasana() {
        return salasana;
    }

    /**
     * Sets the value of the salasana property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalasana(String value) {
        this.salasana = value;
    }

    /**
     * Gets the value of the loppukayttaja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoppukayttaja() {
        return loppukayttaja;
    }

    /**
     * Sets the value of the loppukayttaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoppukayttaja(String value) {
        this.loppukayttaja = value;
    }

    /**
     * Gets the value of the laskutustiedot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaskutustiedot() {
        return laskutustiedot;
    }

    /**
     * Sets the value of the laskutustiedot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaskutustiedot(String value) {
        this.laskutustiedot = value;
    }

    /**
     * Gets the value of the rakennustunnus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRakennustunnus() {
        return rakennustunnus;
    }

    /**
     * Sets the value of the rakennustunnus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRakennustunnus(String value) {
        this.rakennustunnus = value;
    }

    /**
     * Gets the value of the huoneistotunnus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHuoneistotunnus() {
        return huoneistotunnus;
    }

    /**
     * Sets the value of the huoneistotunnus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHuoneistotunnus(String value) {
        this.huoneistotunnus = value;
    }

    /**
     * Gets the value of the vara1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVara1() {
        return vara1;
    }

    /**
     * Sets the value of the vara1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVara1(String value) {
        this.vara1 = value;
    }

}

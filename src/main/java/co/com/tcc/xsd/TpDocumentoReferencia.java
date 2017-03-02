
package co.com.tcc.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tpDocumentoReferencia complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tpDocumentoReferencia">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipodocumento" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="numerodocumento" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="fechadocumento" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tpDocumentoReferencia", propOrder = {
    "tipodocumento",
    "numerodocumento",
    "fechadocumento"
})
public class TpDocumentoReferencia {

    @XmlElement(required = true, nillable = true)
    protected String tipodocumento;
    @XmlElement(required = true, nillable = true)
    protected String numerodocumento;
    @XmlElement(required = true, nillable = true)
    protected String fechadocumento;

    /**
     * Obtiene el valor de la propiedad tipodocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipodocumento() {
        return tipodocumento;
    }

    /**
     * Define el valor de la propiedad tipodocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipodocumento(String value) {
        this.tipodocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad numerodocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumerodocumento() {
        return numerodocumento;
    }

    /**
     * Define el valor de la propiedad numerodocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumerodocumento(String value) {
        this.numerodocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad fechadocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechadocumento() {
        return fechadocumento;
    }

    /**
     * Define el valor de la propiedad fechadocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechadocumento(String value) {
        this.fechadocumento = value;
    }

}

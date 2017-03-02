
package co.com.tcc.clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="remesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="URLRelacionEnvio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="URLRotulos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="URLRemesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IMGRelacionEnvio" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="IMGRotulos" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="IMGRemesa" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="respuesta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "remesa",
    "urlRelacionEnvio",
    "urlRotulos",
    "urlRemesa",
    "imgRelacionEnvio",
    "imgRotulos",
    "imgRemesa",
    "respuesta",
    "mensaje"
})
@XmlRootElement(name = "GrabarDespacho4Response")
public class GrabarDespacho4Response {

    protected String remesa;
    @XmlElement(name = "URLRelacionEnvio")
    protected String urlRelacionEnvio;
    @XmlElement(name = "URLRotulos")
    protected String urlRotulos;
    @XmlElement(name = "URLRemesa")
    protected String urlRemesa;
    @XmlElement(name = "IMGRelacionEnvio")
    protected byte[] imgRelacionEnvio;
    @XmlElement(name = "IMGRotulos")
    protected byte[] imgRotulos;
    @XmlElement(name = "IMGRemesa")
    protected byte[] imgRemesa;
    protected int respuesta;
    protected String mensaje;

    /**
     * Obtiene el valor de la propiedad remesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemesa() {
        return remesa;
    }

    /**
     * Define el valor de la propiedad remesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemesa(String value) {
        this.remesa = value;
    }

    /**
     * Obtiene el valor de la propiedad urlRelacionEnvio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURLRelacionEnvio() {
        return urlRelacionEnvio;
    }

    /**
     * Define el valor de la propiedad urlRelacionEnvio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURLRelacionEnvio(String value) {
        this.urlRelacionEnvio = value;
    }

    /**
     * Obtiene el valor de la propiedad urlRotulos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURLRotulos() {
        return urlRotulos;
    }

    /**
     * Define el valor de la propiedad urlRotulos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURLRotulos(String value) {
        this.urlRotulos = value;
    }

    /**
     * Obtiene el valor de la propiedad urlRemesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURLRemesa() {
        return urlRemesa;
    }

    /**
     * Define el valor de la propiedad urlRemesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURLRemesa(String value) {
        this.urlRemesa = value;
    }

    /**
     * Obtiene el valor de la propiedad imgRelacionEnvio.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getIMGRelacionEnvio() {
        return imgRelacionEnvio;
    }

    /**
     * Define el valor de la propiedad imgRelacionEnvio.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setIMGRelacionEnvio(byte[] value) {
        this.imgRelacionEnvio = value;
    }

    /**
     * Obtiene el valor de la propiedad imgRotulos.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getIMGRotulos() {
        return imgRotulos;
    }

    /**
     * Define el valor de la propiedad imgRotulos.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setIMGRotulos(byte[] value) {
        this.imgRotulos = value;
    }

    /**
     * Obtiene el valor de la propiedad imgRemesa.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getIMGRemesa() {
        return imgRemesa;
    }

    /**
     * Define el valor de la propiedad imgRemesa.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setIMGRemesa(byte[] value) {
        this.imgRemesa = value;
    }

    /**
     * Obtiene el valor de la propiedad respuesta.
     * 
     */
    public int getRespuesta() {
        return respuesta;
    }

    /**
     * Define el valor de la propiedad respuesta.
     * 
     */
    public void setRespuesta(int value) {
        this.respuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad mensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Define el valor de la propiedad mensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }

}

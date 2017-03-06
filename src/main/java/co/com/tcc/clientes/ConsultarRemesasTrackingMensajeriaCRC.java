
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
 *         &lt;element name="Clave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaInicial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaFinal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UsuarioLogin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EstadoRemesa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Respuesta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "clave",
    "docReferencia",
    "remesa",
    "fechaInicial",
    "fechaFinal",
    "usuarioLogin",
    "estadoRemesa",
    "respuesta",
    "mensaje"
})
@XmlRootElement(name = "ConsultarRemesasTrackingMensajeriaCRC")
public class ConsultarRemesasTrackingMensajeriaCRC {

    @XmlElement(name = "Clave")
    protected String clave;
    @XmlElement(name = "DocReferencia")
    protected String docReferencia;
    @XmlElement(name = "Remesa")
    protected String remesa;
    @XmlElement(name = "FechaInicial")
    protected String fechaInicial;
    @XmlElement(name = "FechaFinal")
    protected String fechaFinal;
    @XmlElement(name = "UsuarioLogin")
    protected String usuarioLogin;
    @XmlElement(name = "EstadoRemesa", required = true, type = Integer.class, nillable = true)
    protected Integer estadoRemesa;
    @XmlElement(name = "Respuesta")
    protected int respuesta;
    @XmlElement(name = "Mensaje")
    protected String mensaje;

    /**
     * Obtiene el valor de la propiedad clave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClave() {
        return clave;
    }

    /**
     * Define el valor de la propiedad clave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClave(String value) {
        this.clave = value;
    }

    /**
     * Obtiene el valor de la propiedad docReferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocReferencia() {
        return docReferencia;
    }

    /**
     * Define el valor de la propiedad docReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocReferencia(String value) {
        this.docReferencia = value;
    }

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
     * Obtiene el valor de la propiedad fechaInicial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInicial() {
        return fechaInicial;
    }

    /**
     * Define el valor de la propiedad fechaInicial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInicial(String value) {
        this.fechaInicial = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaFinal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Define el valor de la propiedad fechaFinal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaFinal(String value) {
        this.fechaFinal = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioLogin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    /**
     * Define el valor de la propiedad usuarioLogin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioLogin(String value) {
        this.usuarioLogin = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoRemesa.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEstadoRemesa() {
        return estadoRemesa;
    }

    /**
     * Define el valor de la propiedad estadoRemesa.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEstadoRemesa(Integer value) {
        this.estadoRemesa = value;
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

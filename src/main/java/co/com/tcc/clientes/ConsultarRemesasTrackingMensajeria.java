
package co.com.tcc.clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="clave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="docReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaInicial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaFinal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuarioLoguin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoRemesa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="infoRemesaTracking" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "clave",
    "docReferencia",
    "remesa",
    "fechaInicial",
    "fechaFinal",
    "usuarioLoguin",
    "estadoRemesa",
    "infoRemesaTracking",
    "respuesta",
    "mensaje"
})
@XmlRootElement(name = "ConsultarRemesasTrackingMensajeria")
public class ConsultarRemesasTrackingMensajeria {

    protected String clave;
    protected String docReferencia;
    protected String remesa;
    protected String fechaInicial;
    protected String fechaFinal;
    protected String usuarioLoguin;
    protected int estadoRemesa;
    protected String infoRemesaTracking;
    protected int respuesta;
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
     * Obtiene el valor de la propiedad usuarioLoguin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioLoguin() {
        return usuarioLoguin;
    }

    /**
     * Define el valor de la propiedad usuarioLoguin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioLoguin(String value) {
        this.usuarioLoguin = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoRemesa.
     * 
     */
    public int getEstadoRemesa() {
        return estadoRemesa;
    }

    /**
     * Define el valor de la propiedad estadoRemesa.
     * 
     */
    public void setEstadoRemesa(int value) {
        this.estadoRemesa = value;
    }

    /**
     * Obtiene el valor de la propiedad infoRemesaTracking.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoRemesaTracking() {
        return infoRemesaTracking;
    }

    /**
     * Define el valor de la propiedad infoRemesaTracking.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoRemesaTracking(String value) {
        this.infoRemesaTracking = value;
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

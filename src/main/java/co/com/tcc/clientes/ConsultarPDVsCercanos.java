
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
 *         &lt;element name="Latitud" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Longitud" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="CercaniaKMS" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PDVs" type="{http://clientes.tcc.com.co/}ArrayOfClsPuntoDeVenta" minOccurs="0"/>
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
    "latitud",
    "longitud",
    "cercaniaKMS",
    "pdVs",
    "respuesta",
    "mensaje"
})
@XmlRootElement(name = "ConsultarPDVsCercanos")
public class ConsultarPDVsCercanos {

    @XmlElement(name = "Clave")
    protected String clave;
    @XmlElement(name = "Latitud")
    protected double latitud;
    @XmlElement(name = "Longitud")
    protected double longitud;
    @XmlElement(name = "CercaniaKMS")
    protected double cercaniaKMS;
    @XmlElement(name = "PDVs")
    protected ArrayOfClsPuntoDeVenta pdVs;
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
     * Obtiene el valor de la propiedad latitud.
     * 
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * Define el valor de la propiedad latitud.
     * 
     */
    public void setLatitud(double value) {
        this.latitud = value;
    }

    /**
     * Obtiene el valor de la propiedad longitud.
     * 
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * Define el valor de la propiedad longitud.
     * 
     */
    public void setLongitud(double value) {
        this.longitud = value;
    }

    /**
     * Obtiene el valor de la propiedad cercaniaKMS.
     * 
     */
    public double getCercaniaKMS() {
        return cercaniaKMS;
    }

    /**
     * Define el valor de la propiedad cercaniaKMS.
     * 
     */
    public void setCercaniaKMS(double value) {
        this.cercaniaKMS = value;
    }

    /**
     * Obtiene el valor de la propiedad pdVs.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsPuntoDeVenta }
     *     
     */
    public ArrayOfClsPuntoDeVenta getPDVs() {
        return pdVs;
    }

    /**
     * Define el valor de la propiedad pdVs.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsPuntoDeVenta }
     *     
     */
    public void setPDVs(ArrayOfClsPuntoDeVenta value) {
        this.pdVs = value;
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

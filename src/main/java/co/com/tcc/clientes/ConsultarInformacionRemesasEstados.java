
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
 *         &lt;element name="remesas" type="{http://clientes.tcc.com.co/}ArrayOfRemesa" minOccurs="0"/>
 *         &lt;element name="remesasrespuesta" type="{http://clientes.tcc.com.co/}ArrayOfRemesaEstados" minOccurs="0"/>
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
    "remesas",
    "remesasrespuesta",
    "respuesta",
    "mensaje"
})
@XmlRootElement(name = "ConsultarInformacionRemesasEstados")
public class ConsultarInformacionRemesasEstados {

    @XmlElement(name = "Clave")
    protected String clave;
    protected ArrayOfRemesa remesas;
    protected ArrayOfRemesaEstados remesasrespuesta;
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
     * Obtiene el valor de la propiedad remesas.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRemesa }
     *     
     */
    public ArrayOfRemesa getRemesas() {
        return remesas;
    }

    /**
     * Define el valor de la propiedad remesas.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRemesa }
     *     
     */
    public void setRemesas(ArrayOfRemesa value) {
        this.remesas = value;
    }

    /**
     * Obtiene el valor de la propiedad remesasrespuesta.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRemesaEstados }
     *     
     */
    public ArrayOfRemesaEstados getRemesasrespuesta() {
        return remesasrespuesta;
    }

    /**
     * Define el valor de la propiedad remesasrespuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRemesaEstados }
     *     
     */
    public void setRemesasrespuesta(ArrayOfRemesaEstados value) {
        this.remesasrespuesta = value;
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

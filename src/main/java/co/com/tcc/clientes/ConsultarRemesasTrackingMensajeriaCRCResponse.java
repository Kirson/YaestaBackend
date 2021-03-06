
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
 *         &lt;element name="ConsultarRemesasTrackingMensajeriaCRCResult" type="{http://clientes.tcc.com.co/}ArrayOfClsInfoRemesa" minOccurs="0"/>
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
    "consultarRemesasTrackingMensajeriaCRCResult",
    "respuesta",
    "mensaje"
})
@XmlRootElement(name = "ConsultarRemesasTrackingMensajeriaCRCResponse")
public class ConsultarRemesasTrackingMensajeriaCRCResponse {

    @XmlElement(name = "ConsultarRemesasTrackingMensajeriaCRCResult")
    protected ArrayOfClsInfoRemesa consultarRemesasTrackingMensajeriaCRCResult;
    @XmlElement(name = "Respuesta")
    protected int respuesta;
    @XmlElement(name = "Mensaje")
    protected String mensaje;

    /**
     * Obtiene el valor de la propiedad consultarRemesasTrackingMensajeriaCRCResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsInfoRemesa }
     *     
     */
    public ArrayOfClsInfoRemesa getConsultarRemesasTrackingMensajeriaCRCResult() {
        return consultarRemesasTrackingMensajeriaCRCResult;
    }

    /**
     * Define el valor de la propiedad consultarRemesasTrackingMensajeriaCRCResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsInfoRemesa }
     *     
     */
    public void setConsultarRemesasTrackingMensajeriaCRCResult(ArrayOfClsInfoRemesa value) {
        this.consultarRemesasTrackingMensajeriaCRCResult = value;
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

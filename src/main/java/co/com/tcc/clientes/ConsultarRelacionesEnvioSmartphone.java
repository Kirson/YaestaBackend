
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
 *         &lt;element name="Relacion1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Relacion2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Relacion3" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arrRemesas" type="{http://clientes.tcc.com.co/}ArrayOfClsRemesa" minOccurs="0"/>
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
    "relacion1",
    "relacion2",
    "relacion3",
    "arrRemesas",
    "respuesta",
    "mensaje"
})
@XmlRootElement(name = "ConsultarRelacionesEnvioSmartphone")
public class ConsultarRelacionesEnvioSmartphone {

    @XmlElement(name = "Clave")
    protected String clave;
    @XmlElement(name = "Relacion1")
    protected int relacion1;
    @XmlElement(name = "Relacion2")
    protected int relacion2;
    @XmlElement(name = "Relacion3")
    protected int relacion3;
    protected ArrayOfClsRemesa arrRemesas;
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
     * Obtiene el valor de la propiedad relacion1.
     * 
     */
    public int getRelacion1() {
        return relacion1;
    }

    /**
     * Define el valor de la propiedad relacion1.
     * 
     */
    public void setRelacion1(int value) {
        this.relacion1 = value;
    }

    /**
     * Obtiene el valor de la propiedad relacion2.
     * 
     */
    public int getRelacion2() {
        return relacion2;
    }

    /**
     * Define el valor de la propiedad relacion2.
     * 
     */
    public void setRelacion2(int value) {
        this.relacion2 = value;
    }

    /**
     * Obtiene el valor de la propiedad relacion3.
     * 
     */
    public int getRelacion3() {
        return relacion3;
    }

    /**
     * Define el valor de la propiedad relacion3.
     * 
     */
    public void setRelacion3(int value) {
        this.relacion3 = value;
    }

    /**
     * Obtiene el valor de la propiedad arrRemesas.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsRemesa }
     *     
     */
    public ArrayOfClsRemesa getArrRemesas() {
        return arrRemesas;
    }

    /**
     * Define el valor de la propiedad arrRemesas.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsRemesa }
     *     
     */
    public void setArrRemesas(ArrayOfClsRemesa value) {
        this.arrRemesas = value;
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

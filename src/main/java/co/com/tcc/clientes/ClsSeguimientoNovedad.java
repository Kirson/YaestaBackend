
package co.com.tcc.clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clsSeguimientoNovedad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsSeguimientoNovedad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FcrioTcc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FcrioCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="InfoSeg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsSeguimientoNovedad", propOrder = {
    "fcrioTcc",
    "fcrioCliente",
    "fecha",
    "infoSeg"
})
public class ClsSeguimientoNovedad {

    @XmlElement(name = "FcrioTcc")
    protected String fcrioTcc;
    @XmlElement(name = "FcrioCliente")
    protected String fcrioCliente;
    @XmlElement(name = "Fecha", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(name = "InfoSeg")
    protected String infoSeg;

    /**
     * Obtiene el valor de la propiedad fcrioTcc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcrioTcc() {
        return fcrioTcc;
    }

    /**
     * Define el valor de la propiedad fcrioTcc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcrioTcc(String value) {
        this.fcrioTcc = value;
    }

    /**
     * Obtiene el valor de la propiedad fcrioCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFcrioCliente() {
        return fcrioCliente;
    }

    /**
     * Define el valor de la propiedad fcrioCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFcrioCliente(String value) {
        this.fcrioCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad infoSeg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoSeg() {
        return infoSeg;
    }

    /**
     * Define el valor de la propiedad infoSeg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoSeg(String value) {
        this.infoSeg = value;
    }

}

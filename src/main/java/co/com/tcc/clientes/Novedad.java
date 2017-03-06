
package co.com.tcc.clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Novedad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Novedad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigonovedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechanovedad" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="novedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadonovedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Novedad", propOrder = {
    "codigonovedad",
    "fechanovedad",
    "novedad",
    "estadonovedad"
})
public class Novedad {

    protected String codigonovedad;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechanovedad;
    protected String novedad;
    protected String estadonovedad;

    /**
     * Obtiene el valor de la propiedad codigonovedad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigonovedad() {
        return codigonovedad;
    }

    /**
     * Define el valor de la propiedad codigonovedad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigonovedad(String value) {
        this.codigonovedad = value;
    }

    /**
     * Obtiene el valor de la propiedad fechanovedad.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechanovedad() {
        return fechanovedad;
    }

    /**
     * Define el valor de la propiedad fechanovedad.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechanovedad(XMLGregorianCalendar value) {
        this.fechanovedad = value;
    }

    /**
     * Obtiene el valor de la propiedad novedad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNovedad() {
        return novedad;
    }

    /**
     * Define el valor de la propiedad novedad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNovedad(String value) {
        this.novedad = value;
    }

    /**
     * Obtiene el valor de la propiedad estadonovedad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadonovedad() {
        return estadonovedad;
    }

    /**
     * Define el valor de la propiedad estadonovedad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadonovedad(String value) {
        this.estadonovedad = value;
    }

}

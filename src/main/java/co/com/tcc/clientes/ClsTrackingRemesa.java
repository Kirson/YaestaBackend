
package co.com.tcc.clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clsTrackingRemesa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsTrackingRemesa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Locacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CiudadMovimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DepartamentoMovimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaisMovimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsTrackingRemesa", propOrder = {
    "id",
    "locacion",
    "fecha",
    "descripcion",
    "ciudadMovimiento",
    "departamentoMovimiento",
    "paisMovimiento"
})
public class ClsTrackingRemesa {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Locacion")
    protected String locacion;
    @XmlElement(name = "Fecha", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "CiudadMovimiento")
    protected String ciudadMovimiento;
    @XmlElement(name = "DepartamentoMovimiento")
    protected String departamentoMovimiento;
    @XmlElement(name = "PaisMovimiento")
    protected String paisMovimiento;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad locacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocacion() {
        return locacion;
    }

    /**
     * Define el valor de la propiedad locacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocacion(String value) {
        this.locacion = value;
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
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadMovimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudadMovimiento() {
        return ciudadMovimiento;
    }

    /**
     * Define el valor de la propiedad ciudadMovimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudadMovimiento(String value) {
        this.ciudadMovimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad departamentoMovimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamentoMovimiento() {
        return departamentoMovimiento;
    }

    /**
     * Define el valor de la propiedad departamentoMovimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamentoMovimiento(String value) {
        this.departamentoMovimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad paisMovimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaisMovimiento() {
        return paisMovimiento;
    }

    /**
     * Define el valor de la propiedad paisMovimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaisMovimiento(String value) {
        this.paisMovimiento = value;
    }

}

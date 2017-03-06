
package co.com.tcc.clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsPuntoDeVenta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsPuntoDeVenta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NombrePDV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Horario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Latidud" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Longitud" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsPuntoDeVenta", propOrder = {
    "nombrePDV",
    "direccion",
    "telefono",
    "horario",
    "latidud",
    "longitud"
})
public class ClsPuntoDeVenta {

    @XmlElement(name = "NombrePDV")
    protected String nombrePDV;
    @XmlElement(name = "Direccion")
    protected String direccion;
    @XmlElement(name = "Telefono")
    protected String telefono;
    @XmlElement(name = "Horario")
    protected String horario;
    @XmlElement(name = "Latidud")
    protected double latidud;
    @XmlElement(name = "Longitud")
    protected double longitud;

    /**
     * Obtiene el valor de la propiedad nombrePDV.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePDV() {
        return nombrePDV;
    }

    /**
     * Define el valor de la propiedad nombrePDV.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePDV(String value) {
        this.nombrePDV = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Obtiene el valor de la propiedad horario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Define el valor de la propiedad horario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHorario(String value) {
        this.horario = value;
    }

    /**
     * Obtiene el valor de la propiedad latidud.
     * 
     */
    public double getLatidud() {
        return latidud;
    }

    /**
     * Define el valor de la propiedad latidud.
     * 
     */
    public void setLatidud(double value) {
        this.latidud = value;
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

}

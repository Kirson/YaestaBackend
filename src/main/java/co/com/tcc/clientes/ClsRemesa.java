
package co.com.tcc.clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clsRemesa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsRemesa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FechaReporte" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="NroRemesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaRemesa" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Origen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodOrigen" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Destino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodDestino" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CuentaCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CodNovedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaNovedad" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Novedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EstadoNovedad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EsRelacionEnvio" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="URLImagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TieneImagen" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TieneNovedad" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsRemesa", propOrder = {
    "fechaReporte",
    "nroRemesa",
    "fechaRemesa",
    "origen",
    "codOrigen",
    "destino",
    "codDestino",
    "estado",
    "cuentaCliente",
    "codNovedad",
    "fechaNovedad",
    "novedad",
    "estadoNovedad",
    "tipoDocumento",
    "numeroDocumento",
    "esRelacionEnvio",
    "urlImagen",
    "tieneImagen",
    "tieneNovedad"
})
public class ClsRemesa {

    @XmlElement(name = "FechaReporte", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaReporte;
    @XmlElement(name = "NroRemesa")
    protected String nroRemesa;
    @XmlElement(name = "FechaRemesa", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRemesa;
    @XmlElement(name = "Origen")
    protected String origen;
    @XmlElement(name = "CodOrigen")
    protected int codOrigen;
    @XmlElement(name = "Destino")
    protected String destino;
    @XmlElement(name = "CodDestino")
    protected int codDestino;
    @XmlElement(name = "Estado")
    protected String estado;
    @XmlElement(name = "CuentaCliente")
    protected int cuentaCliente;
    @XmlElement(name = "CodNovedad")
    protected String codNovedad;
    @XmlElement(name = "FechaNovedad", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaNovedad;
    @XmlElement(name = "Novedad")
    protected String novedad;
    @XmlElement(name = "EstadoNovedad")
    protected String estadoNovedad;
    @XmlElement(name = "TipoDocumento")
    protected String tipoDocumento;
    @XmlElement(name = "NumeroDocumento")
    protected String numeroDocumento;
    @XmlElement(name = "EsRelacionEnvio")
    protected boolean esRelacionEnvio;
    @XmlElement(name = "URLImagen")
    protected String urlImagen;
    @XmlElement(name = "TieneImagen")
    protected boolean tieneImagen;
    @XmlElement(name = "TieneNovedad")
    protected boolean tieneNovedad;

    /**
     * Obtiene el valor de la propiedad fechaReporte.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaReporte() {
        return fechaReporte;
    }

    /**
     * Define el valor de la propiedad fechaReporte.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaReporte(XMLGregorianCalendar value) {
        this.fechaReporte = value;
    }

    /**
     * Obtiene el valor de la propiedad nroRemesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNroRemesa() {
        return nroRemesa;
    }

    /**
     * Define el valor de la propiedad nroRemesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNroRemesa(String value) {
        this.nroRemesa = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaRemesa.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRemesa() {
        return fechaRemesa;
    }

    /**
     * Define el valor de la propiedad fechaRemesa.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRemesa(XMLGregorianCalendar value) {
        this.fechaRemesa = value;
    }

    /**
     * Obtiene el valor de la propiedad origen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * Define el valor de la propiedad origen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigen(String value) {
        this.origen = value;
    }

    /**
     * Obtiene el valor de la propiedad codOrigen.
     * 
     */
    public int getCodOrigen() {
        return codOrigen;
    }

    /**
     * Define el valor de la propiedad codOrigen.
     * 
     */
    public void setCodOrigen(int value) {
        this.codOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad destino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Define el valor de la propiedad destino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestino(String value) {
        this.destino = value;
    }

    /**
     * Obtiene el valor de la propiedad codDestino.
     * 
     */
    public int getCodDestino() {
        return codDestino;
    }

    /**
     * Define el valor de la propiedad codDestino.
     * 
     */
    public void setCodDestino(int value) {
        this.codDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad cuentaCliente.
     * 
     */
    public int getCuentaCliente() {
        return cuentaCliente;
    }

    /**
     * Define el valor de la propiedad cuentaCliente.
     * 
     */
    public void setCuentaCliente(int value) {
        this.cuentaCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad codNovedad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodNovedad() {
        return codNovedad;
    }

    /**
     * Define el valor de la propiedad codNovedad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodNovedad(String value) {
        this.codNovedad = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaNovedad.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaNovedad() {
        return fechaNovedad;
    }

    /**
     * Define el valor de la propiedad fechaNovedad.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaNovedad(XMLGregorianCalendar value) {
        this.fechaNovedad = value;
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
     * Obtiene el valor de la propiedad estadoNovedad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoNovedad() {
        return estadoNovedad;
    }

    /**
     * Define el valor de la propiedad estadoNovedad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoNovedad(String value) {
        this.estadoNovedad = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Define el valor de la propiedad tipoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumento(String value) {
        this.tipoDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Define el valor de la propiedad numeroDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumento(String value) {
        this.numeroDocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad esRelacionEnvio.
     * 
     */
    public boolean isEsRelacionEnvio() {
        return esRelacionEnvio;
    }

    /**
     * Define el valor de la propiedad esRelacionEnvio.
     * 
     */
    public void setEsRelacionEnvio(boolean value) {
        this.esRelacionEnvio = value;
    }

    /**
     * Obtiene el valor de la propiedad urlImagen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURLImagen() {
        return urlImagen;
    }

    /**
     * Define el valor de la propiedad urlImagen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURLImagen(String value) {
        this.urlImagen = value;
    }

    /**
     * Obtiene el valor de la propiedad tieneImagen.
     * 
     */
    public boolean isTieneImagen() {
        return tieneImagen;
    }

    /**
     * Define el valor de la propiedad tieneImagen.
     * 
     */
    public void setTieneImagen(boolean value) {
        this.tieneImagen = value;
    }

    /**
     * Obtiene el valor de la propiedad tieneNovedad.
     * 
     */
    public boolean isTieneNovedad() {
        return tieneNovedad;
    }

    /**
     * Define el valor de la propiedad tieneNovedad.
     * 
     */
    public void setTieneNovedad(boolean value) {
        this.tieneNovedad = value;
    }

}

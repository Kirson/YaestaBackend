
package co.com.tcc.clientes;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clsInfoRemesa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsInfoRemesa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Remesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdRemesa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Consecutivo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fecharemesa" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Docreferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigenMpio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodOrigenMpio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DestinoMpio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodDestinoMpio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EstadoRemesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodEstadoRemesa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TieneImagen" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NombRemitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DireccionRemitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CuentaRemitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NombreDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DireccionDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaEntrega" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Unidades" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PesoReal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CodPostalRte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaHoraInicialRecogida" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FechaHoraFinalRecogida" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FechaHoraBaseCumplimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FechaHoraEstimadaEntregaCumplimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Cumplimiento" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CodPostalDrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HorasParaCumplido" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Tracking" type="{http://clientes.tcc.com.co/}ArrayOfClsTrackingRemesa" minOccurs="0"/>
 *         &lt;element name="Novedades" type="{http://clientes.tcc.com.co/}ArrayOfClsNovedadRemesa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsInfoRemesa", propOrder = {
    "remesa",
    "idRemesa",
    "consecutivo",
    "numero",
    "fecharemesa",
    "docreferencia",
    "origenMpio",
    "codOrigenMpio",
    "destinoMpio",
    "codDestinoMpio",
    "estadoRemesa",
    "codEstadoRemesa",
    "tieneImagen",
    "nombRemitente",
    "direccionRemitente",
    "cuentaRemitente",
    "nombreDestinatario",
    "direccionDestinatario",
    "fechaEntrega",
    "unidades",
    "pesoReal",
    "codPostalRte",
    "fechaHoraInicialRecogida",
    "fechaHoraFinalRecogida",
    "fechaHoraBaseCumplimiento",
    "fechaHoraEstimadaEntregaCumplimiento",
    "cumplimiento",
    "codPostalDrio",
    "horasParaCumplido",
    "tracking",
    "novedades"
})
public class ClsInfoRemesa {

    @XmlElement(name = "Remesa")
    protected String remesa;
    @XmlElement(name = "IdRemesa", required = true, type = Integer.class, nillable = true)
    protected Integer idRemesa;
    @XmlElement(name = "Consecutivo", required = true, type = Integer.class, nillable = true)
    protected Integer consecutivo;
    @XmlElement(name = "Numero")
    protected String numero;
    @XmlElement(name = "Fecharemesa", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecharemesa;
    @XmlElement(name = "Docreferencia")
    protected String docreferencia;
    @XmlElement(name = "OrigenMpio")
    protected String origenMpio;
    @XmlElement(name = "CodOrigenMpio", required = true, type = Integer.class, nillable = true)
    protected Integer codOrigenMpio;
    @XmlElement(name = "DestinoMpio")
    protected String destinoMpio;
    @XmlElement(name = "CodDestinoMpio", required = true, type = Integer.class, nillable = true)
    protected Integer codDestinoMpio;
    @XmlElement(name = "EstadoRemesa")
    protected String estadoRemesa;
    @XmlElement(name = "CodEstadoRemesa", required = true, type = Integer.class, nillable = true)
    protected Integer codEstadoRemesa;
    @XmlElement(name = "TieneImagen", required = true, type = Boolean.class, nillable = true)
    protected Boolean tieneImagen;
    @XmlElement(name = "NombRemitente")
    protected String nombRemitente;
    @XmlElement(name = "DireccionRemitente")
    protected String direccionRemitente;
    @XmlElement(name = "CuentaRemitente")
    protected String cuentaRemitente;
    @XmlElement(name = "NombreDestinatario")
    protected String nombreDestinatario;
    @XmlElement(name = "DireccionDestinatario")
    protected String direccionDestinatario;
    @XmlElement(name = "FechaEntrega", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaEntrega;
    @XmlElement(name = "Unidades", required = true, type = Integer.class, nillable = true)
    protected Integer unidades;
    @XmlElement(name = "PesoReal", required = true, nillable = true)
    protected BigDecimal pesoReal;
    @XmlElement(name = "CodPostalRte")
    protected String codPostalRte;
    @XmlElement(name = "FechaHoraInicialRecogida", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraInicialRecogida;
    @XmlElement(name = "FechaHoraFinalRecogida", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraFinalRecogida;
    @XmlElement(name = "FechaHoraBaseCumplimiento", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraBaseCumplimiento;
    @XmlElement(name = "FechaHoraEstimadaEntregaCumplimiento", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraEstimadaEntregaCumplimiento;
    @XmlElement(name = "Cumplimiento", required = true, type = Boolean.class, nillable = true)
    protected Boolean cumplimiento;
    @XmlElement(name = "CodPostalDrio")
    protected String codPostalDrio;
    @XmlElement(name = "HorasParaCumplido", required = true, type = Integer.class, nillable = true)
    protected Integer horasParaCumplido;
    @XmlElement(name = "Tracking")
    protected ArrayOfClsTrackingRemesa tracking;
    @XmlElement(name = "Novedades")
    protected ArrayOfClsNovedadRemesa novedades;

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
     * Obtiene el valor de la propiedad idRemesa.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdRemesa() {
        return idRemesa;
    }

    /**
     * Define el valor de la propiedad idRemesa.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdRemesa(Integer value) {
        this.idRemesa = value;
    }

    /**
     * Obtiene el valor de la propiedad consecutivo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getConsecutivo() {
        return consecutivo;
    }

    /**
     * Define el valor de la propiedad consecutivo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setConsecutivo(Integer value) {
        this.consecutivo = value;
    }

    /**
     * Obtiene el valor de la propiedad numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obtiene el valor de la propiedad fecharemesa.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecharemesa() {
        return fecharemesa;
    }

    /**
     * Define el valor de la propiedad fecharemesa.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecharemesa(XMLGregorianCalendar value) {
        this.fecharemesa = value;
    }

    /**
     * Obtiene el valor de la propiedad docreferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocreferencia() {
        return docreferencia;
    }

    /**
     * Define el valor de la propiedad docreferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocreferencia(String value) {
        this.docreferencia = value;
    }

    /**
     * Obtiene el valor de la propiedad origenMpio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigenMpio() {
        return origenMpio;
    }

    /**
     * Define el valor de la propiedad origenMpio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigenMpio(String value) {
        this.origenMpio = value;
    }

    /**
     * Obtiene el valor de la propiedad codOrigenMpio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodOrigenMpio() {
        return codOrigenMpio;
    }

    /**
     * Define el valor de la propiedad codOrigenMpio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodOrigenMpio(Integer value) {
        this.codOrigenMpio = value;
    }

    /**
     * Obtiene el valor de la propiedad destinoMpio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinoMpio() {
        return destinoMpio;
    }

    /**
     * Define el valor de la propiedad destinoMpio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinoMpio(String value) {
        this.destinoMpio = value;
    }

    /**
     * Obtiene el valor de la propiedad codDestinoMpio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodDestinoMpio() {
        return codDestinoMpio;
    }

    /**
     * Define el valor de la propiedad codDestinoMpio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodDestinoMpio(Integer value) {
        this.codDestinoMpio = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoRemesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoRemesa() {
        return estadoRemesa;
    }

    /**
     * Define el valor de la propiedad estadoRemesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoRemesa(String value) {
        this.estadoRemesa = value;
    }

    /**
     * Obtiene el valor de la propiedad codEstadoRemesa.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodEstadoRemesa() {
        return codEstadoRemesa;
    }

    /**
     * Define el valor de la propiedad codEstadoRemesa.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodEstadoRemesa(Integer value) {
        this.codEstadoRemesa = value;
    }

    /**
     * Obtiene el valor de la propiedad tieneImagen.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTieneImagen() {
        return tieneImagen;
    }

    /**
     * Define el valor de la propiedad tieneImagen.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTieneImagen(Boolean value) {
        this.tieneImagen = value;
    }

    /**
     * Obtiene el valor de la propiedad nombRemitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombRemitente() {
        return nombRemitente;
    }

    /**
     * Define el valor de la propiedad nombRemitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombRemitente(String value) {
        this.nombRemitente = value;
    }

    /**
     * Obtiene el valor de la propiedad direccionRemitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionRemitente() {
        return direccionRemitente;
    }

    /**
     * Define el valor de la propiedad direccionRemitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionRemitente(String value) {
        this.direccionRemitente = value;
    }

    /**
     * Obtiene el valor de la propiedad cuentaRemitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuentaRemitente() {
        return cuentaRemitente;
    }

    /**
     * Define el valor de la propiedad cuentaRemitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuentaRemitente(String value) {
        this.cuentaRemitente = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDestinatario() {
        return nombreDestinatario;
    }

    /**
     * Define el valor de la propiedad nombreDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDestinatario(String value) {
        this.nombreDestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad direccionDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    /**
     * Define el valor de la propiedad direccionDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionDestinatario(String value) {
        this.direccionDestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEntrega.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Define el valor de la propiedad fechaEntrega.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaEntrega(XMLGregorianCalendar value) {
        this.fechaEntrega = value;
    }

    /**
     * Obtiene el valor de la propiedad unidades.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUnidades() {
        return unidades;
    }

    /**
     * Define el valor de la propiedad unidades.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUnidades(Integer value) {
        this.unidades = value;
    }

    /**
     * Obtiene el valor de la propiedad pesoReal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPesoReal() {
        return pesoReal;
    }

    /**
     * Define el valor de la propiedad pesoReal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPesoReal(BigDecimal value) {
        this.pesoReal = value;
    }

    /**
     * Obtiene el valor de la propiedad codPostalRte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPostalRte() {
        return codPostalRte;
    }

    /**
     * Define el valor de la propiedad codPostalRte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPostalRte(String value) {
        this.codPostalRte = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraInicialRecogida.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraInicialRecogida() {
        return fechaHoraInicialRecogida;
    }

    /**
     * Define el valor de la propiedad fechaHoraInicialRecogida.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraInicialRecogida(XMLGregorianCalendar value) {
        this.fechaHoraInicialRecogida = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraFinalRecogida.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraFinalRecogida() {
        return fechaHoraFinalRecogida;
    }

    /**
     * Define el valor de la propiedad fechaHoraFinalRecogida.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraFinalRecogida(XMLGregorianCalendar value) {
        this.fechaHoraFinalRecogida = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraBaseCumplimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraBaseCumplimiento() {
        return fechaHoraBaseCumplimiento;
    }

    /**
     * Define el valor de la propiedad fechaHoraBaseCumplimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraBaseCumplimiento(XMLGregorianCalendar value) {
        this.fechaHoraBaseCumplimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraEstimadaEntregaCumplimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraEstimadaEntregaCumplimiento() {
        return fechaHoraEstimadaEntregaCumplimiento;
    }

    /**
     * Define el valor de la propiedad fechaHoraEstimadaEntregaCumplimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraEstimadaEntregaCumplimiento(XMLGregorianCalendar value) {
        this.fechaHoraEstimadaEntregaCumplimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad cumplimiento.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCumplimiento() {
        return cumplimiento;
    }

    /**
     * Define el valor de la propiedad cumplimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCumplimiento(Boolean value) {
        this.cumplimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad codPostalDrio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPostalDrio() {
        return codPostalDrio;
    }

    /**
     * Define el valor de la propiedad codPostalDrio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPostalDrio(String value) {
        this.codPostalDrio = value;
    }

    /**
     * Obtiene el valor de la propiedad horasParaCumplido.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHorasParaCumplido() {
        return horasParaCumplido;
    }

    /**
     * Define el valor de la propiedad horasParaCumplido.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHorasParaCumplido(Integer value) {
        this.horasParaCumplido = value;
    }

    /**
     * Obtiene el valor de la propiedad tracking.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsTrackingRemesa }
     *     
     */
    public ArrayOfClsTrackingRemesa getTracking() {
        return tracking;
    }

    /**
     * Define el valor de la propiedad tracking.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsTrackingRemesa }
     *     
     */
    public void setTracking(ArrayOfClsTrackingRemesa value) {
        this.tracking = value;
    }

    /**
     * Obtiene el valor de la propiedad novedades.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsNovedadRemesa }
     *     
     */
    public ArrayOfClsNovedadRemesa getNovedades() {
        return novedades;
    }

    /**
     * Define el valor de la propiedad novedades.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsNovedadRemesa }
     *     
     */
    public void setNovedades(ArrayOfClsNovedadRemesa value) {
        this.novedades = value;
    }

}

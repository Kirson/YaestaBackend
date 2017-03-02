//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.02.26 a las 08:51:58 PM ECT 
//


package com.yaesta.integration.tcc.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clsDespachoPaqueteria complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsDespachoPaqueteria"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IDDespacho" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="CodigoLote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FechaHoraLote" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="FechaHoraRecepcion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="FechaDespacho" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="IDClienteRemitente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="IDCiudadCliente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="IDSucursalRemitente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="CodigoCuentaRemitente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="NombreRemitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IDTipoIdentificacionRte" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="NumeroIdentificacionRte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TelefonoRte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DireccionRte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CodigoDaneOrigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IDOrigen" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="IDCDOrigen" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="NombreDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IDTipoIdentificacionDrio" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="NumeroIdentificacionDrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TelefonoDrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DireccionDrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CodigoDaneDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IDDestino" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="BarrioDrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IDCDDestino" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="TotalUnidades" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="TotalPeso" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="TotalPesoFacturado" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="TotalValorMercancia" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="TipoServicioTCC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Comentarios" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NumeroRemesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IDEstadoDespacho" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="FechaHoraCreacion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="UsuarioCreacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FechaHoraUltimaModificacion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="UsuarioUltimaModificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ComentarioAnulacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FechaHoraAnulacion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="UsuarioAnulacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TipoDocumentoReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NumeroDocumentoReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FechaDocumentoReferencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="DocumentosDevolver" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="DocumentosEntregar" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EsEntregaBodega" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="CentroCosto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CiudadOrigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DepartamentoOrigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CiudadDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DepartamentoDestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="detDespacho" type="{http://clientes.tcc.com.co/}ArrayOfClsDespachoPaqueteriaDetalle" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsDespachoPaqueteria", propOrder = {
    "idDespacho",
    "codigoLote",
    "fechaHoraLote",
    "fechaHoraRecepcion",
    "fechaDespacho",
    "idClienteRemitente",
    "idCiudadCliente",
    "idSucursalRemitente",
    "codigoCuentaRemitente",
    "nombreRemitente",
    "idTipoIdentificacionRte",
    "numeroIdentificacionRte",
    "telefonoRte",
    "direccionRte",
    "codigoDaneOrigen",
    "idOrigen",
    "idcdOrigen",
    "nombreDestinatario",
    "idTipoIdentificacionDrio",
    "numeroIdentificacionDrio",
    "telefonoDrio",
    "direccionDrio",
    "codigoDaneDestino",
    "idDestino",
    "barrioDrio",
    "idcdDestino",
    "totalUnidades",
    "totalPeso",
    "totalPesoFacturado",
    "totalValorMercancia",
    "tipoServicioTCC",
    "comentarios",
    "numeroRemesa",
    "idEstadoDespacho",
    "fechaHoraCreacion",
    "usuarioCreacion",
    "fechaHoraUltimaModificacion",
    "usuarioUltimaModificacion",
    "comentarioAnulacion",
    "fechaHoraAnulacion",
    "usuarioAnulacion",
    "tipoDocumentoReferencia",
    "numeroDocumentoReferencia",
    "fechaDocumentoReferencia",
    "documentosDevolver",
    "documentosEntregar",
    "esEntregaBodega",
    "centroCosto",
    "ciudadOrigen",
    "departamentoOrigen",
    "ciudadDestino",
    "departamentoDestino",
    "detDespacho"
})
public class ClsDespachoPaqueteria {

    @XmlElement(name = "IDDespacho", required = true, type = Integer.class, nillable = true)
    protected Integer idDespacho;
    @XmlElement(name = "CodigoLote")
    protected String codigoLote;
    @XmlElement(name = "FechaHoraLote", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraLote;
    @XmlElement(name = "FechaHoraRecepcion", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraRecepcion;
    @XmlElement(name = "FechaDespacho", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaDespacho;
    @XmlElement(name = "IDClienteRemitente", required = true, type = Integer.class, nillable = true)
    protected Integer idClienteRemitente;
    @XmlElement(name = "IDCiudadCliente", required = true, type = Integer.class, nillable = true)
    protected Integer idCiudadCliente;
    @XmlElement(name = "IDSucursalRemitente", required = true, type = Integer.class, nillable = true)
    protected Integer idSucursalRemitente;
    @XmlElement(name = "CodigoCuentaRemitente", required = true, type = Integer.class, nillable = true)
    protected Integer codigoCuentaRemitente;
    @XmlElement(name = "NombreRemitente")
    protected String nombreRemitente;
    @XmlElement(name = "IDTipoIdentificacionRte", required = true, type = Integer.class, nillable = true)
    protected Integer idTipoIdentificacionRte;
    @XmlElement(name = "NumeroIdentificacionRte")
    protected String numeroIdentificacionRte;
    @XmlElement(name = "TelefonoRte")
    protected String telefonoRte;
    @XmlElement(name = "DireccionRte")
    protected String direccionRte;
    @XmlElement(name = "CodigoDaneOrigen")
    protected String codigoDaneOrigen;
    @XmlElement(name = "IDOrigen", required = true, type = Integer.class, nillable = true)
    protected Integer idOrigen;
    @XmlElement(name = "IDCDOrigen", required = true, type = Integer.class, nillable = true)
    protected Integer idcdOrigen;
    @XmlElement(name = "NombreDestinatario")
    protected String nombreDestinatario;
    @XmlElement(name = "IDTipoIdentificacionDrio", required = true, type = Integer.class, nillable = true)
    protected Integer idTipoIdentificacionDrio;
    @XmlElement(name = "NumeroIdentificacionDrio")
    protected String numeroIdentificacionDrio;
    @XmlElement(name = "TelefonoDrio")
    protected String telefonoDrio;
    @XmlElement(name = "DireccionDrio")
    protected String direccionDrio;
    @XmlElement(name = "CodigoDaneDestino")
    protected String codigoDaneDestino;
    @XmlElement(name = "IDDestino", required = true, type = Integer.class, nillable = true)
    protected Integer idDestino;
    @XmlElement(name = "BarrioDrio")
    protected String barrioDrio;
    @XmlElement(name = "IDCDDestino", required = true, type = Integer.class, nillable = true)
    protected Integer idcdDestino;
    @XmlElement(name = "TotalUnidades", required = true, type = Integer.class, nillable = true)
    protected Integer totalUnidades;
    @XmlElement(name = "TotalPeso", required = true, type = Double.class, nillable = true)
    protected Double totalPeso;
    @XmlElement(name = "TotalPesoFacturado", required = true, type = Double.class, nillable = true)
    protected Double totalPesoFacturado;
    @XmlElement(name = "TotalValorMercancia", required = true, type = Double.class, nillable = true)
    protected Double totalValorMercancia;
    @XmlElement(name = "TipoServicioTCC")
    protected String tipoServicioTCC;
    @XmlElement(name = "Comentarios")
    protected String comentarios;
    @XmlElement(name = "NumeroRemesa")
    protected String numeroRemesa;
    @XmlElement(name = "IDEstadoDespacho", required = true, type = Integer.class, nillable = true)
    protected Integer idEstadoDespacho;
    @XmlElement(name = "FechaHoraCreacion", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraCreacion;
    @XmlElement(name = "UsuarioCreacion")
    protected String usuarioCreacion;
    @XmlElement(name = "FechaHoraUltimaModificacion", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraUltimaModificacion;
    @XmlElement(name = "UsuarioUltimaModificacion")
    protected String usuarioUltimaModificacion;
    @XmlElement(name = "ComentarioAnulacion")
    protected String comentarioAnulacion;
    @XmlElement(name = "FechaHoraAnulacion", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraAnulacion;
    @XmlElement(name = "UsuarioAnulacion")
    protected String usuarioAnulacion;
    @XmlElement(name = "TipoDocumentoReferencia")
    protected String tipoDocumentoReferencia;
    @XmlElement(name = "NumeroDocumentoReferencia")
    protected String numeroDocumentoReferencia;
    @XmlElement(name = "FechaDocumentoReferencia", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaDocumentoReferencia;
    @XmlElement(name = "DocumentosDevolver", required = true, type = Integer.class, nillable = true)
    protected Integer documentosDevolver;
    @XmlElement(name = "DocumentosEntregar", required = true, type = Integer.class, nillable = true)
    protected Integer documentosEntregar;
    @XmlElement(name = "EsEntregaBodega")
    protected boolean esEntregaBodega;
    @XmlElement(name = "CentroCosto")
    protected String centroCosto;
    @XmlElement(name = "CiudadOrigen")
    protected String ciudadOrigen;
    @XmlElement(name = "DepartamentoOrigen")
    protected String departamentoOrigen;
    @XmlElement(name = "CiudadDestino")
    protected String ciudadDestino;
    @XmlElement(name = "DepartamentoDestino")
    protected String departamentoDestino;
    protected ArrayOfClsDespachoPaqueteriaDetalle detDespacho;

    /**
     * Obtiene el valor de la propiedad idDespacho.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDDespacho() {
        return idDespacho;
    }

    /**
     * Define el valor de la propiedad idDespacho.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDDespacho(Integer value) {
        this.idDespacho = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoLote.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoLote() {
        return codigoLote;
    }

    /**
     * Define el valor de la propiedad codigoLote.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoLote(String value) {
        this.codigoLote = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraLote.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraLote() {
        return fechaHoraLote;
    }

    /**
     * Define el valor de la propiedad fechaHoraLote.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraLote(XMLGregorianCalendar value) {
        this.fechaHoraLote = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraRecepcion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraRecepcion() {
        return fechaHoraRecepcion;
    }

    /**
     * Define el valor de la propiedad fechaHoraRecepcion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraRecepcion(XMLGregorianCalendar value) {
        this.fechaHoraRecepcion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDespacho.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaDespacho() {
        return fechaDespacho;
    }

    /**
     * Define el valor de la propiedad fechaDespacho.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaDespacho(XMLGregorianCalendar value) {
        this.fechaDespacho = value;
    }

    /**
     * Obtiene el valor de la propiedad idClienteRemitente.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDClienteRemitente() {
        return idClienteRemitente;
    }

    /**
     * Define el valor de la propiedad idClienteRemitente.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDClienteRemitente(Integer value) {
        this.idClienteRemitente = value;
    }

    /**
     * Obtiene el valor de la propiedad idCiudadCliente.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDCiudadCliente() {
        return idCiudadCliente;
    }

    /**
     * Define el valor de la propiedad idCiudadCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDCiudadCliente(Integer value) {
        this.idCiudadCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad idSucursalRemitente.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDSucursalRemitente() {
        return idSucursalRemitente;
    }

    /**
     * Define el valor de la propiedad idSucursalRemitente.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDSucursalRemitente(Integer value) {
        this.idSucursalRemitente = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoCuentaRemitente.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoCuentaRemitente() {
        return codigoCuentaRemitente;
    }

    /**
     * Define el valor de la propiedad codigoCuentaRemitente.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoCuentaRemitente(Integer value) {
        this.codigoCuentaRemitente = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreRemitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreRemitente() {
        return nombreRemitente;
    }

    /**
     * Define el valor de la propiedad nombreRemitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreRemitente(String value) {
        this.nombreRemitente = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoIdentificacionRte.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDTipoIdentificacionRte() {
        return idTipoIdentificacionRte;
    }

    /**
     * Define el valor de la propiedad idTipoIdentificacionRte.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDTipoIdentificacionRte(Integer value) {
        this.idTipoIdentificacionRte = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroIdentificacionRte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIdentificacionRte() {
        return numeroIdentificacionRte;
    }

    /**
     * Define el valor de la propiedad numeroIdentificacionRte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIdentificacionRte(String value) {
        this.numeroIdentificacionRte = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonoRte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonoRte() {
        return telefonoRte;
    }

    /**
     * Define el valor de la propiedad telefonoRte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonoRte(String value) {
        this.telefonoRte = value;
    }

    /**
     * Obtiene el valor de la propiedad direccionRte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionRte() {
        return direccionRte;
    }

    /**
     * Define el valor de la propiedad direccionRte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionRte(String value) {
        this.direccionRte = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoDaneOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoDaneOrigen() {
        return codigoDaneOrigen;
    }

    /**
     * Define el valor de la propiedad codigoDaneOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoDaneOrigen(String value) {
        this.codigoDaneOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad idOrigen.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDOrigen() {
        return idOrigen;
    }

    /**
     * Define el valor de la propiedad idOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDOrigen(Integer value) {
        this.idOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad idcdOrigen.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDCDOrigen() {
        return idcdOrigen;
    }

    /**
     * Define el valor de la propiedad idcdOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDCDOrigen(Integer value) {
        this.idcdOrigen = value;
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
     * Obtiene el valor de la propiedad idTipoIdentificacionDrio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDTipoIdentificacionDrio() {
        return idTipoIdentificacionDrio;
    }

    /**
     * Define el valor de la propiedad idTipoIdentificacionDrio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDTipoIdentificacionDrio(Integer value) {
        this.idTipoIdentificacionDrio = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroIdentificacionDrio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIdentificacionDrio() {
        return numeroIdentificacionDrio;
    }

    /**
     * Define el valor de la propiedad numeroIdentificacionDrio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIdentificacionDrio(String value) {
        this.numeroIdentificacionDrio = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonoDrio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonoDrio() {
        return telefonoDrio;
    }

    /**
     * Define el valor de la propiedad telefonoDrio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonoDrio(String value) {
        this.telefonoDrio = value;
    }

    /**
     * Obtiene el valor de la propiedad direccionDrio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionDrio() {
        return direccionDrio;
    }

    /**
     * Define el valor de la propiedad direccionDrio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionDrio(String value) {
        this.direccionDrio = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoDaneDestino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoDaneDestino() {
        return codigoDaneDestino;
    }

    /**
     * Define el valor de la propiedad codigoDaneDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoDaneDestino(String value) {
        this.codigoDaneDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad idDestino.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDDestino() {
        return idDestino;
    }

    /**
     * Define el valor de la propiedad idDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDDestino(Integer value) {
        this.idDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad barrioDrio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarrioDrio() {
        return barrioDrio;
    }

    /**
     * Define el valor de la propiedad barrioDrio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarrioDrio(String value) {
        this.barrioDrio = value;
    }

    /**
     * Obtiene el valor de la propiedad idcdDestino.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDCDDestino() {
        return idcdDestino;
    }

    /**
     * Define el valor de la propiedad idcdDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDCDDestino(Integer value) {
        this.idcdDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad totalUnidades.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalUnidades() {
        return totalUnidades;
    }

    /**
     * Define el valor de la propiedad totalUnidades.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalUnidades(Integer value) {
        this.totalUnidades = value;
    }

    /**
     * Obtiene el valor de la propiedad totalPeso.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalPeso() {
        return totalPeso;
    }

    /**
     * Define el valor de la propiedad totalPeso.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalPeso(Double value) {
        this.totalPeso = value;
    }

    /**
     * Obtiene el valor de la propiedad totalPesoFacturado.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalPesoFacturado() {
        return totalPesoFacturado;
    }

    /**
     * Define el valor de la propiedad totalPesoFacturado.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalPesoFacturado(Double value) {
        this.totalPesoFacturado = value;
    }

    /**
     * Obtiene el valor de la propiedad totalValorMercancia.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalValorMercancia() {
        return totalValorMercancia;
    }

    /**
     * Define el valor de la propiedad totalValorMercancia.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalValorMercancia(Double value) {
        this.totalValorMercancia = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoServicioTCC.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoServicioTCC() {
        return tipoServicioTCC;
    }

    /**
     * Define el valor de la propiedad tipoServicioTCC.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoServicioTCC(String value) {
        this.tipoServicioTCC = value;
    }

    /**
     * Obtiene el valor de la propiedad comentarios.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Define el valor de la propiedad comentarios.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComentarios(String value) {
        this.comentarios = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroRemesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroRemesa() {
        return numeroRemesa;
    }

    /**
     * Define el valor de la propiedad numeroRemesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroRemesa(String value) {
        this.numeroRemesa = value;
    }

    /**
     * Obtiene el valor de la propiedad idEstadoDespacho.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDEstadoDespacho() {
        return idEstadoDespacho;
    }

    /**
     * Define el valor de la propiedad idEstadoDespacho.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDEstadoDespacho(Integer value) {
        this.idEstadoDespacho = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraCreacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    /**
     * Define el valor de la propiedad fechaHoraCreacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraCreacion(XMLGregorianCalendar value) {
        this.fechaHoraCreacion = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioCreacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    /**
     * Define el valor de la propiedad usuarioCreacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioCreacion(String value) {
        this.usuarioCreacion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraUltimaModificacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraUltimaModificacion() {
        return fechaHoraUltimaModificacion;
    }

    /**
     * Define el valor de la propiedad fechaHoraUltimaModificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraUltimaModificacion(XMLGregorianCalendar value) {
        this.fechaHoraUltimaModificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioUltimaModificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    /**
     * Define el valor de la propiedad usuarioUltimaModificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioUltimaModificacion(String value) {
        this.usuarioUltimaModificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad comentarioAnulacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComentarioAnulacion() {
        return comentarioAnulacion;
    }

    /**
     * Define el valor de la propiedad comentarioAnulacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComentarioAnulacion(String value) {
        this.comentarioAnulacion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaHoraAnulacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraAnulacion() {
        return fechaHoraAnulacion;
    }

    /**
     * Define el valor de la propiedad fechaHoraAnulacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraAnulacion(XMLGregorianCalendar value) {
        this.fechaHoraAnulacion = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioAnulacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioAnulacion() {
        return usuarioAnulacion;
    }

    /**
     * Define el valor de la propiedad usuarioAnulacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioAnulacion(String value) {
        this.usuarioAnulacion = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDocumentoReferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumentoReferencia() {
        return tipoDocumentoReferencia;
    }

    /**
     * Define el valor de la propiedad tipoDocumentoReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumentoReferencia(String value) {
        this.tipoDocumentoReferencia = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDocumentoReferencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumentoReferencia() {
        return numeroDocumentoReferencia;
    }

    /**
     * Define el valor de la propiedad numeroDocumentoReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumentoReferencia(String value) {
        this.numeroDocumentoReferencia = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaDocumentoReferencia.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaDocumentoReferencia() {
        return fechaDocumentoReferencia;
    }

    /**
     * Define el valor de la propiedad fechaDocumentoReferencia.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaDocumentoReferencia(XMLGregorianCalendar value) {
        this.fechaDocumentoReferencia = value;
    }

    /**
     * Obtiene el valor de la propiedad documentosDevolver.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDocumentosDevolver() {
        return documentosDevolver;
    }

    /**
     * Define el valor de la propiedad documentosDevolver.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDocumentosDevolver(Integer value) {
        this.documentosDevolver = value;
    }

    /**
     * Obtiene el valor de la propiedad documentosEntregar.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDocumentosEntregar() {
        return documentosEntregar;
    }

    /**
     * Define el valor de la propiedad documentosEntregar.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDocumentosEntregar(Integer value) {
        this.documentosEntregar = value;
    }

    /**
     * Obtiene el valor de la propiedad esEntregaBodega.
     * 
     */
    public boolean isEsEntregaBodega() {
        return esEntregaBodega;
    }

    /**
     * Define el valor de la propiedad esEntregaBodega.
     * 
     */
    public void setEsEntregaBodega(boolean value) {
        this.esEntregaBodega = value;
    }

    /**
     * Obtiene el valor de la propiedad centroCosto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentroCosto() {
        return centroCosto;
    }

    /**
     * Define el valor de la propiedad centroCosto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentroCosto(String value) {
        this.centroCosto = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    /**
     * Define el valor de la propiedad ciudadOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudadOrigen(String value) {
        this.ciudadOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad departamentoOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamentoOrigen() {
        return departamentoOrigen;
    }

    /**
     * Define el valor de la propiedad departamentoOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamentoOrigen(String value) {
        this.departamentoOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadDestino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudadDestino() {
        return ciudadDestino;
    }

    /**
     * Define el valor de la propiedad ciudadDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudadDestino(String value) {
        this.ciudadDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad departamentoDestino.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartamentoDestino() {
        return departamentoDestino;
    }

    /**
     * Define el valor de la propiedad departamentoDestino.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartamentoDestino(String value) {
        this.departamentoDestino = value;
    }

    /**
     * Obtiene el valor de la propiedad detDespacho.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsDespachoPaqueteriaDetalle }
     *     
     */
    public ArrayOfClsDespachoPaqueteriaDetalle getDetDespacho() {
        return detDespacho;
    }

    /**
     * Define el valor de la propiedad detDespacho.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsDespachoPaqueteriaDetalle }
     *     
     */
    public void setDetDespacho(ArrayOfClsDespachoPaqueteriaDetalle value) {
        this.detDespacho = value;
    }

}

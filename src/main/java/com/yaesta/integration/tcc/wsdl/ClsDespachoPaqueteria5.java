//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.09.06 a las 03:08:21 PM ECT 
//


package com.yaesta.integration.tcc.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clsDespachoPaqueteria5 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsDespachoPaqueteria5"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FechaDespacho" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="CodigoCuentaRemitente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="NombreDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NumeroIdentificacionDrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TelefonoDrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DireccionDrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IDDestino" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="BarrioDrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TotalUnidades" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="TotalPeso" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="TotalValorMercancia" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="TipoServicioTCC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Comentarios" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NumeroRemesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UsuarioCreacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UsuarioUltimaModificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TipoDocumentoReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NumeroDocumentoReferencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FechaDocumentoReferencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="DocumentosDevolver" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="DocumentosEntregar" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="EsEntregaBodega" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="detDespacho" type="{http://clientes.tcc.com.co/}ArrayOfClsDespachoPaqueteriaDetalle5" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsDespachoPaqueteria5", propOrder = {
    "fechaDespacho",
    "codigoCuentaRemitente",
    "nombreDestinatario",
    "numeroIdentificacionDrio",
    "telefonoDrio",
    "direccionDrio",
    "idDestino",
    "barrioDrio",
    "totalUnidades",
    "totalPeso",
    "totalValorMercancia",
    "tipoServicioTCC",
    "comentarios",
    "numeroRemesa",
    "usuarioCreacion",
    "usuarioUltimaModificacion",
    "tipoDocumentoReferencia",
    "numeroDocumentoReferencia",
    "fechaDocumentoReferencia",
    "documentosDevolver",
    "documentosEntregar",
    "esEntregaBodega",
    "detDespacho"
})
public class ClsDespachoPaqueteria5 {

    @XmlElement(name = "FechaDespacho", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaDespacho;
    @XmlElement(name = "CodigoCuentaRemitente", required = true, type = Integer.class, nillable = true)
    protected Integer codigoCuentaRemitente;
    @XmlElement(name = "NombreDestinatario")
    protected String nombreDestinatario;
    @XmlElement(name = "NumeroIdentificacionDrio")
    protected String numeroIdentificacionDrio;
    @XmlElement(name = "TelefonoDrio")
    protected String telefonoDrio;
    @XmlElement(name = "DireccionDrio")
    protected String direccionDrio;
    @XmlElement(name = "IDDestino")
    protected int idDestino;
    @XmlElement(name = "BarrioDrio")
    protected String barrioDrio;
    @XmlElement(name = "TotalUnidades", required = true, type = Integer.class, nillable = true)
    protected Integer totalUnidades;
    @XmlElement(name = "TotalPeso", required = true, type = Double.class, nillable = true)
    protected Double totalPeso;
    @XmlElement(name = "TotalValorMercancia", required = true, type = Double.class, nillable = true)
    protected Double totalValorMercancia;
    @XmlElement(name = "TipoServicioTCC")
    protected String tipoServicioTCC;
    @XmlElement(name = "Comentarios")
    protected String comentarios;
    @XmlElement(name = "NumeroRemesa")
    protected String numeroRemesa;
    @XmlElement(name = "UsuarioCreacion")
    protected String usuarioCreacion;
    @XmlElement(name = "UsuarioUltimaModificacion")
    protected String usuarioUltimaModificacion;
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
    protected ArrayOfClsDespachoPaqueteriaDetalle5 detDespacho;

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
     * Obtiene el valor de la propiedad idDestino.
     * 
     */
    public int getIDDestino() {
        return idDestino;
    }

    /**
     * Define el valor de la propiedad idDestino.
     * 
     */
    public void setIDDestino(int value) {
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
     * Obtiene el valor de la propiedad detDespacho.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsDespachoPaqueteriaDetalle5 }
     *     
     */
    public ArrayOfClsDespachoPaqueteriaDetalle5 getDetDespacho() {
        return detDespacho;
    }

    /**
     * Define el valor de la propiedad detDespacho.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsDespachoPaqueteriaDetalle5 }
     *     
     */
    public void setDetDespacho(ArrayOfClsDespachoPaqueteriaDetalle5 value) {
        this.detDespacho = value;
    }

}

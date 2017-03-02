
package co.com.tcc.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tpGrabarRemesaCompleta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tpGrabarRemesaCompleta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="codigolote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="fechahoralote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="numeroremesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="numeroDepacho" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="unidadnegocio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="fechadespacho" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="cuentaremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="sederemitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="primernombreremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="segundonombreremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="primerapellidoremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="segundoapellidoremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="razonsocialremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="naturalezaremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="tipoidentificacionremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="identificacionremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="telefonoremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="direccionremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="ciudadorigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="tipoidentificaciondestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="identificaciondestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="sededestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="primernombredestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="segundonombredestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="primerapellidodestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="segundoapellidodestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="razonsocialdestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="naturalezadestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="direcciondestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="telefonodestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="ciudaddestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="barriodestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="totalpeso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="totalpesovolumen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="totalvalormercancia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="formapago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="llevabodega" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="recogebodega" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="centrocostos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="totalvalorproducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="unidad" type="{http://www.tcc.com.co/xsd}tpUnidad" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *         &lt;element name="documentoreferencia" type="{http://www.tcc.com.co/xsd}tpDocumentoReferencia" maxOccurs="unbounded" minOccurs="0" form="unqualified"/>
 *         &lt;element name="numeroReferenciaCliente" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="fuente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="generarDocumentos" type="{http://www.w3.org/2001/XMLSchema}boolean" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tpGrabarRemesaCompleta", propOrder = {
    "clave",
    "codigolote",
    "fechahoralote",
    "numeroremesa",
    "numeroDepacho",
    "unidadnegocio",
    "fechadespacho",
    "cuentaremitente",
    "sederemitente",
    "primernombreremitente",
    "segundonombreremitente",
    "primerapellidoremitente",
    "segundoapellidoremitente",
    "razonsocialremitente",
    "naturalezaremitente",
    "tipoidentificacionremitente",
    "identificacionremitente",
    "telefonoremitente",
    "direccionremitente",
    "ciudadorigen",
    "tipoidentificaciondestinatario",
    "identificaciondestinatario",
    "sededestinatario",
    "primernombredestinatario",
    "segundonombredestinatario",
    "primerapellidodestinatario",
    "segundoapellidodestinatario",
    "razonsocialdestinatario",
    "naturalezadestinatario",
    "direcciondestinatario",
    "telefonodestinatario",
    "ciudaddestinatario",
    "barriodestinatario",
    "totalpeso",
    "totalpesovolumen",
    "totalvalormercancia",
    "formapago",
    "observaciones",
    "llevabodega",
    "recogebodega",
    "centrocostos",
    "totalvalorproducto",
    "unidad",
    "documentoreferencia",
    "numeroReferenciaCliente",
    "fuente",
    "generarDocumentos"
})
public class TpGrabarRemesaCompleta {

    protected String clave;
    protected String codigolote;
    protected String fechahoralote;
    protected String numeroremesa;
    protected String numeroDepacho;
    protected String unidadnegocio;
    protected String fechadespacho;
    protected String cuentaremitente;
    protected String sederemitente;
    protected String primernombreremitente;
    protected String segundonombreremitente;
    protected String primerapellidoremitente;
    protected String segundoapellidoremitente;
    protected String razonsocialremitente;
    protected String naturalezaremitente;
    protected String tipoidentificacionremitente;
    protected String identificacionremitente;
    protected String telefonoremitente;
    protected String direccionremitente;
    protected String ciudadorigen;
    protected String tipoidentificaciondestinatario;
    protected String identificaciondestinatario;
    protected String sededestinatario;
    protected String primernombredestinatario;
    protected String segundonombredestinatario;
    protected String primerapellidodestinatario;
    protected String segundoapellidodestinatario;
    protected String razonsocialdestinatario;
    protected String naturalezadestinatario;
    protected String direcciondestinatario;
    protected String telefonodestinatario;
    protected String ciudaddestinatario;
    protected String barriodestinatario;
    protected String totalpeso;
    protected String totalpesovolumen;
    protected String totalvalormercancia;
    protected String formapago;
    protected String observaciones;
    protected String llevabodega;
    protected String recogebodega;
    protected String centrocostos;
    protected String totalvalorproducto;
    protected List<TpUnidad> unidad;
    @XmlElement(nillable = true)
    protected List<TpDocumentoReferencia> documentoreferencia;
    @XmlElement(required = true, nillable = true)
    protected String numeroReferenciaCliente;
    protected String fuente;
    protected boolean generarDocumentos;

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
     * Obtiene el valor de la propiedad codigolote.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigolote() {
        return codigolote;
    }

    /**
     * Define el valor de la propiedad codigolote.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigolote(String value) {
        this.codigolote = value;
    }

    /**
     * Obtiene el valor de la propiedad fechahoralote.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechahoralote() {
        return fechahoralote;
    }

    /**
     * Define el valor de la propiedad fechahoralote.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechahoralote(String value) {
        this.fechahoralote = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroremesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroremesa() {
        return numeroremesa;
    }

    /**
     * Define el valor de la propiedad numeroremesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroremesa(String value) {
        this.numeroremesa = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDepacho.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDepacho() {
        return numeroDepacho;
    }

    /**
     * Define el valor de la propiedad numeroDepacho.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDepacho(String value) {
        this.numeroDepacho = value;
    }

    /**
     * Obtiene el valor de la propiedad unidadnegocio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidadnegocio() {
        return unidadnegocio;
    }

    /**
     * Define el valor de la propiedad unidadnegocio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidadnegocio(String value) {
        this.unidadnegocio = value;
    }

    /**
     * Obtiene el valor de la propiedad fechadespacho.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechadespacho() {
        return fechadespacho;
    }

    /**
     * Define el valor de la propiedad fechadespacho.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechadespacho(String value) {
        this.fechadespacho = value;
    }

    /**
     * Obtiene el valor de la propiedad cuentaremitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuentaremitente() {
        return cuentaremitente;
    }

    /**
     * Define el valor de la propiedad cuentaremitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuentaremitente(String value) {
        this.cuentaremitente = value;
    }

    /**
     * Obtiene el valor de la propiedad sederemitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSederemitente() {
        return sederemitente;
    }

    /**
     * Define el valor de la propiedad sederemitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSederemitente(String value) {
        this.sederemitente = value;
    }

    /**
     * Obtiene el valor de la propiedad primernombreremitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimernombreremitente() {
        return primernombreremitente;
    }

    /**
     * Define el valor de la propiedad primernombreremitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimernombreremitente(String value) {
        this.primernombreremitente = value;
    }

    /**
     * Obtiene el valor de la propiedad segundonombreremitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundonombreremitente() {
        return segundonombreremitente;
    }

    /**
     * Define el valor de la propiedad segundonombreremitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundonombreremitente(String value) {
        this.segundonombreremitente = value;
    }

    /**
     * Obtiene el valor de la propiedad primerapellidoremitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimerapellidoremitente() {
        return primerapellidoremitente;
    }

    /**
     * Define el valor de la propiedad primerapellidoremitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimerapellidoremitente(String value) {
        this.primerapellidoremitente = value;
    }

    /**
     * Obtiene el valor de la propiedad segundoapellidoremitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundoapellidoremitente() {
        return segundoapellidoremitente;
    }

    /**
     * Define el valor de la propiedad segundoapellidoremitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundoapellidoremitente(String value) {
        this.segundoapellidoremitente = value;
    }

    /**
     * Obtiene el valor de la propiedad razonsocialremitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonsocialremitente() {
        return razonsocialremitente;
    }

    /**
     * Define el valor de la propiedad razonsocialremitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonsocialremitente(String value) {
        this.razonsocialremitente = value;
    }

    /**
     * Obtiene el valor de la propiedad naturalezaremitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaturalezaremitente() {
        return naturalezaremitente;
    }

    /**
     * Define el valor de la propiedad naturalezaremitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaturalezaremitente(String value) {
        this.naturalezaremitente = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoidentificacionremitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoidentificacionremitente() {
        return tipoidentificacionremitente;
    }

    /**
     * Define el valor de la propiedad tipoidentificacionremitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoidentificacionremitente(String value) {
        this.tipoidentificacionremitente = value;
    }

    /**
     * Obtiene el valor de la propiedad identificacionremitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificacionremitente() {
        return identificacionremitente;
    }

    /**
     * Define el valor de la propiedad identificacionremitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificacionremitente(String value) {
        this.identificacionremitente = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonoremitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonoremitente() {
        return telefonoremitente;
    }

    /**
     * Define el valor de la propiedad telefonoremitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonoremitente(String value) {
        this.telefonoremitente = value;
    }

    /**
     * Obtiene el valor de la propiedad direccionremitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccionremitente() {
        return direccionremitente;
    }

    /**
     * Define el valor de la propiedad direccionremitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccionremitente(String value) {
        this.direccionremitente = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadorigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudadorigen() {
        return ciudadorigen;
    }

    /**
     * Define el valor de la propiedad ciudadorigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudadorigen(String value) {
        this.ciudadorigen = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoidentificaciondestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoidentificaciondestinatario() {
        return tipoidentificaciondestinatario;
    }

    /**
     * Define el valor de la propiedad tipoidentificaciondestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoidentificaciondestinatario(String value) {
        this.tipoidentificaciondestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad identificaciondestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificaciondestinatario() {
        return identificaciondestinatario;
    }

    /**
     * Define el valor de la propiedad identificaciondestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificaciondestinatario(String value) {
        this.identificaciondestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad sededestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSededestinatario() {
        return sededestinatario;
    }

    /**
     * Define el valor de la propiedad sededestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSededestinatario(String value) {
        this.sededestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad primernombredestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimernombredestinatario() {
        return primernombredestinatario;
    }

    /**
     * Define el valor de la propiedad primernombredestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimernombredestinatario(String value) {
        this.primernombredestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad segundonombredestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundonombredestinatario() {
        return segundonombredestinatario;
    }

    /**
     * Define el valor de la propiedad segundonombredestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundonombredestinatario(String value) {
        this.segundonombredestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad primerapellidodestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimerapellidodestinatario() {
        return primerapellidodestinatario;
    }

    /**
     * Define el valor de la propiedad primerapellidodestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimerapellidodestinatario(String value) {
        this.primerapellidodestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad segundoapellidodestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundoapellidodestinatario() {
        return segundoapellidodestinatario;
    }

    /**
     * Define el valor de la propiedad segundoapellidodestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundoapellidodestinatario(String value) {
        this.segundoapellidodestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad razonsocialdestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonsocialdestinatario() {
        return razonsocialdestinatario;
    }

    /**
     * Define el valor de la propiedad razonsocialdestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonsocialdestinatario(String value) {
        this.razonsocialdestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad naturalezadestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaturalezadestinatario() {
        return naturalezadestinatario;
    }

    /**
     * Define el valor de la propiedad naturalezadestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaturalezadestinatario(String value) {
        this.naturalezadestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad direcciondestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirecciondestinatario() {
        return direcciondestinatario;
    }

    /**
     * Define el valor de la propiedad direcciondestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirecciondestinatario(String value) {
        this.direcciondestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad telefonodestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefonodestinatario() {
        return telefonodestinatario;
    }

    /**
     * Define el valor de la propiedad telefonodestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefonodestinatario(String value) {
        this.telefonodestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudaddestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudaddestinatario() {
        return ciudaddestinatario;
    }

    /**
     * Define el valor de la propiedad ciudaddestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudaddestinatario(String value) {
        this.ciudaddestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad barriodestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarriodestinatario() {
        return barriodestinatario;
    }

    /**
     * Define el valor de la propiedad barriodestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarriodestinatario(String value) {
        this.barriodestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad totalpeso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalpeso() {
        return totalpeso;
    }

    /**
     * Define el valor de la propiedad totalpeso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalpeso(String value) {
        this.totalpeso = value;
    }

    /**
     * Obtiene el valor de la propiedad totalpesovolumen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalpesovolumen() {
        return totalpesovolumen;
    }

    /**
     * Define el valor de la propiedad totalpesovolumen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalpesovolumen(String value) {
        this.totalpesovolumen = value;
    }

    /**
     * Obtiene el valor de la propiedad totalvalormercancia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalvalormercancia() {
        return totalvalormercancia;
    }

    /**
     * Define el valor de la propiedad totalvalormercancia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalvalormercancia(String value) {
        this.totalvalormercancia = value;
    }

    /**
     * Obtiene el valor de la propiedad formapago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormapago() {
        return formapago;
    }

    /**
     * Define el valor de la propiedad formapago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormapago(String value) {
        this.formapago = value;
    }

    /**
     * Obtiene el valor de la propiedad observaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Define el valor de la propiedad observaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservaciones(String value) {
        this.observaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad llevabodega.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLlevabodega() {
        return llevabodega;
    }

    /**
     * Define el valor de la propiedad llevabodega.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLlevabodega(String value) {
        this.llevabodega = value;
    }

    /**
     * Obtiene el valor de la propiedad recogebodega.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecogebodega() {
        return recogebodega;
    }

    /**
     * Define el valor de la propiedad recogebodega.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecogebodega(String value) {
        this.recogebodega = value;
    }

    /**
     * Obtiene el valor de la propiedad centrocostos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentrocostos() {
        return centrocostos;
    }

    /**
     * Define el valor de la propiedad centrocostos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentrocostos(String value) {
        this.centrocostos = value;
    }

    /**
     * Obtiene el valor de la propiedad totalvalorproducto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalvalorproducto() {
        return totalvalorproducto;
    }

    /**
     * Define el valor de la propiedad totalvalorproducto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalvalorproducto(String value) {
        this.totalvalorproducto = value;
    }

    /**
     * Gets the value of the unidad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unidad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnidad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TpUnidad }
     * 
     * 
     */
    public List<TpUnidad> getUnidad() {
        if (unidad == null) {
            unidad = new ArrayList<TpUnidad>();
        }
        return this.unidad;
    }

    /**
     * Gets the value of the documentoreferencia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentoreferencia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentoreferencia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TpDocumentoReferencia }
     * 
     * 
     */
    public List<TpDocumentoReferencia> getDocumentoreferencia() {
        if (documentoreferencia == null) {
            documentoreferencia = new ArrayList<TpDocumentoReferencia>();
        }
        return this.documentoreferencia;
    }

    /**
     * Obtiene el valor de la propiedad numeroReferenciaCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroReferenciaCliente() {
        return numeroReferenciaCliente;
    }

    /**
     * Define el valor de la propiedad numeroReferenciaCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroReferenciaCliente(String value) {
        this.numeroReferenciaCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad fuente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuente() {
        return fuente;
    }

    /**
     * Define el valor de la propiedad fuente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuente(String value) {
        this.fuente = value;
    }

    /**
     * Obtiene el valor de la propiedad generarDocumentos.
     * 
     */
    public boolean isGenerarDocumentos() {
        return generarDocumentos;
    }

    /**
     * Define el valor de la propiedad generarDocumentos.
     * 
     */
    public void setGenerarDocumentos(boolean value) {
        this.generarDocumentos = value;
    }

}


package co.com.tcc.clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clsDespachoPaqueteriaDetalle complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsDespachoPaqueteriaDetalle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IDDespacho" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Consecutivo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TipoDeEmpaque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferenciaCte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CantidadUnidades" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PesoKilosTotalDetalle" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PesoKilosFacturadosTotalDetalle" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PesoKilosUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PesoKilosFacturadosUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="LargoCmsUnitario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AnchoCmsUnitario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AltoCmsUnitario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PesoVolumenUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PesoVolumenTotalDetalle" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ValorMercanciaUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ValorMercanciaTotalDetalle" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PesoInfUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="UnidadMedidaPesoInf" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LargoInfUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="AnchoInfUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="AltoInfUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="UnidadMedidaLongitudInf" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FechaHoraCreacion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UsuarioCreacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaHoraUltimaModificacion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UsuarioUltimaModificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsDespachoPaqueteriaDetalle", propOrder = {
    "idDespacho",
    "consecutivo",
    "tipoDeEmpaque",
    "referenciaCte",
    "descripcion",
    "cantidadUnidades",
    "pesoKilosTotalDetalle",
    "pesoKilosFacturadosTotalDetalle",
    "pesoKilosUnitario",
    "pesoKilosFacturadosUnitario",
    "largoCmsUnitario",
    "anchoCmsUnitario",
    "altoCmsUnitario",
    "pesoVolumenUnitario",
    "pesoVolumenTotalDetalle",
    "valorMercanciaUnitario",
    "valorMercanciaTotalDetalle",
    "pesoInfUnitario",
    "unidadMedidaPesoInf",
    "largoInfUnitario",
    "anchoInfUnitario",
    "altoInfUnitario",
    "unidadMedidaLongitudInf",
    "fechaHoraCreacion",
    "usuarioCreacion",
    "fechaHoraUltimaModificacion",
    "usuarioUltimaModificacion"
})
public class ClsDespachoPaqueteriaDetalle {

    @XmlElement(name = "IDDespacho", required = true, type = Integer.class, nillable = true)
    protected Integer idDespacho;
    @XmlElement(name = "Consecutivo", required = true, type = Integer.class, nillable = true)
    protected Integer consecutivo;
    @XmlElement(name = "TipoDeEmpaque")
    protected String tipoDeEmpaque;
    @XmlElement(name = "ReferenciaCte")
    protected String referenciaCte;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "CantidadUnidades", required = true, type = Integer.class, nillable = true)
    protected Integer cantidadUnidades;
    @XmlElement(name = "PesoKilosTotalDetalle", required = true, type = Double.class, nillable = true)
    protected Double pesoKilosTotalDetalle;
    @XmlElement(name = "PesoKilosFacturadosTotalDetalle", required = true, type = Double.class, nillable = true)
    protected Double pesoKilosFacturadosTotalDetalle;
    @XmlElement(name = "PesoKilosUnitario", required = true, type = Double.class, nillable = true)
    protected Double pesoKilosUnitario;
    @XmlElement(name = "PesoKilosFacturadosUnitario", required = true, type = Double.class, nillable = true)
    protected Double pesoKilosFacturadosUnitario;
    @XmlElement(name = "LargoCmsUnitario", required = true, type = Integer.class, nillable = true)
    protected Integer largoCmsUnitario;
    @XmlElement(name = "AnchoCmsUnitario", required = true, type = Integer.class, nillable = true)
    protected Integer anchoCmsUnitario;
    @XmlElement(name = "AltoCmsUnitario", required = true, type = Integer.class, nillable = true)
    protected Integer altoCmsUnitario;
    @XmlElement(name = "PesoVolumenUnitario", required = true, type = Double.class, nillable = true)
    protected Double pesoVolumenUnitario;
    @XmlElement(name = "PesoVolumenTotalDetalle", required = true, type = Double.class, nillable = true)
    protected Double pesoVolumenTotalDetalle;
    @XmlElement(name = "ValorMercanciaUnitario", required = true, type = Double.class, nillable = true)
    protected Double valorMercanciaUnitario;
    @XmlElement(name = "ValorMercanciaTotalDetalle", required = true, type = Double.class, nillable = true)
    protected Double valorMercanciaTotalDetalle;
    @XmlElement(name = "PesoInfUnitario", required = true, type = Double.class, nillable = true)
    protected Double pesoInfUnitario;
    @XmlElement(name = "UnidadMedidaPesoInf", required = true, type = Integer.class, nillable = true)
    protected Integer unidadMedidaPesoInf;
    @XmlElement(name = "LargoInfUnitario", required = true, type = Double.class, nillable = true)
    protected Double largoInfUnitario;
    @XmlElement(name = "AnchoInfUnitario", required = true, type = Double.class, nillable = true)
    protected Double anchoInfUnitario;
    @XmlElement(name = "AltoInfUnitario", required = true, type = Double.class, nillable = true)
    protected Double altoInfUnitario;
    @XmlElement(name = "UnidadMedidaLongitudInf", required = true, type = Integer.class, nillable = true)
    protected Integer unidadMedidaLongitudInf;
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
     * Obtiene el valor de la propiedad tipoDeEmpaque.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDeEmpaque() {
        return tipoDeEmpaque;
    }

    /**
     * Define el valor de la propiedad tipoDeEmpaque.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDeEmpaque(String value) {
        this.tipoDeEmpaque = value;
    }

    /**
     * Obtiene el valor de la propiedad referenciaCte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenciaCte() {
        return referenciaCte;
    }

    /**
     * Define el valor de la propiedad referenciaCte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenciaCte(String value) {
        this.referenciaCte = value;
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
     * Obtiene el valor de la propiedad cantidadUnidades.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantidadUnidades() {
        return cantidadUnidades;
    }

    /**
     * Define el valor de la propiedad cantidadUnidades.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantidadUnidades(Integer value) {
        this.cantidadUnidades = value;
    }

    /**
     * Obtiene el valor de la propiedad pesoKilosTotalDetalle.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPesoKilosTotalDetalle() {
        return pesoKilosTotalDetalle;
    }

    /**
     * Define el valor de la propiedad pesoKilosTotalDetalle.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPesoKilosTotalDetalle(Double value) {
        this.pesoKilosTotalDetalle = value;
    }

    /**
     * Obtiene el valor de la propiedad pesoKilosFacturadosTotalDetalle.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPesoKilosFacturadosTotalDetalle() {
        return pesoKilosFacturadosTotalDetalle;
    }

    /**
     * Define el valor de la propiedad pesoKilosFacturadosTotalDetalle.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPesoKilosFacturadosTotalDetalle(Double value) {
        this.pesoKilosFacturadosTotalDetalle = value;
    }

    /**
     * Obtiene el valor de la propiedad pesoKilosUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPesoKilosUnitario() {
        return pesoKilosUnitario;
    }

    /**
     * Define el valor de la propiedad pesoKilosUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPesoKilosUnitario(Double value) {
        this.pesoKilosUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad pesoKilosFacturadosUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPesoKilosFacturadosUnitario() {
        return pesoKilosFacturadosUnitario;
    }

    /**
     * Define el valor de la propiedad pesoKilosFacturadosUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPesoKilosFacturadosUnitario(Double value) {
        this.pesoKilosFacturadosUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad largoCmsUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLargoCmsUnitario() {
        return largoCmsUnitario;
    }

    /**
     * Define el valor de la propiedad largoCmsUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLargoCmsUnitario(Integer value) {
        this.largoCmsUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad anchoCmsUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAnchoCmsUnitario() {
        return anchoCmsUnitario;
    }

    /**
     * Define el valor de la propiedad anchoCmsUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAnchoCmsUnitario(Integer value) {
        this.anchoCmsUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad altoCmsUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAltoCmsUnitario() {
        return altoCmsUnitario;
    }

    /**
     * Define el valor de la propiedad altoCmsUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAltoCmsUnitario(Integer value) {
        this.altoCmsUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad pesoVolumenUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPesoVolumenUnitario() {
        return pesoVolumenUnitario;
    }

    /**
     * Define el valor de la propiedad pesoVolumenUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPesoVolumenUnitario(Double value) {
        this.pesoVolumenUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad pesoVolumenTotalDetalle.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPesoVolumenTotalDetalle() {
        return pesoVolumenTotalDetalle;
    }

    /**
     * Define el valor de la propiedad pesoVolumenTotalDetalle.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPesoVolumenTotalDetalle(Double value) {
        this.pesoVolumenTotalDetalle = value;
    }

    /**
     * Obtiene el valor de la propiedad valorMercanciaUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getValorMercanciaUnitario() {
        return valorMercanciaUnitario;
    }

    /**
     * Define el valor de la propiedad valorMercanciaUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setValorMercanciaUnitario(Double value) {
        this.valorMercanciaUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad valorMercanciaTotalDetalle.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getValorMercanciaTotalDetalle() {
        return valorMercanciaTotalDetalle;
    }

    /**
     * Define el valor de la propiedad valorMercanciaTotalDetalle.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setValorMercanciaTotalDetalle(Double value) {
        this.valorMercanciaTotalDetalle = value;
    }

    /**
     * Obtiene el valor de la propiedad pesoInfUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPesoInfUnitario() {
        return pesoInfUnitario;
    }

    /**
     * Define el valor de la propiedad pesoInfUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPesoInfUnitario(Double value) {
        this.pesoInfUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad unidadMedidaPesoInf.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUnidadMedidaPesoInf() {
        return unidadMedidaPesoInf;
    }

    /**
     * Define el valor de la propiedad unidadMedidaPesoInf.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUnidadMedidaPesoInf(Integer value) {
        this.unidadMedidaPesoInf = value;
    }

    /**
     * Obtiene el valor de la propiedad largoInfUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLargoInfUnitario() {
        return largoInfUnitario;
    }

    /**
     * Define el valor de la propiedad largoInfUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLargoInfUnitario(Double value) {
        this.largoInfUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad anchoInfUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAnchoInfUnitario() {
        return anchoInfUnitario;
    }

    /**
     * Define el valor de la propiedad anchoInfUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAnchoInfUnitario(Double value) {
        this.anchoInfUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad altoInfUnitario.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAltoInfUnitario() {
        return altoInfUnitario;
    }

    /**
     * Define el valor de la propiedad altoInfUnitario.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAltoInfUnitario(Double value) {
        this.altoInfUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad unidadMedidaLongitudInf.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUnidadMedidaLongitudInf() {
        return unidadMedidaLongitudInf;
    }

    /**
     * Define el valor de la propiedad unidadMedidaLongitudInf.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUnidadMedidaLongitudInf(Integer value) {
        this.unidadMedidaLongitudInf = value;
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

}

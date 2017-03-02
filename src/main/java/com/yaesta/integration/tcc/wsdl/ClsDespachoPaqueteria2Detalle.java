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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsDespachoPaqueteria2_Detalle complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsDespachoPaqueteria2_Detalle"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodigoIUP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TipoDeEmpaque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Referencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CantidadUnidades" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="PesoKilosUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="PesoVolumenUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="LargoCmsUnitario" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AnchoCmsUnitario" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="AltoCmsUnitario" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ValorMercanciaUnitario" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsDespachoPaqueteria2_Detalle", propOrder = {
    "codigoIUP",
    "tipoDeEmpaque",
    "referencia",
    "descripcion",
    "cantidadUnidades",
    "pesoKilosUnitario",
    "pesoVolumenUnitario",
    "largoCmsUnitario",
    "anchoCmsUnitario",
    "altoCmsUnitario",
    "valorMercanciaUnitario"
})
public class ClsDespachoPaqueteria2Detalle {

    @XmlElement(name = "CodigoIUP")
    protected String codigoIUP;
    @XmlElement(name = "TipoDeEmpaque")
    protected String tipoDeEmpaque;
    @XmlElement(name = "Referencia")
    protected String referencia;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "CantidadUnidades", required = true, type = Integer.class, nillable = true)
    protected Integer cantidadUnidades;
    @XmlElement(name = "PesoKilosUnitario", required = true, type = Double.class, nillable = true)
    protected Double pesoKilosUnitario;
    @XmlElement(name = "PesoVolumenUnitario", required = true, type = Double.class, nillable = true)
    protected Double pesoVolumenUnitario;
    @XmlElement(name = "LargoCmsUnitario", required = true, type = Integer.class, nillable = true)
    protected Integer largoCmsUnitario;
    @XmlElement(name = "AnchoCmsUnitario", required = true, type = Integer.class, nillable = true)
    protected Integer anchoCmsUnitario;
    @XmlElement(name = "AltoCmsUnitario", required = true, type = Integer.class, nillable = true)
    protected Integer altoCmsUnitario;
    @XmlElement(name = "ValorMercanciaUnitario", required = true, type = Double.class, nillable = true)
    protected Double valorMercanciaUnitario;

    /**
     * Obtiene el valor de la propiedad codigoIUP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoIUP() {
        return codigoIUP;
    }

    /**
     * Define el valor de la propiedad codigoIUP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoIUP(String value) {
        this.codigoIUP = value;
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
     * Obtiene el valor de la propiedad referencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Define el valor de la propiedad referencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencia(String value) {
        this.referencia = value;
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

}

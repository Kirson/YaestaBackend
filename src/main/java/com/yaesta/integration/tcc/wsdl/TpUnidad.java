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
 * <p>Clase Java para tpUnidad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tpUnidad"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipounidad" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="tipoempaque" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="claseempaque" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="dicecontener" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="cantidadunidades" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="kilosreales" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="largo" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="alto" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="ancho" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="pesovolumen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="valormercancia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/&gt;
 *         &lt;element name="codigobarras" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="numerobolsa" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="referencias" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tpUnidad", namespace = "http://www.tcc.com.co/xsd", propOrder = {
    "tipounidad",
    "tipoempaque",
    "claseempaque",
    "dicecontener",
    "cantidadunidades",
    "kilosreales",
    "largo",
    "alto",
    "ancho",
    "pesovolumen",
    "valormercancia",
    "codigobarras",
    "numerobolsa",
    "referencias"
})
public class TpUnidad {

    @XmlElement(namespace = "", required = true, nillable = true)
    protected String tipounidad;
    @XmlElement(namespace = "", required = true, nillable = true)
    protected String tipoempaque;
    @XmlElement(namespace = "", required = true, nillable = true)
    protected String claseempaque;
    @XmlElement(namespace = "", required = true, nillable = true)
    protected String dicecontener;
    @XmlElement(namespace = "")
    protected String cantidadunidades;
    @XmlElement(namespace = "")
    protected String kilosreales;
    @XmlElement(namespace = "", required = true, nillable = true)
    protected String largo;
    @XmlElement(namespace = "", required = true, nillable = true)
    protected String alto;
    @XmlElement(namespace = "", required = true, nillable = true)
    protected String ancho;
    @XmlElement(namespace = "")
    protected String pesovolumen;
    @XmlElement(namespace = "")
    protected String valormercancia;
    @XmlElement(namespace = "", required = true, nillable = true)
    protected String codigobarras;
    @XmlElement(namespace = "", required = true, nillable = true)
    protected String numerobolsa;
    @XmlElement(namespace = "", required = true, nillable = true)
    protected String referencias;

    /**
     * Obtiene el valor de la propiedad tipounidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipounidad() {
        return tipounidad;
    }

    /**
     * Define el valor de la propiedad tipounidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipounidad(String value) {
        this.tipounidad = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoempaque.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoempaque() {
        return tipoempaque;
    }

    /**
     * Define el valor de la propiedad tipoempaque.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoempaque(String value) {
        this.tipoempaque = value;
    }

    /**
     * Obtiene el valor de la propiedad claseempaque.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaseempaque() {
        return claseempaque;
    }

    /**
     * Define el valor de la propiedad claseempaque.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaseempaque(String value) {
        this.claseempaque = value;
    }

    /**
     * Obtiene el valor de la propiedad dicecontener.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDicecontener() {
        return dicecontener;
    }

    /**
     * Define el valor de la propiedad dicecontener.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDicecontener(String value) {
        this.dicecontener = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadunidades.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCantidadunidades() {
        return cantidadunidades;
    }

    /**
     * Define el valor de la propiedad cantidadunidades.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCantidadunidades(String value) {
        this.cantidadunidades = value;
    }

    /**
     * Obtiene el valor de la propiedad kilosreales.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKilosreales() {
        return kilosreales;
    }

    /**
     * Define el valor de la propiedad kilosreales.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKilosreales(String value) {
        this.kilosreales = value;
    }

    /**
     * Obtiene el valor de la propiedad largo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLargo() {
        return largo;
    }

    /**
     * Define el valor de la propiedad largo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLargo(String value) {
        this.largo = value;
    }

    /**
     * Obtiene el valor de la propiedad alto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlto() {
        return alto;
    }

    /**
     * Define el valor de la propiedad alto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlto(String value) {
        this.alto = value;
    }

    /**
     * Obtiene el valor de la propiedad ancho.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAncho() {
        return ancho;
    }

    /**
     * Define el valor de la propiedad ancho.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAncho(String value) {
        this.ancho = value;
    }

    /**
     * Obtiene el valor de la propiedad pesovolumen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPesovolumen() {
        return pesovolumen;
    }

    /**
     * Define el valor de la propiedad pesovolumen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPesovolumen(String value) {
        this.pesovolumen = value;
    }

    /**
     * Obtiene el valor de la propiedad valormercancia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValormercancia() {
        return valormercancia;
    }

    /**
     * Define el valor de la propiedad valormercancia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValormercancia(String value) {
        this.valormercancia = value;
    }

    /**
     * Obtiene el valor de la propiedad codigobarras.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigobarras() {
        return codigobarras;
    }

    /**
     * Define el valor de la propiedad codigobarras.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigobarras(String value) {
        this.codigobarras = value;
    }

    /**
     * Obtiene el valor de la propiedad numerobolsa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumerobolsa() {
        return numerobolsa;
    }

    /**
     * Define el valor de la propiedad numerobolsa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumerobolsa(String value) {
        this.numerobolsa = value;
    }

    /**
     * Obtiene el valor de la propiedad referencias.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencias() {
        return referencias;
    }

    /**
     * Define el valor de la propiedad referencias.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencias(String value) {
        this.referencias = value;
    }

}

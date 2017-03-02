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
 * <p>Clase Java para tpDocumentoReferencia complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tpDocumentoReferencia"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipodocumento" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="numerodocumento" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *         &lt;element name="fechadocumento" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tpDocumentoReferencia", namespace = "http://www.tcc.com.co/xsd", propOrder = {
    "tipodocumento",
    "numerodocumento",
    "fechadocumento"
})
public class TpDocumentoReferencia {

    @XmlElement(namespace = "", required = true, nillable = true)
    protected String tipodocumento;
    @XmlElement(namespace = "", required = true, nillable = true)
    protected String numerodocumento;
    @XmlElement(namespace = "", required = true, nillable = true)
    protected String fechadocumento;

    /**
     * Obtiene el valor de la propiedad tipodocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipodocumento() {
        return tipodocumento;
    }

    /**
     * Define el valor de la propiedad tipodocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipodocumento(String value) {
        this.tipodocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad numerodocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumerodocumento() {
        return numerodocumento;
    }

    /**
     * Define el valor de la propiedad numerodocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumerodocumento(String value) {
        this.numerodocumento = value;
    }

    /**
     * Obtiene el valor de la propiedad fechadocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechadocumento() {
        return fechadocumento;
    }

    /**
     * Define el valor de la propiedad fechadocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechadocumento(String value) {
        this.fechadocumento = value;
    }

}

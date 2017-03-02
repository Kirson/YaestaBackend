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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="objDespacho" type="{http://www.tcc.com.co/xsd}tpGrabarRemesaCompleta" minOccurs="0"/&gt;
 *         &lt;element name="remesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="URLRelacionEnvio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="URLRotulos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="URLRemesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IMGRelacionEnvio" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="IMGRotulos" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="IMGRemesa" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="respuesta" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrabarDespacho4", propOrder = {
    "objDespacho",
    "remesa",
    "urlRelacionEnvio",
    "urlRotulos",
    "urlRemesa",
    "imgRelacionEnvio",
    "imgrotulos",
    "imgremesa",
    "respuesta",
    "mensaje"
})
@XmlRootElement(name = "GrabarDespacho4")
public class GrabarDespacho4 {

    protected TpGrabarRemesaCompleta objDespacho;
    protected String remesa;
    @XmlElement(name = "URLRelacionEnvio")
    protected String urlRelacionEnvio;
    @XmlElement(name = "URLRotulos")
    protected String urlRotulos;
    @XmlElement(name = "URLRemesa")
    protected String urlRemesa;
    @XmlElement(name = "IMGRelacionEnvio")
    protected byte[] imgRelacionEnvio;
    @XmlElement(name = "imgrotulos")
    protected byte[] imgrotulos;
    @XmlElement(name = "IMGRemesa")
    protected byte[] imgremesa;
    protected int respuesta;
    protected String mensaje;

    /**
     * Obtiene el valor de la propiedad objDespacho.
     * 
     * @return
     *     possible object is
     *     {@link TpGrabarRemesaCompleta }
     *     
     */
    public TpGrabarRemesaCompleta getObjDespacho() {
        return objDespacho;
    }

    /**
     * Define el valor de la propiedad objDespacho.
     * 
     * @param value
     *     allowed object is
     *     {@link TpGrabarRemesaCompleta }
     *     
     */
    public void setObjDespacho(TpGrabarRemesaCompleta value) {
        this.objDespacho = value;
    }

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
     * Obtiene el valor de la propiedad urlRelacionEnvio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURLRelacionEnvio() {
        return urlRelacionEnvio;
    }

    /**
     * Define el valor de la propiedad urlRelacionEnvio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURLRelacionEnvio(String value) {
        this.urlRelacionEnvio = value;
    }

    /**
     * Obtiene el valor de la propiedad urlRotulos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURLRotulos() {
        return urlRotulos;
    }

    /**
     * Define el valor de la propiedad urlRotulos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURLRotulos(String value) {
        this.urlRotulos = value;
    }

    /**
     * Obtiene el valor de la propiedad urlRemesa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURLRemesa() {
        return urlRemesa;
    }

    /**
     * Define el valor de la propiedad urlRemesa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURLRemesa(String value) {
        this.urlRemesa = value;
    }

    /**
     * Obtiene el valor de la propiedad imgRelacionEnvio.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getIMGRelacionEnvio() {
        return imgRelacionEnvio;
    }

    /**
     * Define el valor de la propiedad imgRelacionEnvio.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setIMGRelacionEnvio(byte[] value) {
        this.imgRelacionEnvio = value;
    }

    /**
     * Obtiene el valor de la propiedad imgRotulos.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImgrotulos() {
        return imgrotulos;
    }

    /**
     * Define el valor de la propiedad imgRotulos.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImgrotulos(byte[] value) {
        this.imgrotulos = value;
    }

    /**
     * Obtiene el valor de la propiedad imgRemesa.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImgremesa() {
        return imgremesa;
    }

    /**
     * Define el valor de la propiedad imgRemesa.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImgremesa(byte[] value) {
        this.imgremesa = value;
    }

    /**
     * Obtiene el valor de la propiedad respuesta.
     * 
     */
    public int getRespuesta() {
        return respuesta;
    }

    /**
     * Define el valor de la propiedad respuesta.
     * 
     */
    public void setRespuesta(int value) {
        this.respuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad mensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Define el valor de la propiedad mensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }

}


package co.com.tcc.xsd;

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
 * &lt;complexType name="tpUnidad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipounidad" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="tipoempaque" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="claseempaque" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="dicecontener" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="cantidadunidades" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="kilosreales" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="largo" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="alto" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="ancho" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="pesovolumen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="valormercancia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="unqualified"/>
 *         &lt;element name="codigobarras" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="numerobolsa" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *         &lt;element name="referencias" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tpUnidad", propOrder = {
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

    @XmlElement(required = true, nillable = true)
    protected String tipounidad;
    @XmlElement(required = true, nillable = true)
    protected String tipoempaque;
    @XmlElement(required = true, nillable = true)
    protected String claseempaque;
    @XmlElement(required = true, nillable = true)
    protected String dicecontener;
    protected String cantidadunidades;
    protected String kilosreales;
    @XmlElement(required = true, nillable = true)
    protected String largo;
    @XmlElement(required = true, nillable = true)
    protected String alto;
    @XmlElement(required = true, nillable = true)
    protected String ancho;
    protected String pesovolumen;
    protected String valormercancia;
    @XmlElement(required = true, nillable = true)
    protected String codigobarras;
    @XmlElement(required = true, nillable = true)
    protected String numerobolsa;
    @XmlElement(required = true, nillable = true)
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

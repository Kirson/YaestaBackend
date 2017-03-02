
package co.com.tcc.clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para clsDespachoPaqueteriaDetalle5 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsDespachoPaqueteriaDetalle5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CantidadUnidades" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PesoKilosTotalDetalle" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="PesoVolumenTotalDetalle" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="LargoCmsUnitario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AnchoCmsUnitario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AltoCmsUnitario" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsDespachoPaqueteriaDetalle5", propOrder = {
    "cantidadUnidades",
    "pesoKilosTotalDetalle",
    "pesoVolumenTotalDetalle",
    "largoCmsUnitario",
    "anchoCmsUnitario",
    "altoCmsUnitario"
})
public class ClsDespachoPaqueteriaDetalle5 {

    @XmlElement(name = "CantidadUnidades", required = true, type = Integer.class, nillable = true)
    protected Integer cantidadUnidades;
    @XmlElement(name = "PesoKilosTotalDetalle", required = true, type = Double.class, nillable = true)
    protected Double pesoKilosTotalDetalle;
    @XmlElement(name = "PesoVolumenTotalDetalle", required = true, type = Double.class, nillable = true)
    protected Double pesoVolumenTotalDetalle;
    @XmlElement(name = "LargoCmsUnitario", required = true, type = Integer.class, nillable = true)
    protected Integer largoCmsUnitario;
    @XmlElement(name = "AnchoCmsUnitario", required = true, type = Integer.class, nillable = true)
    protected Integer anchoCmsUnitario;
    @XmlElement(name = "AltoCmsUnitario", required = true, type = Integer.class, nillable = true)
    protected Integer altoCmsUnitario;

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

}

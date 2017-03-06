
package co.com.tcc.clientes;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConsultarInformacionRemesasDetalleResult" type="{http://clientes.tcc.com.co/}tpSalida" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "consultarInformacionRemesasDetalleResult"
})
@XmlRootElement(name = "ConsultarInformacionRemesasDetalleResponse")
public class ConsultarInformacionRemesasDetalleResponse {

    @XmlElement(name = "ConsultarInformacionRemesasDetalleResult")
    protected TpSalida consultarInformacionRemesasDetalleResult;

    /**
     * Obtiene el valor de la propiedad consultarInformacionRemesasDetalleResult.
     * 
     * @return
     *     possible object is
     *     {@link TpSalida }
     *     
     */
    public TpSalida getConsultarInformacionRemesasDetalleResult() {
        return consultarInformacionRemesasDetalleResult;
    }

    /**
     * Define el valor de la propiedad consultarInformacionRemesasDetalleResult.
     * 
     * @param value
     *     allowed object is
     *     {@link TpSalida }
     *     
     */
    public void setConsultarInformacionRemesasDetalleResult(TpSalida value) {
        this.consultarInformacionRemesasDetalleResult = value;
    }

}

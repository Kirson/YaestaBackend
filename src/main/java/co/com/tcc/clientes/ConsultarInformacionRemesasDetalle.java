
package co.com.tcc.clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="consultar" type="{http://clientes.tcc.com.co/}tpEntrada" minOccurs="0"/>
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
    "consultar"
})
@XmlRootElement(name = "ConsultarInformacionRemesasDetalle")
public class ConsultarInformacionRemesasDetalle {

    protected TpEntrada consultar;

    /**
     * Obtiene el valor de la propiedad consultar.
     * 
     * @return
     *     possible object is
     *     {@link TpEntrada }
     *     
     */
    public TpEntrada getConsultar() {
        return consultar;
    }

    /**
     * Define el valor de la propiedad consultar.
     * 
     * @param value
     *     allowed object is
     *     {@link TpEntrada }
     *     
     */
    public void setConsultar(TpEntrada value) {
        this.consultar = value;
    }

}

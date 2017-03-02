
package co.com.tcc.clientes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsDespachoPaqueteria2_Detalle complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsDespachoPaqueteria2_Detalle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clsDespachoPaqueteria2_Detalle" type="{http://clientes.tcc.com.co/}clsDespachoPaqueteria2_Detalle" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsDespachoPaqueteria2_Detalle", propOrder = {
    "clsDespachoPaqueteria2Detalle"
})
public class ArrayOfClsDespachoPaqueteria2Detalle {

    @XmlElement(name = "clsDespachoPaqueteria2_Detalle", nillable = true)
    protected List<ClsDespachoPaqueteria2Detalle> clsDespachoPaqueteria2Detalle;

    /**
     * Gets the value of the clsDespachoPaqueteria2Detalle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsDespachoPaqueteria2Detalle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsDespachoPaqueteria2Detalle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsDespachoPaqueteria2Detalle }
     * 
     * 
     */
    public List<ClsDespachoPaqueteria2Detalle> getClsDespachoPaqueteria2Detalle() {
        if (clsDespachoPaqueteria2Detalle == null) {
            clsDespachoPaqueteria2Detalle = new ArrayList<ClsDespachoPaqueteria2Detalle>();
        }
        return this.clsDespachoPaqueteria2Detalle;
    }

}

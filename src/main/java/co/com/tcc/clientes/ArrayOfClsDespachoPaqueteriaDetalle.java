
package co.com.tcc.clientes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsDespachoPaqueteriaDetalle complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsDespachoPaqueteriaDetalle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clsDespachoPaqueteriaDetalle" type="{http://clientes.tcc.com.co/}clsDespachoPaqueteriaDetalle" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsDespachoPaqueteriaDetalle", propOrder = {
    "clsDespachoPaqueteriaDetalle"
})
public class ArrayOfClsDespachoPaqueteriaDetalle {

    @XmlElement(nillable = true)
    protected List<ClsDespachoPaqueteriaDetalle> clsDespachoPaqueteriaDetalle;

    /**
     * Gets the value of the clsDespachoPaqueteriaDetalle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsDespachoPaqueteriaDetalle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsDespachoPaqueteriaDetalle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsDespachoPaqueteriaDetalle }
     * 
     * 
     */
    public List<ClsDespachoPaqueteriaDetalle> getClsDespachoPaqueteriaDetalle() {
        if (clsDespachoPaqueteriaDetalle == null) {
            clsDespachoPaqueteriaDetalle = new ArrayList<ClsDespachoPaqueteriaDetalle>();
        }
        return this.clsDespachoPaqueteriaDetalle;
    }

}

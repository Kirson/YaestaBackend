
package co.com.tcc.clientes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsTrackingRemesa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsTrackingRemesa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clsTrackingRemesa" type="{http://clientes.tcc.com.co/}clsTrackingRemesa" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsTrackingRemesa", propOrder = {
    "clsTrackingRemesa"
})
public class ArrayOfClsTrackingRemesa {

    @XmlElement(nillable = true)
    protected List<ClsTrackingRemesa> clsTrackingRemesa;

    /**
     * Gets the value of the clsTrackingRemesa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsTrackingRemesa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsTrackingRemesa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsTrackingRemesa }
     * 
     * 
     */
    public List<ClsTrackingRemesa> getClsTrackingRemesa() {
        if (clsTrackingRemesa == null) {
            clsTrackingRemesa = new ArrayList<ClsTrackingRemesa>();
        }
        return this.clsTrackingRemesa;
    }

}

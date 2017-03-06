
package co.com.tcc.clientes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsSeguimientoNovedad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsSeguimientoNovedad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clsSeguimientoNovedad" type="{http://clientes.tcc.com.co/}clsSeguimientoNovedad" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsSeguimientoNovedad", propOrder = {
    "clsSeguimientoNovedad"
})
public class ArrayOfClsSeguimientoNovedad {

    @XmlElement(nillable = true)
    protected List<ClsSeguimientoNovedad> clsSeguimientoNovedad;

    /**
     * Gets the value of the clsSeguimientoNovedad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsSeguimientoNovedad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsSeguimientoNovedad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsSeguimientoNovedad }
     * 
     * 
     */
    public List<ClsSeguimientoNovedad> getClsSeguimientoNovedad() {
        if (clsSeguimientoNovedad == null) {
            clsSeguimientoNovedad = new ArrayList<ClsSeguimientoNovedad>();
        }
        return this.clsSeguimientoNovedad;
    }

}

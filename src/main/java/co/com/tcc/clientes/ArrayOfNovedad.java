
package co.com.tcc.clientes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfNovedad complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfNovedad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Novedad" type="{http://clientes.tcc.com.co/}Novedad" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfNovedad", propOrder = {
    "novedad"
})
public class ArrayOfNovedad {

    @XmlElement(name = "Novedad", nillable = true)
    protected List<Novedad> novedad;

    /**
     * Gets the value of the novedad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the novedad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNovedad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Novedad }
     * 
     * 
     */
    public List<Novedad> getNovedad() {
        if (novedad == null) {
            novedad = new ArrayList<Novedad>();
        }
        return this.novedad;
    }

}


package co.com.tcc.clientes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsRemesa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsRemesa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clsRemesa" type="{http://clientes.tcc.com.co/}clsRemesa" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsRemesa", propOrder = {
    "clsRemesa"
})
public class ArrayOfClsRemesa {

    @XmlElement(nillable = true)
    protected List<ClsRemesa> clsRemesa;

    /**
     * Gets the value of the clsRemesa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsRemesa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsRemesa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsRemesa }
     * 
     * 
     */
    public List<ClsRemesa> getClsRemesa() {
        if (clsRemesa == null) {
            clsRemesa = new ArrayList<ClsRemesa>();
        }
        return this.clsRemesa;
    }

}

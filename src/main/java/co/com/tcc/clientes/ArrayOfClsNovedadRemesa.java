
package co.com.tcc.clientes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsNovedadRemesa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsNovedadRemesa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clsNovedadRemesa" type="{http://clientes.tcc.com.co/}clsNovedadRemesa" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsNovedadRemesa", propOrder = {
    "clsNovedadRemesa"
})
public class ArrayOfClsNovedadRemesa {

    @XmlElement(nillable = true)
    protected List<ClsNovedadRemesa> clsNovedadRemesa;

    /**
     * Gets the value of the clsNovedadRemesa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsNovedadRemesa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsNovedadRemesa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsNovedadRemesa }
     * 
     * 
     */
    public List<ClsNovedadRemesa> getClsNovedadRemesa() {
        if (clsNovedadRemesa == null) {
            clsNovedadRemesa = new ArrayList<ClsNovedadRemesa>();
        }
        return this.clsNovedadRemesa;
    }

}

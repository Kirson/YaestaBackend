
package co.com.tcc.clientes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsPuntoDeVenta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsPuntoDeVenta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clsPuntoDeVenta" type="{http://clientes.tcc.com.co/}clsPuntoDeVenta" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsPuntoDeVenta", propOrder = {
    "clsPuntoDeVenta"
})
public class ArrayOfClsPuntoDeVenta {

    @XmlElement(nillable = true)
    protected List<ClsPuntoDeVenta> clsPuntoDeVenta;

    /**
     * Gets the value of the clsPuntoDeVenta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsPuntoDeVenta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsPuntoDeVenta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsPuntoDeVenta }
     * 
     * 
     */
    public List<ClsPuntoDeVenta> getClsPuntoDeVenta() {
        if (clsPuntoDeVenta == null) {
            clsPuntoDeVenta = new ArrayList<ClsPuntoDeVenta>();
        }
        return this.clsPuntoDeVenta;
    }

}

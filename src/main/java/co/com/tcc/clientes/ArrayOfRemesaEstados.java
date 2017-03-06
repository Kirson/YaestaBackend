
package co.com.tcc.clientes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfRemesaEstados complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRemesaEstados">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RemesaEstados" type="{http://clientes.tcc.com.co/}RemesaEstados" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRemesaEstados", propOrder = {
    "remesaEstados"
})
public class ArrayOfRemesaEstados {

    @XmlElement(name = "RemesaEstados", nillable = true)
    protected List<RemesaEstados> remesaEstados;

    /**
     * Gets the value of the remesaEstados property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remesaEstados property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemesaEstados().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RemesaEstados }
     * 
     * 
     */
    public List<RemesaEstados> getRemesaEstados() {
        if (remesaEstados == null) {
            remesaEstados = new ArrayList<RemesaEstados>();
        }
        return this.remesaEstados;
    }

}

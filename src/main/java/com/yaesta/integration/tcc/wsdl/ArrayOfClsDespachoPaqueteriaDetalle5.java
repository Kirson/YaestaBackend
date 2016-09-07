//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.09.06 a las 03:08:21 PM ECT 
//


package com.yaesta.integration.tcc.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfClsDespachoPaqueteriaDetalle5 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsDespachoPaqueteriaDetalle5"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="clsDespachoPaqueteriaDetalle5" type="{http://clientes.tcc.com.co/}clsDespachoPaqueteriaDetalle5" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsDespachoPaqueteriaDetalle5", propOrder = {
    "clsDespachoPaqueteriaDetalle5"
})
public class ArrayOfClsDespachoPaqueteriaDetalle5 {

    @XmlElement(nillable = true)
    protected List<ClsDespachoPaqueteriaDetalle5> clsDespachoPaqueteriaDetalle5;

    /**
     * Gets the value of the clsDespachoPaqueteriaDetalle5 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsDespachoPaqueteriaDetalle5 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsDespachoPaqueteriaDetalle5().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsDespachoPaqueteriaDetalle5 }
     * 
     * 
     */
    public List<ClsDespachoPaqueteriaDetalle5> getClsDespachoPaqueteriaDetalle5() {
        if (clsDespachoPaqueteriaDetalle5 == null) {
            clsDespachoPaqueteriaDetalle5 = new ArrayList<ClsDespachoPaqueteriaDetalle5>();
        }
        return this.clsDespachoPaqueteriaDetalle5;
    }

}

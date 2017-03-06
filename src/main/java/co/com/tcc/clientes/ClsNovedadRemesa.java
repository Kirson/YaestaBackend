
package co.com.tcc.clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para clsNovedadRemesa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="clsNovedadRemesa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodigoComplementario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodCiudadPlantea" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CiudadPlantea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodciudadSoluciona" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CiudadSoluciona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Comentarios" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Seguimientos" type="{http://clientes.tcc.com.co/}ArrayOfClsSeguimientoNovedad" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clsNovedadRemesa", propOrder = {
    "id",
    "codigo",
    "codigoComplementario",
    "codCiudadPlantea",
    "ciudadPlantea",
    "codciudadSoluciona",
    "ciudadSoluciona",
    "fecha",
    "descripcion",
    "comentarios",
    "estado",
    "seguimientos"
})
public class ClsNovedadRemesa {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Codigo")
    protected String codigo;
    @XmlElement(name = "CodigoComplementario")
    protected String codigoComplementario;
    @XmlElement(name = "CodCiudadPlantea")
    protected int codCiudadPlantea;
    @XmlElement(name = "CiudadPlantea")
    protected String ciudadPlantea;
    @XmlElement(name = "CodciudadSoluciona")
    protected int codciudadSoluciona;
    @XmlElement(name = "CiudadSoluciona")
    protected String ciudadSoluciona;
    @XmlElement(name = "Fecha", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "Comentarios")
    protected String comentarios;
    @XmlElement(name = "Estado")
    protected String estado;
    @XmlElement(name = "Seguimientos")
    protected ArrayOfClsSeguimientoNovedad seguimientos;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoComplementario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoComplementario() {
        return codigoComplementario;
    }

    /**
     * Define el valor de la propiedad codigoComplementario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoComplementario(String value) {
        this.codigoComplementario = value;
    }

    /**
     * Obtiene el valor de la propiedad codCiudadPlantea.
     * 
     */
    public int getCodCiudadPlantea() {
        return codCiudadPlantea;
    }

    /**
     * Define el valor de la propiedad codCiudadPlantea.
     * 
     */
    public void setCodCiudadPlantea(int value) {
        this.codCiudadPlantea = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadPlantea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudadPlantea() {
        return ciudadPlantea;
    }

    /**
     * Define el valor de la propiedad ciudadPlantea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudadPlantea(String value) {
        this.ciudadPlantea = value;
    }

    /**
     * Obtiene el valor de la propiedad codciudadSoluciona.
     * 
     */
    public int getCodciudadSoluciona() {
        return codciudadSoluciona;
    }

    /**
     * Define el valor de la propiedad codciudadSoluciona.
     * 
     */
    public void setCodciudadSoluciona(int value) {
        this.codciudadSoluciona = value;
    }

    /**
     * Obtiene el valor de la propiedad ciudadSoluciona.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudadSoluciona() {
        return ciudadSoluciona;
    }

    /**
     * Define el valor de la propiedad ciudadSoluciona.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudadSoluciona(String value) {
        this.ciudadSoluciona = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad comentarios.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Define el valor de la propiedad comentarios.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComentarios(String value) {
        this.comentarios = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad seguimientos.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfClsSeguimientoNovedad }
     *     
     */
    public ArrayOfClsSeguimientoNovedad getSeguimientos() {
        return seguimientos;
    }

    /**
     * Define el valor de la propiedad seguimientos.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfClsSeguimientoNovedad }
     *     
     */
    public void setSeguimientos(ArrayOfClsSeguimientoNovedad value) {
        this.seguimientos = value;
    }

}

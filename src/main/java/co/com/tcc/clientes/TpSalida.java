
package co.com.tcc.clientes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tpSalida complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tpSalida">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="remesa" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="numeroremesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="fecharemesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="nombremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="direccionremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="telefonoremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ciudadorigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="nombredestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="direcciondestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="telefonodestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ciudaddestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="totalunidades" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="producto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="entregaenbodega" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="fechaestado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="digitalizada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="numeroReferenciaCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="unidadnegocio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="codigocuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="unidad" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="tipounidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="tipoempaque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dicecontener" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="kilosreales" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="pesovolumen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="codigobarras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="documentosreferencia" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="tipodocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numerodocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="fechadocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="repuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tpSalida", propOrder = {
    "remesa",
    "repuesta",
    "mensaje"
})
public class TpSalida {

    protected List<TpSalida.Remesa> remesa;
    protected String repuesta;
    protected String mensaje;

    /**
     * Gets the value of the remesa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remesa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemesa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TpSalida.Remesa }
     * 
     * 
     */
    public List<TpSalida.Remesa> getRemesa() {
        if (remesa == null) {
            remesa = new ArrayList<TpSalida.Remesa>();
        }
        return this.remesa;
    }

    /**
     * Obtiene el valor de la propiedad repuesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepuesta() {
        return repuesta;
    }

    /**
     * Define el valor de la propiedad repuesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepuesta(String value) {
        this.repuesta = value;
    }

    /**
     * Obtiene el valor de la propiedad mensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Define el valor de la propiedad mensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="numeroremesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="fecharemesa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="nombremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="direccionremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="telefonoremitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ciudadorigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="nombredestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="direcciondestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="telefonodestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ciudaddestino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="totalunidades" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="producto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="entregaenbodega" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="fechaestado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="digitalizada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="numeroReferenciaCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="unidadnegocio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="codigocuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="unidad" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="tipounidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="tipoempaque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="dicecontener" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="kilosreales" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="pesovolumen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="codigobarras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="documentosreferencia" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="tipodocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numerodocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="fechadocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "numeroremesa",
        "fecharemesa",
        "nombremitente",
        "direccionremitente",
        "telefonoremitente",
        "ciudadorigen",
        "nombredestinatario",
        "direcciondestinatario",
        "telefonodestinatario",
        "ciudaddestino",
        "totalunidades",
        "producto",
        "entregaenbodega",
        "estado",
        "fechaestado",
        "observaciones",
        "digitalizada",
        "numeroReferenciaCliente",
        "unidadnegocio",
        "codigocuenta",
        "unidad",
        "documentosreferencia"
    })
    public static class Remesa {

        protected String numeroremesa;
        protected String fecharemesa;
        protected String nombremitente;
        protected String direccionremitente;
        protected String telefonoremitente;
        protected String ciudadorigen;
        protected String nombredestinatario;
        protected String direcciondestinatario;
        protected String telefonodestinatario;
        protected String ciudaddestino;
        protected String totalunidades;
        protected String producto;
        protected String entregaenbodega;
        protected String estado;
        protected String fechaestado;
        protected String observaciones;
        protected String digitalizada;
        protected String numeroReferenciaCliente;
        protected String unidadnegocio;
        protected String codigocuenta;
        protected List<TpSalida.Remesa.Unidad> unidad;
        protected List<TpSalida.Remesa.Documentosreferencia> documentosreferencia;

        /**
         * Obtiene el valor de la propiedad numeroremesa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumeroremesa() {
            return numeroremesa;
        }

        /**
         * Define el valor de la propiedad numeroremesa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumeroremesa(String value) {
            this.numeroremesa = value;
        }

        /**
         * Obtiene el valor de la propiedad fecharemesa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFecharemesa() {
            return fecharemesa;
        }

        /**
         * Define el valor de la propiedad fecharemesa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFecharemesa(String value) {
            this.fecharemesa = value;
        }

        /**
         * Obtiene el valor de la propiedad nombremitente.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombremitente() {
            return nombremitente;
        }

        /**
         * Define el valor de la propiedad nombremitente.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombremitente(String value) {
            this.nombremitente = value;
        }

        /**
         * Obtiene el valor de la propiedad direccionremitente.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDireccionremitente() {
            return direccionremitente;
        }

        /**
         * Define el valor de la propiedad direccionremitente.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDireccionremitente(String value) {
            this.direccionremitente = value;
        }

        /**
         * Obtiene el valor de la propiedad telefonoremitente.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTelefonoremitente() {
            return telefonoremitente;
        }

        /**
         * Define el valor de la propiedad telefonoremitente.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTelefonoremitente(String value) {
            this.telefonoremitente = value;
        }

        /**
         * Obtiene el valor de la propiedad ciudadorigen.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCiudadorigen() {
            return ciudadorigen;
        }

        /**
         * Define el valor de la propiedad ciudadorigen.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCiudadorigen(String value) {
            this.ciudadorigen = value;
        }

        /**
         * Obtiene el valor de la propiedad nombredestinatario.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombredestinatario() {
            return nombredestinatario;
        }

        /**
         * Define el valor de la propiedad nombredestinatario.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombredestinatario(String value) {
            this.nombredestinatario = value;
        }

        /**
         * Obtiene el valor de la propiedad direcciondestinatario.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDirecciondestinatario() {
            return direcciondestinatario;
        }

        /**
         * Define el valor de la propiedad direcciondestinatario.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDirecciondestinatario(String value) {
            this.direcciondestinatario = value;
        }

        /**
         * Obtiene el valor de la propiedad telefonodestinatario.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTelefonodestinatario() {
            return telefonodestinatario;
        }

        /**
         * Define el valor de la propiedad telefonodestinatario.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTelefonodestinatario(String value) {
            this.telefonodestinatario = value;
        }

        /**
         * Obtiene el valor de la propiedad ciudaddestino.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCiudaddestino() {
            return ciudaddestino;
        }

        /**
         * Define el valor de la propiedad ciudaddestino.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCiudaddestino(String value) {
            this.ciudaddestino = value;
        }

        /**
         * Obtiene el valor de la propiedad totalunidades.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTotalunidades() {
            return totalunidades;
        }

        /**
         * Define el valor de la propiedad totalunidades.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTotalunidades(String value) {
            this.totalunidades = value;
        }

        /**
         * Obtiene el valor de la propiedad producto.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProducto() {
            return producto;
        }

        /**
         * Define el valor de la propiedad producto.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProducto(String value) {
            this.producto = value;
        }

        /**
         * Obtiene el valor de la propiedad entregaenbodega.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEntregaenbodega() {
            return entregaenbodega;
        }

        /**
         * Define el valor de la propiedad entregaenbodega.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEntregaenbodega(String value) {
            this.entregaenbodega = value;
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
         * Obtiene el valor de la propiedad fechaestado.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFechaestado() {
            return fechaestado;
        }

        /**
         * Define el valor de la propiedad fechaestado.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFechaestado(String value) {
            this.fechaestado = value;
        }

        /**
         * Obtiene el valor de la propiedad observaciones.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getObservaciones() {
            return observaciones;
        }

        /**
         * Define el valor de la propiedad observaciones.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setObservaciones(String value) {
            this.observaciones = value;
        }

        /**
         * Obtiene el valor de la propiedad digitalizada.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDigitalizada() {
            return digitalizada;
        }

        /**
         * Define el valor de la propiedad digitalizada.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDigitalizada(String value) {
            this.digitalizada = value;
        }

        /**
         * Obtiene el valor de la propiedad numeroReferenciaCliente.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumeroReferenciaCliente() {
            return numeroReferenciaCliente;
        }

        /**
         * Define el valor de la propiedad numeroReferenciaCliente.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumeroReferenciaCliente(String value) {
            this.numeroReferenciaCliente = value;
        }

        /**
         * Obtiene el valor de la propiedad unidadnegocio.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnidadnegocio() {
            return unidadnegocio;
        }

        /**
         * Define el valor de la propiedad unidadnegocio.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnidadnegocio(String value) {
            this.unidadnegocio = value;
        }

        /**
         * Obtiene el valor de la propiedad codigocuenta.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodigocuenta() {
            return codigocuenta;
        }

        /**
         * Define el valor de la propiedad codigocuenta.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodigocuenta(String value) {
            this.codigocuenta = value;
        }

        /**
         * Gets the value of the unidad property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the unidad property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUnidad().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TpSalida.Remesa.Unidad }
         * 
         * 
         */
        public List<TpSalida.Remesa.Unidad> getUnidad() {
            if (unidad == null) {
                unidad = new ArrayList<TpSalida.Remesa.Unidad>();
            }
            return this.unidad;
        }

        /**
         * Gets the value of the documentosreferencia property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the documentosreferencia property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDocumentosreferencia().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TpSalida.Remesa.Documentosreferencia }
         * 
         * 
         */
        public List<TpSalida.Remesa.Documentosreferencia> getDocumentosreferencia() {
            if (documentosreferencia == null) {
                documentosreferencia = new ArrayList<TpSalida.Remesa.Documentosreferencia>();
            }
            return this.documentosreferencia;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="tipodocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="numerodocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="fechadocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "tipodocumento",
            "numerodocumento",
            "fechadocumento"
        })
        public static class Documentosreferencia {

            protected String tipodocumento;
            protected String numerodocumento;
            protected String fechadocumento;

            /**
             * Obtiene el valor de la propiedad tipodocumento.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTipodocumento() {
                return tipodocumento;
            }

            /**
             * Define el valor de la propiedad tipodocumento.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTipodocumento(String value) {
                this.tipodocumento = value;
            }

            /**
             * Obtiene el valor de la propiedad numerodocumento.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumerodocumento() {
                return numerodocumento;
            }

            /**
             * Define el valor de la propiedad numerodocumento.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumerodocumento(String value) {
                this.numerodocumento = value;
            }

            /**
             * Obtiene el valor de la propiedad fechadocumento.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFechadocumento() {
                return fechadocumento;
            }

            /**
             * Define el valor de la propiedad fechadocumento.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFechadocumento(String value) {
                this.fechadocumento = value;
            }

        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="tipounidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="tipoempaque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="dicecontener" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="kilosreales" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="pesovolumen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="codigobarras" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "tipounidad",
            "tipoempaque",
            "dicecontener",
            "kilosreales",
            "pesovolumen",
            "codigobarras"
        })
        public static class Unidad {

            protected String tipounidad;
            protected String tipoempaque;
            protected String dicecontener;
            protected String kilosreales;
            protected String pesovolumen;
            protected String codigobarras;

            /**
             * Obtiene el valor de la propiedad tipounidad.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTipounidad() {
                return tipounidad;
            }

            /**
             * Define el valor de la propiedad tipounidad.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTipounidad(String value) {
                this.tipounidad = value;
            }

            /**
             * Obtiene el valor de la propiedad tipoempaque.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTipoempaque() {
                return tipoempaque;
            }

            /**
             * Define el valor de la propiedad tipoempaque.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTipoempaque(String value) {
                this.tipoempaque = value;
            }

            /**
             * Obtiene el valor de la propiedad dicecontener.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDicecontener() {
                return dicecontener;
            }

            /**
             * Define el valor de la propiedad dicecontener.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDicecontener(String value) {
                this.dicecontener = value;
            }

            /**
             * Obtiene el valor de la propiedad kilosreales.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKilosreales() {
                return kilosreales;
            }

            /**
             * Define el valor de la propiedad kilosreales.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKilosreales(String value) {
                this.kilosreales = value;
            }

            /**
             * Obtiene el valor de la propiedad pesovolumen.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPesovolumen() {
                return pesovolumen;
            }

            /**
             * Define el valor de la propiedad pesovolumen.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPesovolumen(String value) {
                this.pesovolumen = value;
            }

            /**
             * Obtiene el valor de la propiedad codigobarras.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigobarras() {
                return codigobarras;
            }

            /**
             * Define el valor de la propiedad codigobarras.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigobarras(String value) {
                this.codigobarras = value;
            }

        }

    }

}

//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.09.02 a las 09:44:25 AM ECT 
//


package com.yaesta.integration.laarcourier.wsdl;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para WayBill complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="WayBill"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ActualWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ClientWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ContentSdtl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DeclaredValue" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="DeliveryAddress" type="{http://schemas.datacontract.org/2004/07/WarehouseServices}AddressInfo" minOccurs="0"/&gt;
 *         &lt;element name="ElectronicWeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="GUIANumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Height" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Idtrx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Length" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PickUpConsignee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PickupRequestDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Pieces" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Service" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UnitDimension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Warehouseid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Warehouseidloc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WeightUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WayBill", propOrder = {
    "actualWeight",
    "branch",
    "clientWeight",
    "comments",
    "company",
    "contentSdtl",
    "customerId",
    "declaredValue",
    "deliveryAddress",
    "electronicWeight",
    "guiaNumber",
    "height",
    "idtrx",
    "length",
    "password",
    "pickUpConsignee",
    "pickupRequestDate",
    "pieces",
    "service",
    "unitDimension",
    "username",
    "warehouseid",
    "warehouseidloc",
    "weightUnit",
    "width"
})
public class WayBill {

    @XmlElement(name = "ActualWeight")
    protected BigDecimal actualWeight;
    @XmlElementRef(name = "Branch", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> branch;
    @XmlElement(name = "ClientWeight")
    protected BigDecimal clientWeight;
    @XmlElementRef(name = "Comments", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> comments;
    @XmlElementRef(name = "Company", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> company;
    @XmlElementRef(name = "ContentSdtl", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contentSdtl;
    @XmlElementRef(name = "CustomerId", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customerId;
    @XmlElement(name = "DeclaredValue")
    protected BigDecimal declaredValue;
    @XmlElementRef(name = "DeliveryAddress", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<AddressInfo> deliveryAddress;
    @XmlElement(name = "ElectronicWeight")
    protected BigDecimal electronicWeight;
    @XmlElementRef(name = "GUIANumber", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> guiaNumber;
    @XmlElement(name = "Height")
    protected BigDecimal height;
    @XmlElementRef(name = "Idtrx", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idtrx;
    @XmlElement(name = "Length")
    protected BigDecimal length;
    @XmlElementRef(name = "Password", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> password;
    @XmlElementRef(name = "PickUpConsignee", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pickUpConsignee;
    @XmlElementRef(name = "PickupRequestDate", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pickupRequestDate;
    @XmlElement(name = "Pieces")
    protected BigDecimal pieces;
    @XmlElementRef(name = "Service", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> service;
    @XmlElementRef(name = "UnitDimension", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> unitDimension;
    @XmlElementRef(name = "Username", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> username;
    @XmlElementRef(name = "Warehouseid", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> warehouseid;
    @XmlElementRef(name = "Warehouseidloc", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> warehouseidloc;
    @XmlElementRef(name = "WeightUnit", namespace = "http://schemas.datacontract.org/2004/07/WarehouseServices", type = JAXBElement.class, required = false)
    protected JAXBElement<String> weightUnit;
    @XmlElement(name = "Width")
    protected BigDecimal width;

    /**
     * Obtiene el valor de la propiedad actualWeight.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getActualWeight() {
        return actualWeight;
    }

    /**
     * Define el valor de la propiedad actualWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setActualWeight(BigDecimal value) {
        this.actualWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad branch.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBranch() {
        return branch;
    }

    /**
     * Define el valor de la propiedad branch.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBranch(JAXBElement<String> value) {
        this.branch = value;
    }

    /**
     * Obtiene el valor de la propiedad clientWeight.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getClientWeight() {
        return clientWeight;
    }

    /**
     * Define el valor de la propiedad clientWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setClientWeight(BigDecimal value) {
        this.clientWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad comments.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getComments() {
        return comments;
    }

    /**
     * Define el valor de la propiedad comments.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setComments(JAXBElement<String> value) {
        this.comments = value;
    }

    /**
     * Obtiene el valor de la propiedad company.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompany() {
        return company;
    }

    /**
     * Define el valor de la propiedad company.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompany(JAXBElement<String> value) {
        this.company = value;
    }

    /**
     * Obtiene el valor de la propiedad contentSdtl.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContentSdtl() {
        return contentSdtl;
    }

    /**
     * Define el valor de la propiedad contentSdtl.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContentSdtl(JAXBElement<String> value) {
        this.contentSdtl = value;
    }

    /**
     * Obtiene el valor de la propiedad customerId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomerId() {
        return customerId;
    }

    /**
     * Define el valor de la propiedad customerId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomerId(JAXBElement<String> value) {
        this.customerId = value;
    }

    /**
     * Obtiene el valor de la propiedad declaredValue.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDeclaredValue() {
        return declaredValue;
    }

    /**
     * Define el valor de la propiedad declaredValue.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDeclaredValue(BigDecimal value) {
        this.declaredValue = value;
    }

    /**
     * Obtiene el valor de la propiedad deliveryAddress.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AddressInfo }{@code >}
     *     
     */
    public JAXBElement<AddressInfo> getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Define el valor de la propiedad deliveryAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AddressInfo }{@code >}
     *     
     */
    public void setDeliveryAddress(JAXBElement<AddressInfo> value) {
        this.deliveryAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad electronicWeight.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getElectronicWeight() {
        return electronicWeight;
    }

    /**
     * Define el valor de la propiedad electronicWeight.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setElectronicWeight(BigDecimal value) {
        this.electronicWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad guiaNumber.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGUIANumber() {
        return guiaNumber;
    }

    /**
     * Define el valor de la propiedad guiaNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGUIANumber(JAXBElement<String> value) {
        this.guiaNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad height.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHeight() {
        return height;
    }

    /**
     * Define el valor de la propiedad height.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHeight(BigDecimal value) {
        this.height = value;
    }

    /**
     * Obtiene el valor de la propiedad idtrx.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdtrx() {
        return idtrx;
    }

    /**
     * Define el valor de la propiedad idtrx.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdtrx(JAXBElement<String> value) {
        this.idtrx = value;
    }

    /**
     * Obtiene el valor de la propiedad length.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLength() {
        return length;
    }

    /**
     * Define el valor de la propiedad length.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLength(BigDecimal value) {
        this.length = value;
    }

    /**
     * Obtiene el valor de la propiedad password.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPassword() {
        return password;
    }

    /**
     * Define el valor de la propiedad password.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPassword(JAXBElement<String> value) {
        this.password = value;
    }

    /**
     * Obtiene el valor de la propiedad pickUpConsignee.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPickUpConsignee() {
        return pickUpConsignee;
    }

    /**
     * Define el valor de la propiedad pickUpConsignee.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPickUpConsignee(JAXBElement<String> value) {
        this.pickUpConsignee = value;
    }

    /**
     * Obtiene el valor de la propiedad pickupRequestDate.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPickupRequestDate() {
        return pickupRequestDate;
    }

    /**
     * Define el valor de la propiedad pickupRequestDate.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPickupRequestDate(JAXBElement<String> value) {
        this.pickupRequestDate = value;
    }

    /**
     * Obtiene el valor de la propiedad pieces.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPieces() {
        return pieces;
    }

    /**
     * Define el valor de la propiedad pieces.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPieces(BigDecimal value) {
        this.pieces = value;
    }

    /**
     * Obtiene el valor de la propiedad service.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getService() {
        return service;
    }

    /**
     * Define el valor de la propiedad service.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setService(JAXBElement<String> value) {
        this.service = value;
    }

    /**
     * Obtiene el valor de la propiedad unitDimension.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUnitDimension() {
        return unitDimension;
    }

    /**
     * Define el valor de la propiedad unitDimension.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUnitDimension(JAXBElement<String> value) {
        this.unitDimension = value;
    }

    /**
     * Obtiene el valor de la propiedad username.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUsername() {
        return username;
    }

    /**
     * Define el valor de la propiedad username.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUsername(JAXBElement<String> value) {
        this.username = value;
    }

    /**
     * Obtiene el valor de la propiedad warehouseid.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWarehouseid() {
        return warehouseid;
    }

    /**
     * Define el valor de la propiedad warehouseid.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWarehouseid(JAXBElement<String> value) {
        this.warehouseid = value;
    }

    /**
     * Obtiene el valor de la propiedad warehouseidloc.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWarehouseidloc() {
        return warehouseidloc;
    }

    /**
     * Define el valor de la propiedad warehouseidloc.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWarehouseidloc(JAXBElement<String> value) {
        this.warehouseidloc = value;
    }

    /**
     * Obtiene el valor de la propiedad weightUnit.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWeightUnit() {
        return weightUnit;
    }

    /**
     * Define el valor de la propiedad weightUnit.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWeightUnit(JAXBElement<String> value) {
        this.weightUnit = value;
    }

    /**
     * Obtiene el valor de la propiedad width.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWidth() {
        return width;
    }

    /**
     * Define el valor de la propiedad width.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWidth(BigDecimal value) {
        this.width = value;
    }

}

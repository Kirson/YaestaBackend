//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.14 at 08:35:23 PM ECT 
//


package com.yaesta.integration.vitex.wsdl.dto;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FreightStockKeepingUnitDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FreightStockKeepingUnitDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DeliveryTime" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FreightAdditionalInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FreightPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FreightScheduledDateOptions" type="{http://schemas.datacontract.org/2004/07/Vtex.Commerce.WebApps.AdminWcfService.Contracts}ArrayOfFreightScheduledDateOptionDTO" minOccurs="0"/>
 *         &lt;element name="FreightType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FreightTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="StockKeepingUnitId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FreightStockKeepingUnitDTO", namespace = "http://schemas.datacontract.org/2004/07/Vtex.Commerce.WebApps.AdminWcfService.Contracts", propOrder = {
    "deliveryTime",
    "freightAdditionalInfo",
    "freightPrice",
    "freightScheduledDateOptions",
    "freightType",
    "freightTypeId",
    "quantity",
    "stockKeepingUnitId"
})
public class FreightStockKeepingUnitDTO {

    @XmlElement(name = "DeliveryTime")
    protected Integer deliveryTime;
    @XmlElementRef(name = "FreightAdditionalInfo", namespace = "http://schemas.datacontract.org/2004/07/Vtex.Commerce.WebApps.AdminWcfService.Contracts", type = JAXBElement.class)
    protected JAXBElement<String> freightAdditionalInfo;
    @XmlElement(name = "FreightPrice")
    protected BigDecimal freightPrice;
    @XmlElementRef(name = "FreightScheduledDateOptions", namespace = "http://schemas.datacontract.org/2004/07/Vtex.Commerce.WebApps.AdminWcfService.Contracts", type = JAXBElement.class)
    protected JAXBElement<ArrayOfFreightScheduledDateOptionDTO> freightScheduledDateOptions;
    @XmlElementRef(name = "FreightType", namespace = "http://schemas.datacontract.org/2004/07/Vtex.Commerce.WebApps.AdminWcfService.Contracts", type = JAXBElement.class)
    protected JAXBElement<String> freightType;
    @XmlElementRef(name = "FreightTypeId", namespace = "http://schemas.datacontract.org/2004/07/Vtex.Commerce.WebApps.AdminWcfService.Contracts", type = JAXBElement.class)
    protected JAXBElement<String> freightTypeId;
    @XmlElement(name = "Quantity")
    protected Integer quantity;
    @XmlElement(name = "StockKeepingUnitId")
    protected Integer stockKeepingUnitId;

    /**
     * Gets the value of the deliveryTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * Sets the value of the deliveryTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeliveryTime(Integer value) {
        this.deliveryTime = value;
    }

    /**
     * Gets the value of the freightAdditionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFreightAdditionalInfo() {
        return freightAdditionalInfo;
    }

    /**
     * Sets the value of the freightAdditionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFreightAdditionalInfo(JAXBElement<String> value) {
        this.freightAdditionalInfo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the freightPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    /**
     * Sets the value of the freightPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFreightPrice(BigDecimal value) {
        this.freightPrice = value;
    }

    /**
     * Gets the value of the freightScheduledDateOptions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFreightScheduledDateOptionDTO }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFreightScheduledDateOptionDTO> getFreightScheduledDateOptions() {
        return freightScheduledDateOptions;
    }

    /**
     * Sets the value of the freightScheduledDateOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFreightScheduledDateOptionDTO }{@code >}
     *     
     */
    public void setFreightScheduledDateOptions(JAXBElement<ArrayOfFreightScheduledDateOptionDTO> value) {
        this.freightScheduledDateOptions = ((JAXBElement<ArrayOfFreightScheduledDateOptionDTO> ) value);
    }

    /**
     * Gets the value of the freightType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFreightType() {
        return freightType;
    }

    /**
     * Sets the value of the freightType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFreightType(JAXBElement<String> value) {
        this.freightType = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the freightTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFreightTypeId() {
        return freightTypeId;
    }

    /**
     * Sets the value of the freightTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFreightTypeId(JAXBElement<String> value) {
        this.freightTypeId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuantity(Integer value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the stockKeepingUnitId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStockKeepingUnitId() {
        return stockKeepingUnitId;
    }

    /**
     * Sets the value of the stockKeepingUnitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStockKeepingUnitId(Integer value) {
        this.stockKeepingUnitId = value;
    }

}
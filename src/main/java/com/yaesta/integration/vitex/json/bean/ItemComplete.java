
package com.yaesta.integration.vitex.json.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("serial")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "uniqueId",
    "id",
    "productId",
    "ean",
    "lockId",
    "itemAttachment",
    "attachments",
    "quantity",
    "seller",
    "name",
    "refId",
    "price",
    "listPrice",
    "manualPrice",
    "priceTags",
    "imageUrl",
    "detailUrl",
    "components",
    "bundleItems",
    "params",
    "offerings",
    "sellerSku",
    "priceValidUntil",
    "commission",
    "tax",
    "preSaleDate",
    "additionalInfo",
    "measurementUnit",
    "unitMultiplier",
    "sellingPrice",
    "isGift",
    "shippingPrice",
    "supplierName"
})
public class ItemComplete implements Serializable{

    @JsonProperty("uniqueId")
    private String uniqueId;
    @JsonProperty("id")
    private String id;
    @JsonProperty("productId")
    private String productId;
    @JsonProperty("ean")
    private String ean;
    @JsonProperty("lockId")
    private String lockId;
    @JsonProperty("itemAttachment")
    private ItemAttachment itemAttachment;
    @JsonProperty("attachments")
    private List<Object> attachments = new ArrayList<Object>();
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("seller")
    private String seller;
    @JsonProperty("name")
    private String name;
    @JsonProperty("refId")
    private Object refId;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("listPrice")
    private Double listPrice;
    @JsonProperty("manualPrice")
    private Double manualPrice;
    @JsonProperty("priceTags")
    private List<PriceTag> priceTags = new ArrayList<PriceTag>();
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("detailUrl")
    private String detailUrl;
    @JsonProperty("components")
    private List<Object> components = new ArrayList<Object>();
    @JsonProperty("bundleItems")
    private List<Object> bundleItems = new ArrayList<Object>();
    @JsonProperty("params")
    private List<Object> params = new ArrayList<Object>();
    @JsonProperty("offerings")
    private List<Object> offerings = new ArrayList<Object>();
    @JsonProperty("sellerSku")
    private String sellerSku;
    @JsonProperty("priceValidUntil")
    private Double priceValidUntil;
    @JsonProperty("commission")
    private Double commission;
    @JsonProperty("tax")
    private Double tax;
    @JsonProperty("preSaleDate")
    private Object preSaleDate;
    @JsonProperty("additionalInfo")
    private AdditionalInfo additionalInfo;
    @JsonProperty("measurementUnit")
    private String measurementUnit;
    @JsonProperty("unitMultiplier")
    private Integer unitMultiplier;
    @JsonProperty("sellingPrice")
    private Double sellingPrice;
    @JsonProperty("isGift")
    private Boolean isGift;
    @JsonProperty("shippingPrice")
    private Double shippingPrice;
    @JsonProperty("discount")
    private Double discount;
    @JsonProperty("supplierName")
    private String supplierName;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The uniqueId
     */
    @JsonProperty("uniqueId")
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * 
     * @param uniqueId
     *     The uniqueId
     */
    @JsonProperty("uniqueId")
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The productId
     */
    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId
     *     The productId
     */
    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return
     *     The ean
     */
    @JsonProperty("ean")
    public String getEan() {
        return ean;
    }

    /**
     * 
     * @param ean
     *     The ean
     */
    @JsonProperty("ean")
    public void setEan(String ean) {
        this.ean = ean;
    }

    /**
     * 
     * @return
     *     The lockId
     */
    @JsonProperty("lockId")
    public String getLockId() {
        return lockId;
    }

    /**
     * 
     * @param lockId
     *     The lockId
     */
    @JsonProperty("lockId")
    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    /**
     * 
     * @return
     *     The itemAttachment
     */
    @JsonProperty("itemAttachment")
    public ItemAttachment getItemAttachment() {
        return itemAttachment;
    }

    /**
     * 
     * @param itemAttachment
     *     The itemAttachment
     */
    @JsonProperty("itemAttachment")
    public void setItemAttachment(ItemAttachment itemAttachment) {
        this.itemAttachment = itemAttachment;
    }

    /**
     * 
     * @return
     *     The attachments
     */
    @JsonProperty("attachments")
    public List<Object> getAttachments() {
        return attachments;
    }

    /**
     * 
     * @param attachments
     *     The attachments
     */
    @JsonProperty("attachments")
    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    /**
     * 
     * @return
     *     The quantity
     */
    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 
     * @param quantity
     *     The quantity
     */
    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 
     * @return
     *     The seller
     */
    @JsonProperty("seller")
    public String getSeller() {
        return seller;
    }

    /**
     * 
     * @param seller
     *     The seller
     */
    @JsonProperty("seller")
    public void setSeller(String seller) {
        this.seller = seller;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The refId
     */
    @JsonProperty("refId")
    public Object getRefId() {
        return refId;
    }

    /**
     * 
     * @param refId
     *     The refId
     */
    @JsonProperty("refId")
    public void setRefId(Object refId) {
        this.refId = refId;
    }

    /**
     * 
     * @return
     *     The price
     */
    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The listPrice
     */
    @JsonProperty("listPrice")
    public Double getListPrice() {
        return listPrice;
    }

    /**
     * 
     * @param listPrice
     *     The listPrice
     */
    @JsonProperty("listPrice")
    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * 
     * @return
     *     The manualPrice
     */
    @JsonProperty("manualPrice")
    public Double getManualPrice() {
        return manualPrice;
    }

    /**
     * 
     * @param manualPrice
     *     The manualPrice
     */
    @JsonProperty("manualPrice")
    public void setManualPrice(Double manualPrice) {
        this.manualPrice = manualPrice;
    }

    /**
     * 
     * @return
     *     The priceTags
     */
    @JsonProperty("priceTags")
    public List<PriceTag> getPriceTags() {
        return priceTags;
    }

    /**
     * 
     * @param priceTags
     *     The priceTags
     */
    @JsonProperty("priceTags")
    public void setPriceTags(List<PriceTag> priceTags) {
        this.priceTags = priceTags;
    }

    /**
     * 
     * @return
     *     The imageUrl
     */
    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     * @param imageUrl
     *     The imageUrl
     */
    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 
     * @return
     *     The detailUrl
     */
    @JsonProperty("detailUrl")
    public String getDetailUrl() {
        return detailUrl;
    }

    /**
     * 
     * @param detailUrl
     *     The detailUrl
     */
    @JsonProperty("detailUrl")
    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    /**
     * 
     * @return
     *     The components
     */
    @JsonProperty("components")
    public List<Object> getComponents() {
        return components;
    }

    /**
     * 
     * @param components
     *     The components
     */
    @JsonProperty("components")
    public void setComponents(List<Object> components) {
        this.components = components;
    }

    /**
     * 
     * @return
     *     The bundleItems
     */
    @JsonProperty("bundleItems")
    public List<Object> getBundleItems() {
        return bundleItems;
    }

    /**
     * 
     * @param bundleItems
     *     The bundleItems
     */
    @JsonProperty("bundleItems")
    public void setBundleItems(List<Object> bundleItems) {
        this.bundleItems = bundleItems;
    }

    /**
     * 
     * @return
     *     The params
     */
    @JsonProperty("params")
    public List<Object> getParams() {
        return params;
    }

    /**
     * 
     * @param params
     *     The params
     */
    @JsonProperty("params")
    public void setParams(List<Object> params) {
        this.params = params;
    }

    /**
     * 
     * @return
     *     The offerings
     */
    @JsonProperty("offerings")
    public List<Object> getOfferings() {
        return offerings;
    }

    /**
     * 
     * @param offerings
     *     The offerings
     */
    @JsonProperty("offerings")
    public void setOfferings(List<Object> offerings) {
        this.offerings = offerings;
    }

    /**
     * 
     * @return
     *     The sellerSku
     */
    @JsonProperty("sellerSku")
    public String getSellerSku() {
        return sellerSku;
    }

    /**
     * 
     * @param sellerSku
     *     The sellerSku
     */
    @JsonProperty("sellerSku")
    public void setSellerSku(String sellerSku) {
        this.sellerSku = sellerSku;
    }

    /**
     * 
     * @return
     *     The priceValidUntil
     */
    @JsonProperty("priceValidUntil")
    public Double getPriceValidUntil() {
        return priceValidUntil;
    }

    /**
     * 
     * @param priceValidUntil
     *     The priceValidUntil
     */
    @JsonProperty("priceValidUntil")
    public void setPriceValidUntil(Double priceValidUntil) {
        this.priceValidUntil = priceValidUntil;
    }

    /**
     * 
     * @return
     *     The commission
     */
    @JsonProperty("commission")
    public Double getCommission() {
        return commission;
    }

    /**
     * 
     * @param commission
     *     The commission
     */
    @JsonProperty("commission")
    public void setCommission(Double commission) {
        this.commission = commission;
    }

    /**
     * 
     * @return
     *     The tax
     */
    @JsonProperty("tax")
    public Double getTax() {
        return tax;
    }

    /**
     * 
     * @param tax
     *     The tax
     */
    @JsonProperty("tax")
    public void setTax(Double tax) {
        this.tax = tax;
    }

    /**
     * 
     * @return
     *     The preSaleDate
     */
    @JsonProperty("preSaleDate")
    public Object getPreSaleDate() {
        return preSaleDate;
    }

    /**
     * 
     * @param preSaleDate
     *     The preSaleDate
     */
    @JsonProperty("preSaleDate")
    public void setPreSaleDate(Object preSaleDate) {
        this.preSaleDate = preSaleDate;
    }

    /**
     * 
     * @return
     *     The additionalInfo
     */
    @JsonProperty("additionalInfo")
    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * 
     * @param additionalInfo
     *     The additionalInfo
     */
    @JsonProperty("additionalInfo")
    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * 
     * @return
     *     The measurementUnit
     */
    @JsonProperty("measurementUnit")
    public String getMeasurementUnit() {
        return measurementUnit;
    }

    /**
     * 
     * @param measurementUnit
     *     The measurementUnit
     */
    @JsonProperty("measurementUnit")
    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    /**
     * 
     * @return
     *     The unitMultiplier
     */
    @JsonProperty("unitMultiplier")
    public Integer getUnitMultiplier() {
        return unitMultiplier;
    }

    /**
     * 
     * @param unitMultiplier
     *     The unitMultiplier
     */
    @JsonProperty("unitMultiplier")
    public void setUnitMultiplier(Integer unitMultiplier) {
        this.unitMultiplier = unitMultiplier;
    }

    /**
     * 
     * @return
     *     The sellingPrice
     */
    @JsonProperty("sellingPrice")
    public Double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * 
     * @param sellingPrice
     *     The sellingPrice
     */
    @JsonProperty("sellingPrice")
    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * 
     * @return
     *     The isGift
     */
    @JsonProperty("isGift")
    public Boolean getIsGift() {
        return isGift;
    }

    /**
     * 
     * @param isGift
     *     The isGift
     */
    @JsonProperty("isGift")
    public void setIsGift(Boolean isGift) {
        this.isGift = isGift;
    }

    /**
     * 
     * @return
     *     The shippingPrice
     */
    @JsonProperty("shippingPrice")
    public Double getShippingPrice() {
        return shippingPrice;
    }

    /**
     * 
     * @param shippingPrice
     *     The shippingPrice
     */
    @JsonProperty("shippingPrice")
    public void setShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }
    
    
    @JsonProperty("discount")
    public Double getDiscount() {
		return discount;
	}

    @JsonProperty("discount")
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
    
    
    @JsonProperty("supplierName")
	public String getSupplierName() {
		return supplierName;
	}

    @JsonProperty("supplierName")
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


package com.yaesta.integration.vitex.json.bean;

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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "itemIndex",
    "selectedSla",
    "lockTTL",
    "price",
    "listPrice",
    "sellingPrice",
    "deliveryWindow",
    "deliveryCompany",
    "shippingEstimate",
    "shippingEstimateDate",
    "slas",
    "shipsTo",
    "deliveryIds"
})
public class LogisticsInfo {

    @JsonProperty("itemIndex")
    private Integer itemIndex;
    @JsonProperty("selectedSla")
    private String selectedSla;
    @JsonProperty("lockTTL")
    private String lockTTL;
    @JsonProperty("price")
    private Integer price;
    @JsonProperty("listPrice")
    private Integer listPrice;
    @JsonProperty("sellingPrice")
    private Integer sellingPrice;
    @JsonProperty("deliveryWindow")
    private Object deliveryWindow;
    @JsonProperty("deliveryCompany")
    private String deliveryCompany;
    @JsonProperty("shippingEstimate")
    private String shippingEstimate;
    @JsonProperty("shippingEstimateDate")
    private Object shippingEstimateDate;
    @JsonProperty("slas")
    private List<Sla> slas = new ArrayList<Sla>();
    @JsonProperty("shipsTo")
    private List<String> shipsTo = new ArrayList<String>();
    @JsonProperty("deliveryIds")
    private List<DeliveryId> deliveryIds = new ArrayList<DeliveryId>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The itemIndex
     */
    @JsonProperty("itemIndex")
    public Integer getItemIndex() {
        return itemIndex;
    }

    /**
     * 
     * @param itemIndex
     *     The itemIndex
     */
    @JsonProperty("itemIndex")
    public void setItemIndex(Integer itemIndex) {
        this.itemIndex = itemIndex;
    }

    /**
     * 
     * @return
     *     The selectedSla
     */
    @JsonProperty("selectedSla")
    public String getSelectedSla() {
        return selectedSla;
    }

    /**
     * 
     * @param selectedSla
     *     The selectedSla
     */
    @JsonProperty("selectedSla")
    public void setSelectedSla(String selectedSla) {
        this.selectedSla = selectedSla;
    }

    /**
     * 
     * @return
     *     The lockTTL
     */
    @JsonProperty("lockTTL")
    public String getLockTTL() {
        return lockTTL;
    }

    /**
     * 
     * @param lockTTL
     *     The lockTTL
     */
    @JsonProperty("lockTTL")
    public void setLockTTL(String lockTTL) {
        this.lockTTL = lockTTL;
    }

    /**
     * 
     * @return
     *     The price
     */
    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The listPrice
     */
    @JsonProperty("listPrice")
    public Integer getListPrice() {
        return listPrice;
    }

    /**
     * 
     * @param listPrice
     *     The listPrice
     */
    @JsonProperty("listPrice")
    public void setListPrice(Integer listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * 
     * @return
     *     The sellingPrice
     */
    @JsonProperty("sellingPrice")
    public Integer getSellingPrice() {
        return sellingPrice;
    }

    /**
     * 
     * @param sellingPrice
     *     The sellingPrice
     */
    @JsonProperty("sellingPrice")
    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * 
     * @return
     *     The deliveryWindow
     */
    @JsonProperty("deliveryWindow")
    public Object getDeliveryWindow() {
        return deliveryWindow;
    }

    /**
     * 
     * @param deliveryWindow
     *     The deliveryWindow
     */
    @JsonProperty("deliveryWindow")
    public void setDeliveryWindow(Object deliveryWindow) {
        this.deliveryWindow = deliveryWindow;
    }

    /**
     * 
     * @return
     *     The deliveryCompany
     */
    @JsonProperty("deliveryCompany")
    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    /**
     * 
     * @param deliveryCompany
     *     The deliveryCompany
     */
    @JsonProperty("deliveryCompany")
    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    /**
     * 
     * @return
     *     The shippingEstimate
     */
    @JsonProperty("shippingEstimate")
    public String getShippingEstimate() {
        return shippingEstimate;
    }

    /**
     * 
     * @param shippingEstimate
     *     The shippingEstimate
     */
    @JsonProperty("shippingEstimate")
    public void setShippingEstimate(String shippingEstimate) {
        this.shippingEstimate = shippingEstimate;
    }

    /**
     * 
     * @return
     *     The shippingEstimateDate
     */
    @JsonProperty("shippingEstimateDate")
    public Object getShippingEstimateDate() {
        return shippingEstimateDate;
    }

    /**
     * 
     * @param shippingEstimateDate
     *     The shippingEstimateDate
     */
    @JsonProperty("shippingEstimateDate")
    public void setShippingEstimateDate(Object shippingEstimateDate) {
        this.shippingEstimateDate = shippingEstimateDate;
    }

    /**
     * 
     * @return
     *     The slas
     */
    @JsonProperty("slas")
    public List<Sla> getSlas() {
        return slas;
    }

    /**
     * 
     * @param slas
     *     The slas
     */
    @JsonProperty("slas")
    public void setSlas(List<Sla> slas) {
        this.slas = slas;
    }

    /**
     * 
     * @return
     *     The shipsTo
     */
    @JsonProperty("shipsTo")
    public List<String> getShipsTo() {
        return shipsTo;
    }

    /**
     * 
     * @param shipsTo
     *     The shipsTo
     */
    @JsonProperty("shipsTo")
    public void setShipsTo(List<String> shipsTo) {
        this.shipsTo = shipsTo;
    }

    /**
     * 
     * @return
     *     The deliveryIds
     */
    @JsonProperty("deliveryIds")
    public List<DeliveryId> getDeliveryIds() {
        return deliveryIds;
    }

    /**
     * 
     * @param deliveryIds
     *     The deliveryIds
     */
    @JsonProperty("deliveryIds")
    public void setDeliveryIds(List<DeliveryId> deliveryIds) {
        this.deliveryIds = deliveryIds;
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

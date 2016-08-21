
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
    "type",
    "invoiceNumber",
    "courier",
    "trackingNumber",
    "trackingUrl",
    "items",
    "issuanceDate",
    "invoiceValue"
})
public class InvoiceSchema implements Serializable{

    @JsonProperty("type")
    private String type;
    @JsonProperty("invoiceNumber")
    private String invoiceNumber;
    @JsonProperty("courier")
    private String courier;
    @JsonProperty("trackingNumber")
    private String trackingNumber;
    @JsonProperty("trackingUrl")
    private String trackingUrl;
    @JsonProperty("items")
    private List<ItemInvoice> items = new ArrayList<ItemInvoice>();
    @JsonProperty("issuanceDate")
    private String issuanceDate;
    @JsonProperty("invoiceValue")
    private Double invoiceValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The invoiceNumber
     */
    @JsonProperty("invoiceNumber")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * 
     * @param invoiceNumber
     *     The invoiceNumber
     */
    @JsonProperty("invoiceNumber")
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * 
     * @return
     *     The courier
     */
    @JsonProperty("courier")
    public String getCourier() {
        return courier;
    }

    /**
     * 
     * @param courier
     *     The courier
     */
    @JsonProperty("courier")
    public void setCourier(String courier) {
        this.courier = courier;
    }

    /**
     * 
     * @return
     *     The trackingNumber
     */
    @JsonProperty("trackingNumber")
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * 
     * @param trackingNumber
     *     The trackingNumber
     */
    @JsonProperty("trackingNumber")
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    /**
     * 
     * @return
     *     The trackingUrl
     */
    @JsonProperty("trackingUrl")
    public String getTrackingUrl() {
        return trackingUrl;
    }

    /**
     * 
     * @param trackingUrl
     *     The trackingUrl
     */
    @JsonProperty("trackingUrl")
    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    /**
     * 
     * @return
     *     The items
     */
    @JsonProperty("items")
    public List<ItemInvoice> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    @JsonProperty("items")
    public void setItems(List<ItemInvoice> items) {
        this.items = items;
    }

    /**
     * 
     * @return
     *     The issuanceDate
     */
    @JsonProperty("issuanceDate")
    public String getIssuanceDate() {
        return issuanceDate;
    }

    /**
     * 
     * @param issuanceDate
     *     The issuanceDate
     */
    @JsonProperty("issuanceDate")
    public void setIssuanceDate(String issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    /**
     * 
     * @return
     *     The invoiceValue
     */
    @JsonProperty("invoiceValue")
    public Double getInvoiceValue() {
        return invoiceValue;
    }

    /**
     * 
     * @param invoiceValue
     *     The invoiceValue
     */
    @JsonProperty("invoiceValue")
    public void setInvoiceValue(Double invoiceValue) {
        this.invoiceValue = invoiceValue;
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


package com.yaesta.integration.vitex.json.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "orderId",
    "creationDate",
    "clientName",
    "items",
    "totalValue",
    "paymentNames",
    "status",
    "statusDescription",
    "marketPlaceOrderId",
    "sequence",
    "salesChannel",
    "affiliateId",
    "origin",
    "workflowInErrorState",
    "workflowInRetry",
    "lastMessageUnread",
    "shippingEstimatedDate",
    "orderIsComplete",
    "listId",
    "listType"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBean {

    @JsonProperty("orderId")
    private String orderId;
    @JsonProperty("creationDate")
    private String creationDate;
    @JsonProperty("clientName")
    private String clientName;
    @JsonProperty("items")
    private java.util.List<Item> items = new ArrayList<Item>();
    @JsonProperty("totalValue")
    private BigDecimal totalValue;
    @JsonProperty("paymentNames")
    private String paymentNames;
    @JsonProperty("status")
    private String status;
    @JsonProperty("statusDescription")
    private String statusDescription;
    @JsonProperty("marketPlaceOrderId")
    private String marketPlaceOrderId;
    @JsonProperty("sequence")
    private String sequence;
    @JsonProperty("salesChannel")
    private String salesChannel;
    @JsonProperty("affiliateId")
    private String affiliateId;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("workflowInErrorState")
    private Boolean workflowInErrorState;
    @JsonProperty("workflowInRetry")
    private Boolean workflowInRetry;
    @JsonProperty("lastMessageUnread")
    private String lastMessageUnread;
    @JsonProperty("shippingEstimatedDate")
    private String shippingEstimatedDate;
    @JsonProperty("orderIsComplete")
    private Boolean orderIsComplete;
    @JsonProperty("listId")
    private Object listId;
    @JsonProperty("listType")
    private Object listType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The orderId
     */
    @JsonProperty("orderId")
    public String getOrderId() {
        return orderId;
    }

    /**
     * 
     * @param orderId
     *     The orderId
     */
    @JsonProperty("orderId")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 
     * @return
     *     The creationDate
     */
    @JsonProperty("creationDate")
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * 
     * @param creationDate
     *     The creationDate
     */
    @JsonProperty("creationDate")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 
     * @return
     *     The clientName
     */
    @JsonProperty("clientName")
    public String getClientName() {
        return clientName;
    }

    /**
     * 
     * @param clientName
     *     The clientName
     */
    @JsonProperty("clientName")
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 
     * @return
     *     The items
     */
    @JsonProperty("items")
    public java.util.List<Item> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    @JsonProperty("items")
    public void setItems(java.util.List<Item> items) {
        this.items = items;
    }

    /**
     * 
     * @return
     *     The totalValue
     */
    @JsonProperty("totalValue")
    public BigDecimal getTotalValue() {
        return totalValue;
    }

    /**
     * 
     * @param totalValue
     *     The totalValue
     */
    @JsonProperty("totalValue")
    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * 
     * @return
     *     The paymentNames
     */
    @JsonProperty("paymentNames")
    public String getPaymentNames() {
        return paymentNames;
    }

    /**
     * 
     * @param paymentNames
     *     The paymentNames
     */
    @JsonProperty("paymentNames")
    public void setPaymentNames(String paymentNames) {
        this.paymentNames = paymentNames;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The statusDescription
     */
    @JsonProperty("statusDescription")
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * 
     * @param statusDescription
     *     The statusDescription
     */
    @JsonProperty("statusDescription")
    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    /**
     * 
     * @return
     *     The marketPlaceOrderId
     */
    @JsonProperty("marketPlaceOrderId")
    public String getMarketPlaceOrderId() {
        return marketPlaceOrderId;
    }

    /**
     * 
     * @param marketPlaceOrderId
     *     The marketPlaceOrderId
     */
    @JsonProperty("marketPlaceOrderId")
    public void setMarketPlaceOrderId(String marketPlaceOrderId) {
        this.marketPlaceOrderId = marketPlaceOrderId;
    }

    /**
     * 
     * @return
     *     The sequence
     */
    @JsonProperty("sequence")
    public String getSequence() {
        return sequence;
    }

    /**
     * 
     * @param sequence
     *     The sequence
     */
    @JsonProperty("sequence")
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    /**
     * 
     * @return
     *     The salesChannel
     */
    @JsonProperty("salesChannel")
    public String getSalesChannel() {
        return salesChannel;
    }

    /**
     * 
     * @param salesChannel
     *     The salesChannel
     */
    @JsonProperty("salesChannel")
    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    /**
     * 
     * @return
     *     The affiliateId
     */
    @JsonProperty("affiliateId")
    public String getAffiliateId() {
        return affiliateId;
    }

    /**
     * 
     * @param affiliateId
     *     The affiliateId
     */
    @JsonProperty("affiliateId")
    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    /**
     * 
     * @return
     *     The origin
     */
    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    /**
     * 
     * @param origin
     *     The origin
     */
    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * 
     * @return
     *     The workflowInErrorState
     */
    @JsonProperty("workflowInErrorState")
    public Boolean getWorkflowInErrorState() {
        return workflowInErrorState;
    }

    /**
     * 
     * @param workflowInErrorState
     *     The workflowInErrorState
     */
    @JsonProperty("workflowInErrorState")
    public void setWorkflowInErrorState(Boolean workflowInErrorState) {
        this.workflowInErrorState = workflowInErrorState;
    }

    /**
     * 
     * @return
     *     The workflowInRetry
     */
    @JsonProperty("workflowInRetry")
    public Boolean getWorkflowInRetry() {
        return workflowInRetry;
    }

    /**
     * 
     * @param workflowInRetry
     *     The workflowInRetry
     */
    @JsonProperty("workflowInRetry")
    public void setWorkflowInRetry(Boolean workflowInRetry) {
        this.workflowInRetry = workflowInRetry;
    }

    /**
     * 
     * @return
     *     The lastMessageUnread
     */
    @JsonProperty("lastMessageUnread")
    public String getLastMessageUnread() {
        return lastMessageUnread;
    }

    /**
     * 
     * @param lastMessageUnread
     *     The lastMessageUnread
     */
    @JsonProperty("lastMessageUnread")
    public void setLastMessageUnread(String lastMessageUnread) {
        this.lastMessageUnread = lastMessageUnread;
    }

    /**
     * 
     * @return
     *     The shippingEstimatedDate
     */
    @JsonProperty("shippingEstimatedDate")
    public String getShippingEstimatedDate() {
        return shippingEstimatedDate;
    }

    /**
     * 
     * @param shippingEstimatedDate
     *     The ShippingEstimatedDate
     */
    @JsonProperty("shippingEstimatedDate")
    public void setShippingEstimatedDate(String shippingEstimatedDate) {
        this.shippingEstimatedDate = shippingEstimatedDate;
    }

    /**
     * 
     * @return
     *     The orderIsComplete
     */
    @JsonProperty("orderIsComplete")
    public Boolean getOrderIsComplete() {
        return orderIsComplete;
    }

    /**
     * 
     * @param orderIsComplete
     *     The orderIsComplete
     */
    @JsonProperty("orderIsComplete")
    public void setOrderIsComplete(Boolean orderIsComplete) {
        this.orderIsComplete = orderIsComplete;
    }

    /**
     * 
     * @return
     *     The listId
     */
    @JsonProperty("listId")
    public Object getListId() {
        return listId;
    }

    /**
     * 
     * @param listId
     *     The listId
     */
    @JsonProperty("listId")
    public void setListId(Object listId) {
        this.listId = listId;
    }

    /**
     * 
     * @return
     *     The listType
     */
    @JsonProperty("listType")
    public Object getListType() {
        return listType;
    }

    /**
     * 
     * @param listType
     *     The listType
     */
    @JsonProperty("listType")
    public void setListType(Object listType) {
        this.listType = listType;
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

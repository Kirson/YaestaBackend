
package com.yaesta.integration.vitex.json.bean;

import java.util.HashMap;
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
    "id",
    "paymentSystem",
    "paymentSystemName",
    "value",
    "installments",
    "referenceValue",
    "cardHolder",
    "cardNumber",
    "firstDigits",
    "lastDigits",
    "cvv2",
    "expireMonth",
    "expireYear",
    "url",
    "giftCardId",
    "giftCardName",
    "giftCardCaption",
    "redemptionCode",
    "group",
    "tid",
    "dueDate",
    "connectorResponses"
})
public class Payment {

    @JsonProperty("id")
    private String id;
    @JsonProperty("paymentSystem")
    private String paymentSystem;
    @JsonProperty("paymentSystemName")
    private String paymentSystemName;
    @JsonProperty("value")
    private Integer value;
    @JsonProperty("installments")
    private Integer installments;
    @JsonProperty("referenceValue")
    private Integer referenceValue;
    @JsonProperty("cardHolder")
    private Object cardHolder;
    @JsonProperty("cardNumber")
    private Object cardNumber;
    @JsonProperty("firstDigits")
    private Object firstDigits;
    @JsonProperty("lastDigits")
    private Object lastDigits;
    @JsonProperty("cvv2")
    private Object cvv2;
    @JsonProperty("expireMonth")
    private Object expireMonth;
    @JsonProperty("expireYear")
    private Object expireYear;
    @JsonProperty("url")
    private Object url;
    @JsonProperty("giftCardId")
    private Object giftCardId;
    @JsonProperty("giftCardName")
    private Object giftCardName;
    @JsonProperty("giftCardCaption")
    private Object giftCardCaption;
    @JsonProperty("redemptionCode")
    private Object redemptionCode;
    @JsonProperty("group")
    private String group;
    @JsonProperty("tid")
    private Object tid;
    @JsonProperty("dueDate")
    private Object dueDate;
    @JsonProperty("connectorResponses")
    private ConnectorResponses connectorResponses;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The paymentSystem
     */
    @JsonProperty("paymentSystem")
    public String getPaymentSystem() {
        return paymentSystem;
    }

    /**
     * 
     * @param paymentSystem
     *     The paymentSystem
     */
    @JsonProperty("paymentSystem")
    public void setPaymentSystem(String paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    /**
     * 
     * @return
     *     The paymentSystemName
     */
    @JsonProperty("paymentSystemName")
    public String getPaymentSystemName() {
        return paymentSystemName;
    }

    /**
     * 
     * @param paymentSystemName
     *     The paymentSystemName
     */
    @JsonProperty("paymentSystemName")
    public void setPaymentSystemName(String paymentSystemName) {
        this.paymentSystemName = paymentSystemName;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    @JsonProperty("value")
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The installments
     */
    @JsonProperty("installments")
    public Integer getInstallments() {
        return installments;
    }

    /**
     * 
     * @param installments
     *     The installments
     */
    @JsonProperty("installments")
    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    /**
     * 
     * @return
     *     The referenceValue
     */
    @JsonProperty("referenceValue")
    public Integer getReferenceValue() {
        return referenceValue;
    }

    /**
     * 
     * @param referenceValue
     *     The referenceValue
     */
    @JsonProperty("referenceValue")
    public void setReferenceValue(Integer referenceValue) {
        this.referenceValue = referenceValue;
    }

    /**
     * 
     * @return
     *     The cardHolder
     */
    @JsonProperty("cardHolder")
    public Object getCardHolder() {
        return cardHolder;
    }

    /**
     * 
     * @param cardHolder
     *     The cardHolder
     */
    @JsonProperty("cardHolder")
    public void setCardHolder(Object cardHolder) {
        this.cardHolder = cardHolder;
    }

    /**
     * 
     * @return
     *     The cardNumber
     */
    @JsonProperty("cardNumber")
    public Object getCardNumber() {
        return cardNumber;
    }

    /**
     * 
     * @param cardNumber
     *     The cardNumber
     */
    @JsonProperty("cardNumber")
    public void setCardNumber(Object cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * 
     * @return
     *     The firstDigits
     */
    @JsonProperty("firstDigits")
    public Object getFirstDigits() {
        return firstDigits;
    }

    /**
     * 
     * @param firstDigits
     *     The firstDigits
     */
    @JsonProperty("firstDigits")
    public void setFirstDigits(Object firstDigits) {
        this.firstDigits = firstDigits;
    }

    /**
     * 
     * @return
     *     The lastDigits
     */
    @JsonProperty("lastDigits")
    public Object getLastDigits() {
        return lastDigits;
    }

    /**
     * 
     * @param lastDigits
     *     The lastDigits
     */
    @JsonProperty("lastDigits")
    public void setLastDigits(Object lastDigits) {
        this.lastDigits = lastDigits;
    }

    /**
     * 
     * @return
     *     The cvv2
     */
    @JsonProperty("cvv2")
    public Object getCvv2() {
        return cvv2;
    }

    /**
     * 
     * @param cvv2
     *     The cvv2
     */
    @JsonProperty("cvv2")
    public void setCvv2(Object cvv2) {
        this.cvv2 = cvv2;
    }

    /**
     * 
     * @return
     *     The expireMonth
     */
    @JsonProperty("expireMonth")
    public Object getExpireMonth() {
        return expireMonth;
    }

    /**
     * 
     * @param expireMonth
     *     The expireMonth
     */
    @JsonProperty("expireMonth")
    public void setExpireMonth(Object expireMonth) {
        this.expireMonth = expireMonth;
    }

    /**
     * 
     * @return
     *     The expireYear
     */
    @JsonProperty("expireYear")
    public Object getExpireYear() {
        return expireYear;
    }

    /**
     * 
     * @param expireYear
     *     The expireYear
     */
    @JsonProperty("expireYear")
    public void setExpireYear(Object expireYear) {
        this.expireYear = expireYear;
    }

    /**
     * 
     * @return
     *     The url
     */
    @JsonProperty("url")
    public Object getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(Object url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The giftCardId
     */
    @JsonProperty("giftCardId")
    public Object getGiftCardId() {
        return giftCardId;
    }

    /**
     * 
     * @param giftCardId
     *     The giftCardId
     */
    @JsonProperty("giftCardId")
    public void setGiftCardId(Object giftCardId) {
        this.giftCardId = giftCardId;
    }

    /**
     * 
     * @return
     *     The giftCardName
     */
    @JsonProperty("giftCardName")
    public Object getGiftCardName() {
        return giftCardName;
    }

    /**
     * 
     * @param giftCardName
     *     The giftCardName
     */
    @JsonProperty("giftCardName")
    public void setGiftCardName(Object giftCardName) {
        this.giftCardName = giftCardName;
    }

    /**
     * 
     * @return
     *     The giftCardCaption
     */
    @JsonProperty("giftCardCaption")
    public Object getGiftCardCaption() {
        return giftCardCaption;
    }

    /**
     * 
     * @param giftCardCaption
     *     The giftCardCaption
     */
    @JsonProperty("giftCardCaption")
    public void setGiftCardCaption(Object giftCardCaption) {
        this.giftCardCaption = giftCardCaption;
    }

    /**
     * 
     * @return
     *     The redemptionCode
     */
    @JsonProperty("redemptionCode")
    public Object getRedemptionCode() {
        return redemptionCode;
    }

    /**
     * 
     * @param redemptionCode
     *     The redemptionCode
     */
    @JsonProperty("redemptionCode")
    public void setRedemptionCode(Object redemptionCode) {
        this.redemptionCode = redemptionCode;
    }

    /**
     * 
     * @return
     *     The group
     */
    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    /**
     * 
     * @param group
     *     The group
     */
    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 
     * @return
     *     The tid
     */
    @JsonProperty("tid")
    public Object getTid() {
        return tid;
    }

    /**
     * 
     * @param tid
     *     The tid
     */
    @JsonProperty("tid")
    public void setTid(Object tid) {
        this.tid = tid;
    }

    /**
     * 
     * @return
     *     The dueDate
     */
    @JsonProperty("dueDate")
    public Object getDueDate() {
        return dueDate;
    }

    /**
     * 
     * @param dueDate
     *     The dueDate
     */
    @JsonProperty("dueDate")
    public void setDueDate(Object dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * 
     * @return
     *     The connectorResponses
     */
    @JsonProperty("connectorResponses")
    public ConnectorResponses getConnectorResponses() {
        return connectorResponses;
    }

    /**
     * 
     * @param connectorResponses
     *     The connectorResponses
     */
    @JsonProperty("connectorResponses")
    public void setConnectorResponses(ConnectorResponses connectorResponses) {
        this.connectorResponses = connectorResponses;
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

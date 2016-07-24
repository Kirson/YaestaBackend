
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
    "isActive",
    "transactionId",
    "payments"
})
public class Transaction {

    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("payments")
    private List<Payment> payments = new ArrayList<Payment>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The isActive
     */
    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * 
     * @param isActive
     *     The isActive
     */
    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * 
     * @return
     *     The transactionId
     */
    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 
     * @param transactionId
     *     The transactionId
     */
    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 
     * @return
     *     The payments
     */
    @JsonProperty("payments")
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     * 
     * @param payments
     *     The payments
     */
    @JsonProperty("payments")
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
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

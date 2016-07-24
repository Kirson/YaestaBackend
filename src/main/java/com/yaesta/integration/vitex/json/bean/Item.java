
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
    "seller",
    "quantity",
    "description",
    "ean",
    "refId"
})
public class Item {

    @JsonProperty("seller")
    private String seller;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("description")
    private String description;
    @JsonProperty("ean")
    private Object ean;
    @JsonProperty("refId")
    private String refId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The ean
     */
    @JsonProperty("ean")
    public Object getEan() {
        return ean;
    }

    /**
     * 
     * @param ean
     *     The ean
     */
    @JsonProperty("ean")
    public void setEan(Object ean) {
        this.ean = ean;
    }

    /**
     * 
     * @return
     *     The refId
     */
    @JsonProperty("refId")
    public String getRefId() {
        return refId;
    }

    /**
     * 
     * @param refId
     *     The refId
     */
    @JsonProperty("refId")
    public void setRefId(String refId) {
        this.refId = refId;
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

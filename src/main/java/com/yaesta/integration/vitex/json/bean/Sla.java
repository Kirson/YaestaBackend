
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
    "name",
    "shippingEstimate",
    "deliveryWindow",
    "price"
})
public class Sla {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("shippingEstimate")
    private String shippingEstimate;
    @JsonProperty("deliveryWindow")
    private Object deliveryWindow;
    @JsonProperty("price")
    private Integer price;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

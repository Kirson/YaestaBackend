
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
    "cubicweight",
    "height",
    "length",
    "weight",
    "width"
})
public class Dimension {

    @JsonProperty("cubicweight")
    private Double cubicweight;
    @JsonProperty("height")
    private Double height;
    @JsonProperty("length")
    private Double length;
    @JsonProperty("weight")
    private Double weight;
    @JsonProperty("width")
    private Double width;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The cubicweight
     */
    @JsonProperty("cubicweight")
    public Double getCubicweight() {
        return cubicweight;
    }

    /**
     * 
     * @param cubicweight
     *     The cubicweight
     */
    @JsonProperty("cubicweight")
    public void setCubicweight(Double cubicweight) {
        this.cubicweight = cubicweight;
    }

    /**
     * 
     * @return
     *     The height
     */
    @JsonProperty("height")
    public Double getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    @JsonProperty("height")
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The length
     */
    @JsonProperty("length")
    public Double getLength() {
        return length;
    }

    /**
     * 
     * @param length
     *     The length
     */
    @JsonProperty("length")
    public void setLength(Double length) {
        this.length = length;
    }

    /**
     * 
     * @return
     *     The weight
     */
    @JsonProperty("weight")
    public Double getWeight() {
        return weight;
    }

    /**
     * 
     * @param weight
     *     The weight
     */
    @JsonProperty("weight")
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 
     * @return
     *     The width
     */
    @JsonProperty("width")
    public Double getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    @JsonProperty("width")
    public void setWidth(Double width) {
        this.width = width;
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

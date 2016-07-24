
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
    "brandName",
    "brandId",
    "categoriesIds",
    "productClusterId",
    "commercialConditionId",
    "dimension",
    "offeringInfo",
    "offeringType",
    "offeringTypeId"
})
public class AdditionalInfo {

    @JsonProperty("brandName")
    private String brandName;
    @JsonProperty("brandId")
    private String brandId;
    @JsonProperty("categoriesIds")
    private String categoriesIds;
    @JsonProperty("productClusterId")
    private String productClusterId;
    @JsonProperty("commercialConditionId")
    private String commercialConditionId;
    @JsonProperty("dimension")
    private Dimension dimension;
    @JsonProperty("offeringInfo")
    private Object offeringInfo;
    @JsonProperty("offeringType")
    private Object offeringType;
    @JsonProperty("offeringTypeId")
    private Object offeringTypeId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The brandName
     */
    @JsonProperty("brandName")
    public String getBrandName() {
        return brandName;
    }

    /**
     * 
     * @param brandName
     *     The brandName
     */
    @JsonProperty("brandName")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 
     * @return
     *     The brandId
     */
    @JsonProperty("brandId")
    public String getBrandId() {
        return brandId;
    }

    /**
     * 
     * @param brandId
     *     The brandId
     */
    @JsonProperty("brandId")
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    /**
     * 
     * @return
     *     The categoriesIds
     */
    @JsonProperty("categoriesIds")
    public String getCategoriesIds() {
        return categoriesIds;
    }

    /**
     * 
     * @param categoriesIds
     *     The categoriesIds
     */
    @JsonProperty("categoriesIds")
    public void setCategoriesIds(String categoriesIds) {
        this.categoriesIds = categoriesIds;
    }

    /**
     * 
     * @return
     *     The productClusterId
     */
    @JsonProperty("productClusterId")
    public String getProductClusterId() {
        return productClusterId;
    }

    /**
     * 
     * @param productClusterId
     *     The productClusterId
     */
    @JsonProperty("productClusterId")
    public void setProductClusterId(String productClusterId) {
        this.productClusterId = productClusterId;
    }

    /**
     * 
     * @return
     *     The commercialConditionId
     */
    @JsonProperty("commercialConditionId")
    public String getCommercialConditionId() {
        return commercialConditionId;
    }

    /**
     * 
     * @param commercialConditionId
     *     The commercialConditionId
     */
    @JsonProperty("commercialConditionId")
    public void setCommercialConditionId(String commercialConditionId) {
        this.commercialConditionId = commercialConditionId;
    }

    /**
     * 
     * @return
     *     The dimension
     */
    @JsonProperty("dimension")
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * 
     * @param dimension
     *     The dimension
     */
    @JsonProperty("dimension")
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    /**
     * 
     * @return
     *     The offeringInfo
     */
    @JsonProperty("offeringInfo")
    public Object getOfferingInfo() {
        return offeringInfo;
    }

    /**
     * 
     * @param offeringInfo
     *     The offeringInfo
     */
    @JsonProperty("offeringInfo")
    public void setOfferingInfo(Object offeringInfo) {
        this.offeringInfo = offeringInfo;
    }

    /**
     * 
     * @return
     *     The offeringType
     */
    @JsonProperty("offeringType")
    public Object getOfferingType() {
        return offeringType;
    }

    /**
     * 
     * @param offeringType
     *     The offeringType
     */
    @JsonProperty("offeringType")
    public void setOfferingType(Object offeringType) {
        this.offeringType = offeringType;
    }

    /**
     * 
     * @return
     *     The offeringTypeId
     */
    @JsonProperty("offeringTypeId")
    public Object getOfferingTypeId() {
        return offeringTypeId;
    }

    /**
     * 
     * @param offeringTypeId
     *     The offeringTypeId
     */
    @JsonProperty("offeringTypeId")
    public void setOfferingTypeId(Object offeringTypeId) {
        this.offeringTypeId = offeringTypeId;
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

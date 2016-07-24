
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
    "Marketplace"
})
public class Origin_ {

    @JsonProperty("Marketplace")
    private Marketplace_ marketplace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The marketplace
     */
    @JsonProperty("Marketplace")
    public Marketplace_ getMarketplace() {
        return marketplace;
    }

    /**
     * 
     * @param marketplace
     *     The Marketplace
     */
    @JsonProperty("Marketplace")
    public void setMarketplace(Marketplace_ marketplace) {
        this.marketplace = marketplace;
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


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
    "id",
    "rateAndBenefitsIdentifiers"
})
public class RatesAndBenefitsData {

    @JsonProperty("id")
    private String id;
    @JsonProperty("rateAndBenefitsIdentifiers")
    private List<Object> rateAndBenefitsIdentifiers = new ArrayList<Object>();
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
     *     The rateAndBenefitsIdentifiers
     */
    @JsonProperty("rateAndBenefitsIdentifiers")
    public List<Object> getRateAndBenefitsIdentifiers() {
        return rateAndBenefitsIdentifiers;
    }

    /**
     * 
     * @param rateAndBenefitsIdentifiers
     *     The rateAndBenefitsIdentifiers
     */
    @JsonProperty("rateAndBenefitsIdentifiers")
    public void setRateAndBenefitsIdentifiers(List<Object> rateAndBenefitsIdentifiers) {
        this.rateAndBenefitsIdentifiers = rateAndBenefitsIdentifiers;
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

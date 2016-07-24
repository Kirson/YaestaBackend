
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
    "address",
    "logisticsInfo"
})
public class ShippingData {

    @JsonProperty("id")
    private String id;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("logisticsInfo")
    private List<LogisticsInfo> logisticsInfo = new ArrayList<LogisticsInfo>();
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
     *     The address
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The logisticsInfo
     */
    @JsonProperty("logisticsInfo")
    public List<LogisticsInfo> getLogisticsInfo() {
        return logisticsInfo;
    }

    /**
     * 
     * @param logisticsInfo
     *     The logisticsInfo
     */
    @JsonProperty("logisticsInfo")
    public void setLogisticsInfo(List<LogisticsInfo> logisticsInfo) {
        this.logisticsInfo = logisticsInfo;
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

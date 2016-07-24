
package com.yaesta.integration.vitex.json.bean;

import java.util.ArrayList;
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
    "list",
    "facets",
    "paging",
    "stats"
})
public class OrderSchema {

    @JsonProperty("list")
    private java.util.List<OrderBean> list = new ArrayList<OrderBean>();
    @JsonProperty("facets")
    private java.util.List<Facet> facets = new ArrayList<Facet>();
    @JsonProperty("paging")
    private Paging paging;
    @JsonProperty("stats")
    private Stats stats;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The list
     */
    @JsonProperty("list")
    public java.util.List<com.yaesta.integration.vitex.json.bean.OrderBean> getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The list
     */
    @JsonProperty("list")
    public void setList(java.util.List<com.yaesta.integration.vitex.json.bean.OrderBean> list) {
        this.list = list;
    }

    /**
     * 
     * @return
     *     The facets
     */
    @JsonProperty("facets")
    public java.util.List<Facet> getFacets() {
        return facets;
    }

    /**
     * 
     * @param facets
     *     The facets
     */
    @JsonProperty("facets")
    public void setFacets(java.util.List<Facet> facets) {
        this.facets = facets;
    }

    /**
     * 
     * @return
     *     The paging
     */
    @JsonProperty("paging")
    public Paging getPaging() {
        return paging;
    }

    /**
     * 
     * @param paging
     *     The paging
     */
    @JsonProperty("paging")
    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    /**
     * 
     * @return
     *     The stats
     */
    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    /**
     * 
     * @param stats
     *     The stats
     */
    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
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

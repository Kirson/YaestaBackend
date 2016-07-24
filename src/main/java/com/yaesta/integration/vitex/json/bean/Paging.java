
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
    "total",
    "pages",
    "currentPage",
    "perPage"
})
public class Paging {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("pages")
    private Integer pages;
    @JsonProperty("currentPage")
    private Integer currentPage;
    @JsonProperty("perPage")
    private Integer perPage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The total
     */
    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The pages
     */
    @JsonProperty("pages")
    public Integer getPages() {
        return pages;
    }

    /**
     * 
     * @param pages
     *     The pages
     */
    @JsonProperty("pages")
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     * 
     * @return
     *     The currentPage
     */
    @JsonProperty("currentPage")
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * 
     * @param currentPage
     *     The currentPage
     */
    @JsonProperty("currentPage")
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 
     * @return
     *     The perPage
     */
    @JsonProperty("perPage")
    public Integer getPerPage() {
        return perPage;
    }

    /**
     * 
     * @param perPage
     *     The perPage
     */
    @JsonProperty("perPage")
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
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

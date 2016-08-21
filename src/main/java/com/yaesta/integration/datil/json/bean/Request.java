
package com.yaesta.integration.datil.json.bean;

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
    "body-params",
    "query-params",
    "path-params"
})
public class Request {

    @JsonProperty("body-params")
    private BodyParams bodyParams;
    @JsonProperty("query-params")
    private QueryParams queryParams;
    @JsonProperty("path-params")
    private PathParams pathParams;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The bodyParams
     */
    @JsonProperty("body-params")
    public BodyParams getBodyParams() {
        return bodyParams;
    }

    /**
     * 
     * @param bodyParams
     *     The body-params
     */
    @JsonProperty("body-params")
    public void setBodyParams(BodyParams bodyParams) {
        this.bodyParams = bodyParams;
    }

    /**
     * 
     * @return
     *     The queryParams
     */
    @JsonProperty("query-params")
    public QueryParams getQueryParams() {
        return queryParams;
    }

    /**
     * 
     * @param queryParams
     *     The query-params
     */
    @JsonProperty("query-params")
    public void setQueryParams(QueryParams queryParams) {
        this.queryParams = queryParams;
    }

    /**
     * 
     * @return
     *     The pathParams
     */
    @JsonProperty("path-params")
    public PathParams getPathParams() {
        return pathParams;
    }

    /**
     * 
     * @param pathParams
     *     The path-params
     */
    @JsonProperty("path-params")
    public void setPathParams(PathParams pathParams) {
        this.pathParams = pathParams;
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

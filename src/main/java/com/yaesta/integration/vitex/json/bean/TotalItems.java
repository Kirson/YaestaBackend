
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
    "Count",
    "Max",
    "Mean",
    "Min",
    "Missing",
    "StdDev",
    "Sum",
    "SumOfSquares",
    "Facets"
})
public class TotalItems {

    @JsonProperty("Count")
    private Integer count;
    @JsonProperty("Max")
    private Integer max;
    @JsonProperty("Mean")
    private Integer mean;
    @JsonProperty("Min")
    private Integer min;
    @JsonProperty("Missing")
    private Integer missing;
    @JsonProperty("StdDev")
    private Integer stdDev;
    @JsonProperty("Sum")
    private Integer sum;
    @JsonProperty("SumOfSquares")
    private Integer sumOfSquares;
    @JsonProperty("Facets")
    private Facets_ facets;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The count
     */
    @JsonProperty("Count")
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The Count
     */
    @JsonProperty("Count")
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The max
     */
    @JsonProperty("Max")
    public Integer getMax() {
        return max;
    }

    /**
     * 
     * @param max
     *     The Max
     */
    @JsonProperty("Max")
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     * 
     * @return
     *     The mean
     */
    @JsonProperty("Mean")
    public Integer getMean() {
        return mean;
    }

    /**
     * 
     * @param mean
     *     The Mean
     */
    @JsonProperty("Mean")
    public void setMean(Integer mean) {
        this.mean = mean;
    }

    /**
     * 
     * @return
     *     The min
     */
    @JsonProperty("Min")
    public Integer getMin() {
        return min;
    }

    /**
     * 
     * @param min
     *     The Min
     */
    @JsonProperty("Min")
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     * 
     * @return
     *     The missing
     */
    @JsonProperty("Missing")
    public Integer getMissing() {
        return missing;
    }

    /**
     * 
     * @param missing
     *     The Missing
     */
    @JsonProperty("Missing")
    public void setMissing(Integer missing) {
        this.missing = missing;
    }

    /**
     * 
     * @return
     *     The stdDev
     */
    @JsonProperty("StdDev")
    public Integer getStdDev() {
        return stdDev;
    }

    /**
     * 
     * @param stdDev
     *     The StdDev
     */
    @JsonProperty("StdDev")
    public void setStdDev(Integer stdDev) {
        this.stdDev = stdDev;
    }

    /**
     * 
     * @return
     *     The sum
     */
    @JsonProperty("Sum")
    public Integer getSum() {
        return sum;
    }

    /**
     * 
     * @param sum
     *     The Sum
     */
    @JsonProperty("Sum")
    public void setSum(Integer sum) {
        this.sum = sum;
    }

    /**
     * 
     * @return
     *     The sumOfSquares
     */
    @JsonProperty("SumOfSquares")
    public Integer getSumOfSquares() {
        return sumOfSquares;
    }

    /**
     * 
     * @param sumOfSquares
     *     The SumOfSquares
     */
    @JsonProperty("SumOfSquares")
    public void setSumOfSquares(Integer sumOfSquares) {
        this.sumOfSquares = sumOfSquares;
    }

    /**
     * 
     * @return
     *     The facets
     */
    @JsonProperty("Facets")
    public Facets_ getFacets() {
        return facets;
    }

    /**
     * 
     * @param facets
     *     The Facets
     */
    @JsonProperty("Facets")
    public void setFacets(Facets_ facets) {
        this.facets = facets;
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

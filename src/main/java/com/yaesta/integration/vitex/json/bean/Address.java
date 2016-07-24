
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
    "addressType",
    "receiverName",
    "addressId",
    "postalCode",
    "city",
    "state",
    "country",
    "street",
    "number",
    "neighborhood",
    "complement",
    "reference"
})
public class Address {

    @JsonProperty("addressType")
    private String addressType;
    @JsonProperty("receiverName")
    private String receiverName;
    @JsonProperty("addressId")
    private String addressId;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    private String country;
    @JsonProperty("street")
    private String street;
    @JsonProperty("number")
    private String number;
    @JsonProperty("neighborhood")
    private Object neighborhood;
    @JsonProperty("complement")
    private Object complement;
    @JsonProperty("reference")
    private Object reference;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The addressType
     */
    @JsonProperty("addressType")
    public String getAddressType() {
        return addressType;
    }

    /**
     * 
     * @param addressType
     *     The addressType
     */
    @JsonProperty("addressType")
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * 
     * @return
     *     The receiverName
     */
    @JsonProperty("receiverName")
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 
     * @param receiverName
     *     The receiverName
     */
    @JsonProperty("receiverName")
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 
     * @return
     *     The addressId
     */
    @JsonProperty("addressId")
    public String getAddressId() {
        return addressId;
    }

    /**
     * 
     * @param addressId
     *     The addressId
     */
    @JsonProperty("addressId")
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    /**
     * 
     * @return
     *     The postalCode
     */
    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 
     * @param postalCode
     *     The postalCode
     */
    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 
     * @return
     *     The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The state
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The country
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The street
     */
    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    /**
     * 
     * @param street
     *     The street
     */
    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * 
     * @return
     *     The number
     */
    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    /**
     * 
     * @param number
     *     The number
     */
    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 
     * @return
     *     The neighborhood
     */
    @JsonProperty("neighborhood")
    public Object getNeighborhood() {
        return neighborhood;
    }

    /**
     * 
     * @param neighborhood
     *     The neighborhood
     */
    @JsonProperty("neighborhood")
    public void setNeighborhood(Object neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * 
     * @return
     *     The complement
     */
    @JsonProperty("complement")
    public Object getComplement() {
        return complement;
    }

    /**
     * 
     * @param complement
     *     The complement
     */
    @JsonProperty("complement")
    public void setComplement(Object complement) {
        this.complement = complement;
    }

    /**
     * 
     * @return
     *     The reference
     */
    @JsonProperty("reference")
    public Object getReference() {
        return reference;
    }

    /**
     * 
     * @param reference
     *     The reference
     */
    @JsonProperty("reference")
    public void setReference(Object reference) {
        this.reference = reference;
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

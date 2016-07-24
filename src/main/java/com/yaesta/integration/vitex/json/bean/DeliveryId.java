
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
    "courierId",
    "courierName",
    "dockId",
    "quantity",
    "warehouseId"
})
public class DeliveryId {

    @JsonProperty("courierId")
    private String courierId;
    @JsonProperty("courierName")
    private String courierName;
    @JsonProperty("dockId")
    private String dockId;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("warehouseId")
    private String warehouseId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The courierId
     */
    @JsonProperty("courierId")
    public String getCourierId() {
        return courierId;
    }

    /**
     * 
     * @param courierId
     *     The courierId
     */
    @JsonProperty("courierId")
    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    /**
     * 
     * @return
     *     The courierName
     */
    @JsonProperty("courierName")
    public String getCourierName() {
        return courierName;
    }

    /**
     * 
     * @param courierName
     *     The courierName
     */
    @JsonProperty("courierName")
    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    /**
     * 
     * @return
     *     The dockId
     */
    @JsonProperty("dockId")
    public String getDockId() {
        return dockId;
    }

    /**
     * 
     * @param dockId
     *     The dockId
     */
    @JsonProperty("dockId")
    public void setDockId(String dockId) {
        this.dockId = dockId;
    }

    /**
     * 
     * @return
     *     The quantity
     */
    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 
     * @param quantity
     *     The quantity
     */
    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 
     * @return
     *     The warehouseId
     */
    @JsonProperty("warehouseId")
    public String getWarehouseId() {
        return warehouseId;
    }

    /**
     * 
     * @param warehouseId
     *     The warehouseId
     */
    @JsonProperty("warehouseId")
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
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

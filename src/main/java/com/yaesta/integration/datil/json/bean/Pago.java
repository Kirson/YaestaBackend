
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "medio",
    "total",
    "propiedades"
})
public class Pago {

    @JsonProperty("medio")
    private String medio;
    @JsonProperty("total")
    private Double total;
    @JsonProperty("propiedades")
    private Propiedades propiedades;
    
    /**
     * 
     * @return
     *     The medio
     */
    @JsonProperty("medio")
    public String getMedio() {
        return medio;
    }

    /**
     * 
     * @param medio
     *     The medio
     */
    @JsonProperty("medio")
    public void setMedio(String medio) {
        this.medio = medio;
    }

    /**
     * 
     * @return
     *     The total
     */
    @JsonProperty("total")
    public Double getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    @JsonProperty("total")
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The propiedades
     */
    @JsonProperty("propiedades")
    public Propiedades getPropiedades() {
        return propiedades;
    }

    /**
     * 
     * @param propiedades
     *     The propiedades
     */
    @JsonProperty("propiedades")
    public void setPropiedades(Propiedades propiedades) {
        this.propiedades = propiedades;
    }

   

}

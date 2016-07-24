
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "Peso"
})
public class DetallesAdicionales {

    @JsonProperty("Peso")
    private String peso;
    

    /**
     * 
     * @return
     *     The peso
     */
    @JsonProperty("Peso")
    public String getPeso() {
        return peso;
    }

    /**
     * 
     * @param peso
     *     The Peso
     */
    @JsonProperty("Peso")
    public void setPeso(String peso) {
        this.peso = peso;
    }

    
}

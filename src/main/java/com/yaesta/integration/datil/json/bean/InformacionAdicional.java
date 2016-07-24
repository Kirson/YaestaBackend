
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "Tiempo de entrega"
})
public class InformacionAdicional {

    @JsonProperty("Tiempo de entrega")
    private String tiempoDeEntrega;
    
    /**
     * 
     * @return
     *     The tiempoDeEntrega
     */
    @JsonProperty("Tiempo de entrega")
    public String getTiempoDeEntrega() {
        return tiempoDeEntrega;
    }

    /**
     * 
     * @param tiempoDeEntrega
     *     The Tiempo de entrega
     */
    @JsonProperty("Tiempo de entrega")
    public void setTiempoDeEntrega(String tiempoDeEntrega) {
        this.tiempoDeEntrega = tiempoDeEntrega;
    }

   

}

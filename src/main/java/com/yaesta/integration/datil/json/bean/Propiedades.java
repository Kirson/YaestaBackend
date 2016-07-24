
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "plazo",
    "unidad_tiempo"
})
public class Propiedades {

    @JsonProperty("plazo")
    private Integer plazo;
    @JsonProperty("unidad_tiempo")
    private String unidadTiempo;
    
    /**
     * 
     * @return
     *     The plazo
     */
    @JsonProperty("plazo")
    public Integer getPlazo() {
        return plazo;
    }

    /**
     * 
     * @param plazo
     *     The plazo
     */
    @JsonProperty("plazo")
    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    /**
     * 
     * @return
     *     The unidadTiempo
     */
    @JsonProperty("unidad_tiempo")
    public String getUnidadTiempo() {
        return unidadTiempo;
    }

    /**
     * 
     * @param unidadTiempo
     *     The unidad_tiempo
     */
    @JsonProperty("unidad_tiempo")
    public void setUnidadTiempo(String unidadTiempo) {
        this.unidadTiempo = unidadTiempo;
    }


}

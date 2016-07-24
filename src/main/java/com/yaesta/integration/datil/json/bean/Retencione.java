
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "codigo",
    "codigo_porcentaje"
})
public class Retencione {

    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("codigo_porcentaje")
    private String codigoPorcentaje;
    
    /**
     * 
     * @return
     *     The codigo
     */
    @JsonProperty("codigo")
    public String getCodigo() {
        return codigo;
    }

    /**
     * 
     * @param codigo
     *     The codigo
     */
    @JsonProperty("codigo")
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * 
     * @return
     *     The codigoPorcentaje
     */
    @JsonProperty("codigo_porcentaje")
    public String getCodigoPorcentaje() {
        return codigoPorcentaje;
    }

    /**
     * 
     * @param codigoPorcentaje
     *     The codigo_porcentaje
     */
    @JsonProperty("codigo_porcentaje")
    public void setCodigoPorcentaje(String codigoPorcentaje) {
        this.codigoPorcentaje = codigoPorcentaje;
    }

   
}

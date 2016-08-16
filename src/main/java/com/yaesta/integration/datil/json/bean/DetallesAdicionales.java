
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "Peso",
    "numero",
    "serie"
})
public class DetallesAdicionales {

    @JsonProperty("Peso")
    private String peso;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("serie")
    private String serie;
    

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
    
    /**
     * 
     * @return
     *     The numero
     */
    @JsonProperty("numero")
    public String getNumero() {
        return numero;
    }

    /**
     * 
     * @param numero
     *     The numero
     */
    @JsonProperty("numero")
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * 
     * @return
     *     The serie
     */
    @JsonProperty("serie")
    public String getSerie() {
        return serie;
    }

    /**
     * 
     * @param serie
     *     The serie
     */
    @JsonProperty("serie")
    public void setSerie(String serie) {
        this.serie = serie;
    }

    
}

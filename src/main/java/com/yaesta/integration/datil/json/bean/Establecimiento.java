
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "codigo",
    "direccion",
    "punto_emision"
})
public class Establecimiento {

    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("punto_emision")
    private String puntoEmision;
    

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
     *     The direccion
     */
    @JsonProperty("direccion")
    public String getDireccion() {
        return direccion;
    }

    /**
     * 
     * @param direccion
     *     The direccion
     */
    @JsonProperty("direccion")
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * 
     * @return
     *     The puntoEmision
     */
    @JsonProperty("punto_emision")
    public String getPuntoEmision() {
        return puntoEmision;
    }

    /**
     * 
     * @param puntoEmision
     *     The punto_emision
     */
    @JsonProperty("punto_emision")
    public void setPuntoEmision(String puntoEmision) {
        this.puntoEmision = puntoEmision;
    }

    

}

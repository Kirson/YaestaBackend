
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "cantidad",
    "codigo_principal",
    "codigo_auxiliar",
    "precio_unitario",
    "descripcion",
    "detalles_adicionales"
 
})
public class ItemGuiaRemision {

    @JsonProperty("cantidad")
    private Double cantidad;
    @JsonProperty("codigo_principal")
    private String codigoPrincipal;
    @JsonProperty("codigo_auxiliar")
    private String codigoAuxiliar;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("detalles_adicionales")
    private DetallesAdicionales detallesAdicionales;
    
    /**
     * 
     * @return
     *     The cantidad
     */
    @JsonProperty("cantidad")
    public Double getCantidad() {
        return cantidad;
    }

    /**
     * 
     * @param cantidad
     *     The cantidad
     */
    @JsonProperty("cantidad")
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * 
     * @return
     *     The codigoPrincipal
     */
    @JsonProperty("codigo_principal")
    public String getCodigoPrincipal() {
        return codigoPrincipal;
    }

    /**
     * 
     * @param codigoPrincipal
     *     The codigo_principal
     */
    @JsonProperty("codigo_principal")
    public void setCodigoPrincipal(String codigoPrincipal) {
        this.codigoPrincipal = codigoPrincipal;
    }

    /**
     * 
     * @return
     *     The codigoAuxiliar
     */
    @JsonProperty("codigo_auxiliar")
    public String getCodigoAuxiliar() {
        return codigoAuxiliar;
    }

    /**
     * 
     * @param codigoAuxiliar
     *     The codigo_auxiliar
     */
    @JsonProperty("codigo_auxiliar")
    public void setCodigoAuxiliar(String codigoAuxiliar) {
        this.codigoAuxiliar = codigoAuxiliar;
    }

        /**
     * 
     * @return
     *     The descripcion
     */
    @JsonProperty("descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * 
     * @param descripcion
     *     The descripcion
     */
    @JsonProperty("descripcion")
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

        /**
     * 
     * @return
     *     The detallesAdicionales
     */
    @JsonProperty("detalles_adicionales")
    public DetallesAdicionales getDetallesAdicionales() {
        return detallesAdicionales;
    }

    /**
     * 
     * @param detallesAdicionales
     *     The detalles_adicionales
     */
    @JsonProperty("detalles_adicionales")
    public void setDetallesAdicionales(DetallesAdicionales detallesAdicionales) {
        this.detallesAdicionales = detallesAdicionales;
    }

    
}

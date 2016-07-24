
package com.yaesta.integration.datil.json.bean;

import java.util.ArrayList;
import java.util.List;
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
    "precio_total_sin_impuestos",
    "impuestos",
    "detalles_adicionales",
    "descuento"
})
public class Item {

    @JsonProperty("cantidad")
    private Double cantidad;
    @JsonProperty("codigo_principal")
    private String codigoPrincipal;
    @JsonProperty("codigo_auxiliar")
    private String codigoAuxiliar;
    @JsonProperty("precio_unitario")
    private Double precioUnitario;
    @JsonProperty("descripcion")
    private String descripcion;
    @JsonProperty("precio_total_sin_impuestos")
    private Double precioTotalSinImpuestos;
    @JsonProperty("impuestos")
    private List<Impuesto_> impuestos = new ArrayList<Impuesto_>();
    @JsonProperty("detalles_adicionales")
    private DetallesAdicionales detallesAdicionales;
    @JsonProperty("descuento")
    private Double descuento;
    
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
     *     The precioUnitario
     */
    @JsonProperty("precio_unitario")
    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * 
     * @param precioUnitario
     *     The precio_unitario
     */
    @JsonProperty("precio_unitario")
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
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
     *     The precioTotalSinImpuestos
     */
    @JsonProperty("precio_total_sin_impuestos")
    public Double getPrecioTotalSinImpuestos() {
        return precioTotalSinImpuestos;
    }

    /**
     * 
     * @param precioTotalSinImpuestos
     *     The precio_total_sin_impuestos
     */
    @JsonProperty("precio_total_sin_impuestos")
    public void setPrecioTotalSinImpuestos(Double precioTotalSinImpuestos) {
        this.precioTotalSinImpuestos = precioTotalSinImpuestos;
    }

    /**
     * 
     * @return
     *     The impuestos
     */
    @JsonProperty("impuestos")
    public List<Impuesto_> getImpuestos() {
        return impuestos;
    }

    /**
     * 
     * @param impuestos
     *     The impuestos
     */
    @JsonProperty("impuestos")
    public void setImpuestos(List<Impuesto_> impuestos) {
        this.impuestos = impuestos;
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

    /**
     * 
     * @return
     *     The descuento
     */
    @JsonProperty("descuento")
    public Double getDescuento() {
        return descuento;
    }

    /**
     * 
     * @param descuento
     *     The descuento
     */
    @JsonProperty("descuento")
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

   

}

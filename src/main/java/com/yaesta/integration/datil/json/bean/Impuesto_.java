
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "base_imponible",
    "valor",
    "tarifa",
    "codigo",
    "codigo_porcentaje"
})
public class Impuesto_ {

    @JsonProperty("base_imponible")
    private Double baseImponible;
    @JsonProperty("valor")
    private Double valor;
    @JsonProperty("tarifa")
    private Double tarifa;
    @JsonProperty("codigo")
    private String codigo;
    @JsonProperty("codigo_porcentaje")
    private String codigoPorcentaje;
    

    /**
     * 
     * @return
     *     The baseImponible
     */
    @JsonProperty("base_imponible")
    public Double getBaseImponible() {
        return baseImponible;
    }

    /**
     * 
     * @param baseImponible
     *     The base_imponible
     */
    @JsonProperty("base_imponible")
    public void setBaseImponible(Double baseImponible) {
        this.baseImponible = baseImponible;
    }

    /**
     * 
     * @return
     *     The valor
     */
    @JsonProperty("valor")
    public Double getValor() {
        return valor;
    }

    /**
     * 
     * @param valor
     *     The valor
     */
    @JsonProperty("valor")
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * 
     * @return
     *     The tarifa
     */
    @JsonProperty("tarifa")
    public Double getTarifa() {
        return tarifa;
    }

    /**
     * 
     * @param tarifa
     *     The tarifa
     */
    @JsonProperty("tarifa")
    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

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

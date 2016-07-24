
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
    "total_sin_impuestos",
    "impuestos",
    "importe_total",
    "propina",
    "descuento"
})
public class Totales {

    @JsonProperty("total_sin_impuestos")
    private Double totalSinImpuestos;
    @JsonProperty("impuestos")
    private List<Impuesto> impuestos = new ArrayList<Impuesto>();
    @JsonProperty("importe_total")
    private Double importeTotal;
    @JsonProperty("propina")
    private Double propina;
    @JsonProperty("descuento")
    private Double descuento;
   
    /**
     * 
     * @return
     *     The totalSinImpuestos
     */
    @JsonProperty("total_sin_impuestos")
    public Double getTotalSinImpuestos() {
        return totalSinImpuestos;
    }

    /**
     * 
     * @param totalSinImpuestos
     *     The total_sin_impuestos
     */
    @JsonProperty("total_sin_impuestos")
    public void setTotalSinImpuestos(Double totalSinImpuestos) {
        this.totalSinImpuestos = totalSinImpuestos;
    }

    /**
     * 
     * @return
     *     The impuestos
     */
    @JsonProperty("impuestos")
    public List<Impuesto> getImpuestos() {
        return impuestos;
    }

    /**
     * 
     * @param impuestos
     *     The impuestos
     */
    @JsonProperty("impuestos")
    public void setImpuestos(List<Impuesto> impuestos) {
        this.impuestos = impuestos;
    }

    /**
     * 
     * @return
     *     The importeTotal
     */
    @JsonProperty("importe_total")
    public Double getImporteTotal() {
        return importeTotal;
    }

    /**
     * 
     * @param importeTotal
     *     The importe_total
     */
    @JsonProperty("importe_total")
    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    /**
     * 
     * @return
     *     The propina
     */
    @JsonProperty("propina")
    public Double getPropina() {
        return propina;
    }

    /**
     * 
     * @param propina
     *     The propina
     */
    @JsonProperty("propina")
    public void setPropina(Double propina) {
        this.propina = propina;
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

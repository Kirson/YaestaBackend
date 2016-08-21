
package com.yaesta.integration.datil.json.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "secuencial",
    "fecha_emision",
    "emisor",
    "fecha_emision_documento_modificado",
    "moneda",
    "ambiente",
    "totales",
    "comprador",
    "tipo_emision",
    "items",
    "tipo_documento_modificado",
    "numero_documento_modificado",
    "motivo"
})
public class BodyParams {

    @JsonProperty("secuencial")
    private Integer secuencial;
    @JsonProperty("fecha_emision")
    private String fechaEmision;
    @JsonProperty("emisor")
    private Emisor emisor;
    @JsonProperty("fecha_emision_documento_modificado")
    private String fechaEmisionDocumentoModificado;
    @JsonProperty("moneda")
    private String moneda;
    @JsonProperty("ambiente")
    private Integer ambiente;
    @JsonProperty("totales")
    private Totales totales;
    @JsonProperty("comprador")
    private Comprador comprador;
    @JsonProperty("tipo_emision")
    private Integer tipoEmision;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
    @JsonProperty("tipo_documento_modificado")
    private String tipoDocumentoModificado;
    @JsonProperty("numero_documento_modificado")
    private String numeroDocumentoModificado;
    @JsonProperty("motivo")
    private String motivo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The secuencial
     */
    @JsonProperty("secuencial")
    public Integer getSecuencial() {
        return secuencial;
    }

    /**
     * 
     * @param secuencial
     *     The secuencial
     */
    @JsonProperty("secuencial")
    public void setSecuencial(Integer secuencial) {
        this.secuencial = secuencial;
    }

    /**
     * 
     * @return
     *     The fechaEmision
     */
    @JsonProperty("fecha_emision")
    public String getFechaEmision() {
        return fechaEmision;
    }

    /**
     * 
     * @param fechaEmision
     *     The fecha_emision
     */
    @JsonProperty("fecha_emision")
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * 
     * @return
     *     The emisor
     */
    @JsonProperty("emisor")
    public Emisor getEmisor() {
        return emisor;
    }

    /**
     * 
     * @param emisor
     *     The emisor
     */
    @JsonProperty("emisor")
    public void setEmisor(Emisor emisor) {
        this.emisor = emisor;
    }

    /**
     * 
     * @return
     *     The fechaEmisionDocumentoModificado
     */
    @JsonProperty("fecha_emision_documento_modificado")
    public String getFechaEmisionDocumentoModificado() {
        return fechaEmisionDocumentoModificado;
    }

    /**
     * 
     * @param fechaEmisionDocumentoModificado
     *     The fecha_emision_documento_modificado
     */
    @JsonProperty("fecha_emision_documento_modificado")
    public void setFechaEmisionDocumentoModificado(String fechaEmisionDocumentoModificado) {
        this.fechaEmisionDocumentoModificado = fechaEmisionDocumentoModificado;
    }

    /**
     * 
     * @return
     *     The moneda
     */
    @JsonProperty("moneda")
    public String getMoneda() {
        return moneda;
    }

    /**
     * 
     * @param moneda
     *     The moneda
     */
    @JsonProperty("moneda")
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * 
     * @return
     *     The ambiente
     */
    @JsonProperty("ambiente")
    public Integer getAmbiente() {
        return ambiente;
    }

    /**
     * 
     * @param ambiente
     *     The ambiente
     */
    @JsonProperty("ambiente")
    public void setAmbiente(Integer ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * 
     * @return
     *     The totales
     */
    @JsonProperty("totales")
    public Totales getTotales() {
        return totales;
    }

    /**
     * 
     * @param totales
     *     The totales
     */
    @JsonProperty("totales")
    public void setTotales(Totales totales) {
        this.totales = totales;
    }

    /**
     * 
     * @return
     *     The comprador
     */
    @JsonProperty("comprador")
    public Comprador getComprador() {
        return comprador;
    }

    /**
     * 
     * @param comprador
     *     The comprador
     */
    @JsonProperty("comprador")
    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    /**
     * 
     * @return
     *     The tipoEmision
     */
    @JsonProperty("tipo_emision")
    public Integer getTipoEmision() {
        return tipoEmision;
    }

    /**
     * 
     * @param tipoEmision
     *     The tipo_emision
     */
    @JsonProperty("tipo_emision")
    public void setTipoEmision(Integer tipoEmision) {
        this.tipoEmision = tipoEmision;
    }

    /**
     * 
     * @return
     *     The items
     */
    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * 
     * @return
     *     The tipoDocumentoModificado
     */
    @JsonProperty("tipo_documento_modificado")
    public String getTipoDocumentoModificado() {
        return tipoDocumentoModificado;
    }

    /**
     * 
     * @param tipoDocumentoModificado
     *     The tipo_documento_modificado
     */
    @JsonProperty("tipo_documento_modificado")
    public void setTipoDocumentoModificado(String tipoDocumentoModificado) {
        this.tipoDocumentoModificado = tipoDocumentoModificado;
    }

    /**
     * 
     * @return
     *     The numeroDocumentoModificado
     */
    @JsonProperty("numero_documento_modificado")
    public String getNumeroDocumentoModificado() {
        return numeroDocumentoModificado;
    }

    /**
     * 
     * @param numeroDocumentoModificado
     *     The numero_documento_modificado
     */
    @JsonProperty("numero_documento_modificado")
    public void setNumeroDocumentoModificado(String numeroDocumentoModificado) {
        this.numeroDocumentoModificado = numeroDocumentoModificado;
    }

    /**
     * 
     * @return
     *     The motivo
     */
    @JsonProperty("motivo")
    public String getMotivo() {
        return motivo;
    }

    /**
     * 
     * @param motivo
     *     The motivo
     */
    @JsonProperty("motivo")
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

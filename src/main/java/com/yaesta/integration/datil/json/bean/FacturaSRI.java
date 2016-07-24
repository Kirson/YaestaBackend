
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
    "secuencial",
    "emisor",
    "moneda",
    "id",
    "ambiente",
    "totales",
    "comprador",
    "tipo_emision",
    "items",
    "version",
    "retenciones",
    "clave_acceso"
})
public class FacturaSRI {

    @JsonProperty("secuencial")
    private Integer secuencial;
    @JsonProperty("emisor")
    private Emisor emisor;
    @JsonProperty("moneda")
    private String moneda;
    @JsonProperty("id")
    private String id;
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
    @JsonProperty("version")
    private String version;
    @JsonProperty("retenciones")
    private List<Retencione> retenciones = new ArrayList<Retencione>();
    @JsonProperty("clave_acceso")
    private String claveAcceso;
    @JsonProperty("fecha_emision")
    private String fechaEmision;
    

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
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
     *     The version
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The retenciones
     */
    @JsonProperty("retenciones")
    public List<Retencione> getRetenciones() {
        return retenciones;
    }

    /**
     * 
     * @param retenciones
     *     The retenciones
     */
    @JsonProperty("retenciones")
    public void setRetenciones(List<Retencione> retenciones) {
        this.retenciones = retenciones;
    }

    /**
     * 
     * @return
     *     The claveAcceso
     */
    @JsonProperty("clave_acceso")
    public String getClaveAcceso() {
        return claveAcceso;
    }

    /**
     * 
     * @param claveAcceso
     *     The clave_acceso
     */
    @JsonProperty("clave_acceso")
    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    

    @JsonProperty("fecha_emision")
	public String getFechaEmision() {
		return fechaEmision;
	}

    @JsonProperty("fecha_emision")
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
    
    

}

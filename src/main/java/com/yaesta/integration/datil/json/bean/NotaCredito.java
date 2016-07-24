
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
    "ambiente",
    "tipo_emision",
    "secuencial",
    "fecha_emision",
    "emisor",
    "moneda",
    "informacion_adicional",
    "totales",
    "fecha_emision_documento_modificado",
    "numero_documento_modificado",
    "tipo_documento_modificado",
    "motivo",
    "comprador",
    "items"
})
public class NotaCredito {

    @JsonProperty("ambiente")
    private Integer ambiente;
    @JsonProperty("tipo_emision")
    private Integer tipoEmision;
    @JsonProperty("secuencial")
    private Integer secuencial;
    @JsonProperty("fecha_emision")
    private String fechaEmision;
    @JsonProperty("emisor")
    private Emisor emisor;
    @JsonProperty("moneda")
    private String moneda;
    @JsonProperty("informacion_adicional")
    private InformacionAdicional informacionAdicional;
    @JsonProperty("totales")
    private Totales totales;
    @JsonProperty("fecha_emision_documento_modificado")
    private String fechaEmisionDocumentoModificado;
    @JsonProperty("numero_documento_modificado")
    private String numeroDocumentoModificado;
    @JsonProperty("tipo_documento_modificado")
    private String tipoDocumentoModificado;
    @JsonProperty("motivo")
    private String motivo;
    @JsonProperty("comprador")
    private Comprador comprador;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
    
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
     *     The informacionAdicional
     */
    @JsonProperty("informacion_adicional")
    public InformacionAdicional getInformacionAdicional() {
        return informacionAdicional;
    }

    /**
     * 
     * @param informacionAdicional
     *     The informacion_adicional
     */
    @JsonProperty("informacion_adicional")
    public void setInformacionAdicional(InformacionAdicional informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
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

   

}

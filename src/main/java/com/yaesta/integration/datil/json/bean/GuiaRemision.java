
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
    "fecha_inicio_transporte",
    "fecha_fin_transporte",
    "direccion_partida",
    "emisor",
    "informacion_adicional",
    "transportista",
    "destinatarios"
})
public class GuiaRemision {

    @JsonProperty("ambiente")
    private Integer ambiente;
    @JsonProperty("tipo_emision")
    private Integer tipoEmision;
    @JsonProperty("secuencial")
    private Integer secuencial;
    @JsonProperty("fecha_inicio_transporte")
    private String fechaInicioTransporte;
    @JsonProperty("fecha_fin_transporte")
    private String fechaFinTransporte;
    @JsonProperty("direccion_partida")
    private String direccionPartida;
    @JsonProperty("emisor")
    private Emisor emisor;
    @JsonProperty("informacion_adicional")
    private InformacionAdicional informacionAdicional;
    @JsonProperty("transportista")
    private Transportista transportista;
    @JsonProperty("destinatarios")
    private List<Destinatario> destinatarios = new ArrayList<Destinatario>();
    

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
     *     The fechaInicioTransporte
     */
    @JsonProperty("fecha_inicio_transporte")
    public String getFechaInicioTransporte() {
        return fechaInicioTransporte;
    }

    /**
     * 
     * @param fechaInicioTransporte
     *     The fecha_inicio_transporte
     */
    @JsonProperty("fecha_inicio_transporte")
    public void setFechaInicioTransporte(String fechaInicioTransporte) {
        this.fechaInicioTransporte = fechaInicioTransporte;
    }

    /**
     * 
     * @return
     *     The fechaFinTransporte
     */
    @JsonProperty("fecha_fin_transporte")
    public String getFechaFinTransporte() {
        return fechaFinTransporte;
    }

    /**
     * 
     * @param fechaFinTransporte
     *     The fecha_fin_transporte
     */
    @JsonProperty("fecha_fin_transporte")
    public void setFechaFinTransporte(String fechaFinTransporte) {
        this.fechaFinTransporte = fechaFinTransporte;
    }

    /**
     * 
     * @return
     *     The direccionPartida
     */
    @JsonProperty("direccion_partida")
    public String getDireccionPartida() {
        return direccionPartida;
    }

    /**
     * 
     * @param direccionPartida
     *     The direccion_partida
     */
    @JsonProperty("direccion_partida")
    public void setDireccionPartida(String direccionPartida) {
        this.direccionPartida = direccionPartida;
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
     *     The transportista
     */
    @JsonProperty("transportista")
    public Transportista getTransportista() {
        return transportista;
    }

    /**
     * 
     * @param transportista
     *     The transportista
     */
    @JsonProperty("transportista")
    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    /**
     * 
     * @return
     *     The destinatarios
     */
    @JsonProperty("destinatarios")
    public List<Destinatario> getDestinatarios() {
        return destinatarios;
    }

    /**
     * 
     * @param destinatarios
     *     The destinatarios
     */
    @JsonProperty("destinatarios")
    public void setDestinatarios(List<Destinatario> destinatarios) {
        this.destinatarios = destinatarios;
    }

   

}

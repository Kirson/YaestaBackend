
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
    "id",
    "secuencial",
    "fecha_emision",
    "version",
    "clave_acceso",
    "emisor",
    "estado",
    "correos_enviados",
    "guia_remision",
    "moneda",
    "informacion_adicional",
    "ambiente",
    "totales",
    "comprador",
    "envio_sri",
    "tipo_emision",
    "items",
    "pagos",
    "autorizacion"
})
public class FacturaConsulta {

    @JsonProperty("id")
    private String id;
    @JsonProperty("secuencial")
    private String secuencial;
    @JsonProperty("fecha_emision")
    private String fechaEmision;
    @JsonProperty("version")
    private String version;
    @JsonProperty("clave_acceso")
    private String claveAcceso;
    @JsonProperty("emisor")
    private Emisor emisor;
    @JsonProperty("estado")
    private String estado;
    @JsonProperty("correos_enviados")
    private List<CorreosEnviado> correosEnviados = new ArrayList<CorreosEnviado>();
    @JsonProperty("guia_remision")
    private String guiaRemision;
    @JsonProperty("moneda")
    private String moneda;
    @JsonProperty("informacion_adicional")
    private List<Object> informacionAdicional = new ArrayList<Object>();
    @JsonProperty("ambiente")
    private String ambiente;
    @JsonProperty("totales")
    private Totales totales;
    @JsonProperty("comprador")
    private Comprador comprador;
    @JsonProperty("envio_sri")
    private EnvioSri envioSri;
    @JsonProperty("tipo_emision")
    private String tipoEmision;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
    @JsonProperty("pagos")
    private List<Pago> pagos = new ArrayList<Pago>();
    @JsonProperty("autorizacion")
    private Autorizacion autorizacion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The secuencial
     */
    @JsonProperty("secuencial")
    public String getSecuencial() {
        return secuencial;
    }

    /**
     * 
     * @param secuencial
     *     The secuencial
     */
    @JsonProperty("secuencial")
    public void setSecuencial(String secuencial) {
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
     *     The estado
     */
    @JsonProperty("estado")
    public String getEstado() {
        return estado;
    }

    /**
     * 
     * @param estado
     *     The estado
     */
    @JsonProperty("estado")
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * 
     * @return
     *     The correosEnviados
     */
    @JsonProperty("correos_enviados")
    public List<CorreosEnviado> getCorreosEnviados() {
        return correosEnviados;
    }

    /**
     * 
     * @param correosEnviados
     *     The correos_enviados
     */
    @JsonProperty("correos_enviados")
    public void setCorreosEnviados(List<CorreosEnviado> correosEnviados) {
        this.correosEnviados = correosEnviados;
    }

    /**
     * 
     * @return
     *     The guiaRemision
     */
    @JsonProperty("guia_remision")
    public String getGuiaRemision() {
        return guiaRemision;
    }

    /**
     * 
     * @param guiaRemision
     *     The guia_remision
     */
    @JsonProperty("guia_remision")
    public void setGuiaRemision(String guiaRemision) {
        this.guiaRemision = guiaRemision;
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
    public List<Object> getInformacionAdicional() {
        return informacionAdicional;
    }

    /**
     * 
     * @param informacionAdicional
     *     The informacion_adicional
     */
    @JsonProperty("informacion_adicional")
    public void setInformacionAdicional(List<Object> informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    /**
     * 
     * @return
     *     The ambiente
     */
    @JsonProperty("ambiente")
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * 
     * @param ambiente
     *     The ambiente
     */
    @JsonProperty("ambiente")
    public void setAmbiente(String ambiente) {
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
     *     The envioSri
     */
    @JsonProperty("envio_sri")
    public EnvioSri getEnvioSri() {
        return envioSri;
    }

    /**
     * 
     * @param envioSri
     *     The envio_sri
     */
    @JsonProperty("envio_sri")
    public void setEnvioSri(EnvioSri envioSri) {
        this.envioSri = envioSri;
    }

    /**
     * 
     * @return
     *     The tipoEmision
     */
    @JsonProperty("tipo_emision")
    public String getTipoEmision() {
        return tipoEmision;
    }

    /**
     * 
     * @param tipoEmision
     *     The tipo_emision
     */
    @JsonProperty("tipo_emision")
    public void setTipoEmision(String tipoEmision) {
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
     *     The pagos
     */
    @JsonProperty("pagos")
    public List<Pago> getPagos() {
        return pagos;
    }

    /**
     * 
     * @param pagos
     *     The pagos
     */
    @JsonProperty("pagos")
    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    /**
     * 
     * @return
     *     The autorizacion
     */
    @JsonProperty("autorizacion")
    public Autorizacion getAutorizacion() {
        return autorizacion;
    }

    /**
     * 
     * @param autorizacion
     *     The autorizacion
     */
    @JsonProperty("autorizacion")
    public void setAutorizacion(Autorizacion autorizacion) {
        this.autorizacion = autorizacion;
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

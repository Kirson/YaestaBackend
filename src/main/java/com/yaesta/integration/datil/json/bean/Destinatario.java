
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
    "identificacion",
    "tipo_identificacion",
    "razon_social",
    "direccion",
    "email",
    "telefono",
    "fecha_emision_documento_sustento",
    "numero_documento_sustento",
    "numero_autorizacion_documento_sustento",
    "motivo_traslado",
    "tipo_documento_sustento",
    "ruta",
    "documento_aduanero_unico",
    "codigo_establecimiento_destino",
    "items"
})
public class Destinatario {

    @JsonProperty("identificacion")
    private String identificacion;
    @JsonProperty("tipo_identificacion")
    private String tipoIdentificacion;
    @JsonProperty("razon_social")
    private String razonSocial;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("fecha_emision_documento_sustento")
    private String fechaEmisionDocumentoSustento;
    @JsonProperty("numero_documento_sustento")
    private String numeroDocumentoSustento;
    @JsonProperty("numero_autorizacion_documento_sustento")
    private String numeroAutorizacionDocumentoSustento;
    @JsonProperty("motivo_traslado")
    private String motivoTraslado;
    @JsonProperty("tipo_documento_sustento")
    private String tipoDocumentoSustento;
    @JsonProperty("ruta")
    private String ruta;
    @JsonProperty("documento_aduanero_unico")
    private String documentoAduaneroUnico;
    @JsonProperty("codigo_establecimiento_destino")
    private String codigoEstablecimientoDestino;
    @JsonProperty("items")
    private List<ItemGuiaRemision> items = new ArrayList<ItemGuiaRemision>();
    

    /**
     * 
     * @return
     *     The identificacion
     */
    @JsonProperty("identificacion")
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * 
     * @param identificacion
     *     The identificacion
     */
    @JsonProperty("identificacion")
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * 
     * @return
     *     The tipoIdentificacion
     */
    @JsonProperty("tipo_identificacion")
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * 
     * @param tipoIdentificacion
     *     The tipo_identificacion
     */
    @JsonProperty("tipo_identificacion")
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**
     * 
     * @return
     *     The razonSocial
     */
    @JsonProperty("razon_social")
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * 
     * @param razonSocial
     *     The razon_social
     */
    @JsonProperty("razon_social")
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The telefono
     */
    @JsonProperty("telefono")
    public String getTelefono() {
        return telefono;
    }

    /**
     * 
     * @param telefono
     *     The telefono
     */
    @JsonProperty("telefono")
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * 
     * @return
     *     The fechaEmisionDocumentoSustento
     */
    @JsonProperty("fecha_emision_documento_sustento")
    public String getFechaEmisionDocumentoSustento() {
        return fechaEmisionDocumentoSustento;
    }

    /**
     * 
     * @param fechaEmisionDocumentoSustento
     *     The fecha_emision_documento_sustento
     */
    @JsonProperty("fecha_emision_documento_sustento")
    public void setFechaEmisionDocumentoSustento(String fechaEmisionDocumentoSustento) {
        this.fechaEmisionDocumentoSustento = fechaEmisionDocumentoSustento;
    }

    /**
     * 
     * @return
     *     The numeroDocumentoSustento
     */
    @JsonProperty("numero_documento_sustento")
    public String getNumeroDocumentoSustento() {
        return numeroDocumentoSustento;
    }

    /**
     * 
     * @param numeroDocumentoSustento
     *     The numero_documento_sustento
     */
    @JsonProperty("numero_documento_sustento")
    public void setNumeroDocumentoSustento(String numeroDocumentoSustento) {
        this.numeroDocumentoSustento = numeroDocumentoSustento;
    }

    /**
     * 
     * @return
     *     The numeroAutorizacionDocumentoSustento
     */
    @JsonProperty("numero_autorizacion_documento_sustento")
    public String getNumeroAutorizacionDocumentoSustento() {
        return numeroAutorizacionDocumentoSustento;
    }

    /**
     * 
     * @param numeroAutorizacionDocumentoSustento
     *     The numero_autorizacion_documento_sustento
     */
    @JsonProperty("numero_autorizacion_documento_sustento")
    public void setNumeroAutorizacionDocumentoSustento(String numeroAutorizacionDocumentoSustento) {
        this.numeroAutorizacionDocumentoSustento = numeroAutorizacionDocumentoSustento;
    }

    /**
     * 
     * @return
     *     The motivoTraslado
     */
    @JsonProperty("motivo_traslado")
    public String getMotivoTraslado() {
        return motivoTraslado;
    }

    /**
     * 
     * @param motivoTraslado
     *     The motivo_traslado
     */
    @JsonProperty("motivo_traslado")
    public void setMotivoTraslado(String motivoTraslado) {
        this.motivoTraslado = motivoTraslado;
    }

    /**
     * 
     * @return
     *     The tipoDocumentoSustento
     */
    @JsonProperty("tipo_documento_sustento")
    public String getTipoDocumentoSustento() {
        return tipoDocumentoSustento;
    }

    /**
     * 
     * @param tipoDocumentoSustento
     *     The tipo_documento_sustento
     */
    @JsonProperty("tipo_documento_sustento")
    public void setTipoDocumentoSustento(String tipoDocumentoSustento) {
        this.tipoDocumentoSustento = tipoDocumentoSustento;
    }

    /**
     * 
     * @return
     *     The ruta
     */
    @JsonProperty("ruta")
    public String getRuta() {
        return ruta;
    }

    /**
     * 
     * @param ruta
     *     The ruta
     */
    @JsonProperty("ruta")
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * 
     * @return
     *     The documentoAduaneroUnico
     */
    @JsonProperty("documento_aduanero_unico")
    public String getDocumentoAduaneroUnico() {
        return documentoAduaneroUnico;
    }

    /**
     * 
     * @param documentoAduaneroUnico
     *     The documento_aduanero_unico
     */
    @JsonProperty("documento_aduanero_unico")
    public void setDocumentoAduaneroUnico(String documentoAduaneroUnico) {
        this.documentoAduaneroUnico = documentoAduaneroUnico;
    }

    /**
     * 
     * @return
     *     The codigoEstablecimientoDestino
     */
    @JsonProperty("codigo_establecimiento_destino")
    public String getCodigoEstablecimientoDestino() {
        return codigoEstablecimientoDestino;
    }

    /**
     * 
     * @param codigoEstablecimientoDestino
     *     The codigo_establecimiento_destino
     */
    @JsonProperty("codigo_establecimiento_destino")
    public void setCodigoEstablecimientoDestino(String codigoEstablecimientoDestino) {
        this.codigoEstablecimientoDestino = codigoEstablecimientoDestino;
    }

    /**
     * 
     * @return
     *     The items
     */
    @JsonProperty("items")
    public List<ItemGuiaRemision> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    @JsonProperty("items")
    public void setItems(List<ItemGuiaRemision> items) {
        this.items = items;
    }

    

}


package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "email",
    "identificacion",
    "tipo_identificacion",
    "razon_social",
    "direccion",
    "telefono",
    "placa"
})
public class Transportista {

    @JsonProperty("email")
    private String email;
    @JsonProperty("identificacion")
    private String identificacion;
    @JsonProperty("tipo_identificacion")
    private String tipoIdentificacion;
    @JsonProperty("razon_social")
    private String razonSocial;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("placa")
    private String placa;
   

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
     *     The placa
     */
    @JsonProperty("placa")
    public String getPlaca() {
        return placa;
    }

    /**
     * 
     * @param placa
     *     The placa
     */
    @JsonProperty("placa")
    public void setPlaca(String placa) {
        this.placa = placa;
    }

   

}

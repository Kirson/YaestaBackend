
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "ruc",
    "razon_social",
    "nombre_comercial",
    "direccion",
    "contribuyente_especial",
    "obligado_contabilidad",
    "establecimiento"
})
public class Emisor {

    @JsonProperty("ruc")
    private String ruc;
    @JsonProperty("razon_social")
    private String razonSocial;
    @JsonProperty("nombre_comercial")
    private String nombreComercial;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("contribuyente_especial")
    private String contribuyenteEspecial;
    @JsonProperty("obligado_contabilidad")
    private Boolean obligadoContabilidad;
    @JsonProperty("establecimiento")
    private Establecimiento establecimiento;
   

    /**
     * 
     * @return
     *     The ruc
     */
    @JsonProperty("ruc")
    public String getRuc() {
        return ruc;
    }

    /**
     * 
     * @param ruc
     *     The ruc
     */
    @JsonProperty("ruc")
    public void setRuc(String ruc) {
        this.ruc = ruc;
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
     *     The nombreComercial
     */
    @JsonProperty("nombre_comercial")
    public String getNombreComercial() {
        return nombreComercial;
    }

    /**
     * 
     * @param nombreComercial
     *     The nombre_comercial
     */
    @JsonProperty("nombre_comercial")
    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
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
     *     The contribuyenteEspecial
     */
    @JsonProperty("contribuyente_especial")
    public String getContribuyenteEspecial() {
        return contribuyenteEspecial;
    }

    /**
     * 
     * @param contribuyenteEspecial
     *     The contribuyente_especial
     */
    @JsonProperty("contribuyente_especial")
    public void setContribuyenteEspecial(String contribuyenteEspecial) {
        this.contribuyenteEspecial = contribuyenteEspecial;
    }

    /**
     * 
     * @return
     *     The obligadoContabilidad
     */
    @JsonProperty("obligado_contabilidad")
    public Boolean getObligadoContabilidad() {
        return obligadoContabilidad;
    }

    /**
     * 
     * @param obligadoContabilidad
     *     The obligado_contabilidad
     */
    @JsonProperty("obligado_contabilidad")
    public void setObligadoContabilidad(Boolean obligadoContabilidad) {
        this.obligadoContabilidad = obligadoContabilidad;
    }

    /**
     * 
     * @return
     *     The establecimiento
     */
    @JsonProperty("establecimiento")
    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    /**
     * 
     * @param establecimiento
     *     The establecimiento
     */
    @JsonProperty("establecimiento")
    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    
   

}

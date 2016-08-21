
package com.yaesta.integration.datil.json.bean;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "identificador",
    "mensaje",
    "tipo",
    "informacion_adicional"
})
public class Mensaje {

    @JsonProperty("identificador")
    private String identificador;
    @JsonProperty("mensaje")
    private String mensaje;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("informacion_adicional")
    private String informacionAdicional;
   
    /**
     * 
     * @return
     *     The identificador
     */
    @JsonProperty("identificador")
    public String getIdentificador() {
        return identificador;
    }

    /**
     * 
     * @param identificador
     *     The identificador
     */
    @JsonProperty("identificador")
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * 
     * @return
     *     The mensaje
     */
    @JsonProperty("mensaje")
    public String getMensaje() {
        return mensaje;
    }

    /**
     * 
     * @param mensaje
     *     The mensaje
     */
    @JsonProperty("mensaje")
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * 
     * @return
     *     The tipo
     */
    @JsonProperty("tipo")
    public String getTipo() {
        return tipo;
    }

    /**
     * 
     * @param tipo
     *     The tipo
     */
    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * @return
     *     The informacionAdicional
     */
    @JsonProperty("informacion_adicional")
    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    /**
     * 
     * @param informacionAdicional
     *     The informacion_adicional
     */
    @JsonProperty("informacion_adicional")
    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    

}

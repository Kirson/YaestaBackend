
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "fecha_envio",
    "destinatarios"
})
public class CorreosEnviado {

    @JsonProperty("fecha_envio")
    private String fechaEnvio;
    @JsonProperty("destinatarios")
    private String destinatarios;
   
    /**
     * 
     * @return
     *     The fechaEnvio
     */
    @JsonProperty("fecha_envio")
    public String getFechaEnvio() {
        return fechaEnvio;
    }

    /**
     * 
     * @param fechaEnvio
     *     The fecha_envio
     */
    @JsonProperty("fecha_envio")
    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    /**
     * 
     * @return
     *     The destinatarios
     */
    @JsonProperty("destinatarios")
    public String getDestinatarios() {
        return destinatarios;
    }

    /**
     * 
     * @param destinatarios
     *     The destinatarios
     */
    @JsonProperty("destinatarios")
    public void setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
    }

   

}

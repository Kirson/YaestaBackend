
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "tiempo_de_entrega",
    "id_proveedor",
    "nombre_proveedor",
    "telefono_proveedor",
    "email_proveedor",
    "forma_pago",
    "valor_a_cobrar"
})
public class InformacionAdicional {

    @JsonProperty("tiempo_de_entrega")
    private String tiempoDeEntrega;
    
    @JsonProperty("id_proveedor")
    private String idProveedor;
    
    @JsonProperty("nombre_proveedor")
    private String nombreProveedor;
    
    @JsonProperty("telefono_proveedor")
    private String telefonoProveedor;
    
    @JsonProperty("email_proveedor")
    private String emailProveedor;
    
    @JsonProperty("forma_pago")
    private String formaPago;
    
    @JsonProperty("valor_a_cobrar")
    private String valorACobrar;
    
    /**
     * 
     * @return
     *     The tiempoDeEntrega
     */
    @JsonProperty("tiempo_de_entrega")
    public String getTiempoDeEntrega() {
        return tiempoDeEntrega;
    }

    /**
     * 
     * @param tiempoDeEntrega
     *     The Tiempo de entrega
     */
    @JsonProperty("tiempo_de_entrega")
    public void setTiempoDeEntrega(String tiempoDeEntrega) {
        this.tiempoDeEntrega = tiempoDeEntrega;
    }
    
    
    @JsonProperty("id_proveedor")
    public String getIdProveedor() {
		return idProveedor;
	}

    @JsonProperty("id_proveedor")
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	@JsonProperty("nombre_proveedor")
	public String getNombreProveedor() {
		return nombreProveedor;
	}

    @JsonProperty("nombre_proveedor")
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
    
    
    @JsonProperty("telefono_proveedor")
	public String getTelefonoProveedor() {
		return telefonoProveedor;
	}

    @JsonProperty("telefono_proveedor")
	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

    @JsonProperty("email_proveedor")
	public String getEmailProveedor() {
		return emailProveedor;
	}

    @JsonProperty("email_proveedor")
	public void setEmailProveedor(String emailProveedor) {
		this.emailProveedor = emailProveedor;
	}

	@JsonProperty("forma_pago")
	public String getFormaPago() {
		return formaPago;
	}

	@JsonProperty("forma_pago")
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	@JsonProperty("valor_a_cobrar")
	public String getValorACobrar() {
		return valorACobrar;
	}

	@JsonProperty("valor_a_cobrar")
	public void setValorACobrar(String valorACobrar) {
		this.valorACobrar = valorACobrar;
	}

   

}

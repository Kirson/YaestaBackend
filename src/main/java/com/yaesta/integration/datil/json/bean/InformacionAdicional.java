
package com.yaesta.integration.datil.json.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "tiempo_de_entrega",
    "nombre_proveedor",
    "forma_pago",
    "valor_a_cobrar"
})
public class InformacionAdicional {

    @JsonProperty("tiempo_de_entrega")
    private String tiempoDeEntrega;
    
    @JsonProperty("nombre_proveedor")
    private String nombreProveedor;
    
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

    @JsonProperty("nombre_proveedor")
	public String getNombreProveedor() {
		return nombreProveedor;
	}

    @JsonProperty("nombre_proveedor")
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
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

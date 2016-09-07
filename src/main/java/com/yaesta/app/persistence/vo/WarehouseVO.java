package com.yaesta.app.persistence.vo;

import java.io.Serializable;

public class WarehouseVO implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 6672447337269513726L;

	private String transaccion;
	private String pedido;
	private String numeroDocumento;
	private String ordenCompra;
	private String codigoCliente;
	private String cliente;
	private String direccion;
	private String fecha;
	private String tipoDocumento;
	private String fechaEntrega;
	private String horaEntrega;
	private String producto;
	private Long cantidad;
	private String lote;
	private String fechaVencimiento;
	private String almacen;
	
	public String getTransaccion() {
		return transaccion;
	}
	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getOrdenCompra() {
		return ordenCompra;
	}
	public void setOrdenCompra(String ordenCompra) {
		this.ordenCompra = ordenCompra;
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getHoraEntrega() {
		return horaEntrega;
	}
	public void setHoraEntrega(String horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getAlmacen() {
		return almacen;
	}
	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}
	
	
	
}

package com.yaesta.tramaco.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import dmz.comercial.servicio.cliente.dto.EntityCarga;

@XmlRootElement
public class LoadDTO implements Serializable {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 4148137621133016529L;
	private BigDecimal depth;  //profundidad
	private BigDecimal height; //alto
	private BigDecimal width;  //ancho
	private BigDecimal weight;  //peso
	private Long quantity;  //cantidad de producto
	private Long boxes; //cantidad de cajas
	private Long bundles; //cantidad de bultos
	private Long documents; //cantidad de documentos
	private String attachments; // tiene adjuntos (Yes,No / Si, No)
	private BigDecimal insuredValue; //valor asegurado
	private Long productId; //Id Producto
	private String productIdVitex; //Id Producto Vitex
	private Long contractId; //Id contrato
	private String serialGuide; // numero de guia
	private Long localeId; //ide de localidad
	private EntityCarga  originalLoad;
	
	
	public BigDecimal getDepth() {
		return depth;
	}
	public void setDepth(BigDecimal depth) {
		this.depth = depth;
	}
	public BigDecimal getHeight() {
		return height;
	}
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getBoxes() {
		return boxes;
	}
	public void setBoxes(Long boxes) {
		this.boxes = boxes;
	}
	public Long getBundles() {
		return bundles;
	}
	public void setBundles(Long bundles) {
		this.bundles = bundles;
	}
	public Long getDocuments() {
		return documents;
	}
	public void setDocuments(Long documents) {
		this.documents = documents;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	public BigDecimal getInsuredValue() {
		return insuredValue;
	}
	public void setInsuredValue(BigDecimal insuredValue) {
		this.insuredValue = insuredValue;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductIdVitex() {
		return productIdVitex;
	}
	public void setProductIdVitex(String productIdVitex) {
		this.productIdVitex = productIdVitex;
	}
	public Long getContractId() {
		return contractId;
	}
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	public String getSerialGuide() {
		return serialGuide;
	}
	public void setSerialGuide(String serialGuide) {
		this.serialGuide = serialGuide;
	}
	public Long getLocaleId() {
		return localeId;
	}
	public void setLocaleId(Long localeId) {
		this.localeId = localeId;
	}
	public EntityCarga getOriginalLoad() {
		return originalLoad;
	}
	public void setOriginalLoad(EntityCarga originalLoad) {
		this.originalLoad = originalLoad;
	}
	
	
	
}

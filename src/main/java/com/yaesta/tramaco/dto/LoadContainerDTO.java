package com.yaesta.tramaco.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import dmz.comercial.servicio.cliente.dto.EntityCargaDestino;

@XmlRootElement
public class LoadContainerDTO implements Serializable{

	private Long internalSequence;
	private LoadDTO load;
	private EntityCargaDestino originalContainer;
	public Long getInternalSequence() {
		return internalSequence;
	}
	public void setInternalSequence(Long internalSequence) {
		this.internalSequence = internalSequence;
	}
	public LoadDTO getLoad() {
		return load;
	}
	public void setLoad(LoadDTO load) {
		this.load = load;
	}
	public EntityCargaDestino getOriginalContainer() {
		return originalContainer;
	}
	public void setOriginalContainer(EntityCargaDestino originalContainer) {
		this.originalContainer = originalContainer;
	}
	
	
}

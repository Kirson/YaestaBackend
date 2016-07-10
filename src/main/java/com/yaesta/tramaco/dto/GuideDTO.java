package com.yaesta.tramaco.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import dmz.comercial.servicio.cliente.dto.EntityGuia;

@XmlRootElement
public class GuideDTO {

	private List<LoadContainerDTO> loadList;
	
	private List<EntityGuia> guideList;
	
}

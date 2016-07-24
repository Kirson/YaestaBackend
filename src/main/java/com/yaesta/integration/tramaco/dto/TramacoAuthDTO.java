package com.yaesta.integration.tramaco.dto;

import java.io.Serializable;

import dmz.comercial.servicio.cliente.dto.RespuestaAutenticarWs;

public class TramacoAuthDTO implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -4506145221191568129L;
	private String response;
	private RespuestaAutenticarWs respuestaAutenticarWs;
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public RespuestaAutenticarWs getRespuestaAutenticarWs() {
		return respuestaAutenticarWs;
	}
	public void setRespuestaAutenticarWs(RespuestaAutenticarWs respuestaAutenticarWs) {
		this.respuestaAutenticarWs = respuestaAutenticarWs;
	}
	
	
}

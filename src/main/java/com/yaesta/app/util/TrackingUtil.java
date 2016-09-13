package com.yaesta.app.util;

import com.yaesta.app.persistence.vo.TrackingVO;

import dmz.comercial.servicio.cliente.dto.SalidaTrackGuiaWs;

public class TrackingUtil {
	
	public static TrackingVO fromSalidaTrackGuiaWsToTrackingVO(SalidaTrackGuiaWs input){
		TrackingVO result = new TrackingVO();
		
		result.setCarrier(input.getTransportista());
		result.setTransport(input.getTransportista());
		result.setCity(input.getCiudad());
		result.setDateTime(input.getFechaHora());
		result.setStatus(input.getEstado());
		result.setDelivery("TRAMACO");
		result.setUser(input.getUsuario());
		result.setDescription(input.getDescripcion());
		
		return result;
		
	}

}

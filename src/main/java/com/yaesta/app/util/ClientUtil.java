package com.yaesta.app.util;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.Customer;
import com.yaesta.app.persistence.entity.ClienteBodega;
import com.yaesta.app.persistence.vo.ClientVO;
import com.yaesta.app.persistence.vo.ClientWarehouseVO;

public class ClientUtil implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -5267616882233703153L;

	public static ClientWarehouseVO fromClienteBodegaToClientWarehouse(ClienteBodega source){
		ClientWarehouseVO cw = new ClientWarehouseVO();
		cw.setCodigoDestino(source.getCodigo());
		String strTempDir = source.getDireccionEntrega();
		try{
			String[] varDir = strTempDir.split("-");
			strTempDir = varDir[1];
			strTempDir = strTempDir.replace("null","");
		}catch(Exception e){
			
		}
		if(strTempDir.length()>72){
			cw.setDireccionEntrega(strTempDir.substring(0, 71));
		}else{
			cw.setDireccionEntrega(strTempDir);
		}
		if(strTempDir.length()>72){
			cw.setNombreVia(strTempDir.substring(0, 71));
		}else{
			cw.setNombreVia(strTempDir);
		}
		cw.setRazonSocial(source.getRazonSocial());
		cw.setUbicacionGeografica("170150");
		
		return cw;
	}
	
	public static ClientVO fromClientToClientVO(Customer client){
		ClientVO cvo = new ClientVO();
		String strTempDir = client.getAddress();
		try{
			String[] varDir = strTempDir.split("-");
			strTempDir = varDir[1];
			strTempDir = strTempDir.replace("null","");
		}catch(Exception e){
			
		}
		cvo.setAddress(strTempDir);
		cvo.setCanton(client.getCanton());
		cvo.setDocument(client.getDocument());
		cvo.setEmail(client.getEmail());
		cvo.setFirstName(client.getFirstName());
		cvo.setLastName(client.getLastName());
		cvo.setId(client.getId());
		cvo.setLastPaymentMethod(client.getLastPaymentMethod());
		cvo.setPhone(client.getHomePhone());
		cvo.setPostalCode(client.getPostalCode());
		cvo.setProvince(client.getProvince());
		return cvo;
		
	}
}

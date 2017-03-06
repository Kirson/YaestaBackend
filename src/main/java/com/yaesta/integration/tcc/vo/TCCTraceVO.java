package com.yaesta.integration.tcc.vo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.com.tcc.clientes.Remesa;
import co.com.tcc.clientes.RemesaEstados;

public class TCCTraceVO implements Serializable {

	private String message;
	private List<Remesa> remesaList;
	private List<RemesaEstados> remesaEstadoList;
	
	public TCCTraceVO(){
		remesaList = new ArrayList<Remesa>();
		remesaEstadoList = new ArrayList<RemesaEstados>();
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Remesa> getRemesaList() {
		return remesaList;
	}
	public void setRemesaList(List<Remesa> remesaList) {
		this.remesaList = remesaList;
	}

	public List<RemesaEstados> getRemesaEstadoList() {
		return remesaEstadoList;
	}

	public void setRemesaEstadoList(List<RemesaEstados> remesaEstadoList) {
		this.remesaEstadoList = remesaEstadoList;
	}
	
	
	
}

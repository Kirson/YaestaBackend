package com.yaesta.integration.base.enums;

public enum DeliveryEnum {
	
	TRAMACO("1","Tramaco","TRAMACO"),
	MOTO_ENVIOS("2","Moto Envios","ME"),
	TCC("3","TCC","TCC"),
	LAR_COURIER("4","LAR COURIER","LC");
	
	private String id;
	private String name;
	private String nemonic;
	
	DeliveryEnum(String id, String name, String nemonic){
		this.id=id;
		this.name=name;
		this.nemonic=nemonic;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNemonic() {
		return nemonic;
	}

	public void setNemonic(String nemonic) {
		this.nemonic = nemonic;
	}
	
	

}

package com.yaesta.app.persistence.enums;

public enum GuideStatusEnum {

	GENERATED("GENERATED","Generada"),
	GENERATED_PDF("GENERATED-PDF","Generada PDF"),
	PROGRAMED("PROGRAMED","Programada"),
	PENDING("PENDING","Pendiente"),
	DELIVERY_PENDING("DELIVERY-PENDING","Pendiente de entrega"),
	DELIVERY_PROCESS("DELIVERY-PROCESS","En proceso de entrega"),
	DELIVERED("DELIVERED","Entregada"),
	CANCELED("CANCELED","Cancelada");
	
	String code;
	String description;
	
	GuideStatusEnum(String code,String description){
		this.code=code;
		this.description=description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

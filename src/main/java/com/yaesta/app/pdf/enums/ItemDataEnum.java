package com.yaesta.app.pdf.enums;

public enum ItemDataEnum {

	CODE("CODIGO"),
	NAME("NOMBRE"),
	QUANTITY("CANTIDAD");
	
	ItemDataEnum(String descItem){
		this.descItem = descItem;
	}
	
	String descItem;

	public String getDescItem() {
		return descItem;
	}

	public void setDescItem(String descItem) {
		this.descItem = descItem;
	}
	
	
	
}

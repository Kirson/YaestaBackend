package com.yaesta.integration.datil.json.enums;

public enum TipoDocumentoEnum {
   
	
	FACTURA("01","Factura"),
	NOTA_CREDITO("04","Nota de Crédito"),
	NOTA_DEBITO("05","Nota de Débito"),
	GUIA_REMISION("06","Guia de Remisión"),
	COMPROBANTE_RETENCION("07","Comprobante de Retención");
	
	String code;
	String name;
	
	TipoDocumentoEnum(String code, String name)
	{
		this.code =code;
		this.name= name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

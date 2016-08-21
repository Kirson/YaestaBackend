package com.yaesta.integration.datil.json.enums;

public enum PagoEnum {
	/*
	Efectivo	efectivo	Fuera del sistema financiero	01
	Cheque	cheque	Cheque propio	02
	Cheque certificado	cheque_certificado	Cheque certificado	03
	Cheque de gerencia	cheque_gerencia	Cheque de gerencia	04
	Cheque del exterior	cheque_exterior	Cheque del exterior	05
	Débito de cuenta bancaria	debito_cuenta_bancaria	Débito de cuenta	06
	Transferencia en el mismo banco	transferencia_mismo_banco	Transferencia propio banco	07
	Transferencia otro banco nacional	transferencia_otro_banco	Transferencia otro banco nacional	08
	Transferencia banco exterior	transferencia_banco_exterior	Transferencia banco exterior	09
	Tarjeta de crédito nacional	tarjeta_credito_nacional	Tarjeta de crédito nacional	10
	Tarjeta de crédito internacional	tarjeta_credito_internacional	Tarjeta de crédito internacional	11
	Giro	giro	Giro	12
	Depósito en cuenta (Corriente / Ahorros)	deposito_cuenta_bancaria	Depósito en cuenta (Corriente / Ahorros)	13
	Endoso de inversión	endoso_inversion	Endoso de inversión	14
	Compensación de deudas	compensacion_deudas	Compensación de deudas	15
	Tarjeta de débito	tarjeta_debito	Tarjeta de débito	16
	Dinero electrónico Ecuador	dinero_electronico_ec	Dinero electrónico	17
	Tarjeta prepago	tarjeta_prepago	Tarjeta prepago	18*/

	EFECTIVO("Efectivo","efectivo","Fuera del sistema financiero","01"),
	CHEQUE("Cheque","cheque","Cheque propio","02"),
	CHEQUE_CERTIFICADO("Cheque certificado","cheque_certificado","Cheque certificado","03"),
	CHEQUE_GERENCIA("Cheque gerencia","cheque_gerencia","Cheque de gerencia","04"),
	CHEQUE_EXTERIOR("Cheque del exterior","cheque_exterior","Cheque del exterior","05"),
	DEBITO_CTA_BANCARIA("Débito de cuenta bancaria","debito_cuenta_bancaria","Débito de cuenta","06"),
	TRANSFER_MISMO_BANCO("Transferencia en el mismo banco","transferencia_mismo_banco","Transferencia propio banco","07"),
	TRANSFER_OTRO_BANCO("Transferencia otro banco nacional","transferencia_otro_banco","Transferencia otro banco nacional","08"),
	TRANSFERENCIA_BANCARIA_OTRAS_ENTIDADES("TRANSFERENCIA BANCARIA (OTRAS ENTIDADES)","transferencia_otro_banco","Transferencia otro banco nacional","08"),
	TRANSFER_BANCO_EXTERIOR("Transferencia banco exterior","transferencia_banco_exterior","Transferencia banco exterior","09"),
	TARJETA_CREDITO_NACIONAL("Tarjeta de crédito nacional","tarjeta_credito_nacional","Tarjeta de crédito nacional","10"),
	TARJETA_CREDITO_INTERNACIONAL("Tarjeta de crédito internacional","tarjeta_credito_internacional","Tarjeta de crédito internacional","11"),
	GIRO("Giro","giro","Giro","12"),
	DEPOSITO_CTA_BANCARIA("Depósito en cuenta (Corriente / Ahorros)","deposito_cuenta_bancaria","Depósito en cuenta (Corriente / Ahorros)","13"),
	ENDOSO_INVERSION("Endoso de inversión","endoso_inversion","Endoso de inversión","14"),
	COMPENSACION_DEUDAS("Compensación de deudas","compensacion_deudas","Compensación de deudas","15"),
	TARJETA_DEBITO("Tarjeta de débito","tarjeta_debito","Tarjeta de débito","16"),
	DINERO_ELECTRONICO_EC("Dinero electrónico Ecuador","dinero_electronico_ec","Dinero electrónico","17"),
	TARJETA_PREPAGO("Tarjeta prepago","tarjeta_prepago","Tarjeta prepago","18");
	
	
	String formaPago;
	String codigoDatil;
	String descripcionSRI;
	String codigoSRI;
	
	PagoEnum(String formaPago, String codigoDatil,String descripcionSRI, String codigoSRI){
		this.formaPago = formaPago;
		this.codigoDatil = codigoDatil;
		this.descripcionSRI = descripcionSRI;
		this.codigoSRI = codigoSRI;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getCodigoDatil() {
		return codigoDatil;
	}

	public void setCodigoDatil(String codigoDatil) {
		this.codigoDatil = codigoDatil;
	}

	public String getDescripcionSRI() {
		return descripcionSRI;
	}

	public void setDescripcionSRI(String descripcionSRI) {
		this.descripcionSRI = descripcionSRI;
	}

	public String getCodigoSRI() {
		return codigoSRI;
	}

	public void setCodigoSRI(String codigoSRI) {
		this.codigoSRI = codigoSRI;
	}
	
	
	
}

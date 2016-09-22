package com.yaesta.integration.vitex.json.bean.enums;

public enum PaymentEnum {

	PAGO_CONTRA_ENTREGA("Pago contra entrega"),
	PAYPAL("PayPal"),
	NO_PAYMENT("NO-PAYMENT"),
	PAYCLUB("PayClub"),
	SAFETYPAY("Safetypay"),
	TARJETA_ALIA("Tarjeta Alia"),
	TARJETA_CREDITO("Tarjeta de credito"),
	TRANSFERENCIA_BANCARIA_OTRAS_ENTIDADES("TRANSFERENCIA BANCARIA (OTRAS ENTIDADES)"),
	CONSIGNACION_BANCARIA("Consignación Bancaria"),
	TRANSFERENCIA_BANCARIA("Transferencia Bancaria");
	
	String paymentSystemName;
	
	PaymentEnum(String paymentSystemName){
		this.paymentSystemName = paymentSystemName;
	}

	public String getPaymentSystemName() {
		return paymentSystemName;
	}

	public void setPaymentSystemName(String paymentSystemName) {
		this.paymentSystemName = paymentSystemName;
	}
	
	
}

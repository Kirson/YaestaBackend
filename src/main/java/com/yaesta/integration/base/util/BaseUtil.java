package com.yaesta.integration.base.util;

public class BaseUtil {

	public static Double calculateIVA(Double price, int percent, String ivaPercentValue){
		Double vpercent = new Double(ivaPercentValue);
		
		Double iva = price*vpercent;
		
		iva = (double) Math.round(iva * 100) / 100;
		
		return iva;
	}
}

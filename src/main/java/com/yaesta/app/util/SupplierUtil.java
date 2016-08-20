package com.yaesta.app.util;

public class SupplierUtil {

	public static String[] returnSupplierCode(String refId) {

		String result[] = new String[3];
		String errorMessage = "OK";
		String code = refId;
		String productCode = "";

		try {
			String out1[] = refId.split("\\(-");
			//System.out.println("A"+out1[0]);
			//System.out.println("B"+out1[1]);

			String out2[] = out1[1].split("-\\)");
			//System.out.println("C"+out2[0]);
			//System.out.println("D"+out2[1]);

			code = out2[0];
			productCode=out2[1];
		} catch (Exception e) {
			errorMessage = "RefId "+refId+" no esta en el formato acordado";
			System.out.println("==>> error es "+e.getMessage());
		}
		
		result[0]= code;
		result[1]= errorMessage;
		result[2]= productCode;
		//System.out.println("1"+result[0]);
		//System.out.println("2"+result[1]);
		//System.out.println("3"+code);
		//System.out.println("4"+errorMessage);
		return result;
	}
}

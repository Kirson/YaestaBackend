package com.yaesta.app.util;

import com.yaesta.app.persistence.entity.Supplier;
import com.yaesta.app.persistence.vo.SupplierBeanVO;

public class SupplierUtil {

	public static String[] returnSupplierCode(String refId) {

		String result[] = new String[3];
		String errorMessage = "OK";
		String code = refId;
		String productCode = "";

		try {
			String out1[] = refId.split("\\(-");

			String out2[] = out1[1].split("-\\)");

			code = out2[0];
			productCode=out2[1];
		} catch (Exception e) {
			errorMessage = "RefId "+refId+" no se encuentra en el formato acordado";
			System.out.println("==>> error es "+e.getMessage());
		}
		
		result[0]= code;
		result[1]= errorMessage;
		result[2]= productCode;
		return result;
	}
	
	public static SupplierBeanVO fromSupplierToSupplierBean(Supplier source){
		SupplierBeanVO result = new SupplierBeanVO();
		result.setAddress(source.getAddress());
		result.setCanton(source.getCanton());
		result.setContactEmail(source.getContactEmail());
		result.setContactLastName(source.getContactLastName());
		result.setContactName(source.getContactName());
		result.setId(source.getId());
		result.setName(source.getName());
		result.setPhone("'"+source.getPhone());
		result.setProvince(source.getProvince());
		
		return result;
		
	}
}

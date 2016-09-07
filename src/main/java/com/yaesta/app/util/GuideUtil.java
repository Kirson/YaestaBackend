package com.yaesta.app.util;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.vo.GuideVO;

public class GuideUtil implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -7004654078641703007L;

	public static GuideVO fromGuideToGuideVO(Guide source){
		GuideVO result = new GuideVO();
		result.setId(source.getId());
		result.setDeliveryName(source.getDeliveryName());
		result.setOrderId(source.getOrderVitexId());
		if(source.getDeliveryName().equals("TRAMACO")){
			String [] guideStrID = source.getVitexDispatcherId().split("%");
			result.setGuideNumber(guideStrID[1]);
		}
		result.setCustomerName(source.getCustomerName());
		result.setGuideStatus(source.getStatus());
		result.setDeliveryStatus(source.getDeliveryStatus());
		if(source.getSupplier()!=null){
			result.setSupplierId(source.getSupplier().getId());
			result.setSupplierName(source.getSupplier().getName());
		}
		result.setCreationDate(source.getCreateDate());
		result.setDeliveryDate(source.getDeliveryDate());
		return result;
	}
	
}

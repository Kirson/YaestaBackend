package com.yaesta.app.util;

import java.io.Serializable;

import com.yaesta.app.persistence.entity.Guide;
import com.yaesta.app.persistence.vo.GuidePaymentVO;
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
		if(source.getDeliveryName()!=null){
			if(source.getDeliveryName().equals("TRAMACO")){
				String [] guideStrID = source.getVitexDispatcherId().split("%");
				result.setGuideNumber(guideStrID[1]);
			}
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
		result.setOrderDate(source.getOrderDate());
		result.setProgrammedDate(source.getProgrammedDate());
		return result;
	}
	
	public static GuidePaymentVO fromGuideToGuidePaymentVO(Guide source){
		GuidePaymentVO result= new GuidePaymentVO();
		result.setId(source.getId()+"");
		result.setOrderNumber(source.getOrderVitexId());
		result.setGuideNumber(source.getGuideNumber());
		result.setStatus(source.getStatus());
		result.setDeliveryName(source.getDeliveryName());
		result.setSupplierName(source.getSupplier().getName());
		result.setCustomerName(source.getCustomerName());
		
		if(source.getDeliveryPayment()!=null){
			result.setGuideValue(source.getDeliveryPayment()+"");
		}else{
			result.setGuideValue("0.00");
		}
		
		result.setOrderDate(UtilDate.formatDateISO(source.getOrderDate()));
		
		return result;
	}
	
}

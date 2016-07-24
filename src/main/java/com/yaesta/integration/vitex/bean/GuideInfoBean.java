package com.yaesta.integration.vitex.bean;

import java.io.Serializable;
import java.util.List;

import com.yaesta.integration.tramaco.dto.GuideDTO;
import com.yaesta.integration.vitex.json.bean.OrderComplete;

/**
 * 
 * @author cristhian
 *
 */
public class GuideInfoBean implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4355287434095411083L;
	private OrderComplete orderComplete;
	private List<SupplierDeliveryInfo> supplierDeliveryInfoList;
	private List<GuideDTO> guides;
	
	public OrderComplete getOrderComplete() {
		return orderComplete;
	}
	public void setOrderComplete(OrderComplete orderComplete) {
		this.orderComplete = orderComplete;
	}
	public List<SupplierDeliveryInfo> getSupplierDeliveryInfoList() {
		return supplierDeliveryInfoList;
	}
	public void setSupplierDeliveryInfoList(List<SupplierDeliveryInfo> supplierDeliveryInfoList) {
		this.supplierDeliveryInfoList = supplierDeliveryInfoList;
	}
	public List<GuideDTO> getGuides() {
		return guides;
	}
	public void setGuides(List<GuideDTO> guides) {
		this.guides = guides;
	}
	
	
}

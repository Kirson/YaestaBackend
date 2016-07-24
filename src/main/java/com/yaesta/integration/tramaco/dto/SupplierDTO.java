package com.yaesta.integration.tramaco.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.yaesta.app.persistence.entity.Supplier;

@XmlRootElement
public class SupplierDTO  implements Serializable{
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -7870457280414438075L;
	private Supplier supplier;
	private DeliveryInfoDTO deliveryInfo;
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public DeliveryInfoDTO getDeliveryInfo() {
		return deliveryInfo;
	}
	public void setDeliveryInfo(DeliveryInfoDTO deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	
}

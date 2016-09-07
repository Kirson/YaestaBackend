package com.yaesta.app.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "guide",schema="yaesta")
public class Guide implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 3077813564615198122L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guide_seq_gen")
	@SequenceGenerator(name = "guide_seq_gen", sequenceName = "guide_id_seq")
	private Long id;
	
	@Column(name = "serial")
	private String serial;
	
	@Column(name = "vitex_id")
	private String vitexId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "order_vitex_id")
	private String orderVitexId;
	
	@Column(name = "vitex_dispatcher_id")
	private String vitexDispatcherId;
	
	@Column(name="create_date",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="upd_date",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updDate;
	
	@Column(name="delivery_date",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deliveryDate;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="guide_info")
	private String guideInfo;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="sender")
	private String sender;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="receiver")
	private String receiver;
	
	@JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Order order;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;
	
	@Column(name="delivery_cost")
	private Double deliveryCost;
	
	@Column(name="item_value")
	private Double itemValue;
	
	@Column(name="delivery_payment")
	private Double deliveryPayment;
	
	@Column(name="delivery_status")
	private String deliveryStatus;
	
	@Column(name="document_url")
	private String documentUrl;
	
	@Column(name="delivery_name")
	private String deliveryName;
	
	@Column(name="customer_name")
	private String customerName;
	
	@JsonManagedReference
	@JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Supplier supplier;
	
	@Transient
	private List<GuideDetail> details;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getVitexId() {
		return vitexId;
	}

	public void setVitexId(String vitexId) {
		this.vitexId = vitexId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getGuideInfo() {
		return guideInfo;
	}

	public void setGuideInfo(String guideInfo) {
		this.guideInfo = guideInfo;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	
	public String getOrderVitexId() {
		return orderVitexId;
	}

	public void setOrderVitexId(String orderVitexId) {
		this.orderVitexId = orderVitexId;
	}

	

	public String getVitexDispatcherId() {
		return vitexDispatcherId;
	}

	public void setVitexDispatcherId(String vitexDispatcherId) {
		this.vitexDispatcherId = vitexDispatcherId;
	}
	
	

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public List<GuideDetail> getDetails() {
		return details;
	}

	public void setDetails(List<GuideDetail> details) {
		this.details = details;
	}
	
	

	public Double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(Double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public Double getItemValue() {
		return itemValue;
	}

	public void setItemValue(Double itemValue) {
		this.itemValue = itemValue;
	}

	public Double getDeliveryPayment() {
		return deliveryPayment;
	}

	public void setDeliveryPayment(Double deliveryPayment) {
		this.deliveryPayment = deliveryPayment;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}
	
	

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + ((guideInfo == null) ? 0 : guideInfo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((sender == null) ? 0 : sender.hashCode());
		result = prime * result + ((serial == null) ? 0 : serial.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updDate == null) ? 0 : updDate.hashCode());
		result = prime * result + ((vitexId == null) ? 0 : vitexId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guide other = (Guide) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (guideInfo == null) {
			if (other.guideInfo != null)
				return false;
		} else if (!guideInfo.equals(other.guideInfo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;
		if (serial == null) {
			if (other.serial != null)
				return false;
		} else if (!serial.equals(other.serial))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (updDate == null) {
			if (other.updDate != null)
				return false;
		} else if (!updDate.equals(other.updDate))
			return false;
		if (vitexId == null) {
			if (other.vitexId != null)
				return false;
		} else if (!vitexId.equals(other.vitexId))
			return false;
		return true;
	}
	
	
	
}

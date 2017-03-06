package com.yaesta.app.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "order",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order implements Serializable{

	
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4674952752778251837L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
	@SequenceGenerator(name = "order_seq_gen", sequenceName = "order_id_seq")
	private Long id;
	
	@Column(name = "serial")
	private String serial;
	
	@Column(name = "vitex_id")
	private String vitexId;
	
	@Column(name="total_price")
	private BigDecimal totalPrice;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="order_info")
	private String orderInfo;
	
	@JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Customer client;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "vitex_status")
	private String vitexStatus;
	
	@Column(name="create_date",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name="upd_date",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updDate;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="invoice")
	private String invoice;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="credit_note")
	private String creditNote;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(nullable = true)
	@JsonManagedReference
	private List<OrderItem> items;
	
	@Column(name="has_Items")
	private String hasItems;
	
	@JoinColumn(name = "motive_cancel_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Catalog motiveCancel;
	
	@Column(name="motive_cancel_text")
	private String motiveCancelText;
	
	@Column(name="cancel_date",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date cancelDate;
	
	@Column(name="periode")
	private String periode;
	
	@Column(name="pending")
	private Boolean pending;
	
	@Column(name="motive_pending")
	private String motivePending;
	
	@Column(name="pending_solution")
	private String pendingSolution;
	
	@Column(name="invoice_number")
	private String invoiceNumber;
	
	@Column(name="invoice_reference")
	private String invoiceReference;
	
	@Column(name="delivery_name")
	private String deliveryName;
	
	@Column(name="pending_invoice")
	private Boolean pendingInvoice;
	
	@Column(name="payment_method")
	private String paymentMethod;
	
	@Column(name="sri_aut")
	private String sriAut;
	
	public Order(){
		this.status = "registered";
		this.hasItems = "0";
		this.pending = Boolean.FALSE;
		this.pendingInvoice = Boolean.TRUE;
	}

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

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public Customer getClient() {
		return client;
	}

	public void setClient(Customer client) {
		this.client = client;
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
	
	
	

	public String getVitexStatus() {
		return vitexStatus;
	}

	public void setVitexStatus(String vitexStatus) {
		this.vitexStatus = vitexStatus;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getCreditNote() {
		return creditNote;
	}

	public void setCreditNote(String creditNote) {
		this.creditNote = creditNote;
	}
	
	

	public String getHasItems() {
		return hasItems;
	}

	public void setHasItems(String hasItems) {
		this.hasItems = hasItems;
	}
	
	

	public Catalog getMotiveCancel() {
		return motiveCancel;
	}

	public void setMotiveCancel(Catalog motiveCancel) {
		this.motiveCancel = motiveCancel;
	}

	public String getMotiveCancelText() {
		return motiveCancelText;
	}

	public void setMotiveCancelText(String motiveCancelText) {
		this.motiveCancelText = motiveCancelText;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}
	
	

	public Boolean getPending() {
		return pending;
	}

	public void setPending(Boolean pending) {
		this.pending = pending;
	}

	public String getMotivePending() {
		return motivePending;
	}

	public void setMotivePending(String motivePending) {
		this.motivePending = motivePending;
	}

	public String getPendingSolution() {
		return pendingSolution;
	}

	public void setPendingSolution(String pendingSolution) {
		this.pendingSolution = pendingSolution;
	}
	
	

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	
	

	public String getInvoiceReference() {
		return invoiceReference;
	}

	public void setInvoiceReference(String invoiceReference) {
		this.invoiceReference = invoiceReference;
	}
	
	

	public Boolean getPendingInvoice() {
		return pendingInvoice;
	}

	public void setPendingInvoice(Boolean pendingInvoice) {
		this.pendingInvoice = pendingInvoice;
	}
	
	

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	

	public String getSriAut() {
		return sriAut;
	}

	public void setSriAut(String sriAut) {
		this.sriAut = sriAut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderInfo == null) ? 0 : orderInfo.hashCode());
		result = prime * result + ((serial == null) ? 0 : serial.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
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
		Order other = (Order) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderInfo == null) {
			if (other.orderInfo != null)
				return false;
		} else if (!orderInfo.equals(other.orderInfo))
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
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
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

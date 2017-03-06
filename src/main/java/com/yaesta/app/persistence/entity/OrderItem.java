package com.yaesta.app.persistence.entity;

import java.io.Serializable;
import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "order_item",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderItem implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -218395980318608280L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_seq_gen")
	@SequenceGenerator(name = "order_item_seq_gen", sequenceName = "order_item_id_seq")
	private Long id;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="item_info")
	private String itemInfo;
	
	@Column(name = "vitex_id") //id de la orden en vitex
	private String vitexId;
	
	@Column(name="price")  //precio del item
	private Double price;
	
	@Column(name="unit_price")  //precio del item
	private Double unitPrice;
	
	@Column(name="discount")  //descuento
	private Double discount;
	
	@Column(name="quantity")  //cantidad de producto
	private Long quantity;
	
	@Column(name="customer_value")  //precio del item que paga el cliente
	private Double customerValue;
	
	@Column(name="value_receivables")  //precio que se cobra en caso de pago contra entrega
	private Double valueReceivables;
	
	@JsonBackReference
	@JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Order order;
	
	@JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Product product;
	
	@JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Customer client;
	
	@JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Supplier supplier;
	
	@Column(name="order_sequence") //secuencia de la orden
	private String orderSequence;
	
	@Column(name="supplier_name") //nombre del proveedor
	private String supplierName;
	
	@Column(name="way_to_pay") //forma de pago
	private String wayToPay;
	
	@Column(name="customer_document") //documento del producto
	private String customerDocument;
	
	@Column(name="customer_name") //documento del producto
	private String customerName;
	
	@Column(name="customer_address") //direccion del cliente
	private String customerAddress;
	
	@Column(name="customer_phone") //telefono del cliente
	private String customerPhone;
	
	@Column(name="customer_state") //provincia del cliente
	private String customerState;
	
	@Column(name="customer_canton") //canton del cliente
	private String customerCanton;
	
	@Column(name="product_description") //descripcion del producto
	private String productDescription;
	
	@Column(name="product_key") //id del producto en vtex
	private String productKey;
	
	@Column(name="order_date",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	@Column(name="order_status") //estado de la orden en vitex
	private String orderStatus;
	
	@Column(name="status_description") //estado de la orden en vitex
	private String statusDescription;
	
	@Column(name="brand_name")
	private String brandName;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="sku_id")
	private String skuId;
	
	@Column(name="is_warehouse")
	private Boolean isWarehouse;
	
	@Column(name="item_vtex_id")
	private String itemVTexId;
	
	@Column(name="invoice_reference")
	private String invoiceReference;
	
	@Column(name="invoice_number")
	private String invoiceNumber;
	
	@Column(name="guide_number")
	private String guideNumber;
	
	@Column(name="delivery_name")
	private String deliveryName;
	
	@Column(name="str_guide_date")
	private String strGuideDate;
	
	@Column(name="guide_date")
	private Date guideDate;
	
	@Column(name="item_partial_value")
	private Double itemPartialValue;
	
	@Column(name="guide_value")
	private Double guideValue;
	
	@Column(name="programmed_date")
	private Date programmedDate;
	
	@Column(name="sri_aut")
	private String sriAut;
	
	public OrderItem(){
		isWarehouse=Boolean.FALSE;
		itemPartialValue=0D;
		guideValue=0D;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}

	public String getVitexId() {
		return vitexId;
	}

	public void setVitexId(String vitexId) {
		this.vitexId = vitexId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getClient() {
		return client;
	}

	public void setClient(Customer client) {
		this.client = client;
	}

	public String getOrderSequence() {
		return orderSequence;
	}

	public void setOrderSequence(String orderSequence) {
		this.orderSequence = orderSequence;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getWayToPay() {
		return wayToPay;
	}

	public void setWayToPay(String wayToPay) {
		this.wayToPay = wayToPay;
	}

	public String getCustomerDocument() {
		return customerDocument;
	}

	public void setCustomerDocument(String customerDocument) {
		this.customerDocument = customerDocument;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		String strPhone =customerPhone;
		return strPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public String getCustomerCanton() {
		return customerCanton;
	}

	public void setCustomerCanton(String customerCanton) {
		this.customerCanton = customerCanton;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductKey() {
		String strProductKey = productKey;
		return strProductKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Double getCustomerValue() {
		return customerValue;
	}

	public void setCustomerValue(Double customerValue) {
		this.customerValue = customerValue;
	}

	public Double getValueReceivables() {
		return valueReceivables;
	}

	public void setValueReceivables(Double valueReceivables) {
		this.valueReceivables = valueReceivables;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public Boolean getIsWarehouse() {
		return isWarehouse;
	}

	public void setIsWarehouse(Boolean isWarehouse) {
		this.isWarehouse = isWarehouse;
	}

	public String getItemVTexId() {
		return itemVTexId;
	}

	public void setItemVTexId(String itemVTexId) {
		this.itemVTexId = itemVTexId;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getGuideNumber() {
		return guideNumber;
	}

	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}

	public String getInvoiceReference() {
		return invoiceReference;
	}

	public void setInvoiceReference(String invoiceReference) {
		this.invoiceReference = invoiceReference;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getStrGuideDate() {
		return strGuideDate;
	}

	public void setStrGuideDate(String strGuideDate) {
		this.strGuideDate = strGuideDate;
	}

	public Date getGuideDate() {
		return guideDate;
	}

	public void setGuideDate(Date guideDate) {
		this.guideDate = guideDate;
	}

	public Double getItemPartialValue() {
		return itemPartialValue;
	}

	public void setItemPartialValue(Double itemPartialValue) {
		this.itemPartialValue = itemPartialValue;
	}

	public Double getGuideValue() {
		return guideValue;
	}

	public void setGuideValue(Double guideValue) {
		this.guideValue = guideValue;
	}

	public Date getProgrammedDate() {
		return programmedDate;
	}

	public void setProgrammedDate(Date programmedDate) {
		this.programmedDate = programmedDate;
	}

	public String getSriAut() {
		return sriAut;
	}

	public void setSriAut(String sriAut) {
		this.sriAut = sriAut;
	}
	
	
	
	
	
}

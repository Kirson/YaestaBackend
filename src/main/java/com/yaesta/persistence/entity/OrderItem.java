package com.yaesta.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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

@Entity
@Table(name = "order_item",schema="yaesta")
public class OrderItem implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -218395980318608280L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_seq_gen")
	@SequenceGenerator(name = "order_item_seq_gen", sequenceName = "order_item_id_seq")
	private Long id;
	
	@org.hibernate.annotations.Type(type="com.yaesta.persistence.util.SQLXMLType")
	@Column(name="item_info")
	private String itemInfo;
	
	@Column(name = "vitex_id")
	private String vitexId;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="quantity")
	private Long quantity;
	
	@JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Order order;
	
	@JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Product product;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
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
	
	
	
	
}

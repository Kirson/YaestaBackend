package com.yaesta.app.persistence.entity;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "guide_detail",schema="yaesta")
public class GuideDetail implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2464723887512761721L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guide_detail_seq_gen")
	@SequenceGenerator(name = "guide_detail_seq_gen", sequenceName = "guide_detail_id_seq")
	private Long id;
	
	@Column(name = "serial")
	private String serial;
	
	@Column(name = "vitex_id")
	private String vitexId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "product_vitex_id")
	private String productVitexId;
	
	@Column(name = "order_vitex_id")
	private String orderVitexId;
	
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="item_info")
	private String itemInfo;
	
	@JsonBackReference
	@JoinColumn(name = "guide_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Guide guide;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_id")
	private String itemId;

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

	public String getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
	}

	public String getProductVitexId() {
		return productVitexId;
	}

	public void setProductVitexId(String productVitexId) {
		this.productVitexId = productVitexId;
	}

	public String getOrderVitexId() {
		return orderVitexId;
	}

	public void setOrderVitexId(String orderVitexId) {
		this.orderVitexId = orderVitexId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	
	
}

package com.yaesta.integration.vitex.wsdl.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="OrderItemVO")
public class OrderItemVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1057241685443822882L;
	private String productRefId;
	private String productName;
	private String productId;
	private String productVitexId;
	private BigDecimal cost;
	private BigDecimal shippingCost;
	private BigDecimal totalDiscount;
	private List<ItemDiscountVO> discounts;
	
	public OrderItemVO(){
		discounts = new ArrayList<ItemDiscountVO>();
		totalDiscount = new BigDecimal(0);
	}
	
	
	public String getProductRefId() {
		return productRefId;
	}
	public void setProductRefId(String productRefId) {
		this.productRefId = productRefId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductVitexId() {
		return productVitexId;
	}
	public void setProductVitexId(String productVitexId) {
		this.productVitexId = productVitexId;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public BigDecimal getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}


	public List<ItemDiscountVO> getDiscounts() {
		return discounts;
	}


	public void setDiscounts(List<ItemDiscountVO> discounts) {
		this.discounts = discounts;
	}


	public BigDecimal getTotalDiscount() {
		return totalDiscount;
	}


	public void setTotalDiscount(BigDecimal totalDiscount) {
		this.totalDiscount = totalDiscount;
	}
	
	
}

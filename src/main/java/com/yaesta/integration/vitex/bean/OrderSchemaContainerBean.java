package com.yaesta.integration.vitex.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yaesta.integration.vitex.json.bean.OrderBean;
import com.yaesta.integration.vitex.json.bean.OrderComplete;
import com.yaesta.integration.vitex.json.bean.OrderSchema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "schemalist",
    "orderList",
    "orderBeanList",
    "totalPages",
    "searchPages"
})
public class OrderSchemaContainerBean implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("schemaList")
	private List<OrderSchema> schemaList;
	@JsonProperty("orderList")
	private List<OrderComplete> orderList;
	@JsonProperty("orderBeanList")
	private List<OrderBean>  orderBeanList;
	@JsonProperty("totalPages")
	private Long totalPages;
	@JsonProperty("searchPages")
	private List<Long> searchPages;
	
	public OrderSchemaContainerBean(){
		schemaList = new ArrayList<OrderSchema>();
		orderList = new ArrayList<OrderComplete>();
		orderBeanList = new ArrayList<OrderBean>();
		searchPages = new ArrayList<Long>();
	}

	@JsonProperty("schemaList")
	public List<OrderSchema> getSchemaList() {
		return schemaList;
	}

	@JsonProperty("schemaList")
	public void setSchemaList(List<OrderSchema> schemaList) {
		this.schemaList = schemaList;
	}

	@JsonProperty("orderList")
	public List<OrderComplete> getOrderList() {
		return orderList;
	}

	@JsonProperty("orderList")
	public void setOrderList(List<OrderComplete> orderList) {
		this.orderList = orderList;
	}
	
	@JsonProperty("orderBeanList")
	public List<OrderBean> getOrderBeanList() {
		return orderBeanList;
	}

	@JsonProperty("orderBeanList")
	public void setOrderBeanList(List<OrderBean> orderBeanList) {
		this.orderBeanList = orderBeanList;
	}

	@JsonProperty("totalPages")
	public Long getTotalPages() {
		return totalPages;
	}

	@JsonProperty("totalPages")
	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	@JsonProperty("searchPages")
	public List<Long> getSearchPages() {
		return searchPages;
	}

	@JsonProperty("searchPages")
	public void setSearchPages(List<Long> searchPages) {
		this.searchPages = searchPages;
	}
	
	
	
}

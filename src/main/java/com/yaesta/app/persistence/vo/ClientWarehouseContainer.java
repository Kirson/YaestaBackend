package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
	"customers"
})
@SuppressWarnings("serial")
public class ClientWarehouseContainer implements Serializable {

	private List<ClientWarehouseVO> customers;
	
	public ClientWarehouseContainer(){
		customers = new ArrayList<ClientWarehouseVO>();
	}

	public List<ClientWarehouseVO> getCustomers() {
		return customers;
	}

	public void setCustomers(List<ClientWarehouseVO> customers) {
		this.customers = customers;
	}
	
	
	
}

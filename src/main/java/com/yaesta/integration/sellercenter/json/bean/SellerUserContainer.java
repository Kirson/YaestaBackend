package com.yaesta.integration.sellercenter.json.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "users"
})
public class SellerUserContainer implements Serializable{
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1645486205802434485L;
	@JsonProperty("users")
	private List<SellerUser> users;
	
	public SellerUserContainer(){
		users= new ArrayList<SellerUser>();
	}
	
	@JsonProperty("users")
	public List<SellerUser> getUsers() {
		return users;
	}

	@JsonProperty("users")
	public void setUsers(List<SellerUser> users) {
		this.users = users;
	}
	
	

}

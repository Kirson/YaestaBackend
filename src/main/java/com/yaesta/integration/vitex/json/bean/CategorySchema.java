package com.yaesta.integration.vitex.json.bean;

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
    "list"
})
public class CategorySchema implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4641984437214504767L;
	
	@JsonProperty("list")
	private List<CategoryVtex> list;
	
	public CategorySchema(){
		list=new ArrayList<CategoryVtex>();
	}

	@JsonProperty("list")
	public List<CategoryVtex> getList() {
		return list;
	}

	@JsonProperty("list")
	public void setList(List<CategoryVtex> list) {
		this.list = list;
	}
	
	
}

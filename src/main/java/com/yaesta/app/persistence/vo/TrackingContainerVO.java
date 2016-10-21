package com.yaesta.app.persistence.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "trackingList"
})
public class TrackingContainerVO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 8056740260354492467L;
	@JsonProperty("trackingList")
	private List<TrackingVO> trackingList;
	
	public TrackingContainerVO(){
		trackingList = new ArrayList<TrackingVO>();
	}

	public List<TrackingVO> getTrackingList() {
		return trackingList;
	}

	public void setTrackingList(List<TrackingVO> trackingList) {
		this.trackingList = trackingList;
	}
	
	
}

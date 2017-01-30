package com.yaesta.app.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "guide_process",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GuideProcess implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2254646446265371217L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guide_process_seq_gen")
	@SequenceGenerator(name = "guide_process_seq_gen", sequenceName = "guide_process_id_seq")
	private Long id;
	
	
	@Column(name="process_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date processDate;
	
	@Column(name="closed_date")
	private Boolean closedDate;
	
	@Column(name="total_guides")
	private Long totalGuides;
	
	@Column(name="num_programmed")
	private Long numProgrammed;
	
	@Column(name="num_pending")
	private Long numPending;
	
	@Column(name="num_delivery_pending")
	private Long numDeliveryPending;
	
	@Column(name="num_canceled")
	private Long numCanceled;
	
	@Column(name="num_delivery")
	private Long numDelivery;
	
	@Transient
	private String strClosedDate;
	
	
	public GuideProcess(){
		closedDate = Boolean.FALSE;
		strClosedDate = "No";
		totalGuides=0L;
		numProgrammed=0L;
		numPending=0L;
		numDeliveryPending=0L;
		numCanceled=0L;
		numDelivery=0L;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public Boolean getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Boolean closedDate) {
		this.closedDate = closedDate;
	}

	public Long getTotalGuides() {
		return totalGuides;
	}

	public void setTotalGuides(Long totalGuides) {
		this.totalGuides = totalGuides;
	}

	public Long getNumProgrammed() {
		return numProgrammed;
	}

	public void setNumProgrammed(Long numProgrammed) {
		this.numProgrammed = numProgrammed;
	}

	public Long getNumPending() {
		return numPending;
	}

	public void setNumPending(Long numPending) {
		this.numPending = numPending;
	}

	public Long getNumDeliveryPending() {
		return numDeliveryPending;
	}

	public void setNumDeliveryPending(Long numDeliveryPending) {
		this.numDeliveryPending = numDeliveryPending;
	}

	public Long getNumCanceled() {
		return numCanceled;
	}

	public void setNumCanceled(Long numCanceled) {
		this.numCanceled = numCanceled;
	}

	public Long getNumDelivery() {
		return numDelivery;
	}

	public void setNumDelivery(Long numDelivery) {
		this.numDelivery = numDelivery;
	}

	public String getStrClosedDate() {
		return strClosedDate;
	}

	public void setStrClosedDate(String strClosedDate) {
		this.strClosedDate = strClosedDate;
	}
	
	@PostLoad
	public void postLoad(){
		
		if(closedDate){
			strClosedDate = "Si";
		}else{
			strClosedDate = "No";
		}
	}
	

}

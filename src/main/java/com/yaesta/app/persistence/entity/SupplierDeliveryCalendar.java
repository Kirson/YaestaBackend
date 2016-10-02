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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "supplier_Delivery_Calendar",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SupplierDeliveryCalendar implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -2502137813176700688L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplierdc_seq_gen")
	@SequenceGenerator(name = "supplierdc_seq_gen", sequenceName = "supplier_delivery_calendar_id_seq")
	private Long id;
	
	@Column(name="monday_deliver")
	private Integer mondayDeliver;
	
	@Column(name="monday_timestamp",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mondayTimestamp;
	
	@Column(name="tuesday_deliver")
	private Integer tuesdayDeliver;
	
	@Column(name="tuesdayTimestamp",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tuesdayTimestamp;
	
	@Column(name="wednesday_deliver")
	private Integer wednesdayDeliver;
	
	@Column(name="wednesday_timestamp",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date wednesdayTimestamp;
	
	@Column(name="thursday_deliver")
	private Integer thursdayDeliver;
	
	@Column(name="thursday_timestamp",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date thursdayTimestamp;
	
	@Column(name="friday_deliver")
	private Integer fridayDeliver;
	
	@Column(name="friday_timestamp",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fridayTimestamp;
	
	@Column(name="saturday_deliver")
	private Integer saturdayDeliver;
	
	@Column(name="saturday_timestamp",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date saturday_timestamp;
	
	@Column(name="sunday_deliver")
	private Integer sundayDeliver;
	
	@Column(name="sunday_timestamp",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sundayTimestamp;
	
	@JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
	private Supplier supplier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMondayDeliver() {
		return mondayDeliver;
	}

	public void setMondayDeliver(Integer mondayDeliver) {
		this.mondayDeliver = mondayDeliver;
	}

	public Date getMondayTimestamp() {
		return mondayTimestamp;
	}

	public void setMondayTimestamp(Date mondayTimestamp) {
		this.mondayTimestamp = mondayTimestamp;
	}

	public Integer getTuesdayDeliver() {
		return tuesdayDeliver;
	}

	public void setTuesdayDeliver(Integer tuesdayDeliver) {
		this.tuesdayDeliver = tuesdayDeliver;
	}

	public Date getTuesdayTimestamp() {
		return tuesdayTimestamp;
	}

	public void setTuesdayTimestamp(Date tuesdayTimestamp) {
		this.tuesdayTimestamp = tuesdayTimestamp;
	}

	public Integer getWednesdayDeliver() {
		return wednesdayDeliver;
	}

	public void setWednesdayDeliver(Integer wednesdayDeliver) {
		this.wednesdayDeliver = wednesdayDeliver;
	}

	public Date getWednesdayTimestamp() {
		return wednesdayTimestamp;
	}

	public void setWednesdayTimestamp(Date wednesdayTimestamp) {
		this.wednesdayTimestamp = wednesdayTimestamp;
	}

	public Integer getThursdayDeliver() {
		return thursdayDeliver;
	}

	public void setThursdayDeliver(Integer thursdayDeliver) {
		this.thursdayDeliver = thursdayDeliver;
	}

	public Date getThursdayTimestamp() {
		return thursdayTimestamp;
	}

	public void setThursdayTimestamp(Date thursdayTimestamp) {
		this.thursdayTimestamp = thursdayTimestamp;
	}

	public Integer getFridayDeliver() {
		return fridayDeliver;
	}

	public void setFridayDeliver(Integer fridayDeliver) {
		this.fridayDeliver = fridayDeliver;
	}

	public Date getFridayTimestamp() {
		return fridayTimestamp;
	}

	public void setFridayTimestamp(Date fridayTimestamp) {
		this.fridayTimestamp = fridayTimestamp;
	}

	public Integer getSaturdayDeliver() {
		return saturdayDeliver;
	}

	public void setSaturdayDeliver(Integer saturdayDeliver) {
		this.saturdayDeliver = saturdayDeliver;
	}

	public Date getSaturday_timestamp() {
		return saturday_timestamp;
	}

	public void setSaturday_timestamp(Date saturday_timestamp) {
		this.saturday_timestamp = saturday_timestamp;
	}

	public Integer getSundayDeliver() {
		return sundayDeliver;
	}

	public void setSundayDeliver(Integer sundayDeliver) {
		this.sundayDeliver = sundayDeliver;
	}

	public Date getSundayTimestamp() {
		return sundayTimestamp;
	}

	public void setSundayTimestamp(Date sundayTimestamp) {
		this.sundayTimestamp = sundayTimestamp;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
}

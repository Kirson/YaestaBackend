package com.yaesta.app.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "guide_migrate",schema="yaesta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GuideMigrate implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -7528559036486982076L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guide_migrate_seq_gen")
	@SequenceGenerator(name = "guide_migrate_seq_gen", sequenceName = "guide_migrate_id_seq")
	private Long id;

	@Column(name = "guide_number")
	private String guideNumber;
	
	@Column(name = "delivery_status")
	private String deliveryStatus;
	
	@Column(name = "observation")
	private String observation;
	
	@Column(name = "payment_acepted")
	private String paymentAcepted;
	
	@Column(name = "pod")
	private String pod;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGuideNumber() {
		return guideNumber;
	}

	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getPaymentAcepted() {
		return paymentAcepted;
	}

	public void setPaymentAcepted(String paymentAcepted) {
		this.paymentAcepted = paymentAcepted;
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}
	
	
	
}

package com.yaesta.app.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "yaesta_log",schema="yaesta")
public class YaEstaLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "yaesta_log_id_seq")
	@SequenceGenerator(name = "yaesta_log_id_seq", sequenceName = "yaesta_log_id_seq")
	private Long id;
	
	@Column(name="process_name")
	private String processName;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="xml_info")
	private String xmlInfo;
	
	@Column(name="error_info")
	private String errorInfo;
	
	@org.hibernate.annotations.Type(type="com.yaesta.app.persistence.util.SQLXMLType")
	@Column(name="addional_info")
	private String additionalInfo;
	
	@Column(name="text_info")
	private String textinfo;
	
	@Column(name="log_date",columnDefinition="TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date logDate;
	
	@Column(name="order_id")
	private String orderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getXmlInfo() {
		return xmlInfo;
	}

	public void setXmlInfo(String xmlInfo) {
		this.xmlInfo = xmlInfo;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getTextinfo() {
		return textinfo;
	}

	public void setTextinfo(String textinfo) {
		this.textinfo = textinfo;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
}

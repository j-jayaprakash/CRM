package com.jsp.appservice.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="app_service")
@EntityListeners(AuditingEntityListener.class)
public class AppService implements Serializable{
	
	@Id
	@GenericGenerator(name="auto-reg",strategy="increment")
	@GeneratedValue(generator="auto-reg")
	@Column(name="alt_key")
	private int altKey;
	
	
	@Column(name="service_name")
	private String serviceName;
	
	@Column(name="service_url")
	private String serviceUrl;
	
	@Column(name="status")
	private String status;
	
	@Column(name = "created_date", updatable = false)
	@CreatedDate
	private LocalDate createdDate;
	
	@Column(name = "modified_date", insertable = false)
	@LastModifiedDate
	private LocalDate modifiedDate;

	public int getAltKey() {
		return altKey;
	}

	public void setAltKey(int altKey) {
		this.altKey = altKey;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "AppService [altKey=" + altKey + ", serviceName=" + serviceName + ", serviceUrl=" + serviceUrl
				+ ", status=" + status + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	

}

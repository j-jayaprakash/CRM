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
@Table(name = "app_properties")
@EntityListeners(AuditingEntityListener.class)
public class AppProperties implements Serializable {

	@Id
	@GenericGenerator(name = "auto-reg", strategy = "increment")
	@GeneratedValue(generator = "auto-reg")
	@Column(name = "alt_key")
	private int altKey;

	@Column(name = "module_name", nullable = false)
	private String moduleName;

	@Column(name = "property_key", unique = true)
	private String propertyKey;

	@Column(name = "property_value", nullable = false)
	private String propertyValue;

	@Column(name = "created_date", updatable = false)
	@CreatedDate
	private LocalDate createdDate;

	@Column(name = "modified_date", insertable = false)
	@LastModifiedDate
	private LocalDate modifiedDate;

	@Column(name = "created_by")

	private String createdBy;

	@Column(name = "modified_by")
	private String modifiedBy;

	public int getAltKey() {
		return altKey;
	}

	public void setAltKey(int altKey) {
		this.altKey = altKey;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getPropertyKey() {
		return propertyKey;
	}

	public void setPropertyKey(String propertyKey) {
		this.propertyKey = propertyKey;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "AppProperties [altKey=" + altKey + ", moduleName=" + moduleName + ", propertyKey=" + propertyKey
				+ ", propertyValue=" + propertyValue + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
	}

}

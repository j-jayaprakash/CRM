package com.jsp.integration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.jdbc.core.RowMapper;

@Table(name = "customer_details")
@Entity
public class CustomerDetails {

	@Id
	@Column(name = "uniqe_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long uniqeId;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "telephone_number", unique = true)
	private String telephoneNumber;
	@Column(name = "sms_status")
	private String smsStatus;

	public long getUniqeId() {
		return uniqeId;
	}

	public void setUniqeId(long uniqeId) {
		this.uniqeId = uniqeId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getSmsStatus() {
		return smsStatus;
	}

	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}

	@Override
	public String toString() {
		return "CustomerDetails [uniqeId=" + uniqeId + ", customerName=" + customerName + ", telephoneNumber="
				+ telephoneNumber + ", smsStatus=" + smsStatus + "]";
	}

	
}

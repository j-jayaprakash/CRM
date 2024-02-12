package com.jsp.integration.dto;

import java.io.Serializable;

import javax.persistence.Column;

public class CustomerDetailsDto implements Serializable {

	private String customerName;
	private String telephoneNumber;

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



}

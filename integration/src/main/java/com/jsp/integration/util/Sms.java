package com.jsp.integration.util;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sms implements Serializable {

	@Value("${twilio.accountSid}")
	private String accountSid;

	@Value("${twilio.phoneNumber}")
	private String phoneNumber;

	@Value("${twilio.authToken}")
	private String authToken;

	@Value("${twilio.senderId}")
	private String senderId;
	
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getPhone() {
		return phoneNumber;
	}

	public void setPhone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

}

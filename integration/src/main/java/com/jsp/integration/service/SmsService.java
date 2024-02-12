package com.jsp.integration.service;

import com.jsp.integration.dto.CustomerDetailsDto;
import com.jsp.integration.dto.SmsDetailsDto;

public interface SmsService {

	public String sendMessage(String to,String message);
	
	public String createTemplate(SmsDetailsDto smsDetDto);
	
	public String saveCustomer(CustomerDetailsDto customerDto);
	
	public String prepareTemplate(long uId, String tempId);
	
}

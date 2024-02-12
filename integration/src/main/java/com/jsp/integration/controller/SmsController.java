package com.jsp.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.integration.dto.CustomerDetailsDto;
import com.jsp.integration.dto.SmsDetailsDto;
import com.jsp.integration.service.SmsServiceImpl;

@RestController
public class SmsController {

	@Autowired
	public SmsServiceImpl messageServiceImpl;


	@PostMapping("/add_template")
	public @ResponseBody String addTemplate(@RequestBody SmsDetailsDto smsDetails) {

		return messageServiceImpl.createTemplate(smsDetails);
	}
	
	@PostMapping("/add_customer")
	public @ResponseBody String addCustomer(@RequestBody CustomerDetailsDto customerDetailsDto ) {
		
		return messageServiceImpl.saveCustomer(customerDetailsDto);
	}
	
	@PostMapping("/send_real_sms/{userId},{templateId}")
	
	public @ResponseBody String sendRealSms(long userId , String templateId) {
		return  messageServiceImpl.prepareTemplate(userId , templateId );
	}

}

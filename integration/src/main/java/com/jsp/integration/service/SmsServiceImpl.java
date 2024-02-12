package com.jsp.integration.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.integration.dto.CustomerDetailsDto;
import com.jsp.integration.dto.SmsDetailsDto;
import com.jsp.integration.dto.TemplatePlaceholderDto;
import com.jsp.integration.entity.CustomerDetails;
import com.jsp.integration.entity.TemplateObjectEntity;
import com.jsp.integration.util.EDUtil;
import com.jsp.integration.util.Sms;
import com.jsp.integration.util.TemplatePlaceholder;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsServiceImpl implements SmsService {

	@Autowired
	public Sms sms;

	@Autowired
	ModelMapper mapper;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	RestTemplate rt;

	@Override
	public String sendMessage(String to, String message) {

		try {
			Twilio.init(sms.getAccountSid(), sms.getAuthToken());
			Message.creator(new PhoneNumber(to), new PhoneNumber(sms.getSenderId()), message).create();
		} catch (Exception e) {
			return "sms sent failed , because of " + e.getMessage();
		}
		return " SMS Sent Successfully ";

	}

	@Override
	public String prepareTemplate(long cId, String tempId) {

		Map<String, Object> tempMap = jdbcTemplate.queryForMap("select * from sms_details where template_code = ?",
				tempId);
		Map<String, Object> customerMap = jdbcTemplate.queryForMap("select * from customer_details where uniqe_id = ?",
				cId);

		TemplateObjectEntity templateObjDto = new TemplateObjectEntity();

		templateObjDto.setTemplateCode(tempMap.get("template_code").toString());
		templateObjDto.setEntityId(tempMap.get("entity_id").toString());
		templateObjDto.setTemplateSubject(tempMap.get("template_subject").toString());
		templateObjDto.setTemplateContent(EDUtil.decode(tempMap.get("template_content").toString()));
		templateObjDto.setTemplatePlaceholder(
				null != tempMap.get("template_placeholder") ? tempMap.get("template_placeholder").toString() : null);

		CustomerDetails customerDetDto = new CustomerDetails();
		customerDetDto.setCustomerName(customerMap.get("customer_name").toString());
		customerDetDto.setTelephoneNumber(customerMap.get("telephone_number").toString());

		TemplatePlaceholderDto placeHolders = null;
		
		try {
			placeHolders = objectMapper.readValue(templateObjDto.getTemplatePlaceholder(),
					TemplatePlaceholderDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		String content = templateObjDto.getTemplateContent();
		StringBuilder msg = new StringBuilder();

		msg.append("Subject : " + templateObjDto.getTemplateSubject() + " , ");

		if (null == placeHolders || placeHolders.getTemplatePlaceholders().size() == 0)
			msg.append(content);
		else {
			for (int i = 0; i < placeHolders.getTemplatePlaceholders().size(); i++) {
				TemplatePlaceholder each = placeHolders.getTemplatePlaceholders().get(i);
				content = content.replaceAll("[$][{]" + each.getPlaceholder() + "[}]",
						customerMap.get(each.getEntityFieldName()).toString());
			}
			msg.append(content);
		}

//		String sendMessage = sendMessage(customerDetDto.getTelephoneNumber(), msg.toString());

		return msg.toString();// sendMessage + " , " + msg;

	}

	@Override
	public String createTemplate(SmsDetailsDto smsDetDto) {

		TemplateObjectEntity templateEntity = mapper.map(smsDetDto, TemplateObjectEntity.class);

		try {
			templateEntity.setTemplatePlaceholder(objectMapper.writeValueAsString(smsDetDto.getTemplatePlaceholders()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		String query = "insert into sms_details (template_code,entity_id,template_subject,template_content,template_placeholder,created_date,created_by,modified_date,modified_by) values (?,?,?,?,?,?,?,?,?)";

		int queryForRowSet = jdbcTemplate.update(query, templateEntity.getTemplateCode(), templateEntity.getEntityId(),
				templateEntity.getTemplateSubject(), EDUtil.encode(smsDetDto.getTemplateContent()),
				templateEntity.getTemplatePlaceholder(), LocalDate.now(), templateEntity.getCreatedBy(),
				templateEntity.getModifiedDate(), templateEntity.getModifiedBy());
		return "template added " + queryForRowSet;

	}

	@Override
	public String saveCustomer(CustomerDetailsDto customerDto) {

		CustomerDetails customerDetails = mapper.map(customerDto, CustomerDetails.class);

		String query = "insert into customer_details (customer_name,telephone_number) values (?,?)";

		int insert = jdbcTemplate.update(query, customerDetails.getCustomerName(),
				customerDetails.getTelephoneNumber());
		return "Custemer Added " + insert;
	}

}

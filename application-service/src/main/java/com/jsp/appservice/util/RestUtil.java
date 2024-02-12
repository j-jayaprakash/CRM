package com.jsp.appservice.util;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestUtil {
	
//	public static Map<String,String> invokeApi(String url,HttpMethod type,Object requestBody,RestProperties restProperties,RestTemplate restTemplate){
//		ResponseEntity<RestProperties> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, RestProperties.class);
//		RestProperties properties = responseEntity.getBody();
//		ObjectMapper.
//		return null;
//	}
}

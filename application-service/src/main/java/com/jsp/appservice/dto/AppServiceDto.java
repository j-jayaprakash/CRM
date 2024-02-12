package com.jsp.appservice.dto;

import java.io.Serializable;

public class AppServiceDto implements Serializable {

	private String serviceName;
	
	private String serviceUrl;

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
	
}

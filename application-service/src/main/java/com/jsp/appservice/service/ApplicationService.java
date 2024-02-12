package com.jsp.appservice.service;

import com.jsp.appservice.dto.AppPropertiesDto;
import com.jsp.appservice.dto.AppResponseDto;
import com.jsp.appservice.dto.AppServiceDto;

public interface ApplicationService {

	public AppResponseDto processCreateProperties(AppPropertiesDto appPropertiesDto);
	public AppResponseDto processGetProperties();
	public AppResponseDto processGetPropertiesByModuleName(String moduleName);
	public AppResponseDto processGetPropertiesByPropertyKey(String propertyKey);
	public AppResponseDto processRegisterService(AppServiceDto appServiceDto);
	public AppResponseDto processGetAppServiceByServiceName(String serviceName);
}

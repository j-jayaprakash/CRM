package com.jsp.appservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.appservice.constants.ApplicationServiceConstants;
import com.jsp.appservice.dto.AppPropertiesDto;
import com.jsp.appservice.dto.AppResponseDto;
import com.jsp.appservice.dto.AppServiceDto;
import com.jsp.appservice.service.ApplicationServiceImpl;


/**This controller class is used to receive the request and map it to requested method by using url and it send 
 * the response to the requested area
 * @RestController annotation is the combination of both @controller and @ResponsBody annotations 
 */

@RestController
public class ApplicationServiceController {

	@Autowired
	private ApplicationServiceImpl applicationServiceImpl;
	
	
	@PostMapping(value=ApplicationServiceConstants.CREATE_PROPERTIES)
	public @ResponseBody AppResponseDto createProperties(@RequestBody AppPropertiesDto appPropertiesDto) {
		AppResponseDto dto = applicationServiceImpl.processCreateProperties(appPropertiesDto);
		return dto;
	}
	
	@GetMapping(value=ApplicationServiceConstants.GET_PROPERTIES)
	public @ResponseBody AppResponseDto getProperties() {
		AppResponseDto dto = applicationServiceImpl.processGetProperties();
		return dto;
	}
	
	
	@GetMapping(value=ApplicationServiceConstants.GET_PROPERTIES_BY_MODULE_NAME)
	public @ResponseBody AppResponseDto getPropertiesByModuleName(@RequestParam String moduleName) {
		AppResponseDto dto = applicationServiceImpl.processGetPropertiesByModuleName(moduleName);
		return dto;
	}
	
	@GetMapping(value=ApplicationServiceConstants.GET_PROPERTIES_BY_PROPERTY_KEY)
	public @ResponseBody AppResponseDto getPropertiesByPropertyKey(@PathVariable("propertyKey") String propertyKey) {
		AppResponseDto dto = applicationServiceImpl.processGetPropertiesByPropertyKey(propertyKey);
		return dto;
	}
	
	@PostMapping(value=ApplicationServiceConstants.REGISTER_SERVICE)
	public @ResponseBody AppResponseDto registerService(@RequestBody AppServiceDto appServiceDto) {
		AppResponseDto dto = applicationServiceImpl.processRegisterService(appServiceDto);
		return dto;
	}
	
	@GetMapping(value=ApplicationServiceConstants.GET_APP_SERVICE_BY_SERVICE_NAME)
	public @ResponseBody AppResponseDto getAppServiceByServiceName(@PathVariable String serviceName) {
		AppResponseDto dto = applicationServiceImpl.processGetAppServiceByServiceName(serviceName);
		return dto;
	}
}

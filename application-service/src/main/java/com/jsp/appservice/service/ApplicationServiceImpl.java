package com.jsp.appservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.appservice.dto.AppPropertiesDto;
import com.jsp.appservice.dto.AppResponseDto;
import com.jsp.appservice.dto.AppServiceDto;
import com.jsp.appservice.entity.AppProperties;
import com.jsp.appservice.entity.AppService;
import com.jsp.appservice.repository.AppPropertiesRepository;
import com.jsp.appservice.repository.AppServiceRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private AppPropertiesRepository appPropertiesRepository;
	
	@Autowired
	private AppServiceRepository appServiceRepository;
	
	@Override
	public AppResponseDto processCreateProperties(AppPropertiesDto appPropertiesDto) {
		 AppProperties appProperties = new AppProperties();
		 appProperties.setModuleName(appPropertiesDto.getModuleName());
		 appProperties.setPropertyKey(appPropertiesDto.getPropertykey());
		 appProperties.setPropertyValue(appPropertiesDto.getPropertyValue());
		 appProperties.setCreatedBy(appPropertiesDto.getUserName());
		 try {
			 AppProperties properties = appPropertiesRepository.save(appProperties);
			 if(properties==null) {
				 return new AppResponseDto("FAILURE", "500", null, null);
			 }
			 return new AppResponseDto("SUCCESS", "200", properties, null);
		 }
		 catch(Exception e) {
			return new AppResponseDto("FAILURE", "500", null, e.getLocalizedMessage()); 
		 }
	
	}

	@Override
	public AppResponseDto processGetProperties() {
		try {
			List<AppProperties> list = appPropertiesRepository.findAll();
			if(list.size()==0) {
				return new AppResponseDto("FAILURE", "500", null, "no records found");
			}
			return new AppResponseDto("SUCCESS", "200", list, null);
		}
		catch(Exception e) {
			return new AppResponseDto("FAILURE", "500", null, e.getLocalizedMessage());
		}
		
	}
	

	
	@Override
	public AppResponseDto processGetPropertiesByModuleName(String moduleName) {
		try {
			List<AppProperties> list = appPropertiesRepository.findByModuleName(moduleName);
			if(list.size()==0) {
				return new AppResponseDto("FAILURE", "500", null, null);
			}
			return new AppResponseDto("SUCCESS", "200", list, null);
		}
		catch(Exception e) {
			return new AppResponseDto("FAILURE", "500", null, e.getLocalizedMessage());
		}
	}

	@Override
	public AppResponseDto processGetPropertiesByPropertyKey(String propertyKey) {
		try {
			AppProperties appProperties = appPropertiesRepository.findByPropertyKey(propertyKey);
			if(appProperties==null) {
				return new AppResponseDto("FAILURE", "500", null, null);
			}
			return new AppResponseDto("SUCCESS", "200", appProperties,null);
		}
		catch(Exception e) {
			return new AppResponseDto("FAILURE", "500", null, e.getLocalizedMessage());
		}
	}

	@Override
	public AppResponseDto processRegisterService(AppServiceDto appServiceDto) {
		AppService appService = new AppService();
		appService.setServiceName(appServiceDto.getServiceName());
		appService.setServiceUrl(appServiceDto.getServiceUrl());
		appService.setStatus("SUCCESS");
		try {
			AppService service = appServiceRepository.save(appService);
			if(service==null) {
				return new AppResponseDto("FAILURE", "500", null, null);
			}
			return new AppResponseDto("SUCCESS", "200", service, null);
		}
		catch(Exception e) {
			return new AppResponseDto("FAILURE","500",null, e.getLocalizedMessage());
		}
	}

	@Override
	public AppResponseDto processGetAppServiceByServiceName(String serviceName) {
		try {
			AppService service = appServiceRepository.findByServiceName(serviceName);
			if(service==null) {
				return new AppResponseDto("FAILURE", "500",null, null);
			}
			return new AppResponseDto("SUCCESS", "200",service, null);
		}
		catch(Exception e) {
			return new AppResponseDto("FAILURE", "500",null, e.getLocalizedMessage());
		}
	}

}

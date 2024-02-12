package com.jsp.appservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.appservice.entity.AppService;

public interface AppServiceRepository extends JpaRepository<AppService, Integer> {
	
	public AppService findByServiceName(String serviceName);

}

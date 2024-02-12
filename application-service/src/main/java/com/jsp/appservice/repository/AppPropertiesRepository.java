package com.jsp.appservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.appservice.entity.AppProperties;

public interface AppPropertiesRepository extends JpaRepository<AppProperties, Integer> {
	
	public List<AppProperties> findByModuleName(String moduleName);
	
	public AppProperties findByPropertyKey(String propertyKey);

}

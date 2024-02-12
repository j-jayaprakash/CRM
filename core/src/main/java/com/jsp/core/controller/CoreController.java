package com.jsp.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.core.Dto.ReadRequestDto;
import com.jsp.core.service.CoreService;


@RestController
public class CoreController {

	@Autowired
	CoreService cser;
	
	@PostMapping(value = "/genarate_query")
	public @ResponseBody String read(@RequestBody ReadRequestDto dto) {
		
				return cser.formSqlQuery(dto);
		

	}
}

package com.jsp.core.service;

import java.util.List;

import com.jsp.core.Dto.ReadRequestDto;
import com.jsp.core.util.Clauses;
import com.jsp.core.util.Projections;

public interface CoreService {
	
	public String formSqlQuery(ReadRequestDto readRequestDto);
	
	
	public String createClauses(List<Clauses> clause);
	
	
	public String createProjections(List<Projections> projection);

}

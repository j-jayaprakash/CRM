package com.jsp.core.Dto;

import java.io.Serializable;
import java.util.List;

import com.jsp.core.util.Filter;
import com.jsp.core.util.Projections;

public class ReadRequestDto implements Serializable {

	private String entityName;
	private List<Projections> projections;
	private Filter filter;
	private String orderBy;

	public ReadRequestDto() {
		// TODO Auto-generated constructor stub
	}
	

	public ReadRequestDto(String entityName, List<Projections> projections, Filter filter, String orderBy) {
		super();
		this.entityName = entityName;
		this.projections = projections;
		this.filter = filter;
		this.orderBy = orderBy;
	}



	public String getEntityName() {
		return entityName;
	}



	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}



	public List<Projections> getProjections() {
		return projections;
	}



	public void setProjections(List<Projections> projections) {
		this.projections = projections;
	}



	public Filter getFilter() {
		return filter;
	}



	public void setFilter(Filter filter) {
		this.filter = filter;
	}



	public String getOrderBy() {
		return orderBy;
	}



	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}



	@Override
	public String toString() {
		return "ReadRequestDto [entityName=" + entityName + ", projections=" + projections + ", filter=" + filter
				+ ", orderBy=" + orderBy + "]";
	}

	
}

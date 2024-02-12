package com.jsp.core.util;

public class Projections {

	private String fieldName;
	
	public Projections() {
		// TODO Auto-generated constructor stub
	}
	

	public Projections(String fieldName) {
		super();
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public String toString() {
		return "Projections [fieldName=" + fieldName + "]";
	}

}

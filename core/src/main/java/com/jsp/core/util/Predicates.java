package com.jsp.core.util;

import java.util.List;

public class Predicates {

	private String dimension;
	private String operator;
	private Object value;
	private List<Object> range;
	private List<Object> list;
	
	
	public Predicates() {
		// TODO Auto-generated constructor stub
	}

	public Predicates(String dimension, String operator, Object value, List<Object> range, List<Object> list) {
		super();
		this.dimension = dimension;
		this.operator = operator;
		this.value = value;
		this.range = range;
		this.list = list;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public List<Object> getRange() {
		return range;
	}

	public void setRange(List<Object> range) {
		this.range = range;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Predicates [dimension=" + dimension + ", operator=" + operator + ", value=" + value + ", range=" + range
				+ ", list=" + list + "]";
	}

}

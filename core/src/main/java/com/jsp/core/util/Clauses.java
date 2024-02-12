package com.jsp.core.util;

import java.util.List;

public class Clauses {
	
	private String type;
	private List<Predicates> predicates;
	
	public Clauses() {
	}
	
	
	
	public Clauses(String type, List<Predicates> predicates) {
		super();
		this.type = type;
		this.predicates = predicates;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Predicates> getPredicates() {
		return predicates;
	}
	public void setPredicates(List<Predicates> predicates) {
		this.predicates = predicates;
	}
	@Override
	public String toString() {
		return "Clause [type=" + type + ", predicates=" + predicates + "]";
	}
	
	
	
	

}

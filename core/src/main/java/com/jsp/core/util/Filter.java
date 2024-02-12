package com.jsp.core.util;

import java.util.List;

public class Filter {
	
	private List<Clauses> clause;
	
	public Filter() {
		// TODO Auto-generated constructor stub
	}

	public Filter(List<Clauses> clause) {
		super();
		this.clause = clause;
	}

	public List<Clauses> getClauses() {
		return clause;
	}

	public void setClauses(List<Clauses> clauses) {
		this.clause = clauses;
	}

	@Override
	public String toString() {
		return "Filter [clause=" + clause + "]";
	}
	
	

}

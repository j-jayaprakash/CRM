package com.jsp.integration.util;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TemplatePlaceholder implements Serializable {

	@JsonProperty("entityFieldName")
	private String entityFieldName;
	@JsonProperty("placeholder")
	private String placeholder;

	public String getEntityFieldName() {
		return entityFieldName;
	}

	public void setEntityFieldName(String entityFieldName) {
		this.entityFieldName = entityFieldName;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	@Override
	public String toString() {
		return "TemplatePlaceholder [entityFieldName=" + entityFieldName + ", placeholder=" + placeholder + "]";
	}

	
}

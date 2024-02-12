package com.jsp.integration.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jsp.integration.util.TemplatePlaceholder;

public class TemplatePlaceholderDto implements Serializable{

	@JsonProperty("templatePlaceholders")
	private List<TemplatePlaceholder> templatePlaceholders;

	public List<TemplatePlaceholder> getTemplatePlaceholders() {
		return templatePlaceholders;
	}

	public void setTemplatePlaceholders(List<TemplatePlaceholder> templatePlaceholders) {
		this.templatePlaceholders = templatePlaceholders;
	}

	@Override
	public String toString() {
		return "TemplatePlaceholderDto [templatePlaceholders=" + templatePlaceholders + "]";
	}

}

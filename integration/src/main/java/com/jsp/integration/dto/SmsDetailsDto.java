package com.jsp.integration.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class SmsDetailsDto implements Serializable {

	private String templateCode;
	private String entityId;
	private String templateSubject;
	private String templateContent;
	private TemplatePlaceholderDto templatePlaceholders;
	private String createdBy;
	private String modifiedBy;

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getTemplateSubject() {
		return templateSubject;
	}

	public void setTemplateSubject(String templateSubject) {
		this.templateSubject = templateSubject;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}
	




	public TemplatePlaceholderDto getTemplatePlaceholders() {
		return templatePlaceholders;
	}

	public void setTemplatePlaceholders(TemplatePlaceholderDto templatePlaceholders) {
		this.templatePlaceholders = templatePlaceholders;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "SmsDetailsDto [templateCode=" + templateCode + ", entityId=" + entityId + ", templateSubject="
				+ templateSubject + ", templateContent=" + templateContent + ", templatePlaceholders="
				+ templatePlaceholders + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
	}

}

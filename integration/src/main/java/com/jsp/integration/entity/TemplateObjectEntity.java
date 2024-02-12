package com.jsp.integration.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jsp.integration.dto.TemplatePlaceholderDto;
import com.jsp.integration.util.TemplatePlaceholder;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "sms_details")
public class TemplateObjectEntity {

	@Id
	@GenericGenerator(name = "inc", strategy = "increment")
	@GeneratedValue(generator = "inc")
	@Column(name = "alt_key")
	private long altKey;
	@Column(name = "template_code")
	private String templateCode;
	@Column(name = "entity_id")
	private String entityId;
	@Column(name = "template_subject")
	private String templateSubject;
	@Column(name = "template_content")
	private String templateContent;
	@Column(name = "template_placeholder")
	private String templatePlaceholder;
	@CreatedDate
	@Column(name = "created_date", updatable = false)
	private LocalDate createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@LastModifiedDate
	@Column(name = "modified_date", insertable = false)
	private LocalDate modifiedDate;
	@Column(name = "modified_by")
	private String modifiedBy;

	public long getAltKey() {
		return altKey;
	}

	public void setAltKey(long altKey) {
		this.altKey = altKey;
	}

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



	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "SmsDetails [altKey=" + altKey + ", templateCode=" + templateCode + ", entityId=" + entityId
				+ ", templateSubject=" + templateSubject + ", templateContent=" + templateContent
				+ ", templatePlaceholder=" + templatePlaceholder + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", modifiedDate=" + modifiedDate + ", modifiedBy=" + modifiedBy + "]";
	}

	public String getTemplatePlaceholder() {
		return templatePlaceholder;
	}

	public void setTemplatePlaceholder(String templatePlaceholder) {
		this.templatePlaceholder = templatePlaceholder;
	}

}

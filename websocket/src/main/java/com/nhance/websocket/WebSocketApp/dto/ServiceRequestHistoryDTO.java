package com.nhance.websocket.WebSocketApp.dto;

import java.util.Date;

public class ServiceRequestHistoryDTO {

	private Long serviceRequestHistoryId;
	private String serviceRequestNumber;
	private String status;
	private String serviceRequestMessage;
	private String attachedDocument;
	private String attachedDocumentFileName;
	private String attachedDocumentFormat;
	private String createdBy;
	private Date createdDate;
	private byte[] customerPhoto;
	private String archiveId;
	private String sessionId;
	
	
	public Long getServiceRequestHistoryId() {
		return serviceRequestHistoryId;
	}
	public void setServiceRequestHistoryId(Long serviceRequestHistoryId) {
		this.serviceRequestHistoryId = serviceRequestHistoryId;
	}
	public String getServiceRequestNumber() {
		return serviceRequestNumber;
	}
	public void setServiceRequestNumber(String serviceRequestNumber) {
		this.serviceRequestNumber = serviceRequestNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getServiceRequestMessage() {
		return serviceRequestMessage;
	}
	public void setServiceRequestMessage(String serviceRequestMessage) {
		this.serviceRequestMessage = serviceRequestMessage;
	}
	public String getAttachedDocument() {
		return attachedDocument;
	}
	public void setAttachedDocument(String attachedDocument) {
		this.attachedDocument = attachedDocument;
	}
	public String getAttachedDocumentFileName() {
		return attachedDocumentFileName;
	}
	public void setAttachedDocumentFileName(String attachedDocumentFileName) {
		this.attachedDocumentFileName = attachedDocumentFileName;
	}
	public String getAttachedDocumentFormat() {
		return attachedDocumentFormat;
	}
	public void setAttachedDocumentFormat(String attachedDocumentFormat) {
		this.attachedDocumentFormat = attachedDocumentFormat;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public byte[] getCustomerPhoto() {
		return customerPhoto;
	}
	public void setCustomerPhoto(byte[] customerPhoto) {
		this.customerPhoto = customerPhoto;
	}
	public String getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(String archiveId) {
		this.archiveId = archiveId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	
}

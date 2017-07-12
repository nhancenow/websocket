package com.nhance.websocket.WebSocketApp.entity;

import java.io.Serializable;
import java.util.Date;

public class ServiceRequestHistory implements Serializable {
	private static final long serialVersionUID = -8698502914519307480L;
	private Long serviceRequestHistoryId;
	private String serviceRequestNumber;
	private String status;
    private String message;
    private String attachedDocument;
    private String attachedDocumentFilename;
    private String attachedDocumentFormat;
    private String customerId;
    private String customerName;
    private String sessionId;
    private String token;
    private String archiveId;
    private Integer archiveDuration;
    private Integer archiveSize;
    private String comment;
    private String customercareCode;
    private String updatedBy;
    private Date updatedDate;

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


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getAttachedDocument() {
		return attachedDocument;
	}


	public void setAttachedDocument(String attachedDocument) {
		this.attachedDocument = attachedDocument;
	}


	public String getAttachedDocumentFilename() {
		return attachedDocumentFilename;
	}


	public void setAttachedDocumentFilename(String attachedDocumentFilename) {
		this.attachedDocumentFilename = attachedDocumentFilename;
	}


	public String getAttachedDocumentFormat() {
		return attachedDocumentFormat;
	}


	public void setAttachedDocumentFormat(String attachedDocumentFormat) {
		this.attachedDocumentFormat = attachedDocumentFormat;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getSessionId() {
		return sessionId;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getArchiveId() {
		return archiveId;
	}


	public void setArchiveId(String archiveId) {
		this.archiveId = archiveId;
	}


	public Integer getArchiveDuration() {
		return archiveDuration;
	}


	public void setArchiveDuration(Integer archiveDuration) {
		this.archiveDuration = archiveDuration;
	}


	public Integer getArchiveSize() {
		return archiveSize;
	}


	public void setArchiveSize(Integer archiveSize) {
		this.archiveSize = archiveSize;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getCustomercareCode() {
		return customercareCode;
	}


	public void setCustomercareCode(String customercareCode) {
		this.customercareCode = customercareCode;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}

package com.nhance.websocket.WebSocketApp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class ServiceRequest implements Serializable {

	private static final long serialVersionUID = -7668732609118723090L;
    private Long serviceRequestId;
    private String serviceRequestNumber;
    private String serviceRequestSubject;
    private String serviceRequestMessage;
    private String status;
    private String digitalKitCode;
    private String customerId;
    private String sellerId;
    private String attachedDocument;
    private String attachedDocumentFilename;
    private String attachedDocumentFormat;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
    private long locationAddressId;
    
	public Long getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(Long serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	public String getServiceRequestNumber() {
		return serviceRequestNumber;
	}
	public void setServiceRequestNumber(String serviceRequestNumber) {
		this.serviceRequestNumber = serviceRequestNumber;
	}
	public String getServiceRequestSubject() {
		return serviceRequestSubject;
	}
	public void setServiceRequestSubject(String serviceRequestSubject) {
		this.serviceRequestSubject = serviceRequestSubject;
	}
	public String getServiceRequestMessage() {
		return serviceRequestMessage;
	}
	public void setServiceRequestMessage(String serviceRequestMessage) {
		this.serviceRequestMessage = serviceRequestMessage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDigitalKitCode() {
		return digitalKitCode;
	}
	public void setDigitalKitCode(String digitalKitCode) {
		this.digitalKitCode = digitalKitCode;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
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
	public long getLocationAddressId() {
		return locationAddressId;
	}
	public void setLocationAddressId(long locationAddressId) {
		this.locationAddressId = locationAddressId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   

}

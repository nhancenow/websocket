package com.nhance.websocket.WebSocketApp.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class ServiceRequestDTO {
	private String serviceRequestNumber;
	private String serviceRequestSubject;
	private String serviceRequestMessage;
	private String digitalKitCode;
	private String attachedDocument;
	private String attachedDocumentFileName;
	private String attachedDocumentFormat;
	private MultipartFile attachedFile;
	private Date createdDate;
	private Date updatedDate;
//	private String createdDateStr;
	private String createdBy;
	private String updatedBy;
//	private String fromDate;
//	private String toDate;
//	private String customerName;
//	private String createdByName;
	private long locationAddressId;
//	private String productName;
	private String status;
//	private Integer resolved;
//	private Integer closed;
//	private String productImage;
//	private String city;
//	private String pinCode;
	private Map<String, List<String>> additionalProperties;
	
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
	public String getDigitalKitCode() {
		return digitalKitCode;
	}
	public void setDigitalKitCode(String digitalKitCode) {
		this.digitalKitCode = digitalKitCode;
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
	public MultipartFile getAttachedFile() {
		return attachedFile;
	}
	public void setAttachedFile(MultipartFile attachedFile) {
		this.attachedFile = attachedFile;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public long getLocationAddressId() {
		return locationAddressId;
	}
	public void setLocationAddressId(long locationAddressId) {
		this.locationAddressId = locationAddressId;
	}
/*	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
*/	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, List<String>> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, List<String>> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	
		
	/**
	 * The Interface CheckCreateServiceRequest.
	 */
	public interface ValidateCreateServiceRequest {}
	
	/**
	 * The Interface CheckGetServiceRequestDetails.
	 */
	public interface ValidateGetServiceRequest {}
	
	/**
	 * The Interface CheckReplyServiceRequest.
	 */
	public interface ValidateReplyServiceRequest {}
	
	/**
	 * The Interface CheckCloseServiceRequest.
	 */
	public interface ValidateCloseServiceRequest {}
	
	/**
	 * The Interface ValidateLoadServiceRequest.
	 */
	public interface ValidateLoadServiceRequest {}
	
	/**
	 * The Interface ValidateUpdateServiceRequest.
	 */
	public interface ValidateUpdateServiceRequest {}
	
}

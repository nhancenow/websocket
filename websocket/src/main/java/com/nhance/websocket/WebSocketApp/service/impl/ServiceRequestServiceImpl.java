package com.nhance.websocket.WebSocketApp.service.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.nhance.websocket.WebSocketApp.constants.NhanceConstants;
import com.nhance.websocket.WebSocketApp.constants.NhanceErrorConstants;
import com.nhance.websocket.WebSocketApp.dao.ServiceRequestDao;
import com.nhance.websocket.WebSocketApp.dao.ServiceRequestExtnDao;
import com.nhance.websocket.WebSocketApp.dao.ServiceRequestHistoryDao;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO;
import com.nhance.websocket.WebSocketApp.entity.ServiceRequest;
import com.nhance.websocket.WebSocketApp.entity.ServiceRequestExtn;
import com.nhance.websocket.WebSocketApp.entity.ServiceRequestHistory;
import com.nhance.websocket.WebSocketApp.enums.SequenceEnum;
import com.nhance.websocket.WebSocketApp.enums.ServiceRequestStageEnum;
import com.nhance.websocket.WebSocketApp.enums.StatusEnum;
import com.nhance.websocket.WebSocketApp.exception.NhanceApplicationException;
import com.nhance.websocket.WebSocketApp.service.ServiceRequestService;
import com.nhance.websocket.WebSocketApp.utils.FileUtil;
import com.nhance.websocket.WebSocketApp.validator.ServiceRequestValidator;

public class ServiceRequestServiceImpl implements ServiceRequestService {
	@Autowired
	private ServiceRequestValidator serviceRequestValidator;
	
	@Autowired
	private ServiceRequestDao serviceRequestDao;
	
	@Autowired
	private ServiceRequestHistoryDao serviceRequestHistoryDao;
	
	@Autowired
	private ServiceRequestExtnDao serviceRequestExtnDao;
	
	@Autowired
	protected Environment environment;
	
/*	private CustomerDetail customerDetail;
	private Seller seller;
*/	private String serviceRequestNumber;
	
	@Override
	public ServiceRequestDTO createServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException {
	//	serviceRequestValidator.validateCreateServiceRequest(serviceRequestDTO);
		
		// Get the customer detail using digitalKitCode
/*		customerDetail = commonDao.getCustomerDetailByDigitalKitCode(serviceRequestDTO.getDigitalKitCode());
		if (null == customerDetail || customerDetail.getStatus() != StatusEnum.ACTIVE.getCode().intValue()) {
			throw new NhanceApplicationException(NhanceErrorConstants.INVALID_CUSTOMER);
		}
		
		// Get the seller details using digitalKitCode
		seller = commonDao.getSellerByDigitalKitCode(serviceRequestDTO.getDigitalKitCode());
		if (null == seller) {
			throw new NhanceApplicationException(NhanceErrorConstants.INVALID_SELLER);
		}
*/		
		// Location address details has been removed from service request
		// It should be handled separately
		
		
		ServiceRequest serviceRequest = new ServiceRequest();
		convertServiceRequestDTOToServiceRequest(serviceRequestDTO, serviceRequest);
		serviceRequest.setStatus(ServiceRequestStageEnum.NEW.getText());
		serviceRequestDao.save(serviceRequest);
		
		
		ServiceRequestHistory serviceRequestHistory = new ServiceRequestHistory();
		convertServiceRequestDTOToServiceRequestHistory(serviceRequestDTO, serviceRequestHistory);
		serviceRequestHistory.setStatus(ServiceRequestStageEnum.NEW.getText());
		serviceRequestHistoryDao.save(serviceRequestHistory);
		
		saveServiceRequestDTOToServiceRequestExtn(serviceRequestDTO);
		
		return serviceRequestDTO;
	}
	
	@Override
	public ServiceRequestDTO updateServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException {
	//	serviceRequestValidator.validateUpdateServiceRequest(serviceRequestDTO);
		
		// Get the customer detail using digitalKitCode
/*		customerDetail = commonDao.getCustomerDetailByDigitalKitCode(serviceRequestDTO.getDigitalKitCode());
		if (null == customerDetail || customerDetail.getStatus() != StatusEnum.ACTIVE.getCode().intValue()) {
			throw new NhanceApplicationException(NhanceErrorConstants.INVALID_CUSTOMER);
		}
		
		// Get the seller details using digitalKitCode
		seller = commonDao.getSellerByDigitalKitCode(serviceRequestDTO.getDigitalKitCode());
		if (null == seller) {
			throw new NhanceApplicationException(NhanceErrorConstants.INVALID_SELLER);
		}
*/		
		// Location address details has been removed from service request
		// It should be handled separately
		
		ServiceRequest serviceRequest = new ServiceRequest();
		convertServiceRequestDTOToServiceRequest(serviceRequestDTO, serviceRequest);
		serviceRequest.setStatus(ServiceRequestStageEnum.UPDATED.getText());
		serviceRequestDao.save(serviceRequest);
		
		
		ServiceRequestHistory serviceRequestHistory = new ServiceRequestHistory();
		convertServiceRequestDTOToServiceRequestHistory(serviceRequestDTO, serviceRequestHistory);
		serviceRequestHistory.setStatus(ServiceRequestStageEnum.UPDATED.getText());
		serviceRequestHistoryDao.save(serviceRequestHistory);
		
		saveServiceRequestDTOToServiceRequestExtn(serviceRequestDTO);
		
		return serviceRequestDTO;
	}
	
	@Override
	public ServiceRequestDTO getServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException {
		String serviceRequestNumber = serviceRequestDTO.getServiceRequestNumber();
		ServiceRequest serviceRequset = serviceRequestDao.getServiceRequestByRequestNumber(serviceRequestNumber);
		convertServiceRequestToServiceRequestDTO(serviceRequset, serviceRequestDTO);
		
		List<ServiceRequestExtn> serviceRequestExtnList = serviceRequestExtnDao.getServiceRequestExtnByRequestNumber(serviceRequestNumber);
		
		if(serviceRequestExtnList != null && serviceRequestExtnList.size() > 0) {
			Map<String, List<String>> additionalProperties = new HashMap<String, List<String>>();
			
			for (ServiceRequestExtn serviceRequestExtn : serviceRequestExtnList) {
				String key = serviceRequestExtn.getExtnKey();
				if(!additionalProperties.containsKey(key)) {
					additionalProperties.put(key, new ArrayList<String>());
				}
				additionalProperties.get(key).add(serviceRequestExtn.getExtnValue());
			}
			serviceRequestDTO.setAdditionalProperties(additionalProperties);
		}
		
		return serviceRequestDTO;
	}
	
	@Override
	public ServiceRequestDTO closeServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException {
		String serviceRequestNumber = serviceRequestDTO.getServiceRequestNumber();
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestByRequestNumber(serviceRequestNumber);
		serviceRequest.setStatus(ServiceRequestStageEnum.CLOSED.getText());
		serviceRequestDao.save(serviceRequest);
		serviceRequestDTO.setStatus(ServiceRequestStageEnum.CLOSED.getText());
		
		return serviceRequestDTO;
	}
	
	@Override
	public ServiceRequestDTO deleteServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException {
		String serviceRequestNumber = serviceRequestDTO.getServiceRequestNumber();
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequestByRequestNumber(serviceRequestNumber);
		serviceRequest.setStatus(ServiceRequestStageEnum.DELETED.getText());
		serviceRequestDao.save(serviceRequest);
		serviceRequestDTO.setStatus(ServiceRequestStageEnum.DELETED.getText());
		
		return serviceRequestDTO;
	}


	private void convertServiceRequestToServiceRequestDTO(ServiceRequest serviceRequset, ServiceRequestDTO serviceRequestDTO) {
		serviceRequestDTO.setServiceRequestSubject(serviceRequset.getServiceRequestSubject());
		serviceRequestDTO.setServiceRequestMessage(serviceRequset.getServiceRequestMessage());
		serviceRequestDTO.setDigitalKitCode(serviceRequset.getDigitalKitCode());
		serviceRequestDTO.setAttachedDocument(serviceRequset.getAttachedDocument());
		serviceRequestDTO.setAttachedDocumentFileName(serviceRequset.getAttachedDocumentFilename());
		serviceRequestDTO.setAttachedDocumentFormat(serviceRequset.getAttachedDocumentFormat());
	//	serviceRequestDTO.setAttachedFile
		serviceRequestDTO.setCreatedDate(serviceRequset.getCreatedDate());
		serviceRequestDTO.setCreatedBy(serviceRequset.getCreatedBy());
		serviceRequestDTO.setUpdatedDate(serviceRequset.getUpdatedDate());
		serviceRequestDTO.setUpdatedBy(serviceRequset.getUpdatedBy());
		serviceRequestDTO.setLocationAddressId(serviceRequset.getLocationAddressId());
		serviceRequestDTO.setStatus(serviceRequset.getStatus());
	}
	
	private void convertServiceRequestDTOToServiceRequest(ServiceRequestDTO serviceRequestDTO,
			ServiceRequest serviceRequest) {
		serviceRequest.setServiceRequestSubject(serviceRequestDTO.getServiceRequestSubject());
		serviceRequest.setServiceRequestMessage(serviceRequestDTO.getServiceRequestMessage());
		serviceRequest.setStatus(serviceRequestDTO.getStatus());
		serviceRequest.setDigitalKitCode(serviceRequestDTO.getDigitalKitCode());
/*		serviceRequest.setCustomerId(customerDetail.getCustomerCode());
		serviceRequest.setSellerId(seller.getSellerCode());
		serviceRequest.setCreatedBy(customerDetail.getCustomerCode());
		serviceRequest.setCreatedDate(new Date());
		serviceRequest.setUpdatedBy(customerDetail.getCustomerCode());
*/		serviceRequest.setLocationAddressId(serviceRequestDTO.getLocationAddressId());
		serviceRequest.setUpdatedDate(new Date());
		
		serviceRequestNumber = generateServiceRequestNumber();
		serviceRequestDTO.setServiceRequestNumber(serviceRequestNumber);
		serviceRequest.setServiceRequestNumber(serviceRequestNumber);
		
		if (StringUtils.isNotEmpty(serviceRequestDTO.getAttachedDocument())) {
			File dir = null;
			String fileName = null;
			String pickUpFilePath = environment.getRequiredProperty("serviceRequestPickupLoc") + serviceRequest.getServiceRequestNumber();
			try {
				dir = FileUtil.makeDirectory(
						environment.getRequiredProperty("serviceRequestLoc") + serviceRequest.getServiceRequestNumber());
			} catch (Exception e) {
/*				throw new NhanceApplicationException(NhanceErrorConstants.SERVICE_ERROR);
*/			}

			fileName = serviceRequestDTO.getAttachedDocumentFileName() + "." + serviceRequestDTO.getAttachedDocumentFormat();
			FileUtil.writeFileFromEncodedBase64String(serviceRequestDTO.getAttachedDocument(), dir.getPath() + File.separator + fileName);
			serviceRequest.setAttachedDocument(pickUpFilePath + File.separator + fileName);
			serviceRequest.setAttachedDocumentFilename(serviceRequestDTO.getAttachedDocumentFileName());
			serviceRequest.setAttachedDocumentFormat(serviceRequestDTO.getAttachedDocumentFormat());
		}
	}
	
	private void convertServiceRequestDTOToServiceRequestHistory(ServiceRequestDTO serviceRequestDTO, ServiceRequestHistory serviceRequestHistory) {
		serviceRequestHistory.setServiceRequestNumber(serviceRequestNumber);
		serviceRequestHistory.setStatus(serviceRequestDTO.getStatus());
		serviceRequestHistory.setMessage(serviceRequestDTO.getServiceRequestMessage());
/*		serviceRequestHistory.setCustomerId(customerDetail.getCustomerCode());
		serviceRequestHistory.setCustomerName(customerDetail.getCustomeName());
		serviceRequestHistory.setSessionId(); // TODO
		serviceRequestHistory.setToken(token); // TODO
		serviceRequestHistory.setArchiveId(archiveId); // TODO
		serviceRequestHistory.setArchiveDuration(archiveDuration); // TODO
		serviceRequestHistory.setArchiveSize(archiveSize); // TODO
		serviceRequestHistory.setComment(comment); // TODO
		serviceRequestHistory.setCustomercareCode(customercareCode); //TODO
		serviceRequestHistory.setUpdatedBy(customerDetail.getCustomerCode());
*/		serviceRequestHistory.setUpdatedDate(new Date());
		
		if (serviceRequestNumber == null) {
			serviceRequestNumber = generateServiceRequestNumber();
			serviceRequestDTO.setServiceRequestNumber(serviceRequestNumber);
			serviceRequestHistory.setServiceRequestNumber(serviceRequestNumber);
		}
		
		if (StringUtils.isNotEmpty(serviceRequestDTO.getAttachedDocument())) {
			File dir = null;
			String fileName = null;
			String pickUpFilePath = environment.getRequiredProperty("serviceRequestPickupLoc") + serviceRequestHistory.getServiceRequestNumber();
			try {
				dir = FileUtil.makeDirectory(
						environment.getRequiredProperty("serviceRequestLoc") + serviceRequestHistory.getServiceRequestNumber());
			} catch (Exception e) {
/*				throw new NhanceApplicationException(NhanceErrorConstants.SERVICE_ERROR);
*/			}
		
			fileName = serviceRequestDTO.getAttachedDocumentFileName() + "." + serviceRequestDTO.getAttachedDocumentFormat();
			FileUtil.writeFileFromEncodedBase64String(serviceRequestDTO.getAttachedDocument(), dir.getPath() + File.separator + fileName);
			serviceRequestHistory.setAttachedDocument(pickUpFilePath + File.separator + fileName);
			serviceRequestHistory.setAttachedDocumentFilename(serviceRequestDTO.getAttachedDocumentFileName());
			serviceRequestHistory.setAttachedDocumentFormat(serviceRequestDTO.getAttachedDocumentFormat());
		}
	}

	private void saveServiceRequestDTOToServiceRequestExtn(ServiceRequestDTO serviceRequestDTO) {
		if (serviceRequestDTO.getAdditionalProperties() != null && serviceRequestDTO.getAdditionalProperties().size() > 0 ) {
			Map<String, List<String>> additionalProperties = serviceRequestDTO.getAdditionalProperties();
			
			for(Map.Entry<String, List<String>> mapEntry : additionalProperties.entrySet()){
				String key = mapEntry.getKey();
				List<String> values = mapEntry.getValue();
				
				for (String value : values) {
					ServiceRequestExtn serviceRequestExtn = new ServiceRequestExtn();
					serviceRequestExtn.setServiceRequestNumber(serviceRequestNumber);
					serviceRequestExtn.setExtnKey(key);
					serviceRequestExtn.setExtnValue(value);
					
					serviceRequestExtnDao.save(serviceRequestExtn);
				}
			}
		}
	}

	private String generateServiceRequestNumber() {
/*		Long userCodeSequence = commonDao.getNextSequence(SequenceEnum.SERVICE_REQUEST_NUMBER.getName());
		String userCode = StringUtils.leftPad(Long.toString(userCodeSequence),
				SequenceEnum.SERVICE_REQUEST_NUMBER.getMinSeqLength(), NhanceConstants.PADDING_CHAR_ZERO);
		return new StringBuilder().append(SequenceEnum.SERVICE_REQUEST_NUMBER.getCategoryCode()).append(userCode)
				.toString();
*/		return "xyz";
		}
}
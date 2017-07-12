package com.nhance.websocket.WebSocketApp.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nhance.websocket.WebSocketApp.dto.ServiceRequestHistoryDTO;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO;
import com.nhance.websocket.WebSocketApp.exception.NhanceApplicationException;

public interface ServiceRequestService {

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ServiceRequestDTO createServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ServiceRequestDTO updateServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException;
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ServiceRequestDTO getServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException; 
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ServiceRequestDTO closeServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException;
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public ServiceRequestDTO deleteServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException;
	
}

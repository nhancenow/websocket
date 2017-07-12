package com.nhance.websocket.WebSocketApp.request;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO;
import com.nhance.websocket.WebSocketApp.response.Response;
import com.nhance.websocket.WebSocketApp.service.ServiceRequestService;
import com.nhance.websocket.WebSocketApp.service.impl.ServiceRequestServiceImpl;

public class UserRequest extends Request{
	private String requestMessage;
	private Map<String, List<String>> headers;
	private String serviceRequestType;
	
	public UserRequest(String requestMessage, Map<String, List<String>> headers) {
		super(RequestType.USER, requestMessage);
		this.requestMessage = requestMessage;
		this.headers = headers;
	}
	
	@Override
	public ServiceRequestDTO handleRequest() {
		serviceRequestType = headers.get("service_request_type").get(0);
		Gson gson = new Gson();
		ServiceRequestDTO serviceRequestDTO = gson.fromJson(requestMessage, ServiceRequestDTO.class);
		
		ServiceRequestService serviceRequestService = new ServiceRequestServiceImpl();
		
		try {
		if (serviceRequestType.toLowerCase().contains("createservicerequest")) {
			serviceRequestDTO = serviceRequestService.createServiceRequest(serviceRequestDTO);
		} else if (serviceRequestType.toLowerCase().contains("updateservicerequest")) {
			serviceRequestDTO = serviceRequestService.updateServiceRequest(serviceRequestDTO);
		} else if (serviceRequestType.toLowerCase().contains("getservicerequest")) {
			serviceRequestDTO = serviceRequestService.getServiceRequest(serviceRequestDTO);
		} else if (serviceRequestType.toLowerCase().contains("closeservicerequest")) {
			serviceRequestDTO = serviceRequestService.closeServiceRequest(serviceRequestDTO);
		} else if (serviceRequestType.toLowerCase().contains("deleteservicerequest")) {
			serviceRequestDTO = serviceRequestService.deleteServiceRequest(serviceRequestDTO);
		} 
		} catch (Exception e) {
			
		}
		return serviceRequestDTO;
	}	
}

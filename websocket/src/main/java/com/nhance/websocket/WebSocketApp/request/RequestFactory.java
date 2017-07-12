package com.nhance.websocket.WebSocketApp.request;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO;
import com.nhance.websocket.WebSocketApp.response.Response;

public class RequestFactory {
	
	public static ServiceRequestDTO processRequest(String message, Map<String, List<String>> headers) {
		ServiceRequestDTO serviceRequestDTO = null;
		String value = headers.get("request_type").get(0);
		RequestType requestType = RequestType.fromName(value);
    	
		switch(requestType) {
			case USER:
				UserRequest userRequest = new UserRequest(message, headers);
				serviceRequestDTO = userRequest.handleRequest();
				break;
			case ADMIN:
				
				break;
			case CUSTOMER:
				
				break;
			case PARTNER:
				
				break;
			case OUTLET:
	
				break;
			default:
				
		}
		
		return serviceRequestDTO;
	}
}

package com.nhance.websocket.WebSocketApp.request;

import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO;

public class AdminRequest extends Request {
	
	public AdminRequest(String requestMessage) {
		super(RequestType.ADMIN, requestMessage);
		handleRequest();
	}
	
	@Override
	public ServiceRequestDTO handleRequest() {
		return null;
	}
}

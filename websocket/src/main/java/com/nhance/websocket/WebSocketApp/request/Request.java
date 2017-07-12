package com.nhance.websocket.WebSocketApp.request;

import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO;

public abstract class Request {
	private RequestType requestType;
	protected String requestMessage;
	
	public Request(RequestType requestType, String requestMessage) {
		this.requestType = requestType;
		this.requestMessage = requestMessage;
	}
	
	public abstract ServiceRequestDTO handleRequest();

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public String getRequestMessage() {
		return requestMessage;
	}

	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}
	
}

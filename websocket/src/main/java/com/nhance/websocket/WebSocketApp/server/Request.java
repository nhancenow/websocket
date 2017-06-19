package com.nhance.websocket.WebSocketApp.server;

public abstract class Request {
	private RequestType requestType;
	protected RequestMessage requestMessage;
	
	public Request(RequestType requestType, RequestMessage requestMessage) {
		this.requestType = requestType;
		this.requestMessage = requestMessage;
	}
	
	protected abstract void handleRequest();
	
	public RequestType getRequestType() {
		return requestType;
	}
	
	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
}

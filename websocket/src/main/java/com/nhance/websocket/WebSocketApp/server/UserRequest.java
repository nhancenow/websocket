package com.nhance.websocket.WebSocketApp.server;

public class UserRequest extends Request{
	
	public UserRequest(RequestMessage requestMessage) {
		super(RequestType.USER, requestMessage);
		handleRequest();
	}
	
	@Override
	protected void handleRequest() {
		
	}
}

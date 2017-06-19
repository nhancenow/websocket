package com.nhance.websocket.WebSocketApp.server;

public class AdminRequest extends Request {
	
	public AdminRequest(RequestMessage requestMessage) {
		super(RequestType.ADMIN, requestMessage);
		handleRequest();
	}
	
	@Override
	protected void handleRequest() {
		
	}
}

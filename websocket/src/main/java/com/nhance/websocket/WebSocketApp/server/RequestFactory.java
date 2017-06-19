package com.nhance.websocket.WebSocketApp.server;

public class RequestFactory {
	
	public static Request processRequest(RequestType requestType, RequestMessage requestMessage) {
		Request request = null;
		switch(requestType) {
			case USER:
				request = new UserRequest(requestMessage);	
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
		
		
		return request;
	}

}

package com.nhance.websocket.WebSocketApp.request;


public enum RequestType {
	USER 				("user"),
	ADMIN				("admin"),
	CUSTOMER 			("customer"),
	PARTNER				("partner"),
	OUTLET				("outlet"),
	
	UNKNOWN				("unknown")
	;
	
	
	
	private String type;
	
	RequestType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public static RequestType fromName(String name) {
		for (RequestType type : RequestType.values()) {
			if (type.getType().equals(name) || type.name().equals(name)) {
				return type;
			}
		}
		return RequestType.UNKNOWN;
	}

}

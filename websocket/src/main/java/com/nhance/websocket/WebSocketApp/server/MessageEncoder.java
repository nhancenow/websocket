package com.nhance.websocket.WebSocketApp.server;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<RequestMessage> {
	private String seed = "0123456789abcdef";
	
	@Override
	public void init(final EndpointConfig config) {
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	@Override
    public String encode(final RequestMessage message) throws EncodeException {
    	String encryptedString = null;
        String builderString = Json.createObjectBuilder()
                       .add("sender", message.getSender())
                       .add("url", message.getUrl())
                       .add("queryParam", message.getQueryParam())
                       .add("content", message.getContent())
                        .add("method", message.getMethod())
                       .add("date", message.getDate())
                       .build().toString();
        try {
        	encryptedString = CryptUtil.encrypt(builderString, seed);
        } catch (Exception e) {
        }
        return encryptedString;
    }
}

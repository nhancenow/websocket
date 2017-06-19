package com.nhance.websocket.WebSocketApp.server;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class MessageDecoder implements Decoder.Text<RequestMessage> {
	private String seed = "0123456789abcdef";
	
	@Override
	public void init(final EndpointConfig config) {
		
	}
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	public boolean willDecode(final String s) {
		return true;
	}
	
	@Override
	public RequestMessage decode(final String message) throws DecodeException {
		String decryptMessage = null;;
		try {
			decryptMessage = CryptUtil.decrypt(message, seed);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestMessage requestMessage = new RequestMessage();
		JsonObject obj = Json.createReader(new StringReader(decryptMessage)).readObject();
		requestMessage.setSender(obj.getString("sender"));
		requestMessage.setUrl(obj.getString("url"));
		requestMessage.setQueryParam(obj.getString("queryParam"));
		requestMessage.setContent(obj.getString("content"));
		requestMessage.setMethod(obj.getString("ethod"));
		requestMessage.setDate(obj.getString("date"));
		
		return requestMessage;
	}
}

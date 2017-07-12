package com.nhance.websocket.WebSocketApp.response;

public class ResponseMessage {
	private String sender;
	private String content;
	private String method;
	private String date;

	public ResponseMessage() {
		this.sender = null;
		this.content = null;
		this.method = null;
		this.date = null;
	}
	public ResponseMessage(String sender, String content, String method, String date) {
		this.sender = sender;
		this.content = content;
		this.method = method;
		this.date = date;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}

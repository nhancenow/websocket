package com.nhance.websocket.WebSocketApp.response;

import java.util.Date;

public class Response {
	private String sender;
	private String content;
	private Date date;
	

	public Response() {
		sender = null;
		content = null;
		date = null;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

		
}

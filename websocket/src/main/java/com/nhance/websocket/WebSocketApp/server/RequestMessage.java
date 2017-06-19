package com.nhance.websocket.WebSocketApp.server;

import java.util.Date;

public class RequestMessage {
	private String sender;
	private String url;
	private String queryParam;
	private String content;
	private String method;
	private String date;

	public RequestMessage() {
		sender = null;
		url = null;
		queryParam = null;
		content = null;
		method = null;
		date = null;
	}
	
	public RequestMessage(String sender, 
							String url,
							String queryParam,
							String content,
							String method,
							String date) {
		this.sender = sender;
		this.url = url;
		this.queryParam = queryParam;
		this.content = content;
		this.method = method;
		this.date = date;
	}
	
	public String getSender() {
		return this.sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getQueryParam() {
		return this.queryParam;
	}
	
	public void setQueryParam(String queryParam) {
		this.queryParam = queryParam;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getMethod() {
		return this.method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String toString() {
		
		
		return null;
	}
}

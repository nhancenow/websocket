/* Copyright © EasOfTech 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of EasOfTech. You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms and
* conditions entered into with EasOfTech.
*
* Id: NhanceSystemException.java
*
* Date Author Changes
* 7 Jan, 2016 Saroj Created
*/
package com.nhance.websocket.WebSocketApp.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class NhanceSystemException.
 */
public class NhanceSystemException extends RuntimeException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5863269302127204536L;
	
	/** The messages. */
	private List<NhanceApplicationMessage> messages = null;
	
	/**
	 * Instantiates a new corum system exception.
	 *
	 * @param key the key
	 * @param parameters the parameters
	 * @param e the e
	 */
	public NhanceSystemException(String key, Object[] parameters,Throwable e){
		super(e);
		this.addMessage(key, parameters);
	}
	
	/**
	 * Instantiates a new corum system exception.
	 *
	 * @param key the key
	 * @param parameters the parameters
	 */
	public NhanceSystemException(String key, Object[] parameters){
		this.addMessage(key, parameters);
	}	
	
	/**
	 * Instantiates a new corum system exception.
	 *
	 * @param key the key
	 */
	public NhanceSystemException(String key){
		this.addMessage(key, null);
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public List<NhanceApplicationMessage> getMessages() {
		return messages;
	}

	/**
	 * Sets the messages.
	 *
	 * @param messages the new messages
	 */
	public void setMessages(List<NhanceApplicationMessage> messages) {
		this.messages = messages;
	}
	
	/**
	 * Adds the message.
	 *
	 * @param key the key
	 * @param parameters the parameters
	 */
	public void addMessage(String key, Object[] parameters){
		if(messages == null){
			messages = new ArrayList<NhanceApplicationMessage>();
		}
		messages.add(new NhanceApplicationMessage(key, parameters));
	}
}

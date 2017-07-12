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
 * The Class NHanceException.
 */
public class NhanceApplicationException extends Exception {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7287740981822872554L;
	
	/** The messages. */
	private List<NhanceApplicationMessage> messages = null;
	
	/**
	 * Instantiates a new corum application exception.
	 *
	 * @param messages the messages
	 */
	public NhanceApplicationException( List<NhanceApplicationMessage> messages ) {
		
		this.setMessages(messages);
	}
	
	/**
	 * Instantiates a new corum application exception.
	 *
	 * @param key the key
	 * @param parameters the parameters
	 * @param e the e
	 */
	public NhanceApplicationException(String key, Object[] parameters,Throwable e){
		super(e);
		this.addMessage(key, parameters);
	}
	
	/**
	 * Instantiates a new corum application exception.
	 *
	 * @param key the key
	 * @param parameters the parameters
	 */
	public NhanceApplicationException(String key, Object[] parameters){
		this.addMessage(key, parameters);
	}
	
	/**
	 * Instantiates a new corum application exception.
	 *
	 * @param key the key
	 */
	public NhanceApplicationException(String key){
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
	
	/**
	 * Prints the errors.
	 */
	public void printErrors() {

		if( messages != null ) {
			
			for (NhanceApplicationMessage message : messages) {
				
				System.err.println(message.getKey() +  ": " + 
						((message.getParameters() != null && message.getParameters().length > 0 ) ?
								message.getParameters()[0] : ""));
			}
		}
	}
	
	/**
	 * Contains error code.
	 *
	 * @param errorCode the error code
	 * @return true, if successful
	 */
	public boolean containsErrorCode( String errorCode ) {

		if( messages != null ) {
			
			for (NhanceApplicationMessage message : messages) {
				
				if( message.getKey().equals(errorCode)) {
					
					return true;
				}
			}
		}
		return false;
	}
}

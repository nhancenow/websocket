/* Copyright © EasOfTech 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of EasOfTech. You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms and
* conditions entered into with EasOfTech.
*
* Id: NhanceApplicationMessage.java
*
* Date Author Changes
* 7 Jan, 2016 Saroj Created
*/
package com.nhance.websocket.WebSocketApp.exception;

import java.io.Serializable;

/**
 * The Class NhanceApplicationMessage.
 */
public class NhanceApplicationMessage implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8329518251567604229L;
	
	/** The key. */
	private String key;
	
	/** The parameters. */
	private Object[] parameters;
	
	/**
	 * Instantiates a new corum application message.
	 *
	 * @param key the key
	 * @param parameters the parameters
	 */
	public NhanceApplicationMessage(String key, Object... parameters){
		
		this.key = key;
		this.parameters = parameters;
	}
	
	/**
	 * Instantiates a new corum application message.
	 *
	 * @param key the key
	 */
	public NhanceApplicationMessage(String key){
		
		this(key, (Object[])null);
	}
	
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	public Object[] getParameters() {
		return parameters;
	}
	
	/**
	 * Sets the parameters.
	 *
	 * @param parameters the new parameters
	 */
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ApplicationMessage [\n");
		if (key != null)
			builder.append("key=").append(key).append(",\n ");
		builder.append("\n]");
		return builder.toString();
	}
	
}

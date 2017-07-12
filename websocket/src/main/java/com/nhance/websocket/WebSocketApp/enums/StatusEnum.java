/* Copyright © EasOfTech 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of EasOfTech. You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms and
* conditions entered into with EasOfTech.
*
* Id: StatusEnum.java
*
* Date Author Changes
* 19 Dec, 2015 Saroj.Biswal Created
*/
package com.nhance.websocket.WebSocketApp.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class StatusEnum.
 */
public class StatusEnum {

	/** The status map. */
	private static Map<Integer, String> statusMap = new HashMap<Integer, String>();

	/** The Constant ACTIVE. */
	public static final StatusEnum ACTIVE = new StatusEnum(1, "Active");

	/** The Constant INACTIVE. */
	public static final StatusEnum INACTIVE = new StatusEnum(2, "InActive");

	/** The Constant DELETED. */
	public static final StatusEnum DELETED = new StatusEnum(3, "Deleted");
	
	/** The Constant DOWNLOADED. */
	public static final StatusEnum DOWNLOADED = new StatusEnum(4, "Downloaded");
	
	/** The Constant GENERATED. */
	public static final StatusEnum GENERATED = new StatusEnum(5, "Generated");
	
	/** The Constant ONBOARDED. */
	public static final StatusEnum ONBOARDED = new StatusEnum(6, "Onboarded");
	
	/** The Constant SENT. */
	public static final StatusEnum SENT = new StatusEnum(7, "Sent");
	
	/** The Constant FAILED. */
	public static final StatusEnum FAILED = new StatusEnum(8, "Failed");
	
	/** The Constant EXPIRED. */
	public static final StatusEnum EXPIRED = new StatusEnum(9, "Expired");
	
	/** The Constant CLOSED. */
	public static final StatusEnum CLOSED = new StatusEnum(10, "Closed");
	
	/** The Constant OPEN. */
	public static final StatusEnum OPEN = new StatusEnum(11, "Open");
	
	/** The Constant CUSTOMER_REGISTERED. */
	public static final StatusEnum CUSTOMER_REGISTERED = new StatusEnum(12, "Customer Registered");
	
	/** The Constant SUCCESS. */
	public static final StatusEnum SUCCESS = new StatusEnum(13, "Success");
	
	/** The Constant BILL_GENERATED. */
	public static final StatusEnum BILL_GENERATED = new StatusEnum(14, "Bill Generated");
	
	/** The Constant BILL_SEND. */
	public static final StatusEnum BILL_SEND = new StatusEnum(15, "Bill Send");
	
	/** The Constant SCHEDULE_NOTIFICATION. */
	public static final StatusEnum SCHEDULE_NOTIFICATION = new StatusEnum(16, "Active");
	
	/** The Constant UPDATE_SCHEDULE_NOTIFICATION. */
	public static final StatusEnum UPDATE_SCHEDULE_NOTIFICATION = new StatusEnum(17, "Active");
	
	/** The Constant DEACTIVATE_NOTIFICATION. */
	public static final StatusEnum DEACTIVATE_NOTIFICATION = new StatusEnum(18, "InActive");
	
	/** The Constant EMAIL_VERIFIED. */
	public static final StatusEnum EMAIL_VERIFIED = new StatusEnum(19, "Email Verified");
	
	/** The Constant DELETE_NOTIFICATION. */
	public static final StatusEnum DELETE_NOTIFICATION = new StatusEnum(20, "Delete");
	
	/** The Constant PENDING. */
	public static final StatusEnum PENDING = new StatusEnum(21, "Pending");
	
	/** The Constant APPROVED. */
	public static final StatusEnum APPROVED = new StatusEnum(22, "Approved");
	
	/** The Constant REJECTED. */
	public static final StatusEnum REJECTED = new StatusEnum(23, "Rejected");

	/** The code. */
	private Integer code;

	/** The text. */
	private String text;

	/**
	 * Gets the terminal status map.
	 * 
	 * @return the terminal status map
	 */
	public static Map<Integer, String> getStatusMap() {
		return statusMap;
	}

	/**
	 * Instantiates a new status enum.
	 * 
	 * @param code
	 *            the code
	 * @param text
	 *            the text
	 */
	public StatusEnum(Integer code, String text) {
		this.code = code;
		this.text = text;
		String exisintgValue = statusMap.put(code, text);
		if (exisintgValue != null) {

			throw new IllegalArgumentException("The code " + code
					+ " already exists in StatusEEnum");
		}
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the message.
	 * 
	 * @param code
	 *            the code
	 * @return the message
	 */
	public static String getMessage(final Integer code) {
		if (statusMap.get(code) != null) {
			return statusMap.get(code);
		}
		return String.valueOf(code);
	}

}

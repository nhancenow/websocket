/* Copyright © EasOfTech 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of EasOfTech. You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms and
* conditions entered into with EasOfTech.
*
* Id: SequenceEnum.java
*
* Date Author Changes
* 9 Feb, 2016 Saroj Created
*/
package com.nhance.websocket.WebSocketApp.enums;

/**
 * The Enum SequenceEnum.
 */
public enum SequenceEnum {

	/** The entity code. */
	DK_CODE( "10", "dk_code", 6 ),
	
	/** The user code. */
	USER_CODE( "11", "user_code", 6 ),
	
	/** The dk txn id. */
	DK_TXN_ID( "12", "dk_txn_id", 8 ),
	
	/** The invoice no. */
	INVOICE_NO( "INV", "invoice_no", 5 ),
	
	/** The customer code. */
	CUSTOMER_CODE( "13", "customer_code", 6 ),
	
	/** The seller code. */
	SELLER_CODE( "14", "seller_code", 6 ),
	
	/** The service request number. */
	SERVICE_REQUEST_NUMBER( "15", "service_request_number", 6 ),
	
	/** The notification code. */
	NOTIFICATION_CODE( "16", "notification_code", 6 ),
	
	/** The outlet code. */
	OUTLET_CODE( "17", "outlet_code", 6 ),
	
	/** The action code. */
	ACTION_CODE( "18", "action_code", 6 ),
	
	/** The pricing feature code. */
	PRICING_FEATURE_CODE( "19", "pricing_feature_code", 6 ),
	
	/** The rule code. */
	RULE_CODE( "20", "rule_code", 6 ),
	
	/** The mandatory attribute code. */
	MANDATORY_ATTRIBUTE_CODE( "21", "mandatory_attribute_code", 6 );

	/** The name. */
	private String name;

	/** The category code. */
	private String categoryCode;

	/** The min length. */
	private int minSeqLength;

	/**
	 * Instantiates a new sequence enum.
	 *
	 * @param categoryCode the category code
	 * @param name the name
	 * @param minSeqLength the min seq length
	 */
	private SequenceEnum( String categoryCode, String name, int minSeqLength ) {
		this.name = name;
		this.categoryCode = categoryCode;
		this.minSeqLength = minSeqLength;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the category code.
	 *
	 * @return the category code
	 */
	public String getCategoryCode() {
		return categoryCode;
	}

	/**
	 * Gets the min seq length.
	 *
	 * @return the min seq length
	 */
	public int getMinSeqLength() {
		return minSeqLength;
	}

}


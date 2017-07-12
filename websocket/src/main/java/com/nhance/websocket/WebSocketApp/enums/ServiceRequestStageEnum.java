/* Copyright � EasOfTech 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of EasOfTech. You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms and
* conditions entered into with EasOfTech.
*
* Id: ServiceRequestStageEnum.java
*
* Date Author Changes
* 14 Apr, 2016 Saroj Created
*/
package com.nhance.websocket.WebSocketApp.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum ServiceRequestStageEnum.
 */
public enum ServiceRequestStageEnum {

	/** The new. */
	NEW(1, "New" ),
	
	/** The underprogress. */
	UNDERPROGRESS(2, "Under Progress" ),
	
	/** The resolved. */
	RESOLVED(3, "Resolved" ),
	
	/** The resolved. */
	DELETED(4, "Deleted" ),
	
	/** The reopen. */
	REOPEN(5, "Re Open" ),
	
	/** The closed. */
	CLOSED(6, "Closed" ),
	
	/** The updated. */
	UPDATED(6, "Updated" );
	
	/** The code. */
	private Integer code;
	
	/** The text. */
	private String text;
	
	/** The stage map. */
	private static Map<Integer, String> stageMap = new HashMap<Integer, String>();
	
	/** The partial stage map. */
	private static Map<Integer, String> partialStageMap = new HashMap<Integer, String>();

	static {
		for ( ServiceRequestStageEnum serviceRequestStageEnum : ServiceRequestStageEnum.values() ) {
			stageMap.put( serviceRequestStageEnum.getCode(), serviceRequestStageEnum.getText() );
			partialStageMap.put( serviceRequestStageEnum.getCode(), serviceRequestStageEnum.getText() );
		}
	}
	
	/**
	 * Instantiates a new service request stage enum.
	 *
	 * @param code the code
	 * @param text the text
	 */
	private ServiceRequestStageEnum(Integer code, String text) {
		this.code = code;
		this.text = text;
	}
	
	/**
	 * Gets the stage map.
	 *
	 * @return the stage map
	 */
	public static Map<Integer, String> getStageMap() {
		return stageMap;
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
	 * Gets the partial stage map.
	 *
	 * @return the partial stage map
	 */
	public static Map<Integer, String> getPartialStageMap() {
		partialStageMap.remove(ServiceRequestStageEnum.NEW.getCode());
		partialStageMap.remove(ServiceRequestStageEnum.DELETED.getCode());
		return partialStageMap;
	}
	
	/**
	 * Gets the stage type.
	 *
	 * @param code the code
	 * @return the stage type
	 */
	public static String getStageType( final Integer code ) {
		if ( stageMap.get( code ) != null )  {
			return stageMap.get( code );
		}
		return "";
	}
	
}

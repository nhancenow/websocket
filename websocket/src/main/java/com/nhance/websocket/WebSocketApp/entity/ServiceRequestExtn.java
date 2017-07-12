/* Copyright © EasOfTech 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of EasOfTech. You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms and
* conditions entered into with EasOfTech.
*
* Id: ServiceRequestExtn.java
*
* Date Author Changes
* 24 Apr, 2017 Saroj Created
*/
package com.nhance.websocket.WebSocketApp.entity;

import java.io.Serializable;


public class ServiceRequestExtn implements Serializable {
	private static final long serialVersionUID = -6231630039437535403L;
    private Long serviceRequestExtnId;
    private String serviceRequestNumber;
    private String extnKey;
    private String extnValue;

    public Long getServiceRequestExtnId() {
		return serviceRequestExtnId;
	}
	public void setServiceRequestExtnId(Long serviceRequestExtnId) {
		this.serviceRequestExtnId = serviceRequestExtnId;
	}
	public String getServiceRequestNumber() {
		return serviceRequestNumber;
	}
	public void setServiceRequestNumber(String serviceRequestNumber) {
		this.serviceRequestNumber = serviceRequestNumber;
	}
	public String getExtnKey() {
		return extnKey;
	}
	public void setExtnKey(String extnKey) {
		this.extnKey = extnKey;
	}
	public String getExtnValue() {
		return extnValue;
	}
	public void setExtnValue(String extnValue) {
		this.extnValue = extnValue;
	}


}

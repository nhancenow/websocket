/* Copyright © EasOfTech 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of EasOfTech. You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms and
* conditions entered into with EasOfTech.
*
* Id: ServiceRequestValidator.java
*
* Date Author Changes
* 18 Apr, 2016 Saroj Created
*/
package com.nhance.websocket.WebSocketApp.validator;

import com.nhance.websocket.WebSocketApp.exception.NhanceApplicationException;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO;

/**
 * The Interface ServiceRequestValidator.
 */
public interface ServiceRequestValidator {

	/**
	 * Validate create service request.
	 *
	 * @param serviceRequestDTO the service request dto
	 * @throws NhanceApplicationException the nhance application exception
	 */
	public void validateCreateServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException;

	/**
	 * Validate load service request.
	 *
	 * @param serviceRequestDTO the service request dto
	 * @throws NhanceApplicationException the nhance application exception
	 */
	public void validateLoadServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException;

	/**
	 * Validate update service request.
	 *
	 * @param serviceRequestDTO the service request dto
	 * @throws NhanceApplicationException 
	 */
	public void validateUpdateServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException;
	
	/**
	 * Validate get service request details.
	 *
	 * @param serviceRequestDTO the service request dto
	 * @throws NhanceApplicationException the nhance application exception
	 */
	void validateGetServiceRequestDetails(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException;

	/**
	 * Reply service request.
	 *
	 * @param serviceRequestDTO the service request dto
	 * @throws NhanceApplicationException the nhance application exception
	 */
	void replyServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException;

	/**
	 * Close service request.
	 *
	 * @param serviceRequestDTO the service request dto
	 * @throws NhanceApplicationException the nhance application exception
	 */
	void closeServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException;

}

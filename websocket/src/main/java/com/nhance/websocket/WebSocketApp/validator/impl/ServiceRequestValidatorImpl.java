/* Copyright © EasOfTech 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of EasOfTech. You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms and
* conditions entered into with EasOfTech.
*
* Id: ServiceRequestValidatorImpl.java
*
* Date Author Changes
* 18 Apr, 2016 Saroj Created
*/
package com.nhance.websocket.WebSocketApp.validator.impl;

import org.springframework.stereotype.Component;

import com.nhance.websocket.WebSocketApp.exception.NhanceApplicationException;
import com.nhance.websocket.WebSocketApp.validator.BaseValidator;
import com.nhance.websocket.WebSocketApp.validator.ServiceRequestValidator;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO.ValidateCloseServiceRequest;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO.ValidateCreateServiceRequest;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO.ValidateGetServiceRequest;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO.ValidateReplyServiceRequest;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO.ValidateLoadServiceRequest;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO.ValidateUpdateServiceRequest;


/**
 * The Class ServiceRequestValidatorImpl.
 */
@Component("serviceRequestValidator")
public class ServiceRequestValidatorImpl extends BaseValidator<ServiceRequestDTO> implements ServiceRequestValidator {

	/* (non-Javadoc)
	 * @see com.nhance.web.validator.ServiceRequestValidator#validateCreateServiceRequest(com.nhance.web.dto.ServiceRequestDTO)
	 */
	@Override
	public void validateCreateServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException {
		validateDTOGroups(serviceRequestDTO, false, ValidateCreateServiceRequest.class);
	}

	/* (non-Javadoc)
	 * @see com.nhance.web.validator.ServiceRequestValidator#validateLoadServiceRequest(com.nhance.web.dto.ServiceRequestDTO)
	 */
	@Override
	public void validateLoadServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException {
		validateDTOGroups(serviceRequestDTO, false, ValidateLoadServiceRequest.class);
	}

	/* (non-Javadoc)
	 * @see com.nhance.web.validator.ServiceRequestValidator#validateUpdateServiceRequest(com.nhance.web.dto.ServiceRequestDTO)
	 */
	@Override
	public void validateUpdateServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException {
		validateDTOGroups(serviceRequestDTO, false, ValidateUpdateServiceRequest.class);
	}
	
	/* (non-Javadoc)
	 * @see com.nhance.validator.CommonValidator#validateGetServiceRequestDetails(com.nhance.dto.ServiceRequestDTO)
	 */
	@Override
	public void validateGetServiceRequestDetails(ServiceRequestDTO serviceRequestDTO)
			throws NhanceApplicationException {
		validateDTOGroups(serviceRequestDTO, false, ValidateGetServiceRequest.class);
	}

	/* (non-Javadoc)
	 * @see com.nhance.validator.CommonValidator#replyServiceRequest(com.nhance.dto.ServiceRequestDTO)
	 */
	@Override
	public void replyServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException {
		validateDTOGroups(serviceRequestDTO, false, ValidateReplyServiceRequest.class);
	}

	/* (non-Javadoc)
	 * @see com.nhance.validator.CommonValidator#closeServiceRequest(com.nhance.dto.ServiceRequestDTO)
	 */
	@Override
	public void closeServiceRequest(ServiceRequestDTO serviceRequestDTO) throws NhanceApplicationException {
		validateDTOGroups(serviceRequestDTO, false, ValidateCloseServiceRequest.class);
	}

}

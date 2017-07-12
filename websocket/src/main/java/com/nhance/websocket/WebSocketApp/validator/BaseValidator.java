/* Copyright © EasOfTech 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of EasOfTech. You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms and
* conditions entered into with EasOfTech.
*
* Id: BaseValidator.java
*
* Date Author Changes
* 7 Jan, 2016 Saroj Created
*/
package com.nhance.websocket.WebSocketApp.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.groups.Default;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.nhance.websocket.WebSocketApp.constants.NhanceErrorConstants;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO;
import com.nhance.websocket.WebSocketApp.exception.NhanceApplicationException;
import com.nhance.websocket.WebSocketApp.exception.NhanceApplicationMessage;


/**
 * The Class BaseValidator.
 *
 * @param <T> the generic type
 */
public abstract class BaseValidator<T extends ServiceRequestDTO> {

	/** The validator. */
	@Autowired
	private javax.validation.Validator validator;
	
	/**
	 * Validate dto.
	 *
	 * @param dto the dto
	 * @throws NhanceApplicationException the nhance application exception
	 */
	protected void validateDTO( T dto ) throws NhanceApplicationException {

		throwExceptionOnConstraintViolation(validator.validate( dto ));
	}
	
	/**
	 * Validate dto partial.
	 *
	 * @param dto the dto
	 * @param values the values
	 * @throws NhanceApplicationException the nhance application exception
	 */
	protected void validateDTOPartial( T dto, String... values ) throws NhanceApplicationException {

		for (String string : values) {
		
			throwExceptionOnConstraintViolation(validator.validateProperty( dto, string ));
		}
	}
	
	/**
	 * Validate dto groups.
	 *
	 * @param dto the dto
	 * @param includeDefault the include default
	 * @param groups the groups
	 * @throws NhanceApplicationException the nhance application exception
	 */
	protected void validateDTOGroups( T dto, boolean includeDefault, Class<?>... groups ) throws NhanceApplicationException {

		if( includeDefault ) {
			
			Class<?>[] tempGroups = new Class[groups.length + 1];
			for (int i = 0; i < groups.length; i++) {
				
				tempGroups[i] = groups[i];
			}
			tempGroups[groups.length] = Default.class;
			groups = tempGroups;
		}
		throwExceptionOnConstraintViolation(validator.validate( dto, groups ));
	}
	
	/**
	 * Throw exception on constraint violation.
	 *
	 * @param violations the violations
	 * @throws NhanceApplicationException the nhance application exception
	 */
	private void throwExceptionOnConstraintViolation( Set<ConstraintViolation<T>> violations ) throws NhanceApplicationException {

		if(!violations.isEmpty()) {
			
			List<NhanceApplicationMessage> messages = new ArrayList<NhanceApplicationMessage>();
			for (ConstraintViolation<T> violation : violations) {
				
				messages.add(new NhanceApplicationMessage(NhanceErrorConstants.VALIDATION_ERROR, 
						violation.getPropertyPath() + " " + violation.getMessage()));
			}
			throwExceptionOnValidation(messages);
		}
	}
	
	/**
	 * Throw exception on validation.
	 *
	 * @param messages the messages
	 * @throws NhanceApplicationException the nhance application exception
	 */
	protected void throwExceptionOnValidation( List<NhanceApplicationMessage> messages ) throws NhanceApplicationException {

		if( CollectionUtils.isNotEmpty(messages) ) {
			
			throw new NhanceApplicationException(messages);
		}
	}
}

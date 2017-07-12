/* Copyright © EasOfTech 2015. All rights reserved.
*
* This software is the confidential and proprietary information
* of EasOfTech. You shall not disclose such Confidential
* Information and shall use it only in accordance with the terms and
* conditions entered into with EasOfTech.
*
* Id: BaseDao.java
*
* Date Author Changes
* 18 Dec, 2015 Saroj.Biswal Created
*/
package com.nhance.websocket.WebSocketApp.dao;

import java.io.Serializable;
import java.util.List;

/**
 * The Interface BaseDao.
 */
public interface BaseDao {
	
    /**
	 * Save.
	 * 
	 * @param obj
	 *            the obj
	 * @return the serializable
	 */
    public abstract Serializable save(Object obj);
    
    /**
     * Save or update.
     *
     * @param obj the obj
     */
    public abstract void saveOrUpdate(Object obj);

    /**
	 * Update.
	 * 
	 * @param obj
	 *            the obj
	 */
    public abstract void update(Object obj);

    /**
	 * Delete.
	 * 
	 * @param obj
	 *            the obj
	 */
    public abstract void delete(Object obj);
    
    /**
	 * Save list.
	 * 
	 * @param list
	 *            the list
	 */
    public abstract void saveList(@SuppressWarnings("rawtypes") List list);
    
    /**
	 * Flush.
	 */
    public abstract void flush();
    
    /**
     * Gets the next sequence.
     *
     * @param sequenceType the sequence type
     * @return the next sequence
     */
    Long getNextSequence(String sequenceType);
}
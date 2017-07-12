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
package com.nhance.websocket.WebSocketApp.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nhance.websocket.WebSocketApp.dao.BaseDao;

/**
 * The Class BaseDaoImpl.
 */
@Repository
public class BaseDaoImpl implements BaseDao {
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/** The hibernate template. */
	private HibernateTemplate hibernateTemplate;

	/**
	 * Sets the session factory.
	 */
	@Autowired
	public final void setSessionFactory() {

		if (hibernateTemplate == null || sessionFactory != hibernateTemplate.getSessionFactory())
			hibernateTemplate = createHibernateTemplate(sessionFactory);
	}

	/**
	 * Creates the hibernate template.
	 * 
	 * @param sessionFactory
	 *            the session factory
	 * @return the hibernate template
	 */
	protected HibernateTemplate createHibernateTemplate(
			SessionFactory sessionFactory) {

		return new HibernateTemplate(sessionFactory);
	}

	/**
	 * Gets the hibernate template.
	 * 
	 * @return the hibernate template
	 */
	public HibernateTemplate getHibernateTemplate() {

		return hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see com.nhance.dao.base.BaseDao#save(java.lang.Object)
	 */
	public Serializable save(Object obj) {
		return getHibernateTemplate().save(obj);
	}
	
	/* (non-Javadoc)
	 * @see com.nhance.dao.base.BaseDao#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(Object obj) {
		 getHibernateTemplate().saveOrUpdate(obj);
	}

	/* (non-Javadoc)
	 * @see com.nhance.dao.base.BaseDao#update(java.lang.Object)
	 */
	public void update(Object obj) {
		getHibernateTemplate().update(obj);
	}

	/* (non-Javadoc)
	 * @see com.nhance.dao.base.BaseDao#delete(java.lang.Object)
	 */
	public void delete(Object obj) {
		getHibernateTemplate().delete(obj);
	}

	/* (non-Javadoc)
	 * @see com.nhance.dao.base.BaseDao#saveList(java.util.List)
	 */
	public void saveList(@SuppressWarnings("rawtypes") List list) {
		for(Object object : list){
			getHibernateTemplate().save(object);
		}
	}

	/* (non-Javadoc)
	 * @see com.nhance.dao.base.BaseDao#flush()
	 */
	public void flush() {
		getHibernateTemplate().flush() ;		
	}
	
	/* (non-Javadoc)
	 * @see com.nhance.core.dao.BaseDao#getNextSequence(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Long getNextSequence(String string) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		String queryString = "SELECT next_val(?) as seq_val";
		SQLQuery query = session.createSQLQuery(queryString);
		query.addScalar("seq_val", LongType.INSTANCE);
		query.setParameter(0, string);
		List<Long> list = query.list();
		session.close();
		if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * View list.
	 *
	 * @param <T> the generic type
	 * @param baseDTO the base dto
	 * @param criteria the criteria
	 * @param criteriaValues the criteria values
	 * @return the list
	 */
/*	@SuppressWarnings("unchecked")
	public <T> List<T> viewList(BaseDTO baseDTO, Object criteria, Object... criteriaValues){
		List<T> resultList = null;
		if(criteria instanceof DetachedCriteria){
			resultList = (List<T>) getHibernateTemplate().findByCriteria((DetachedCriteria) criteria);
		} else if(criteria instanceof String){
			resultList = (List<T>) getHibernateTemplate().find((String) criteria, criteriaValues);
		} else if(criteria instanceof Query){
			resultList = ((Query) criteria).list();
		}
		resultList = applyPagination(baseDTO, resultList);
		return CollectionUtils.isNotEmpty(resultList) ? resultList : null;
	}
	
	*//**
	 * Apply pagination.
	 *
	 * @param <T> the generic type
	 * @param baseDTO the base dto
	 * @param resultList the result list
	 * @return the list
	 *//*
	public <T> List<T> applyPagination(BaseDTO baseDTO, List<T> resultList) {
		List<T> returnResultList = resultList;
		
		// Old logic, Not Used...
		if(baseDTO.isPaginationRequired()){
			baseDTO.setTotalSize(resultList.size()); 
			resultList = (List<?>) getHibernateTemplate().findByCriteria(criteria, baseDTO.getQueryPageNumber() * NhanceConstants.RESULTS_PER_PAGE, NhanceConstants.RESULTS_PER_PAGE);
		}
		
		if (baseDTO.isPaginationRequired()) {
			returnResultList = new ArrayList<T>();
			baseDTO.setTotalSize(resultList.size());
			if(null == baseDTO.getResultsPerPage()) baseDTO.setResultsPerPage(NhanceConstants.RESULTS_PER_PAGE);
			int loopStart = baseDTO.getQueryPageNumber() * baseDTO.getResultsPerPage();
			int loopEnd = loopStart + baseDTO.getResultsPerPage();
			if (loopEnd > resultList.size()) loopEnd = resultList.size();
			for (int i = loopStart; i < loopEnd; i++) {
				returnResultList.add(resultList	.get(i));
			}
		}
		return returnResultList;
	}
*/
}

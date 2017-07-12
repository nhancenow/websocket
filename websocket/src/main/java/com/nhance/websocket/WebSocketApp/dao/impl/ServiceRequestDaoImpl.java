package com.nhance.websocket.WebSocketApp.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nhance.websocket.WebSocketApp.dao.ServiceRequestDao;
import com.nhance.websocket.WebSocketApp.entity.ServiceRequest;

@Repository
public class ServiceRequestDaoImpl extends BaseDaoImpl implements ServiceRequestDao {
	@SuppressWarnings("unchecked")
	@Override
	public ServiceRequest getServiceRequestByRequestNumber(String serviceRequestNumber) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceRequest.class, "sr");
		criteria.add(Restrictions.eq("sr.serviceRequestNumber", serviceRequestNumber));
		List<ServiceRequest> serviceRequests = (List<ServiceRequest>)getHibernateTemplate().findByCriteria(criteria);
		return CollectionUtils.isNotEmpty(serviceRequests) ? serviceRequests.get(0) : null;
	}
}

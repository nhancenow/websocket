package com.nhance.websocket.WebSocketApp.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.nhance.websocket.WebSocketApp.dao.ServiceRequestExtnDao;
import com.nhance.websocket.WebSocketApp.entity.ServiceRequestExtn;

public class ServiceRequestExtnDaoImpl extends BaseDaoImpl implements ServiceRequestExtnDao{
	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceRequestExtn> getServiceRequestExtnByRequestNumber (String serviceRequestNumber) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceRequestExtn.class, "sre");
		criteria.add(Restrictions.eq("sre.serviceRequestNumber", serviceRequestNumber));
		List<ServiceRequestExtn> serviceRequestExtns = (List<ServiceRequestExtn>)getHibernateTemplate().findByCriteria(criteria);
		return CollectionUtils.isNotEmpty(serviceRequestExtns) ? serviceRequestExtns : null;
	}
}

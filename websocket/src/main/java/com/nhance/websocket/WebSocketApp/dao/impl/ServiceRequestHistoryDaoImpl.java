package com.nhance.websocket.WebSocketApp.dao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.nhance.websocket.WebSocketApp.dao.ServiceRequestHistoryDao;
import com.nhance.websocket.WebSocketApp.entity.ServiceRequestHistory;

public class ServiceRequestHistoryDaoImpl extends BaseDaoImpl implements ServiceRequestHistoryDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceRequestHistory> getServiceRequestHistoryByRequestNumber (String serviceRequestNumber) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceRequestHistory.class, "srh");
		criteria.add(Restrictions.eq("srh.serviceRequestNumber", serviceRequestNumber));
		List<ServiceRequestHistory> serviceRequestHistories = (List<ServiceRequestHistory>)getHibernateTemplate().findByCriteria(criteria);
		return CollectionUtils.isNotEmpty(serviceRequestHistories) ? serviceRequestHistories : null;
	}

}

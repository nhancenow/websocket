package com.nhance.websocket.WebSocketApp.dao;

import java.util.List;

import com.nhance.websocket.WebSocketApp.entity.ServiceRequestHistory;

public interface ServiceRequestHistoryDao extends BaseDao {

	List<ServiceRequestHistory> getServiceRequestHistoryByRequestNumber(String serviceRequestNumber);
}

package com.nhance.websocket.WebSocketApp.dao;

import java.util.List;

import com.nhance.websocket.WebSocketApp.entity.ServiceRequestExtn;

public interface ServiceRequestExtnDao extends BaseDao {

	List<ServiceRequestExtn> getServiceRequestExtnByRequestNumber(String serviceRequestNumber);

}

package com.nhance.websocket.WebSocketApp.dao;

import java.util.List;

import com.nhance.websocket.WebSocketApp.dao.BaseDao;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO;
import com.nhance.websocket.WebSocketApp.entity.ServiceRequest;

public interface ServiceRequestDao extends BaseDao {

	ServiceRequest getServiceRequestByRequestNumber(String serviceRequestNumber);

}

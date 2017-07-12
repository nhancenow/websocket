package com.nhance.websocket.WebSocketApp.client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.HandshakeResponse;

public class ClientConfigurator extends ClientEndpointConfig.Configurator {

	private String [] service_type = {"createservicerequest",
									"updateservicerequest",
									"loadservicerequest",
									"listservicerequest",
									"closeservicerequest",
									"deleteservicerequest"};
    @Override
    public void beforeRequest(Map<String, List<String>> headers) {
        headers.put("service_type", Arrays.asList(service_type[0]));
    }

    @Override
    public void afterResponse(HandshakeResponse handshakeResponse) {
        final Map<String, List<String>> headers = handshakeResponse.getHeaders();
    }
}

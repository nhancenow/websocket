package com.nhance.websocket.WebSocketApp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;
 
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
 
import org.glassfish.tyrus.client.ClientManager;

import com.google.gson.Gson;


@ClientEndpoint (configurator = ClientConfigurator.class)
public class WebSocketClientEndpoint {
 
    private static CountDownLatch latch;
 
    private Logger logger = Logger.getLogger(this.getClass().getName());
 
    @OnOpen
    public void onOpen(Session session) {
    //	logger.info("Connected ... " + session.getId());
    	System.out.println("Connected ... " + session.getId());
    	ClientRequest clientRequest = new ClientRequest("user");
    	Gson gson = new Gson();
		String jsonString = gson.toJson(clientRequest);
		
		try {
            session.getBasicRemote().sendText(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
 
    @OnMessage
    public void onMessage(String message, Session session) {
    	BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
           // logger.info("Received ...." + message);
            System.out.println("Received ...." + message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
      //  logger.info(String.format("Session %s close because of %s", session.getId(), closeReason));
        System.out.println("Session " + session.getId() + " close because of " + closeReason.toString());
        latch.countDown();
    }
 
    public class ClientRequest {
    	String request_type;
    	
    	ClientRequest(String type) {
    		request_type = type;
    	}
    }
    
    public static void main(String[] args) {
        latch = new CountDownLatch(1);
 
        ClientManager client = ClientManager.createClient();
        try {
            client.connectToServer(WebSocketClientEndpoint.class, new URI("ws://localhost:8025/websockets/1234"));
            latch.await();
 
        } catch (DeploymentException | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
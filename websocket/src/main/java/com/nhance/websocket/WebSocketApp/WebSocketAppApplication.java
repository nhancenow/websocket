package com.nhance.websocket.WebSocketApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

import com.nhance.websocket.WebSocketApp.server.WebSocketServer;

@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties
@ImportResource(value= {"classpath:hibernateContext.xml"}) 
public class WebSocketAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketAppApplication.class, args);
		WebSocketServer.runServer();
	}
}

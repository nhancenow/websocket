package com.nhance.websocket.WebSocketApp.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.glassfish.tyrus.server.Server;

import com.nhance.websocket.WebSocketApp.server.WebSocketServerEndpoint;


public class WebSocketServer {
 
/*    public static void main(String[] args) {
        runServer();
    }
*/ 
    public static void runServer() {
   // 	Set<Class<?>> beanClasses = getClassesFromString("WebSocketServerEndpoint.class;WebSocketServerEndpoint.ServerConfigurator.class");
        Server server = new Server("localhost", 8025, "/websockets", WebSocketServerEndpoint.class);
        
   // 	Server server = new Server("localhost", 8025, "/websockets", beanClasses);
    	
        try {
            server.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please press a key to stop the server:");
            reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }
    
    private static Set<Class<?>> getClassesFromString(String rawString) {
        Set<Class<?>> beanClasses = new HashSet<Class<?>>();
        StringTokenizer st = new StringTokenizer(rawString, ";");
        while (st.hasMoreTokens()) {
            String nextClassname = st.nextToken().trim();
            if (!"".equals(nextClassname)) {
                try {
                    beanClasses.add(Class.forName(nextClassname));
                } catch (ClassNotFoundException cnfe) {
                    throw new RuntimeException("Stop: cannot load class: " + nextClassname);
                }
            }
        }
        return beanClasses;
}
}
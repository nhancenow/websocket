package com.nhance.websocket.WebSocketApp.server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.validation.ConstraintViolationException;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nhance.websocket.WebSocketApp.dto.ServiceRequestDTO;
import com.nhance.websocket.WebSocketApp.request.RequestFactory;

//@ServerEndpoint(value = "/{id}", encoders = MessageEncoder.class, decoders = MessageDecoder.class,
@ServerEndpoint(value = "/{id}", configurator = ServerConfigurator.class)
public class WebSocketServerEndpoint {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private String id;
    private final Set<Session> sessions;
    private Map<String, List<String>> headers;
    
    public WebSocketServerEndpoint() {
    	sessions = new HashSet<Session>();
    }
    
    @OnOpen
    public void onOpen(final Session session, EndpointConfig config, @PathParam("id") final String id ) {
        this.id = id;
        sessions.add(session);
        String sessionId = session.getId();
    	logger.info("Connected ... " + sessionId);
    	headers = (Map<String, List<String>>) config.getUserProperties().get("headers");
   		if (!headers.isEmpty()) {
   			Iterator<Map.Entry<String, List<String>>> itr = headers.entrySet().iterator();
   			while (itr.hasNext()) {
				Map.Entry<String, List<String>> pair = itr.next();
				String value = "";
				for (String str : pair.getValue()) {
					value += str + ",";
				}
				logger.info("KEY=" + pair.getKey() + " and VALUES=" + value);
			}
		}

    	
    	// add text based message handler 
    	  session.addMessageHandler(new MessageHandler.Whole<String>() { 
    	 
    	   @Override 
    	   public void onMessage(String message) { 
    		   logger.info(sessionId + ": text message: " + message);
    		   
    		   ServiceRequestDTO serviceRequestDTO = RequestFactory.processRequest(message, headers);
    		   Gson gson = new Gson();
    		   String jsonString = gson.toJson(serviceRequestDTO);
    		   try {
    			   session.getBasicRemote().sendText(jsonString);
    		   } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   } 
    	  }); 
    	 
    	  // add binary based message handler 
    	  session.addMessageHandler(new MessageHandler.Whole<ByteBuffer>() { 
    	 
    	   @Override 
    	   public void onMessage(ByteBuffer buffer) { 
    		   logger.info(sessionId + ": binary message: " 
    	      + new String(buffer.array())); 
    	   } 
    	  });
    }
 
/*    @OnMessage
    public Response onMessage(final RequestMessage message, final Session session) {
    	String content;
    	ObjectMapper objMapper = new ObjectMapper();
    	JsonNode jsonNode = objMapper.readTree(content);
    	String value = jsonNode.findValue("request").asText();
    	
    	
    	Response response = RequestFactory.processRequest(message);
    	session.
    	//String scrambledWord = (String) session.getUserProperties().get("scrambledWord");
     //   return checkLastWordAndSendANewWord(scrambledWord, unscrambledWord, session);
    	return response;
    }
*/ 
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
    	sessions.remove(session);
        logger.info(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }
 
    @OnError 
    public void onError(Session session, Throwable error) {
    	try { 
            if (error.getCause() instanceof ConstraintViolationException) { 
                // Just report the first validation problem. 
                JsonObject jsonObject = Json.createObjectBuilder() 
                        .add("error", 
                                ((ConstraintViolationException) error.getCause()) 
                                .getConstraintViolations().iterator().next() 
                                .getMessage()) 
                        .build(); 
                session.getBasicRemote().sendText(jsonObject.toString()); 
            } else { 
                logger.log(Level.FATAL, null, error); 
            } 
        } catch (IOException ex) { 
            logger.log(Level.FATAL, null, ex); 
        }
    	sessions.remove(session);
    }
    
/*    private String checkLastWordAndSendANewWord(String scrambledWord, String unscrambledWord, Session session) {
        WordRepository repository = WordRepository.getInstance();
        Word word = repository.getWord(scrambledWord);
 
        String nextScrambledWord = repository.getRandomWord().getScrambledWord();
 
        session.getUserProperties().put("scrambledWord", nextScrambledWord);
 
        String correctUnscrambledWord = word.getUnscrambbledWord();
 
        if (word == null || !correctUnscrambledWord.equals(unscrambledWord)) {
            return String.format("You guessed it wrong. Correct answer %s. Try the next one .. %s",
                    correctUnscrambledWord, nextScrambledWord);
        }
        return String.format("You guessed it right. Try the next word ...  %s", nextScrambledWord);
    }
*/  
 /*   public class ServerConfigurator extends ServerEndpointConfig.Configurator {
//    public class ServerConfigurator extends TyrusServerEndpointConfigurator {
    	@Override
        public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
    		headers = request.getHeaders();
    		
    		if (!headers.isEmpty()) {
    			Iterator<Map.Entry<String, List<String>>> itr = headers.entrySet().iterator();
    			while (itr.hasNext()) {
    				Map.Entry<String, List<String>> pair = itr.next();
    				String value = "";
    				for (String str : pair.getValue()) {
    					value += str + ",";
    				}
    				logger.info("KEY=" + pair.getKey() + " and VALUES=" + value);
    			}
    		}
    	}
    }
*/}

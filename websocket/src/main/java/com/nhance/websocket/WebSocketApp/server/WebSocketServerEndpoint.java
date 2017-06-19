package com.nhance.websocket.WebSocketApp.server;

import java.io.IOException;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/{id}", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class WebSocketServerEndpoint {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private String id;
    
    @OnOpen
    public void onOpen(final Session session, @PathParam("id") final String id ) {
        this.id = id; 
    	logger.info("Connected ... " + session.getId());
    }
 
    @OnMessage
    public RequestMessage onMessage(final RequestMessage message, final Session session) {
    	String path = message.getUrl();
    	String user = path.substring(0, path.indexOf("/"));
    	RequestType type = RequestType.fromName(user);
    	
    	switch(type) {
    		case USER:
    			RequestFactory.processRequest(type, message);
    		
    		case ADMIN:
    		
    		
    		case CUSTOMER:
    		
    		
    		case PARTNER:
    			
    			
    		case OUTLET:
    			
    			
    		default:
    			
    	
    	}
    	
    	String scrambledWord = (String) session.getUserProperties().get("scrambledWord");
     //   return checkLastWordAndSendANewWord(scrambledWord, unscrambledWord, session);
    	return null;
    }
 
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }
 
    private String checkLastWordAndSendANewWord(String scrambledWord, String unscrambledWord, Session session) {
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
}

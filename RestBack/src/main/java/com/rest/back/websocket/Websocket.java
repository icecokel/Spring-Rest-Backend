package com.rest.back.websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class Websocket extends TextWebSocketHandler{
	List<WebSocketSession> sessions = new ArrayList<>();
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("afterConnectionEstablished :::" + session.getId());
		
		sessions.add(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("handleTextMessage :::" + message.getPayload());
		String sessionId = session.getId();
		for(WebSocketSession ws : sessions) {
			ws.sendMessage(new TextMessage(sessionId +":"+ message.getPayload()));
		}
	}
	 
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("afterConnectionClosed :::" + session.getId());
	}
}

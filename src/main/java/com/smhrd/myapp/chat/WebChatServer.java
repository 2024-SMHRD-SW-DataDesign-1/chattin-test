package com.smhrd.myapp.chat;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;

import com.smhrd.myapp.model.Log;
import com.smhrd.myapp.model.MavenMember;



@ServerEndpoint(value = "/chat/{chatId}", configurator = WebSocketFilter.WebSocketConfigurator.class)
public class WebChatServer extends HttpServlet {
	// 스레드 안정성을 위해 사용하는 함수
	private static Map<Session,String> users = Collections.synchronizedMap(new HashMap<Session, String>());
	private static Map<Session, String> sessionChatIdMap = Collections.synchronizedMap(new HashMap<>());
	
	// 클라이언트가 웹 소켓 서버에 연결될 때 호출됩니다.
	@OnOpen
	public void onOpen(Session session, @PathParam("chatId") String chatId) throws IOException{

		HttpSession httpSession = (HttpSession) session.getUserProperties().get("httpSession");
		MavenMember member = (MavenMember) httpSession.getAttribute("member");
		String userId = member.getU_id();
		
		System.out.println(chatId);
		
		users.put(session, userId);
		sessionChatIdMap.put(session, chatId);
		//sendNotice(chatId,userId+"이 입장하셨습니다.");
		
		
		
	}
	
	// 클라이언트로부터 메시지를 수신할떄
	@OnMessage
	public void onMsg(String message, Session session) throws IOException{
		String userName = users.get(session);
		String chatId = sessionChatIdMap.get(session);
		
		synchronized (users) {
			for (Session currentSession : users.keySet()) {
	            String sessionChatId = sessionChatIdMap.get(currentSession);
	            if (!currentSession.equals(session)) {
	            	if (sessionChatId != null && sessionChatId.equals(chatId)) {
	            		currentSession.getBasicRemote().sendText(message);
	            		
	            	}
	            }
	        }
		}
		
	}

	// 클라이언트와의 연결이 종료될 때 호출됩니다.
	@OnClose
	public void onClose(Session session) throws IOException{
		String userName = users.get(session);
		String chatId = sessionChatIdMap.get(session);
		users.remove(session);
		sessionChatIdMap.remove(session);
		//sendNotice(chatId, userName + "님이 퇴장하셨습니다. 현재 사용자 " + users.size() + "명");
	}
	
	public void sendNotice(String chatId, String message) throws IOException{
		String userName = "server";
		System.out.println(userName + " : " + message);
		
		synchronized (users) {
			for (Session session : users.keySet()) {
	            String sessionChatId = sessionChatIdMap.get(session);
	            if (sessionChatId != null && sessionChatId.equals(chatId)) {
	                session.getBasicRemote().sendText(userName + " : " + message);
	            }
	        }
		}
	}
	
	

}



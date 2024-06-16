package com.smhrd.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.myapp.mapper.ChatMapper;
import com.smhrd.myapp.model.Chat;
import com.smhrd.myapp.model.Log;

@Service
public class ChatService {

	@Autowired //의존성 주입
	ChatMapper mapper;
	
	public int chat(Chat chat) {
		return mapper.chat(chat);
	}
	
	public List<Chat> chatlist(String u_id) {
		return mapper.chatlist(u_id);
	}
	
	public List<Chat> receivelist(String u_id) {
		return mapper.receivelist(u_id);
	}
	
	public int accept(String receiveId) {
		return mapper.accept(receiveId);
	}
	
	public int saveLog(Log save) {
		return mapper.saveLog(save);
	}
	
	public List<Log> loadLog(String chatId) {
		return mapper.loadLog(chatId);
	}
}

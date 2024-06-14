package com.smhrd.myapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.myapp.model.Chat;
import com.smhrd.myapp.model.Log;
import com.smhrd.myapp.model.MavenMember;
import com.smhrd.myapp.service.ChatService;

@Controller
public class ChatController {

	@Autowired
	ChatService service;	
	
	// 채팅요청
		@RequestMapping(value = "/member/call", method = RequestMethod.POST)
		public String call(@RequestParam("receiveId") String receiveId, HttpSession session) {
			MavenMember member = (MavenMember) session.getAttribute("member");
			Chat chat = new Chat();
			chat.setSendId(member.getU_id());
			chat.setReceiveId(receiveId);
			System.out.println(chat.getSendId());
			System.out.println(chat.getReceiveId());
			int res = service.chat(chat);
			return "redirect:/index";
		}

		// 채팅목록 출력
		@RequestMapping(value = "/member/chatlist/{id}", method = RequestMethod.GET)
		public String chatlist(@PathVariable("id") String id, Model model) {
			List<Chat> sendlist = service.chatlist(id);
			List<Chat> receivelist = service.receivelist(id);

			model.addAttribute("chatlist", sendlist);
			model.addAttribute("receivelist", receivelist);
			return "chatList";
		}

		// 채팅 요청 수락
		@RequestMapping(value = "/member/accept/{receiveId}", method = RequestMethod.GET)
		public String chatlist(@PathVariable("receiveId") String receiveId) {
			service.accept(receiveId);
			return "redirect:/member/chatlist/" + receiveId;
		}

		// 로그 저장
		@RequestMapping(value = "/chat/send", method =RequestMethod.POST, consumes="application/json;")
		public @ResponseBody void saveLog(@RequestBody String chatLog) throws JsonMappingException, JsonProcessingException {
			ObjectMapper mapper = new ObjectMapper();
	        Log log = mapper.readValue(chatLog, Log.class);
	        
			int res = service.saveLog(log);
			System.out.println(res);
		}
		
		// 로그 가져오기
		@RequestMapping(value = "/chat/roadLog", method =RequestMethod.POST, consumes="application/json;", produces = "application/text; charset=UTF-8")
		public @ResponseBody String loadLog(@RequestBody String chatId) throws JsonMappingException, JsonProcessingException {
			ObjectMapper mapper = new ObjectMapper();
	        Log log = mapper.readValue(chatId, Log.class);
	        
			List<Log> returnLog = service.loadLog(log.getChatId());
			
			ObjectMapper om = new ObjectMapper();
			String jsonString = om.writeValueAsString(returnLog);
			
			return jsonString;
		}
		
	
}

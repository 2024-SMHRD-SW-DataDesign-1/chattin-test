package com.smhrd.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	// index 페이지를 리턴해주는 메서드
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		// view resolver : /WEB-INF/views/index.jsp
		return "index";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/member/update", method=RequestMethod.GET)
	public String update() {
		return "member/update";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		return "member/list";
	}
	
	@RequestMapping(value="/chatting/{chatId}", method=RequestMethod.GET)
	public String chatting(@PathVariable("chatId") String chatId, Model model) {
		model.addAttribute("chatId", chatId);
		return "chatting";
	}
	
	@RequestMapping(value="/chatList", method=RequestMethod.GET)
	public String chatList() {
		return "chatList";
	}
}


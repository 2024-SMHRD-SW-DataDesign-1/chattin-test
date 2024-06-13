package com.smhrd.myapp.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Log {
	private String chatId;
	private String sendId;
	private String log;
	private Timestamp recodeTime;
	private int ruread;

	public Log(String chatId, String sendId, String log) {
		this.chatId = chatId;
		this.sendId = sendId;
		this.log = log;
	}
	
}


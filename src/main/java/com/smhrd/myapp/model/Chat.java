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
public class Chat {

	private int chatId;
	private String sendId;
	private String receiveId;
	private Timestamp lastTime;
	private String lastLog;
	private int accept; 
}

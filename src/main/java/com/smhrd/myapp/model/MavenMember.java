package com.smhrd.myapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class MavenMember {	
	private String u_id;
	private String u_pw;
	private String u_nickname;
	private String u_address;
	private String u_email;
	private String u_name;
	
	// 채팅관련 변수
	private String log;
	
  
   
}

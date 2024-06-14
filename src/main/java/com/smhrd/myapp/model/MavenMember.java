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
	
	// 채팅관련 변수
	private String log;
	
   public MavenMember(String u_id, String u_pw) {
	      super();
	      this.u_id = u_id;
	      this.u_pw = u_pw;
	   }
   
   public MavenMember(String u_id, String u_pw, String u_nickname) {
	      super();
	      this.u_id = u_id;
	      this.u_pw = u_pw;
	      this.u_nickname = u_nickname;
	   }
   
}

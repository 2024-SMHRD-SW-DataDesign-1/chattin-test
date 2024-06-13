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
	private String id;
	private String pw;
	private String nickname;
	private String address;
	private String email;
	
	// 채팅관련 변수
	private String log;
	
   public MavenMember(String id, String pw) {
	      super();
	      this.id = id;
	      this.pw = pw;
	   }
   
   public MavenMember(String id, String pw, String nickname) {
	      super();
	      this.id = id;
	      this.pw = pw;
	      this.nickname = nickname;
	   }
   
}

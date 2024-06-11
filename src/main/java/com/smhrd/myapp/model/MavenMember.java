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
	// lombok 사용법
	// 1. 현재 사용하는 이클립스를 lombok 프로그램에 추가
	// 2. 이클립스 리스타트
	// 3. 프로젝트에 lombok.jar dependency 추가
	private String id;
	private String pw;
	private String nickname;
	
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

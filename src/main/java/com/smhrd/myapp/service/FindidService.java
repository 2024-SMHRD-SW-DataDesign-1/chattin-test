package com.smhrd.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.myapp.mapper.ChatMapper;
import com.smhrd.myapp.mapper.FindidMapper;
import com.smhrd.myapp.model.MavenMember;

@Service
public class FindidService {
	
	@Autowired 
	FindidMapper mapper;
	
	public int findid(MavenMember member){
		MavenMember result = mapper.findid(member);
		if(result!=null) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public String getid(String u_email) {
		return mapper.getid(u_email);
	}

}

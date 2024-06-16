package com.smhrd.myapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.myapp.model.MavenMember;

@Mapper
public interface FindidMapper {
	
	@Select("select * from USERS where u_email=#{u_email}")
	public MavenMember findid(MavenMember member);

	@Select("select u_id from USERS where u_email=#{u_email}")
	public String getid(String u_email);
}

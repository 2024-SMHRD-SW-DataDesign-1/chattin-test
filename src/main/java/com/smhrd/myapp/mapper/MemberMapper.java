package com.smhrd.myapp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.myapp.model.Chat;
import com.smhrd.myapp.model.Log;
import com.smhrd.myapp.model.MavenMember;

@Mapper
public interface MemberMapper {
	// 회원가입 처리
	public int memberJoin(MavenMember member);
	
	public MavenMember memberLogin(MavenMember member);
	
//	@Update("update mavenmember set pw=#{pw}, nickname=#{nickname} where id=#{id}")
//	public int memberUpdate(MavenMember member);
//	
//	@Delete("delete from mavenmember where id=#{id}")
//	public int memberDelete(String id);
//	
//	@Select("select * from mavenmember")
//	public List<MavenMember> memberList();
//	
//	@Insert("insert into mavenmember values (#{id}, #{pw}, #{nickname})")
//	public int chatAdd(String log);
	
	@Insert("insert into CHAT (sendId,receiveId) value (#{sendId},#{receiveId})")
	public int chat(Chat chat);
	
	@Select("select * from CHAT where sendId=#{id}")
	public List<Chat> chatlist(String id);
	
	@Select("select * from CHAT where receiveId=#{id}")
	public List<Chat> receivelist(String id);
	
	@Update("update CHAT set accept=1 where receiveId=#{receiveId}")
	public int accept(String receiveId);
	
	@Insert("insert into chatLog (chatId,sendId,log) value (#{chatId},#{sendId},#{log}")
	public int saveLog(Log save);
}

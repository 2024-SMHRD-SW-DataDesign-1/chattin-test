package com.smhrd.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.myapp.model.Chat;
import com.smhrd.myapp.model.Log;

@Mapper
public interface ChatMapper {

	@Insert("insert into CHAT (sendId,receiveId) value (#{sendId},#{receiveId})")
	public int chat(Chat chat);
	
	@Select("select * from CHAT where sendId=#{u_id}")
	public List<Chat> chatlist(String u_id);
	
	@Select("select * from CHAT where receiveId=#{u_id}")
	public List<Chat> receivelist(String u_id);
	
	@Update("update CHAT set accept=1 where receiveId=#{receiveId}")
	public int accept(String receiveId);
	
	@Insert("insert into chatLog (chatId,sendId,log) value (#{chatId},#{sendId},#{log})")
	public int saveLog(Log save);
	
	@Select("select * from chatLog where chatId=#{chatId}")
	public List<Log> loadLog(String chatId);
}

<%@page import="com.smhrd.myapp.model.MavenMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% MavenMember member = (MavenMember)session.getAttribute("member"); %>
	<!-- 현재 경로 : localhost:8089/myapp/update -->
	<!-- 요청 경로 : localhost:8089/myapp/member/update -->
	   <form action="update" method="post">
      ID : <input type="text" name="id" value="<% member.getId(); %>"><br>
      PASSWORD : <input type="password" name="pw"><br>
      NICKNAME : <input type="text" name="nickname" value="<% member.getNickname(); %>" ><br>
      <input type="submit" value="회원가입">
   </form>
</body>

</html>
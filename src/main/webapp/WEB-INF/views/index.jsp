<%@page import="com.smhrd.myapp.model.MavenMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% MavenMember member = (MavenMember)session.getAttribute("member");%>
	<% if (member == null) {%>
		<a href="join"> <button>회원가입</button></a>
		<a href="login"> <button>로그인</button></a>
	<%} else{%>
		<%-- <a href="update"> <button>회원정보수정</button></a>
		<a href="member/delete?id=<%=member.getId()%>"><button>회원탈퇴</button></a> --%>
	<% if(member.getU_id().equals("admin")){%>
		<a href="member/list"><button>회원전체리스트</button></a>
	<% } %>
		<form action="member/call" method="post">
			채팅요청보낼ID <input type="text" name="receiveId">
			<input type="submit" value="요청보내기">
		</form>
		<a href="member/chatlist/<%=member.getU_id()%>"><button>채팅목록</button></a>
		
		
		<a href="member/logout"> <button>로그아웃</button></a>
	<%} %>

</body>
</html>
<%@page import="com.smhrd.myapp.model.MavenMember"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<MavenMember> list = (List<MavenMember>)request.getAttribute("list");
		System.out.println(list.size());
	%>
	<table border=1>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>닉네임</th>		
		</tr>
		<%for(MavenMember m:list) {%>
			<tr>
				<td><%= m.getU_id() %></td>
				<td><%= m.getU_pw() %></td>
				<td><%= m.getU_nickname() %></td>
				<!-- 파라미터는 경로 자체에 포함하는 방법 -->
				<td><a href="/myapp/member/delete/<%= m.getU_id() %>">삭제</a></td>
			</tr>
		<%} %>
	</table>
</body>
</html>
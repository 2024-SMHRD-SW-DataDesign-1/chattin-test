<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String message = (String) session.getAttribute("message");
    if (message != null) {
        session.removeAttribute("message"); // 메시지를 세션에서 제거하여 페이지 새로고침 시 알림이 다시 표시되지 않도록 합니다.
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
        <% if (message != null) { %>
            <% if ("success".equals(message)) { %>
                alert("메세지 전송 완료! 메일을 확인해주세요.");
            <% } else if ("fail".equals(message)) { %>
                alert("이름과 이메일을 다시 확인해주세요.");
            <% } %>
        <% } %>
    </script>
</head>
<body>
	<form action="findidcon" method="post">
		ID찾기
		NAME : <input type="text" name="u_name"><br>
		EMAIL : <input type="email" name="u_email"><br>
		<input type="submit" value="id찾기">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 현재 위치 : localhost:8089/myapp/join -->
	<!-- 회원가입 : localhost:8089/myapp/member/join -->
   <form action="member/join" method="post">
      ID : <input type="text" name="id"><br>
      PASSWORD : <input type="password" name="pw"><br>
      NICKNAME : <input type="text" name="nickname"><br>
      <input type="submit" value="회원가입">
   </form>
</body>
</html>
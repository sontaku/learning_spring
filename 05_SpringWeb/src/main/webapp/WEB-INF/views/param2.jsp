<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : ${memberVO.name } <br/>
	아이디 : ${memberVO.id } <br/>
	나이 : ${memberVO.age } <br/>
	
	<hr/>
	세션값 : ${sessionScope.login }
</body>
</html>
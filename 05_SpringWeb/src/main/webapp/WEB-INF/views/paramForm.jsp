<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param.jsp</title>
</head>
<body>
	<h2> 이전 화면의 파라미터 값을 여기서 출력 </h2>
	${vo.id }<br/>
	${vo.name }<br/>
	${vo.age }<br/>
	
	<br/>
	
	${mv.getId() }<br/>
	${mv.getName()}<br/>
	${mv.getAge()}<br/>
	
</body>
</html>
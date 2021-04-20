<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>여기는 뷰 페이지 입니다. 특히 autoScan</h4>
	
	회원 정보 : ${vo }<br/>
	${vo.getClass() }<br/>
	${vo.getId() }
	${vo.getName() }
	${vo.getAge() } <br/>
	
	${vo.id }
	${vo.name }
	${vo.age }
	
</body>
</html>
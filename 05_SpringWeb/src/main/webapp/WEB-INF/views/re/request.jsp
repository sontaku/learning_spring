<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : ${param.id }<br/> 
	이름 : ${param.name }<br/> 
	나이 : ${param.age } <br/>

	아이디 : ${vo.id }<br/> 
	이름 : ${vo.name }<br/> 
	나이 : ${vo.age } <br/>

	아이디 : ${memberVO.id }<br/> 
	이름 : ${memberVO.name }<br/> 
	나이 : ${memberVO.age }<br/>

<!-- 권장하는 방법 -->
	아이디 : ${memberVo.id }<br/> 
	이름 : ${memberVo.name }<br/> 
	나이 : ${memberVo.age }<br/>
</body>
</html>
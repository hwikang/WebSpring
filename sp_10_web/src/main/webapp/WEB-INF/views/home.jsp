<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<img src="/web/resources/pizza.jpg"/>
<img src="/web/img/beef.jpg"/>
<p> 
	<a href="/web/aLink?username=홍길동&num=1122">a 태그로 링크걸기</a>
</p>
<p>
	<form method="get" action="/web/formData">
		아이디 : <input type="text" name="id"/><br/>
		비밀번호 : <input type="password" name="pwd"><br/>
		<input type="submit" value="전송"/>
	</form>
</p>
<p>
	<form method="post" action="/web/formData2">
		아이디 : <input type="text" name="id"/><br/>
		비밀번호 : <input type="password" name="pwd"><br/>
		<input type="hidden" name="num" value="100">
		<input type="submit" value="전송"/>
	</form>
</p>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>

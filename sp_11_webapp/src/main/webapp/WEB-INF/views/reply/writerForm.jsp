<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/app/replyWriterOk">
	작성자 : <input type="text" name="writer"/><br/>
	제목 : <input type="text" name="subject"/><br/>
	내용 : <textarea name="content" rows="5" cols="40"></textarea><br/>
	<input type="submit" value="submit"/><br/>

</form>
</body>
</html>
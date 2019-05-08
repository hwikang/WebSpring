<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDIT</title>
</head>
<body>
<form method="post" action="/app/replyEditOk">
	작성자 : <input type="text" name="writer" value="${vo.writer }" disable/><br/>
	제목 : <input type="text" name="subject" value="${vo.subject }"/><br/>
	내용 : <textarea name="content" rows="5" cols="40">${vo.content}</textarea><br/>
	<input type="hidden" name="regNum" value="${vo.regNum}"/>
	<input type="submit" value="submit"/><br/>

</form>
</body>
</html>
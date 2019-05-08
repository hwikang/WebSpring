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
<form method="post" action="/web/writeOk">
	작성자:<input type="text"name="userid" value="khdrogbaMybatis"/>
	제목:<input type="text"name="title" >
	내용:<input type="text"name="content" rows="10" cols="50"/>
	<input type="hidden" name="recordNo"/>
	<input type="submit" value="☆★subbbbmittt★☆"/>
</form>
</body>
</html>
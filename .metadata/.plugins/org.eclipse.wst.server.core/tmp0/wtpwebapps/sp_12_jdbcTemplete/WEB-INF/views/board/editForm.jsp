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
<form method="post" action="/webapp/editOk">
	<ul>
		<li>작성자:<input type="text" name="userid" value="${vo.userid }"></li>
		<li>제목:<input type="text" name="title" value="${vo.title }"></li>
		<li>글내용:<input type="text" name="content" value="${vo.content}"></li>
		<li><input type="submit" value="submit"></li>
	</ul>
	<input type="hidden" name="recordNo" value="${vo.recordNo }"/>
</form>
</body>
</html>
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
<ul>
	<li>num : ${vo.regNum }</li>
	<li>writer : ${vo.writer }</li>
	<li>regdate : ${vo.regDate }</li>
	<li>views : ${vo.hit }</li>
	<li>title : ${vo.subject }</li>
	<li>content : ${vo.content }</li>
</ul>
<div>
	<a href="/app/">Home</a>
	<a href="/app/replyEditForm?regNum=${vo.regNum }">Edit</a>
	<a href="/app/replyForm?regNum=${vo.regNum }">Reply</a>
	<a href="/app/delete?regNum=${vo.regNum }">Delete</a>
	
</div>
</body>
</html>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<c:if test="${logStatus==null || logStatus=='N' }">
<a href="/app/login">로그인</a>
</c:if>
<c:if test="${logStatus=='Y' }">
<a href="/app/logout">${username }로그아웃</a>
</c:if>
<a href="/app/replyList"><img src="/app/img/beef.jpg"/></a>
</body>
</html>

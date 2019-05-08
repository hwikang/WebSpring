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
<ol>
	<li>${vo.recordNo }</li>
	<li>${vo.userid}</li>
	<li>${vo.title}</li>
	<li>${vo.content}</li>
	<li>${vo.regdate}</li>
</ol>
<a href="/web/edit?recordNo=${vo.recordNo }">이수정김수정</a>
</body>
</html>
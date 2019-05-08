<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		width:850px;
		margin:0 auto;
		
	}
	ul,li{
		margin:0px;
		padding:0px;
	}
	li{
		border-bottom:1px solid gray;
		float:left;
		list-style-type:none;
		width:10%;
	}
	li:nth-child(2){width:60%}
	
</style>
</head>
<body>
<a href="/webapp/writer">글쓰기</a>
<ul>
	<li>번호</li>	
	<li>제목</li>
	<li>글쓴이</li>
	<li>조회수</li>
	<li>등록일</li>
</ul>
<c:forEach var="vo" items="${list}">
	<ul>
		<li>${vo.recordNo }</li>	
		<li><a href="/webapp/view?recordNo=${vo.recordNo}">${vo.title }</a></li>
		<li>${vo.userid }</li>
		<li>${vo.hit }</li>
		<li>${vo.regdate}</li>
	</ul>
</c:forEach>
</body>
</html>
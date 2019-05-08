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
<h1>게시판목록</h1>
<link rel="stylesheet" href="/app/js_css/style.css"/>
<ul>
	<li>번호</li>
	<li>제목</li>
	<li>작성자</li>
	<li>조회수</li>
	<li>등록일</li>
</ul>
<c:set var="totalRecord" value="${totalRecord }"/>
<c:forEach var="vo" items="${list }"> 
	<ul>
		<li>${totalRecord}
			<c:set var="totalRecord" value="${totalRecord-1 }"/>
		</li>
		<!-- 밀어쓰기 -->
		<li>
		<c:forEach begin="1" end="${vo.lev }">
			-->
		</c:forEach>
		<a href="/app/replyView?regNum=${vo.regNum }">${vo.subject }</a></li>
		<li>${vo.writer }</li>
		<li>${vo.hit }</li>
		<li>${vo.regDate }</li>
	</ul>	
</c:forEach>

<a href="/app/">홈</a>
<a href="/app/writerForm">글쓰기</a>

</body>
</html>
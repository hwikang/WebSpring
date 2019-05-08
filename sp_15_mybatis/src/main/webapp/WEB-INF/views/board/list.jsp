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
	<table>
		<thead>
			<tr>
				<td>번호</td>
				<td>id</td>
				<td>title</td>
				<td>views</td>
				<td>date</td>	
			</tr>			
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.recordNo}</td>
					<td>${vo.userid}</td>
					<p><a href="/web/view?recordNo=${vo.recordNo }">${vo.title}</a></p>
					<td>${vo.hit}</td>
					<td>${vo.regdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/web/write">글쓰기</a>
	<a href=""></a>
	
	
</body>
</html>
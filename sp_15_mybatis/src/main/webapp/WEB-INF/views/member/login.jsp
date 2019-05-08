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
	<form method="post" action="/web/loginCheck">
		<input type="text" name="userid"/><br/>
		<input type="text" name="userpwd"/><br/>
		<input type="submit" value="login"/>
	</form>
</body>
</html>
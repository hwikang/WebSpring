<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<a href="/home/list">LIST</a>
<hr/>
<h1>
	Form1
</h1>

<form method="post" name="frm1" action="/home/fileupload1"  enctype="multipart/form-data">	
	<input type="text" name="userid" value="kh1"><br/>
	<input type="text" name="title"><br/>
	<input type="file" name="filename"><br/>
	<input type="file" name="filename2"><br/>
	<input type="submit">
</form>
<hr/>
<h1>
	Form2 
</h1>

<form method="post" name="frm2" action="/home/fileupload2"  enctype="multipart/form-data">	
	<input type="text" name="userid" value="kh2"><br/>
	<input type="text" name="title"><br/>
	<input type="file" name="filename"><br/>
	<input type="file" name="filename"><br/>
	<input type="submit">
</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</head>
<body class="container">
<h1>목록</h1>
<div class="row">
	<div class="col-1">번호</div>
	<div class="col-3">제목</div>
	<div class="col-2">작성자</div>
	<div class="col-2">첨부</div>
	<div class="col-2">등록일</div>
</div>
<c:forEach var="vo" items="${list }">
	<ul>
		<li>${vo.recordNo }</li>
		<li>${vo.title }</li>
		<li>${vo.userid }</li>
		<li>
		<c:if test="${vo.filename !=null}"><a href="javascript:down('${vo.filename}','${vo.recordNo }')">file</a></c:if>
		<c:if test="${vo.filename2 !=null}"><a href="javascript:down('${vo.filename2}','${vo.recordNo }')">file2</a></c:if>
		</li>
		<li>${vo.regdate }</li>
	</ul>
</c:forEach>
<form method="post" name="download" id="download" action="/home/fileDown">
	<input type="hidden" name="filename" id="filename"/>
	<input type="hidden" name="recordNo" id="recordNo"/>
</form>


</body>
<script>
	function down(filename,recordNo){
		document.querySelector("#filename").value = filename;
		document.querySelector("#recordNo").value = recordNo;		
		document.querySelector("#download").submit();
	}
</script>


</html>
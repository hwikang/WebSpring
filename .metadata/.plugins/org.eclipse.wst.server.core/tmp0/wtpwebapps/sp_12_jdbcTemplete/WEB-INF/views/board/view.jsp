<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="http://code.jquery.com/jquery-3.3.1.js"  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="  crossorigin="anonymous"></script>
</head>
<body>
	<ul>
		<li>번호 :${vo.recordNo }</li>
		<li>작성자 : ${vo.userid }</li>
		<li>날짜 : ${vo.regdate }</li>
		<li>제목 : ${vo.title }</li>
		<li>글내용 : ${vo.content }</li>
		<li>조회수 : ${vo.hit }</li>
		
	</ul>
	<a href="/webapp/">홈</a>
	<a href="/webapp/boardList">목록</a>
	<a href="/webapp/editForm?recordNo=${vo.recordNo }">수정</a>
	<a href="/webapp/delete?recordNo=${vo.recordNo }">삭제</a>
	<form method="post" id="frm">
		<input type="text" name="replyContent"/>
		<input type="hidden" value="${vo.recordNo}" name="recordNo"/>
		<input type="hidden" value="khdrogba" name="userid"/>
		<input type="button" value="submit" id="replySubmit"/>		
	</form>
	<ul id="replyList">
	<c:forEach var='vo' items="${replyVo }">
		<li>${vo.replyContent}</li>
	
	
	</c:forEach>
	</ul>
	<div></div>
</body>
<script>
const replySubmit = document.querySelector("#replySubmit");
const replyList = document.querySelector("#replyList");

	function replyEvent(){
		replySubmit.addEventListener("click",function(e){
		
			let uri = "/webapp/reply";
			let param = $("#frm").serialize();
			console.log(param);
			$.ajax({
				type : "POST",
				url : uri,
				data : param,
				
			//	contentType : "application/json;charset=UTF-8",
				success : function(result){
					//result = 리스트
					$resultList = $(result);
					let R ="";
					$resultList.each(function(i,d){
						R += "<li>" + d.userid + d.replyContent + d.replyRegdate+"</li>"
					})
					replyList.innerHTML = R;
				},
				error : function(error){
					replyList.innerHTML = error.responseText;
				}
				
				
			});
		})
	}
	
	function init(){
		replyEvent()
	}
	init();
</script>




</html>
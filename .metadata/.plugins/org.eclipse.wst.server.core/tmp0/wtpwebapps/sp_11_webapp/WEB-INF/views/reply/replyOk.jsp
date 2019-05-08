<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${cnt>0 }">
	<script>
		alert('댓글 작성 완료쓰');
		location.href="/app/replyList"
	</script>
</c:if>
<c:if test="${cnt<=0 }">
	<script>
		alert('댓글 작성 fail쓰');
		history.back();
	</script>
</c:if>
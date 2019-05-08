<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${cnt>0 }">
	<script>
		alert("등록완료");
		location.href="/app/replyList";
	</script>
</c:if>
<c:if test="${cnt<=0 }">
	<script>
		alert("등록실패");
		history.back();
	</script>
</c:if>

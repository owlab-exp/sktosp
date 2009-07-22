<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.skt.opensocial.persistence.*" %>
<% User user = (User) session.getAttribute("USER"); %>
<script>
if (<%=user.isIsAdministrator()%> == false) {
	alert('<%=user.getPerson().getName()%>는 관리자 권한이 없습니다.');
	history.back();
}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- for use of struts tags -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.skt.opensocial.common.UserData" %>
<%@ page session="true" %>
<br>
<!-- div class="login" -->
<div class="loggedin">
<% UserData userData = (UserData) session.getAttribute("USER"); %>
안녕하세요
<br>
<b><%= userData.getUserName() %></b> 님
<br><br>
<a href="<%=request.getContextPath()%>/security/UserLogout.action">로그아웃</a>
</div>
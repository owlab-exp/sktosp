<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- for use of struts tags -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.skt.opensocial.common.UserData" %>
<%@ page session="true" %>
<br>
<div class="login">
<%-- 
<jsp:useBean id="USER" type="com.skt.opensocial.common.UserData" beanName="userData" scope="session">
<jsp:getProperty property="userName" name="userData"/>
</jsp:useBean>
--%>
<% UserData userData = (UserData) session.getAttribute("USER"); %>
<%= userData.getUserName() %>
</div>
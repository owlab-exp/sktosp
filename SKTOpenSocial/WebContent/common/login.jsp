<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- for use of struts tags -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<br>
<div class="login">
<s:form action="UserLogin" namespace="/security">
		<s:textfield name="userId" label="사용자 ID" labelposition="top" required="true" requiredposition="left" size="10" />
		<s:password name="password" label ="패스워드" labelposition="top" required="true" requiredposition="left" size="12"/>
		<s:submit value="로그인" />
		

</s:form>
<s:form action="Registration" namespace="/user">
		<s:submit value="회원가입" />
</s:form>
</div>


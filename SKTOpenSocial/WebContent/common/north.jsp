<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
      <div id="header">
      <table width="100%" height="100%" border="0">
        <tr align="center">
          <td width="25%" style="background-color:#FFFFFF"><img src="<%= request.getContextPath() %>/images/logo.jpg"></td>
          <td width="15%" onclick="javacript:location.href='<%= request.getContextPath() %>/user/MyProfilePage.action'" style="cursor:hand">SKT OpenSocial 홈</td>
          <td width="5%">|</td>
          <td width="8%">사용자 메뉴</td>
          <td width="5%">|</td>
          <td width="8%" onclick="javacript:location.href='<%= request.getContextPath() %>/developer/ListGadgets.action'" style="cursor:hand">개발자 메뉴</td>
          <td width="5%">|</td>
          <td width="8%">관리자 메뉴</td>
          <td width="5%">|</td>
          <td width="8%"><a href="<%= request.getContextPath() %>/security/UserLogout.action">로그아웃</a></td>
        </tr>
      </table>
    </div>

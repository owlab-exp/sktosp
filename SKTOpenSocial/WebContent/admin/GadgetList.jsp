<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/common/header.jsp"%>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

<table width="1023" height="767" border="1" cellspacing="0" cellpadding="0">
  <tr>
  <!-- north -->
    <td colspan="3" height="10%" align="center" valign="middle">

<%@ include file="/common/north.jsp"%>

    </td>
  </tr>
  <tr>
  <!-- west -->
    <td width="25%" align="center" valign="top">

<%@ include file="/common/west.jsp"%>
<%@ include file="/common/menu.jsp"%>

    </td>
    <!-- east -->
    <td width="75%" align="left" valign="top">
      <div id="east">
  
      <table width="100%" cellpadding="10">
        <!-- navigation -->
        <tr>
          <td>
                      
<%@ include file="/common/nav.jsp"%>

          </td>
        </tr>

        
        <!-- search -->
        <tr>
          <td>


	<s:form action="GadgetList" theme="simple">
	    <s:select label="�˻�����" name="searchfield" headerKey="1" headerValue="-- �����ϼ��� --" list="#{'name':'�̸�','owner':'�����'}"/> 
	    <s:textfield name="query"/> 
	    <s:submit value="�˻�"/>
	    
	</s:form>

		      </td>
	      </tr>
	      
	      
        <tr>
          <td>
          
            <!-- bbs -->
            <table cellpadding="0" cellspacing="0" width="100%" class="subtit_board" summary="�Խ���"> 
			<colgroup> 
                <col width="10%" /> 
                <col width="45%" /> 
                <col width="10%" /> 
                <col width="15% /> 
                <col width="15%" /> 
                <col width="5%" /> 
              </colgroup>
              
<!--  <s:property value="gadgetlistStr"/>	-->

    			  <tr style="background-color:#F5F5F5;">
          			<td>�̸�</td> 
                	<td>����</td> 
      			    <td align="center">������</td> 
      			    <td align="center">�������</td> 
      			    <td align="center">����</td> 
      			    <td align="center">�������</td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>

    			<s:iterator value="gadgetlist">
    			  <tr> 
          			<td><span class="num"><s:property value="name"/></span></td> 
                	<td><s:property value="desc"/></td> 
      			    <td align="center"><s:property value="owner"/></td> 
      			    <td align="center"><span class="num"><s:property value="createdDate"/></span></td> 
      			    <td align="center"><span class="num"><input type=button value="<s:property value="status"/>"></span></td> 
      			    <td align="center"><input type=button value="����"></td> 
      			  </tr>
      			  <tr><td class="line" colspan="6"></td></tr>
      			</s:iterator>
				</table>
            </td>
           </tr>
           <tr>
           	<td>
            <!-- paging --> 
            
			<div class="paging"> 
				<em class="p"><a href="">����</a></em> 
				<span class="on">1</span>
				<a href="">2</a>
				<a href="">3</a>
				<em class="n"><a href="">����</a></em> 
			</div>
            </td>
      	</tr>
      </table>
 	     
      </div> <!-- east div -->
      
    </td>
  </tr>
  <!-- south -->
  <tr>
    <td colspan=3 height="10%" align="center" valign="middle">
<%@ include file="/common/south.jsp"%>
	</tr> 
</table>

</body>

</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <div id="west">
      <div class="login">
      <table>
        <tr>
          <td>
              <form id="login" name="login" action="login.jsp" target="_self" method="post" autocomplete="off" onsubmit="return form_chk();"> 
              �̸���: <input type="text" id="loginEmail" name="email" class="bg" title="�̸��� �ּ� �Է�" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" datatype="an" mask="-_@." /> 
              <br>��й�ȣ: <input type="password" id="loginPasswd" name="passwd" class="bg" title="��й�ȣ �Է�" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" enc="on" /> 
              <br><br><input type="submit" class="btn" title="�α��ι�ư" value="�α���"/> 
              <input type="hidden" id="loginEChk" name="echk" value="" /> 
              </form>
          </td>
        </tr>
      </table>
      </div>
    </div>

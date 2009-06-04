<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div id="west">
    <br>
      <div class="login">
      <table>
        <tr>
          <td>
              <form id="login" name="login" action="login.jsp" target="_self" method="post" autocomplete="off" onsubmit="return form_chk();"> 
              이메일: <input type="text" id="loginEmail" name="email" class="bg" title="이메일 주소 입력" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" datatype="an" mask="-_@." /> 
              <br>비밀번호: <input type="password" id="loginPasswd" name="passwd" class="bg" title="비밀번호 입력" onfocus="ChgInput(this);" onkeydown="ChgInput(this);" onmouseover="this.focus();" enc="on" /> 
              <br><br><input type="submit" class="btn" title="로그인버튼" value="로그인"/> 
              <input type="hidden" id="loginEChk" name="echk" value="" /> 
              </form>
          </td>
        </tr>
      </table>
      </div>
    </div>

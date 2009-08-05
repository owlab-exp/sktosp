
//---------숫자체크함수-------------
         
function IsNumber(formname) {
   //var form = eval('document.signform.' + formname);
   var form = eval(formname);
   for(var i = 0; i < form.value.length; i++) {
      var chr = form.value.substr(i,1);
      if(chr < '0' || chr > '9') {            
         return false;
      }
   }
   return true;   
}

//------------한글체크함수-----------
function h_check(Objectname) {
    var intErr
    var strValue = Objectname.value
    var retCode = 0

    for (i = 0; i < strValue.length; i++) {

        var retCode = strValue.charCodeAt(i)
        var retChar = strValue.substr(i,1).toUpperCase()

        retCode = parseInt(retCode)

        if ((retChar < '0' || retChar > '9') && (retChar < 'A' || retChar > 'Z') && ((retCode > 255) || (retCode < 0))) {
                intErr = -1;
                break;
        }
    }
    return (intErr);
}

//---------------- 회원 필드 정의 ----------------------------------->

// 필수 항목 유무 검사
function Isreq(required){
    var f = document.member_form;
    var field = new Array();
    
    field['email'] = true;
    field['jumin'] = true;
    field['homepage'] = true;
    field['c_phone'] = true;
    field['h_phone'] = true;
    field['birth'] = true;
    field['birth_type'] = true;
    field['h_zip'] = true;
    field['h_addr'] = true;
    field['sex'] = true;
    field['job'] = true;
    field['mailling'] = true;
    field['info_open'] = true;
    field['intro'] = true;
    field['add_01'] = true;
    field['add_02'] = true;
    field['add_03'] = true;
    field['add_04'] = true;
    field['add_05'] = true;
    
    return field[required];
}
//---------------- 회원 필드 정의 ----------------------------------->


//---------------- 회원 아이디 체크 함수 ---------------------------->
function mem_id_check(){

    var member_id = 'id';
    var member_id = eval("document.member_form." + member_id);

    if(member_id.value.length <= 4 || member_id.value.length >= 20) {
       alert('아이디는 4 ~ 20자 이내의 영문소문자나 숫자 또는 조합된 문자열이어야 합니다');
       member_id.focus();
       member_id.select();
       return false;
    }

    for(var i = 0; i < member_id.value.length; i++) {
       var chr = member_id.value.substr(i,1);         
       if((chr < '0' || chr > '9') && (chr < 'a' || chr > 'z')) {
           alert('아이디는 4 ~ 20자 이내의 영문소문자나 숫자 또는 조합된 문자열이어야 합니다');
           member_id.focus();
           member_id.select();
           return false;  
       }
    }

    if(!member_id.value) {
        alert('아이디를 입력하신 후에 확인하세요.');
        member_id.focus();
        return false;
    }
    
    return true;
}
//---------------- 회원 아이디 체크 함수 ---------------------------->

//---------------- 패스워드 체크 함수 ------------------------------->
function mem_pass_check(){
    var member_pass = eval(document.member_form.passwd);

    if(member_pass.value.length < 4 || member_pass.value.length > 15) {
       alert('패스워드는 4 ~ 15자의  영문자나 숫자 또는 조합된 문자열이어야 합니다');
       member_pass.focus();
       member_pass.select();
       return false;
    }

    return true;
}
//---------------- 패스워드 체크 함수 ---------------------------->

//---------------- E-Mail 체크 함수 ------------------------------>
function email_check() {
  var email = document.member_form.email;
  var email_num = document.member_form.email.value.length;
  var str_email = document.member_form.email.value;
  for (var l = 0; l <= (email_num - 1); l++){
     if(str_email.indexOf(' ') >= 0 ){
        alert ('E 메일 주소에서 공란을 빼주십시오');
        email.focus();
        email.select();
        return false;
     }
  }
  if ((str_email.indexOf('/')) != -1){
     alert('메일 형식이 잘못되었습니다');
      email.focus();
     email.select();
      return false;
  }
  if ((str_email.indexOf(';')) != -1){
      alert('메일 형식이 잘못되었습니다');
      email.focus();
     email.select();
      return false;
  }
  if ((email_num != 0) && (str_email.search(/(\S+)@(\S+)\.(\S+)/) == -1)){
      alert('메일 형식이 잘못되었습니다');
      email.focus();
     email.select();
      return false;
  }
  if (h_check(email) == -1) {
     alert('한글은 사용할 수 없습니다');
     email.focus();
     email.select();
      return false;
  }
  return true;
}
//---------------- E-Mail 체크 함수 ------------------------------>

//---------------- 주민번호 체크 함수 ---------------------------->
function jumin_check() {
    
    var chk =0
    var yy = member_form.jumin1.value.substring(0,2)
    var mm = member_form.jumin1.value.substring(2,4)
    var dd = member_form.jumin1.value.substring(4,6)
    var sex = member_form.jumin2.value.substring(0,1)

    if ((member_form.jumin1.value.length!=6)||(yy <25||mm <1||mm>12||dd<1)){
            alert ('잘못된 주민등록번호입니다');
            member_form.jumin1.value='';
            member_form.jumin2.value='';
            member_form.jumin1.focus();
            return false;
    }

    if ((sex != 1 && sex !=2 )||(member_form.jumin2.value.length != 7 )){
            alert ('잘못된 주민등록번호입니다');
            member_form.jumin1.value='';
            member_form.jumin2.value='';
            member_form.jumin2.focus();
            return;
    }   
  
    for (var i = 0; i <=5 ; i++){ 
        chk = chk + ((i%8+2) * parseInt(member_form.jumin1.value.substring(i,i+1)))
    }

    for (var i = 6; i <=11 ; i++){ 
            chk = chk + ((i%8+2) * parseInt(member_form.jumin2.value.substring(i-6,i-5)))
    }

    chk = 11 - (chk %11)
    chk = chk % 10

    if (chk != member_form.jumin2.value.substring(6,7)) {
            alert ('주민등록번호가 맞지않습니다');
            member_form.jumin1.value='';
            member_form.jumin2.value='';
            member_form.jumin2.focus();
            return;
    }
    return true;
}
//---------------- 주민번호 체크 함수 ---------------------------->


function chk_member_form(){

    var f = document.member_form;

    //if(!IsreqCheck())   return false;

    if(!f.id.value) {
        alert('아이디를 작성해 주세요.');
        f.id.focus();
        return false;
    }
    if(!mem_id_check()) return false;

    if(!f.passwd.value || !f.re_passwd.value) {
        alert('암호를 작성해 주세요.');
        f.passwd.focus();
        return false;
    }
    if(f.passwd.value != f.re_passwd.value) {
        alert('암호가 일치하지 않습니다.');
        f.passwd.value='';
        f.re_passwd.value='';
        f.passwd.focus();
        return false;
    }
    if(!mem_pass_check()) return false;

    if(!f.name.value) {
        alert('이름을 작성해 주세요.');
        f.name.focus();
        return false;
    }
    
    
        if(Isreq('email')){
            if(!f.email.value) {
                alert('이메일 을 작성해 주세요.');
                f.email.focus();
                return false;
            }
            if(!email_check()) return false;
        }
        if(Isreq('homepage')){
            if(!f.homepage.value) {
                f.homepage.focus();
                alert('홈페이지을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('c_phone')){
            if(!f.c_phone1.value || !f.c_phone2.value || !f.c_phone3.value) {
                alert('핸드폰을(를) 작성해 주세요.');
                return false;
            }
        }
        if(f.c_phone1 && !IsNumber(f.c_phone1)) {
            alert('핸드폰은(는) 숫자로 작성해 주세요.');        
            f.c_phone1.value=''
            f.c_phone1.focus();
            return false;
        }
        if(f.c_phone2 && !IsNumber(f.c_phone2)) {
            if(!IsNumber(f.c_phone2)) {
                alert('핸드폰은(는) 숫자로 작성해 주세요.');        
                f.c_phone2.value='';
                f.c_phone2.focus();
                return false;
            }
        }
        if(f.c_phone3 && !IsNumber(f.c_phone3)) {
            if(!IsNumber(f.c_phone3)) {
                alert('핸드폰은(는) 숫자로 작성해 주세요.');        
                f.c_phone3.value=''
                f.c_phone3.focus();
                return false;
            }
        }
        if(Isreq('h_phone')){
            if(!f.h_phone1.value || !f.h_phone2.value || !f.h_phone3.value) {
                alert('전화번호을(를) 작성해 주세요.');
                f.h_phone1.focus();
                return false;
            }
        }
        if(f.h_phone1 && !IsNumber(f.h_phone1)) {
            alert('전화번호은(는) 숫자로 작성해 주세요.');        
            f.h_phone1.value=''
            f.h_phone1.focus();
            return false;
        }
        if(f.h_phone2 && !IsNumber(f.h_phone2)) {
            if(!IsNumber(f.h_phone2)) {
                alert('전화번호은(는) 숫자로 작성해 주세요.');        
                f.h_phone2.value='';
                f.h_phone2.focus();
                return false;
            }
        }
        if(f.h_phone3 && !IsNumber(f.h_phone3)) {
            if(!IsNumber(f.h_phone3)) {
                alert('전화번호은(는) 숫자로 작성해 주세요.');        
                f.h_phone3.value=''
                f.h_phone3.focus();
                return false;
            }
        }
        if(Isreq('jumin')){
            if(!f.jumin1.value || !f.jumin2.value) {
                alert('주민등록번호 을(를) 작성해 주세요.');
                return false;
            }

            if(!IsNumber(f.jumin1)) {
                alert('주민등록번호는 숫자여야 합니다.');
                f.jumin2.focus();
                return false;         
            }
            if(!IsNumber(f.jumin2)) {
                alert('주민등록번호는 숫자여야 합니다.');
                f.jumin1.focus();
                return false;         
            }
            if(!jumin_check()) {
                f.jumin1.focus();   
                return false;
            }
        }
        if(Isreq('birth')){
            if(!f.birth1.value || !f.birth2.value || !f.birth3.value) {
                alert('생일을(를) 작성해 주세요.');
                f.birth1.focus();
                return false;
            }
        }
        if(f.birth1 && !IsNumber(f.birth1)) {
            alert('생일은(는) 숫자로 작성해 주세요.');        
            f.birth1.value=''
            f.birth1.focus();
            return false;
        }
        if(f.birth2 && !IsNumber(f.birth2)) {
            if(!IsNumber(f.birth2)) {
                alert('생일은(는) 숫자로 작성해 주세요.');        
                f.birth2.value='';
                f.birth2.focus();
                return false;
            }
        }
        if(f.birth3 && !IsNumber(f.birth3)) {
            if(!IsNumber(f.birth3)) {
                alert('생일은(는) 숫자로 작성해 주세요.');        
                f.birth3.value=''
                f.birth3.focus();
                return false;
            }
        }
        if(Isreq('birth_type')){
            if(!f.birth_type.value) {
                f.birth_type.focus();
                alert('음(양)력을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('h_zip')){
            if(!f.h_zip1.value || !f.h_zip2.value) {
                alert('zip code을(를) 작성해 주세요.');
                f.h_zip1.focus();
                return false;
            }
        }
        if(f.h_zip1 && !IsNumber(f.h_zip1)) {
            alert('zip code은(는) 숫자로 작성해 주세요.');        
            f.h_zip1.value=''
            f.h_zip1.focus();
            return false;
        }
        if(f.h_zip2 && !IsNumber(f.h_zip2)) {
            if(!IsNumber(f.h_zip2)) {
                alert('zip code은(는) 숫자로 작성해 주세요.');        
                f.h_zip2.value='';
                f.h_zip2.focus();
                return false;
            }
        }
        if(Isreq('h_addr')){
            if(!f.h_addr.value) {
                f.h_addr.focus();
                alert('집주소을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('sex')){
            if(!f.sex.value) {
                f.sex.focus();
                alert('성별을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('job')){
            if(!f.job.value) {
                f.job.focus();
                alert('직업을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('mailling')){
            if(!f.mailling.value) {
                f.mailling.focus();
                alert('메일링 수신을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('info_open')){
            if(!f.info_open.value) {
                f.info_open.focus();
                alert('개인정보공개을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('recom_id')){
            if(!f.recom_id.value) {
                f.recom_id.focus();
                alert('추천아이디을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('intro')){
            if(!f.intro.value) {
                f.intro.focus();
                alert('자기 소개을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('add_01')){
            if(!f.add_01.value) {
                f.add_01.focus();
                alert('좋아하는 연애인을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('add_02')){
            if(!f.add_02.value) {
                f.add_02.focus();
                alert('직장명을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('add_03')){
            if(!f.add_03.value) {
                f.add_03.focus();
                alert('경혼 유무을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('add_04')){
            if(!f.add_04.value) {
                f.add_04.focus();
                alert('뉴스 레터 받기을(를) 작성해 주세요.');
                return false;
            }
        }
        if(Isreq('add_05')){
            if(!f.add_05.value) {
                f.add_05.focus();
                alert('사이트 건의사항을(를) 작성해 주세요.');
                return false;
            }
        }
   
    return true;

        //f.action = 'community.php3?link=member';
        //f.submit();
}

// 중복 아이디 검색
function search_id(){
    
    if(!mem_id_check()) return false;
    else{
        var m_id = document.member_form.id.value;
        window.open("http://www.keodo.co.kr/bbseboard/member/member.php3?link=di&search_id=" + m_id,"dup_id","width=400,height=200,scrollbars=yes");
        return true;
    }    
}

// 우편번호 검색
function post_searching(){
    window.open("http://www.keodo.co.kr/bbseboard/member/member.php3?link=sa","post_searching","width=450,height=200,scrollbars=yes");
    return true;
}

//-->

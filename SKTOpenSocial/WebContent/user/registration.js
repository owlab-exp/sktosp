
//---------����üũ�Լ�-------------
         
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

//------------�ѱ�üũ�Լ�-----------
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

//---------------- ȸ�� �ʵ� ���� ----------------------------------->

// �ʼ� �׸� ���� �˻�
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
//---------------- ȸ�� �ʵ� ���� ----------------------------------->


//---------------- ȸ�� ���̵� üũ �Լ� ---------------------------->
function mem_id_check(){

    var member_id = 'id';
    var member_id = eval("document.member_form." + member_id);

    if(member_id.value.length <= 4 || member_id.value.length >= 20) {
       alert('���̵�� 4 ~ 20�� �̳��� �����ҹ��ڳ� ���� �Ǵ� ���յ� ���ڿ��̾�� �մϴ�');
       member_id.focus();
       member_id.select();
       return false;
    }

    for(var i = 0; i < member_id.value.length; i++) {
       var chr = member_id.value.substr(i,1);         
       if((chr < '0' || chr > '9') && (chr < 'a' || chr > 'z')) {
           alert('���̵�� 4 ~ 20�� �̳��� �����ҹ��ڳ� ���� �Ǵ� ���յ� ���ڿ��̾�� �մϴ�');
           member_id.focus();
           member_id.select();
           return false;  
       }
    }

    if(!member_id.value) {
        alert('���̵� �Է��Ͻ� �Ŀ� Ȯ���ϼ���.');
        member_id.focus();
        return false;
    }
    
    return true;
}
//---------------- ȸ�� ���̵� üũ �Լ� ---------------------------->

//---------------- �н����� üũ �Լ� ------------------------------->
function mem_pass_check(){
    var member_pass = eval(document.member_form.passwd);

    if(member_pass.value.length < 4 || member_pass.value.length > 15) {
       alert('�н������ 4 ~ 15����  �����ڳ� ���� �Ǵ� ���յ� ���ڿ��̾�� �մϴ�');
       member_pass.focus();
       member_pass.select();
       return false;
    }

    return true;
}
//---------------- �н����� üũ �Լ� ---------------------------->

//---------------- E-Mail üũ �Լ� ------------------------------>
function email_check() {
  var email = document.member_form.email;
  var email_num = document.member_form.email.value.length;
  var str_email = document.member_form.email.value;
  for (var l = 0; l <= (email_num - 1); l++){
     if(str_email.indexOf(' ') >= 0 ){
        alert ('E ���� �ּҿ��� ������ ���ֽʽÿ�');
        email.focus();
        email.select();
        return false;
     }
  }
  if ((str_email.indexOf('/')) != -1){
     alert('���� ������ �߸��Ǿ����ϴ�');
      email.focus();
     email.select();
      return false;
  }
  if ((str_email.indexOf(';')) != -1){
      alert('���� ������ �߸��Ǿ����ϴ�');
      email.focus();
     email.select();
      return false;
  }
  if ((email_num != 0) && (str_email.search(/(\S+)@(\S+)\.(\S+)/) == -1)){
      alert('���� ������ �߸��Ǿ����ϴ�');
      email.focus();
     email.select();
      return false;
  }
  if (h_check(email) == -1) {
     alert('�ѱ��� ����� �� �����ϴ�');
     email.focus();
     email.select();
      return false;
  }
  return true;
}
//---------------- E-Mail üũ �Լ� ------------------------------>

//---------------- �ֹι�ȣ üũ �Լ� ---------------------------->
function jumin_check() {
    
    var chk =0
    var yy = member_form.jumin1.value.substring(0,2)
    var mm = member_form.jumin1.value.substring(2,4)
    var dd = member_form.jumin1.value.substring(4,6)
    var sex = member_form.jumin2.value.substring(0,1)

    if ((member_form.jumin1.value.length!=6)||(yy <25||mm <1||mm>12||dd<1)){
            alert ('�߸��� �ֹε�Ϲ�ȣ�Դϴ�');
            member_form.jumin1.value='';
            member_form.jumin2.value='';
            member_form.jumin1.focus();
            return false;
    }

    if ((sex != 1 && sex !=2 )||(member_form.jumin2.value.length != 7 )){
            alert ('�߸��� �ֹε�Ϲ�ȣ�Դϴ�');
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
            alert ('�ֹε�Ϲ�ȣ�� �����ʽ��ϴ�');
            member_form.jumin1.value='';
            member_form.jumin2.value='';
            member_form.jumin2.focus();
            return;
    }
    return true;
}
//---------------- �ֹι�ȣ üũ �Լ� ---------------------------->


function chk_member_form(){

    var f = document.member_form;

    //if(!IsreqCheck())   return false;

    if(!f.id.value) {
        alert('���̵� �ۼ��� �ּ���.');
        f.id.focus();
        return false;
    }
    if(!mem_id_check()) return false;

    if(!f.passwd.value || !f.re_passwd.value) {
        alert('��ȣ�� �ۼ��� �ּ���.');
        f.passwd.focus();
        return false;
    }
    if(f.passwd.value != f.re_passwd.value) {
        alert('��ȣ�� ��ġ���� �ʽ��ϴ�.');
        f.passwd.value='';
        f.re_passwd.value='';
        f.passwd.focus();
        return false;
    }
    if(!mem_pass_check()) return false;

    if(!f.name.value) {
        alert('�̸��� �ۼ��� �ּ���.');
        f.name.focus();
        return false;
    }
    
    
        if(Isreq('email')){
            if(!f.email.value) {
                alert('�̸��� �� �ۼ��� �ּ���.');
                f.email.focus();
                return false;
            }
            if(!email_check()) return false;
        }
        if(Isreq('homepage')){
            if(!f.homepage.value) {
                f.homepage.focus();
                alert('Ȩ��������(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('c_phone')){
            if(!f.c_phone1.value || !f.c_phone2.value || !f.c_phone3.value) {
                alert('�ڵ�����(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(f.c_phone1 && !IsNumber(f.c_phone1)) {
            alert('�ڵ�����(��) ���ڷ� �ۼ��� �ּ���.');        
            f.c_phone1.value=''
            f.c_phone1.focus();
            return false;
        }
        if(f.c_phone2 && !IsNumber(f.c_phone2)) {
            if(!IsNumber(f.c_phone2)) {
                alert('�ڵ�����(��) ���ڷ� �ۼ��� �ּ���.');        
                f.c_phone2.value='';
                f.c_phone2.focus();
                return false;
            }
        }
        if(f.c_phone3 && !IsNumber(f.c_phone3)) {
            if(!IsNumber(f.c_phone3)) {
                alert('�ڵ�����(��) ���ڷ� �ۼ��� �ּ���.');        
                f.c_phone3.value=''
                f.c_phone3.focus();
                return false;
            }
        }
        if(Isreq('h_phone')){
            if(!f.h_phone1.value || !f.h_phone2.value || !f.h_phone3.value) {
                alert('��ȭ��ȣ��(��) �ۼ��� �ּ���.');
                f.h_phone1.focus();
                return false;
            }
        }
        if(f.h_phone1 && !IsNumber(f.h_phone1)) {
            alert('��ȭ��ȣ��(��) ���ڷ� �ۼ��� �ּ���.');        
            f.h_phone1.value=''
            f.h_phone1.focus();
            return false;
        }
        if(f.h_phone2 && !IsNumber(f.h_phone2)) {
            if(!IsNumber(f.h_phone2)) {
                alert('��ȭ��ȣ��(��) ���ڷ� �ۼ��� �ּ���.');        
                f.h_phone2.value='';
                f.h_phone2.focus();
                return false;
            }
        }
        if(f.h_phone3 && !IsNumber(f.h_phone3)) {
            if(!IsNumber(f.h_phone3)) {
                alert('��ȭ��ȣ��(��) ���ڷ� �ۼ��� �ּ���.');        
                f.h_phone3.value=''
                f.h_phone3.focus();
                return false;
            }
        }
        if(Isreq('jumin')){
            if(!f.jumin1.value || !f.jumin2.value) {
                alert('�ֹε�Ϲ�ȣ ��(��) �ۼ��� �ּ���.');
                return false;
            }

            if(!IsNumber(f.jumin1)) {
                alert('�ֹε�Ϲ�ȣ�� ���ڿ��� �մϴ�.');
                f.jumin2.focus();
                return false;         
            }
            if(!IsNumber(f.jumin2)) {
                alert('�ֹε�Ϲ�ȣ�� ���ڿ��� �մϴ�.');
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
                alert('������(��) �ۼ��� �ּ���.');
                f.birth1.focus();
                return false;
            }
        }
        if(f.birth1 && !IsNumber(f.birth1)) {
            alert('������(��) ���ڷ� �ۼ��� �ּ���.');        
            f.birth1.value=''
            f.birth1.focus();
            return false;
        }
        if(f.birth2 && !IsNumber(f.birth2)) {
            if(!IsNumber(f.birth2)) {
                alert('������(��) ���ڷ� �ۼ��� �ּ���.');        
                f.birth2.value='';
                f.birth2.focus();
                return false;
            }
        }
        if(f.birth3 && !IsNumber(f.birth3)) {
            if(!IsNumber(f.birth3)) {
                alert('������(��) ���ڷ� �ۼ��� �ּ���.');        
                f.birth3.value=''
                f.birth3.focus();
                return false;
            }
        }
        if(Isreq('birth_type')){
            if(!f.birth_type.value) {
                f.birth_type.focus();
                alert('��(��)����(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('h_zip')){
            if(!f.h_zip1.value || !f.h_zip2.value) {
                alert('zip code��(��) �ۼ��� �ּ���.');
                f.h_zip1.focus();
                return false;
            }
        }
        if(f.h_zip1 && !IsNumber(f.h_zip1)) {
            alert('zip code��(��) ���ڷ� �ۼ��� �ּ���.');        
            f.h_zip1.value=''
            f.h_zip1.focus();
            return false;
        }
        if(f.h_zip2 && !IsNumber(f.h_zip2)) {
            if(!IsNumber(f.h_zip2)) {
                alert('zip code��(��) ���ڷ� �ۼ��� �ּ���.');        
                f.h_zip2.value='';
                f.h_zip2.focus();
                return false;
            }
        }
        if(Isreq('h_addr')){
            if(!f.h_addr.value) {
                f.h_addr.focus();
                alert('���ּ���(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('sex')){
            if(!f.sex.value) {
                f.sex.focus();
                alert('������(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('job')){
            if(!f.job.value) {
                f.job.focus();
                alert('������(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('mailling')){
            if(!f.mailling.value) {
                f.mailling.focus();
                alert('���ϸ� ������(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('info_open')){
            if(!f.info_open.value) {
                f.info_open.focus();
                alert('��������������(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('recom_id')){
            if(!f.recom_id.value) {
                f.recom_id.focus();
                alert('��õ���̵���(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('intro')){
            if(!f.intro.value) {
                f.intro.focus();
                alert('�ڱ� �Ұ���(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('add_01')){
            if(!f.add_01.value) {
                f.add_01.focus();
                alert('�����ϴ� ��������(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('add_02')){
            if(!f.add_02.value) {
                f.add_02.focus();
                alert('�������(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('add_03')){
            if(!f.add_03.value) {
                f.add_03.focus();
                alert('��ȥ ������(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('add_04')){
            if(!f.add_04.value) {
                f.add_04.focus();
                alert('���� ���� �ޱ���(��) �ۼ��� �ּ���.');
                return false;
            }
        }
        if(Isreq('add_05')){
            if(!f.add_05.value) {
                f.add_05.focus();
                alert('����Ʈ ���ǻ�����(��) �ۼ��� �ּ���.');
                return false;
            }
        }
   
    return true;

        //f.action = 'community.php3?link=member';
        //f.submit();
}

// �ߺ� ���̵� �˻�
function search_id(){
    
    if(!mem_id_check()) return false;
    else{
        var m_id = document.member_form.id.value;
        window.open("http://www.keodo.co.kr/bbseboard/member/member.php3?link=di&search_id=" + m_id,"dup_id","width=400,height=200,scrollbars=yes");
        return true;
    }    
}

// �����ȣ �˻�
function post_searching(){
    window.open("http://www.keodo.co.kr/bbseboard/member/member.php3?link=sa","post_searching","width=450,height=200,scrollbars=yes");
    return true;
}

//-->

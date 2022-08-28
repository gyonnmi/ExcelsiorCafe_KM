/*loginOk.js*/

const loginForm=document.querySelector('#loginForm');
const userId=document.querySelector('#userId');
const userPw=document.querySelector('#userPw');
const loginOkBtn=document.querySelector('#loginOkBtn');

//유효성 검사
loginOkBtn.addEventListener('click', ()=>{
	if(userId==null || userId.value=="" || userId.value<=0) {
		alert("아이디를 입력하세요!");
		userId.focus();
		return false;
	}
	if(userPw==null || userPw.value=="" || userPw.value<=0) {
		alert("비밀번호를 입력하세요!");
		userPw.focus();
		return false;
	}
	
	alert("로그인 실행!");
	loginForm.submit();
	

});





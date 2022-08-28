/*updateOk.js*/

const updateForm=document.querySelector('#updateForm');
const userId=document.querySelector('#userId');
const userPw=document.querySelector('#userPw');
const userPw2=document.querySelector('#userPw2');
const userName=document.querySelector('#userName');
const userBirthday=document.querySelector('#userBirthday');
const userPhone=document.querySelector('#userPhone');
const updateOkBtn=document.querySelector('#updateOkBtn');

//비밀번호 체크
userPw2.addEventListener('keyup',()=>{
	if(userPw.value!=userPw2.value) {
		pwch.innerText="비밀번호가 틀립니다.";
		pwch.classList.remove('pwch2');
	} else {
		pwch.innerText="비밀번호가 일치합니다.";
		pwch.classList.add('pwch2');
	}
});

//유효성 검사
updateOkBtn.addEventListener('click', ()=>{
	if(userPw==null || userPw.value=="" || userPw.value<=0) {
		alert("비밀번호를 입력하세요!");
		userPw.focus();
		return false;
	}
	if(userPw2==null || userPw2.value=="" || userPw2.value<=0) {
		alert("비밀번호를 입력하세요!");
		userPw2.focus();
		return false;
	}
	if(userPw.value!=userPw2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		userPw2.focus();
		return false;
	}
	if(userName==null || userName.value=="" || userName.value<=0) {
		alert("이름을 입력하세요!");
		userName.focus();
		return false;
	}
	if(userBirthday==null || userBirthday.value=="" || userBirthday.value<=0) {
		alert("생년월일을 입력하세요!");
		userBirthday.focus();
		return false;
	}
	if(userPhone==null || userPhone.value=="" || userPhone.value<=0) {
		alert("전화번호를 입력하세요!");
		userPhone.focus();
		return false;
	}
	
	alert("회원 정보 수정을 완료했습니다!");
	updateForm.submit();
	
});














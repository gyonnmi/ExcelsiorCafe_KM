/*joinOk.js*/

const joinForm=document.querySelector('#joinForm');
const userId=document.querySelector('#userId');
const userPw=document.querySelector('#userPw');
const userPw2=document.querySelector('#userPw2');
const userName=document.querySelector('#userName');
const userBirthday=document.querySelector('#userBirthday');
const userPhone=document.querySelector('#userPhone');
const joinOkBtn=document.querySelector('#joinOkBtn');
const idCheckBtn=document.querySelector('#idCheckBtn');


const xhr=new XMLHttpRequest();

idCheckBtn.addEventListener('click', ()=>{
	const data="userId="+userId.value; //"userId=값"
	const url="ajaxIdChecked.do";
	//2		//방식	url 비동기(기본)
	xhr.open("POST", url, true);
	//3
	xhr.setRequestHeader("content-type",
		"application/x-www-form-urlencoded;charset=utf8");
	//4
	xhr.onreadystatechange=function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("Success!!");
			const result=xhr.responseText; //서버에서 response data
			
			
			console.log(result+" << result");
			//아이디가 있으면 select count(*) from 테이블명 where userId=? -> 1
			//아이디가 없으면 select count(*) from 테이블명 where userId=? -> !1
			if(result == 1) {
				alert("중복된 아이디 입니다.");
				userId.focus();
			} else {
				alert("사용할 수 있는 아이디 입니다.");
				userPw.focus();
			}
		}
	}
	xhr.send(data);
});

function joinOk() {
	let data="userId="+userId.value+"&"+
	"userPw="+userPw.value+"&"+
	"userPw2="+userPw2.value+"&"+
	"userName="+userName.value+"&"+
	"userBirthday="+userBirthday.value+"&"+
	"userPhone="+userPhone.value;
	
	const url="joinOk.do";
//	const url="loginView.do";
	console.log(data);
	
	xhr.open("POST", url, true);
	xhr.setRequestHeader("content-type",
	"application/x-www-form-urlencoded;charset=utf8");
	xhr.onreadystatechange=function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			const result=xhr.responseText; //서버에서 response data
			if(result == 1) {
				alert("회원가입 실패");
			} else {
				alert("회원가입 성공!");
				location.href="/webProject_KM/loginView.do";
			}
		}
	}
	xhr.send(data);
}

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
joinOkBtn.addEventListener('click', ()=>{
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
	joinOk();	
	alert("회원가입 실행!");
});















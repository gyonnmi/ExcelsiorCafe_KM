/*noticeWrite.js*/

const noticeWriteForm=document.querySelector('#noticeWriteForm');
const notice_no=document.querySelector('#notice_no');
const notice_title=document.querySelector('#notice_title');
const notice_content=document.querySelector('#notice_content');
const notice_date=document.querySelector('#notice_date');
const noticeWriteOkBtn=document.querySelector('#noticeWriteOkBtn');

noticeWriteOkBtn.addEventListener('click',()=>{
	if(notice_no==null || notice_no.value=="" || notice_no.value<=0) {
		alert("게시글 번호 미입력");
		notice_no.focus();
		return false;
	}
	if(notice_title==null || notice_title.value=="" || notice_title.value<=0) {
		alert("제목 미입력");
		notice_title.focus();
		return false;
	}
	if(notice_content==null || notice_content.value=="" || notice_content.value<=0) {
		alert("내용 미입력");
		notice_content.focus();
		return false;
	}
	if(notice_date==null || notice_date.value=="" || notice_date.value<=0) {
		alert("작성일자 미입력");
		notice_date.focus();
		return false;
	}
	alert('게시글 작성을 완료했습니다!');
	noticeWriteForm.submit();
});
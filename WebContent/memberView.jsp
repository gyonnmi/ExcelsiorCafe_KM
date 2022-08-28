<%@page import="org.project.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
MemberDto member = 
	(MemberDto)request.getAttribute("member");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberView</title>
<link rel="stylesheet" href="css/memberView.css" />
<script src="js/updateOk.js" defer></script>
</head>
<body>
	<%@include file="common/header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<div class="update">
				<form action="updateOk.do" method="post" id="updateForm">
					<table>
						<thead>
							<tr>
								<th>MODIFY</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<label for="userId">아이디</label> <br />
									<input type="hidden" name="userId" id="userId" value="<%=member.getUserId() %>"/>
									<span class="id"><%=member.getUserId() %></span>
								</td>
							</tr>
							<tr>
								<td>
									<label for="userPw">비밀번호</label> <br />
									<input type="password" name="userPw" id="userPw" placeholder="비밀번호를 입력해 주세요." />
								</td>
							</tr>
							<tr>
								<td>
									<label for="userPw2">비밀번호 재확인</label> <br />
									<input type="password" name="userPw2" id="userPw2" placeholder="비밀번호를 다시 입력해 주세요." />
								</td>
							</tr>
							<tr>
								<td>
									<span id="pwch" class="pwch2"></span>
								</td>
							</tr>
							<tr>
								<td>
									<label for="userName">이름</label> <br />
									<input type="text" name="userName" id="userName" value="<%=member.getUserName() %>" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="userBirthday">생년월일</label> <br />
									<input type="text" name="userBirthday" id="userBirthday" value="<%=member.getUserBirthday() %>" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="userPhone">휴대전화</label> <br />
									<input type="text" name="userPhone" id="userPhone" value="<%=member.getUserPhone() %>" />
								</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td>
									<input type="button" value="정보수정" id="updateOkBtn" />
									<hr />
									<a href="memberDeleteView.do?userId=<%=member.getUserId() %>">회원탈퇴</a>
								</td>
							</tr>
						</tfoot>
					</table>
				</form>
			</div>
		</div>
	</div>
	<%@include file="common/footer.jsp" %>
</body>
</html>
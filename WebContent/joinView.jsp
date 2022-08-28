<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join page</title>
<link rel="stylesheet" href="css/join.css" />
<script src="js/joinOk.js" defer></script>
</head>
<body>
	<%@include file="common/header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<div class="join">
				<form action="joinOk.do" method="post" id="joinForm">
					<table>
						<thead>
							<tr>
								<th>SIGN UP</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<label for="userId">아이디</label> <br />
									<input type="text" name="userId" id="userId" placeholder="아이디를 입력해 주세요." class="input-id"/>
									<input type="button" value="중복확인" id="idCheckBtn" class="" />
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
									<input type="text" name="userName" id="userName" placeholder="이름을 입력해 주세요." />
								</td>
							</tr>
							<tr>
								<td>
									<label for="userBirthday">생년월일</label> <br />
									<input type="text" name="userBirthday" id="userBirthday" placeholder="생년월일을 입력해 주세요. (ex. 19980713)" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="userPhone">휴대전화</label> <br />
									<input type="text" name="userPhone" id="userPhone" placeholder="전화번호를 입력해 주세요. (ex. 010-0000-0000)" />
								</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td>
									<input type="button" value="가입하기" id="joinOkBtn" />
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
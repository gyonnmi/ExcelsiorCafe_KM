<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<link rel="stylesheet" href="css/login.css" />
<script src="js/loginOk.js" defer></script>
</head>
<body>
	<%@include file="common/header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<div class="login">
				<form action="loginOk.do" method="post" id="loginForm">
					<table>
						<thead>
							<tr>
								<th>SIGN IN</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="text" name="userId" id="userId" placeholder="아이디를 입력해 주세요." /></td>
							</tr>
							<tr>
								<td><input type="password" name="userPw" id="userPw" placeholder="비밀번호를 입력해 주세요." /></td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td>
									<input type="button" value="로그인" id="loginOkBtn" /> <br />
									<hr />
									<a href="joinView.do">회원가입</a>
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
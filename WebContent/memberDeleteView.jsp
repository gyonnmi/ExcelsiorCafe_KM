<%@page import="org.project.dao.ProjectDao"%>
<%@page import="org.project.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String userId =
	(String)request.getAttribute("userId");
ProjectDao dao=ProjectDao.getInstance();
String dbPassword=dao.dbPassword(userId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good Bye</title>
<link rel="stylesheet" href="css/memberDelete.css" />
</head>
<body>
	<%@include file="common/header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<div class="delete">
				<form action="deleteOk.do" method="post" id="deleteForm">
					<table>
						<thead>
							<tr>
								<th>DELETE ACCOUNT</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<label for="userId">아이디</label> <br />
									<input type="hidden" name="userId" id="userId" value="<%=userId %>"/>
									<span class="id"><%=userId %></span>
								</td>
							</tr>
							<tr>
								<td>
								<%
									if(sessionId.equals("admin")) {
								%>
									<label for="userPw">비밀번호</label> <br />
									<input type="text" name="userPw" id="userPw" value="<%=dbPassword %>" />
								<%		
									} else {
								%>
									<label for="userPw">비밀번호</label> <br />
									<input type="password" name="userPw" id="userPw" placeholder="비밀번호를 입력해 주세요." />
								<%	
									}
								%>
								</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td>
									<input type="submit" value="회원탈퇴" id="deleteOkBtn" />
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
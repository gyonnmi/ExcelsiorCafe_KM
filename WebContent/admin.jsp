<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userId=(String)session.getAttribute("sessionId");
	if(userId==null || !userId.equals("admin")) {
		out.println("<script>");
    out.println("alert('관리자 외에 접근이 불가합니다.');");
    out.println("</script>");
    response.sendRedirect("/index.do");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="css/admin.css" />
</head>
<body>
	<%@include file="common/header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<div class="admin">
				<p class="welcome"><span><%=userId %></span>님, 환영합니다!</p>
				<div class="list-con">
					<ul>
						<li><a href="memberListView.do">회원목록조회</a></li>
						<li><a href="noticeWriteView.bo">공지사항 작성</a></li>
						<li><a href="#">Ex1</a></li>
						<li><a href="#">Ex2</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<%@include file="common/footer.jsp" %>
</body>
</html>
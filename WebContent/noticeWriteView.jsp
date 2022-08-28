<%@page import="org.project.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userId=(String)session.getAttribute("sessionId");
	if(userId==null || !userId.equals("admin")) {
    response.sendRedirect("/index.do");
	}
	
	BoardDao dao=BoardDao.getInstance();
	String todayTime=dao.getDate();
	int notice_no=dao.maxNo();
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeWrite</title>
<link rel="stylesheet" href="css/noticeWrite.css" />
<script src="js/noticeWrite.js" defer></script>
</head>
<body>
	<%@include file="common/header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<div class="notice">
				<form action="noticeWriteOk.bo" method="post" id="noticeWriteForm">
					<table>
						<thead>
							<tr>
								<th colspan="2">Notice</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><label for="notice_no">번호</label></td>
								<td><input type="text" name="notice_no" id="notice_no" value="<%=notice_no %>" /></td>
							</tr>
							<tr>
								<td><label for="notice_title">제목</label></td>
								<td><input type="text" name="notice_title" id="notice_title" /></td>
							</tr>
							<tr>
								<td><label for="notice_content">내용</label></td>
								<td><textarea rows="15" cols="25" name="notice_content" id="notice_content"></textarea></td>
							</tr>
							<tr>
								<td><label for="notice_date">작성일자</label></td>
								<td><input type="text" name="notice_date" id="notice_date" value="<%=todayTime %>" /></td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="2">
									<input type="button" value="작성하기" id="noticeWriteOkBtn" />
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
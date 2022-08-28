<%@page import="org.project.dao.BoardDao"%>
<%@page import="org.project.dto.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	NoticeDto noti=(NoticeDto)request.getAttribute("noti");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeView</title>
<link rel="stylesheet" href="css/noticeView.css" />
</head>
<body>
	<%@include file="common/header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<h1 class="t1">공지사항</h1>
			<div class="sec">
				<hr color="#5d4037"/>
				<h3><%=noti.getNotice_title() %></h3>
				<p><%=noti.getNotice_date() %></p>
				<hr color="#5d4037"/>
				<div class="sec-con">
					<textarea rows="" cols="" readonly="readonly" class="ta"><%=noti.getNotice_content() %></textarea>
				</div>
			</div>
			<hr  style="border:2px solid #c0c0c0;"/>
			<a href="notice.bo" class="b1">목록</a>
		</div>
	</div>
	<%@include file="common/footer.jsp" %>
</body>
</html>
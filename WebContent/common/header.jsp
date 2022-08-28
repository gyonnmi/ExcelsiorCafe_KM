<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="header">
	<div class="nav">	
		<div class="top-nav">
			<div class="gnb">
				<ul>
				<%
					String sessionId=(String)session.getAttribute("sessionId");
					if(sessionId==null) {
				%>
					<li><a href="index.do">HOME</a></li>
					<li><a href="notice.bo">NOTICE</a></li>
					<li><a href="menu.bo">MENU</a></li>
					<li><a href="joinView.do">JOIN</a></li>
					<li><a href="loginView.do">LOGIN</a></li>
				<% 
					} else if(sessionId.equals("admin")) {
				%>
					<li><a href="index.do">HOME</a></li>
					<li><a href="notice.bo">NOTICE</a></li>
					<li><a href="menu.bo">MENU</a></li>
					<li><a href="admin.do" class="a1">#관리자 페이지</a></li>
					<li><a href="logout.do" class="a2">LOGOUT</a></li>
					<li><a href="#"><%=sessionId %>님</a></li>
				<%		
					} else if(sessionId!=null) {
				%>
					<li><a href="index.do">HOME</a></li>
					<li><a href="menu.do">MENU</a></li>
					<li><a href="memberView.do?userId=<%=sessionId %>">MY PAGE</a></li>
					<li><a href="logout.do" class="a2">LOGOUT</a></li>
					<li><a href="#"><%=sessionId %>님</a></li>
				<%		
					}
				%>
				</ul>
			</div>
		</div>
		<div class="bottom-nav">
			<div class="logo">
				<img src="img/logo.png" alt="" />
			</div>
		</div>
	</div>
</div>
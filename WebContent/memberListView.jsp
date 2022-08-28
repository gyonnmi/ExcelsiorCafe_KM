<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>   
  
<%
	request.setCharacterEncoding("UTF-8");
	String userId=(String)session.getAttribute("sessionId");
	if(userId==null || !userId.equals("admin")) {
    response.sendRedirect("/index.do");
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList</title>
<link rel="stylesheet" href="css/memberListView.css" />
</head>
<body>
	
<!-- Connection, DB Connect -->
<sql:setDataSource
	var="connect"
	driver="oracle.jdbc.driver.OracleDriver"
	url="jdbc:oracle:thin:@//localhost:1521/xe"
	user="system"
	password="1234"
/>

	<%@include file="common/header.jsp" %>
	
	<%-- 회원목록조회 --%>
	<sql:query var="result" dataSource="${connect }">
		select * from pj_member order by userId asc
	</sql:query>
	
	<div class="container">
		<div class="inner-con">
			<div class="memberListView-con">
				<div class="search">
					<div class="search-con">
						<form action="search.do" method="post" id="searchForm">
							<select name="sel" id="sel">
								<option value="">:::검색:::</option>
								<option value="userId">아이디</option>
								<option value="userName">이름</option>
								<option value="userBirthday">생년월일</option>
								<option value="userPhone">전화번호</option>
							</select>
							<input type="text" name="search" id="search" size="20" maxlength="20" placeholder="search"/>
							<input type="button" value="검색" id="searchBtn"/>		
						</form>
					</div>
				</div>
				<div class="table-con">
					<table>
						<thead>
							<tr>
								<th class="tit" colspan="6">회원 목록</th>
							</tr>
							<tr>
								<th>아이디</th>
								<th>비밀번호</th>
								<th>이름</th>
								<th>생년월일</th>
								<th>전화번호</th>
								<th>상세보기</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="member" items="${result.rows }" varStatus="status">
							<tr>
								<td>${member.userId }</td>
								<td>${member.userPw }</td>
								<td>${member.userName }</td>
								<td>${member.userBirthday }</td>
								<td>${member.userPhone }</td>
								<td><a href="memberView.do?userId=${member.userId }">상세</a></td>
							</tr>
						</c:forEach>
						</tbody>
						<tfoot></tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="common/footer.jsp" %>

</body>
</html>
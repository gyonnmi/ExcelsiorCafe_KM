<%@page import="org.project.dto.NoticeDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<NoticeDto> notices=(ArrayList<NoticeDto>)request.getAttribute("notices");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
<link rel="stylesheet" href="css/notice.css" />
</head>
<body>
	<%@include file="common/header.jsp" %>
	<div class="container">
		<div class="inner-con">
			<div class="notice">
				<h2 class="t1">Notice</h2>
				<form action="searchOk.bo" method="post" id="searchForm">
					<div class="search">
						<input type="text" name="search" id="search" size="20" maxlength="20" placeholder="검색어를 입력해 주세요."/>
						<input type="submit" value="검색" id="searchBtn"/>		
					</div>
				</form>
				<table>
					<thead>
						<tr>
							<th class="n1">NO</th>
							<th class="n2">제목</th>
							<th class="n3">날짜</th>
							<th class="n1">조회수</th>
						</tr>
					</thead>
					<tbody>
					<%
						for(NoticeDto list:notices) {
					%>
						<tr>
							<td><a href="noticeView.bo?notice_no=<%=list.getNotice_no() %>"><%=list.getNotice_no() %></a></td>
							<td class="tt"><a href="noticeView.bo?notice_no=<%=list.getNotice_no() %>"><%=list.getNotice_title() %></a></td>
							<td><%=list.getNotice_date() %></td>
							<td><%=list.getHit() %></td>
						</tr>
					<%		
						}
					%>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="4">
								[<a href="#"> ◀◀ </a>]
                [<a href="#"> ◀ </a>]
               	[<a href="#"> 1 </a>]
                [<a href="#"> 2 </a>]
                [<a href="#"> 3 </a>]
                [<a href="#"> 4 </a>]
                [<a href="#"> 5 </a>]
                [<a href="#"> 6 </a>]
                [<a href="#"> 7 </a>]
                [<a href="#"> 8 </a>]
                [<a href="#"> 9 </a>]
                [<a href="#"> 10 </a>]
                [<a href="#"> ▶ </a>]
                [<a href="#"> ▶▶ </a>]
              </td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
	<%@include file="common/footer.jsp" %>
</body>
</html>
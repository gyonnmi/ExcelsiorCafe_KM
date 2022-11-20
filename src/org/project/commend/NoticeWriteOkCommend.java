package org.project.commend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.BoardDao;

public class NoticeWriteOkCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("NoticeWriteOkCommend");
		
		int notice_no=Integer.parseInt(request.getParameter("notice_no"));
		String notice_title=request.getParameter("notice_title");
		String notice_content=request.getParameter("notice_content");
		String notice_date=request.getParameter("notice_date");
		int hit=0;
		
		BoardDao dao=BoardDao.getInstance();
		int rs=dao.noticeWrite(notice_no, notice_title, notice_content, notice_date, hit);
		
		String url="";
		if(rs!=1) {
			System.out.println("공지사항 작성 실패");
			url="/admin.jsp";
		} else {
			System.out.println("공지사항 작성 성공");
			url="/index.jsp";
		}
		request.setAttribute("url", url);
	}
}

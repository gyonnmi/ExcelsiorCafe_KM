package org.project.commend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.ProjectDao;

public class DeleteOkCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원탈퇴 commend");
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		
		ProjectDao dao=ProjectDao.getInstance();
		
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("sessionId");
		
		boolean rs=dao.deleteDo(userId, userPw);
		String url="";
		if(rs==true) {
			if(sessionId.equals("admin")) {
				System.out.println("관리자권한 회원탈퇴 Ok");
				url="/memberListView.do";
			} else {
				System.out.println("회원탈퇴 Ok");
				url="/index.do";
				session.invalidate();				
			}
		} else {
			System.out.println("회원탈퇴  Fail");
			url="/index.do";	
		}
		request.setAttribute("url", url);
	}
}

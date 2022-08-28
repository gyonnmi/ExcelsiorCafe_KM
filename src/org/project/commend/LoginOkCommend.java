package org.project.commend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.ProjectDao;

public class LoginOkCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인 commend");
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		
		ProjectDao dao=ProjectDao.getInstance();
		
		HttpSession session=request.getSession();
		
		int rs=dao.loginDo(userId, userPw);
		
		String url="";
		
		if(rs!=1) {
			System.out.println("로그인 실패");
			url="index.do";
		} else if(userId.equals("admin") && userPw.equals("0713")) {
			System.out.println("관리자 로그인 성공");
			session.setAttribute("sessionId", userId);
			url="/admin.jsp";
		} else {
			System.out.println("일반 회원 로그인 성공");
			session.setAttribute("sessionId", userId);
			url="index.do";
		}
		
		request.setAttribute("url", url);
		
	}

}

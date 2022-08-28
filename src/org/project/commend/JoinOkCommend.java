package org.project.commend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.ProjectDao;

public class JoinOkCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원가입 commend");
		
		String userId=request.getParameter("userId");
		String userPw=request.getParameter("userPw");
		String userName=request.getParameter("userName");
		String userBirthday=request.getParameter("userBirthday");
		String userPhone=request.getParameter("userPhone");
		
		ProjectDao dao=ProjectDao.getInstance();

		int rs=dao.insertDo(userId, userPw, userName, userBirthday, userPhone);
		
		String url="";
		
		if(rs!=1) {
			System.out.println("회원가입 실패");
			url="/index.do";
		} else {
			System.out.println("회원가입 성공");
			url="/loginView.do";
		}
		request.setAttribute("url", url); 
	}
}

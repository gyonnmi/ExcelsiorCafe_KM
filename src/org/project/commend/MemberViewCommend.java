package org.project.commend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.ProjectDao;
import org.project.dto.MemberDto;

public class MemberViewCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원상세보기 commend");
		
		String userId=request.getParameter("userId");
		
		ProjectDao dao=ProjectDao.getInstance();
		MemberDto member=dao.memberViewDo(userId);
		
		String url="";
		if(member!=null) {
			System.out.println("회원상세조회 Ok");
			request.setAttribute("member", member);
			url="/memberView.jsp";
		} else {
			System.out.println("회원상세조회  Fail");
			url="/index.do";
		}
		
		request.setAttribute("url", url);
		
	}

}


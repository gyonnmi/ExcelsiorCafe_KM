package org.project.commend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그아웃 commend");
		
		HttpSession session=request.getSession();
		
		//������ ���� ������ ��� ����
		session.invalidate();
		
		String url="/index.do";
		
		request.setAttribute("url", url);
	}

}

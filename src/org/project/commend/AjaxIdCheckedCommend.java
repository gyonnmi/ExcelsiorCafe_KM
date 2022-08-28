package org.project.commend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.ProjectDao;

public class AjaxIdCheckedCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Ajax IdChecked commend");
		
response.setContentType("text/html);charset=utf-8");
		
		String userId=request.getParameter("userId");
		
		ProjectDao dao=ProjectDao.getInstance();
		
		int rs=dao.idChecked(userId);
		
		System.out.println(rs+ " 1=중복 / 0=사용가능");
		PrintWriter out=response.getWriter();
		
		out.print(rs+"");
		out.close();
	}

}

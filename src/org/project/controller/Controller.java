package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.commend.AjaxIdCheckedCommend;
import org.project.commend.DeleteOkCommend;
import org.project.commend.ExcuteCommend;
import org.project.commend.JoinOkCommend;
import org.project.commend.LoginOkCommend;
import org.project.commend.LogoutCommend;
import org.project.commend.MemberViewCommend;
import org.project.commend.UpdateOkCommend;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글 인코딩(한글처리)
		
		String path=request.getContextPath(); //프로젝트 path만 얻어온다.
		// => /webProject_KM
		String uri=request.getRequestURI(); //프로젝트와 파일경로까지 얻어온다.
		// => /webProject_KM/index.do
		String basicURL=uri.substring(path.length());
		// => /index.do
		
		System.out.println(basicURL);
		
		ExcuteCommend commend=null;
		
		String url="";
		
		if(basicURL.equals("/index.do")) {
			url="/index.jsp";
		} else if(basicURL.equals("/loginView.do")) {
			url="/loginView.jsp";
		} else if(basicURL.equals("/joinView.do")) {
			url="/joinView.jsp";
		} else if(basicURL.equals("/joinOk.do")) {
			commend=new JoinOkCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/loginOk.do")) {
			commend=new LoginOkCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/logout.do")) {
			commend=new LogoutCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/admin.do")) {
			url="/admin.jsp";
		} else if(basicURL.equals("/memberListView.do")) {
			url="/memberListView.jsp";
		} else if(basicURL.equals("/memberView.do")) {
			commend=new MemberViewCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/updateOk.do")) {
			commend=new UpdateOkCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/deleteOk.do")) {
			commend=new DeleteOkCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/memberDeleteView.do")) {
			String userId=request.getParameter("userId");
			request.setAttribute("userId", userId);
			url="/memberDeleteView.jsp";
			System.out.println("탈퇴 회원 아이디: "+userId);
		} else if(basicURL.equals("/ajaxIdChecked.do")) {
			commend=new AjaxIdCheckedCommend();
			commend.excuteQueryCommend(request, response);
			return;
		}
		RequestDispatcher disp=request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글 인코딩(한글처리)
		doGet(request, response);
	}

}

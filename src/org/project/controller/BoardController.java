package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.commend.ExcuteCommend;
import org.project.commend.NoticeListCommend;
import org.project.commend.NoticeViewCommend;
import org.project.commend.NoticeWriteOkCommend;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String path=request.getContextPath(); //프로젝트 path만 얻어온다.
		// => /webProject_KM
		String uri=request.getRequestURI(); //프로젝트와 파일경로까지 얻어온다.
		// => /webProject_KM/index.do
		String basicURL=uri.substring(path.length());
		// => /index.do
		
		System.out.println(basicURL);
		
		ExcuteCommend commend=null;
		
		String url="";
		
		if(basicURL.equals("/menu.bo")) {
			url="/menu.jsp";
		} else if(basicURL.equals("/noticeWriteView.bo")) {
			url="/noticeWriteView.jsp";
		} else if(basicURL.equals("/noticeWriteOk.bo")) {
			commend=new NoticeWriteOkCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/notice.bo")) {
			commend=new NoticeListCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		} else if(basicURL.equals("/noticeView.bo")) {
			commend=new NoticeViewCommend();
			commend.excuteQueryCommend(request, response);
			url=(String)request.getAttribute("url");
		}
		
		RequestDispatcher disp=request.getRequestDispatcher(url);
		disp.forward(request, response);
	}
}

package org.project.commend;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.BoardDao;
import org.project.dto.NoticeDto;

public class NoticeListCommend implements ExcuteCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("NoticeListCommend");
		
		BoardDao dao=BoardDao.getInstance();
		ArrayList<NoticeDto> notices=dao.notice();
		
		String url="";
		if(notices!=null) {
			System.out.println("공지사항 조회 성공");
			url="/notice.jsp";
			request.setAttribute("notices", notices);
		} else {
			System.out.println("공지사항 조회 실패");
			url="/notice.jsp";
		}
		request.setAttribute("url", url);
	}

}

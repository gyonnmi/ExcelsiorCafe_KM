package org.project.commend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.BoardDao;
import org.project.dto.NoticeDto;

public class NoticeViewCommend implements ExcuteCommend {

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("NoticeViewCommend");
		
		int notice_no=Integer.parseInt(request.getParameter("notice_no"));
		
		BoardDao dao=BoardDao.getInstance();
		NoticeDto noti=dao.NoticeView(notice_no);
		int hit=dao.updateHit(notice_no);
		
		String url="";
		if(noti!=null) {
			System.out.println("공지 조회 성공");
			request.setAttribute("noti", noti);
			request.setAttribute("hit", hit);
			url="/noticeView.jsp";
		} else {
			System.out.println("공지 조회 실패");
			url="/notice.bo";
		}
		request.setAttribute("url", url);
	}

}

package com.jspprj.web.dao.controller.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspprj.web.dao.NoticeDao;
import com.jspprj.web.dao.mybatis.MyBatisNoticeDao;
import com.jspprj.web.entities.Notice;
import com.jspprj.web.model.NoticeModel;

@WebServlet("/customer/notice-edit")
public class NoticeEditController extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//사용자 입력
		String _code = request.getParameter("code");
		NoticeDao noticeDao = new MyBatisNoticeDao();
		Notice notice;
		notice = noticeDao.get(_code);
		request.setAttribute("n", notice);



		//2.자원을 공유하면서 부르기: 일을 이서서 계속
		request.getRequestDispatcher("/WEB-INF/views/customer/notice-edit.jsp").forward(request,response);
		//Dispatcher 누군가를 호출하기 위한도구 forward 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String content = request.getParameter("content");
		String title = request.getParameter("title");

		NoticeDao noticeDao = new MyBatisNoticeDao();

		Notice notice = new Notice();
		notice.setCode(code);
		notice.setTitle(title);
		notice.setContent(content);

		noticeDao.update(notice);
		//	      request.getRequestDispatcher("/WEB-INF/views/customer/notice-edit.jsp").forward(request, response);
		response.sendRedirect("notice-detail?code="+code);
	}
}

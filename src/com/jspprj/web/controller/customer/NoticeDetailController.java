package com.jspprj.web.controller.customer;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspprj.web.dao.NoticeDao;
import com.jspprj.web.dao.NoticeFileDao;
import com.jspprj.web.dao.mybatis.MyBatisNoticeDao;
//import com.jspprj.web.dao.mybatis.MyBatisNoticeFileDao;
import com.jspprj.web.entities.Notice;
import com.jspprj.web.entities.NoticeFile;

/*준모 오빠가 주신 코드 16.10.31*/
@WebServlet("/customer/notice-detail")

public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String _code = request.getParameter("code");
		System.out.println(_code);

		NoticeDao noticeDao;  //DAO:data access object 즉 data service 하는 클래스를 분리해서 재사용하도록.
		Notice notice;
		noticeDao = new MyBatisNoticeDao();

	//	NoticeFileDao fdao = new MyBatisNoticeFileDao();
		//List<NoticeFile> noticeFiles;

		try {

			notice = noticeDao.get(_code);
		//	noticeFiles = fdao.getList(_code);
			//Notice notice = dao.get("31");
			//noticeDao.hitUp(_code);
			
			request.setAttribute("n", notice);
			request.setAttribute("pn", noticeDao.getPrev(_code));
			request.setAttribute("nn", noticeDao.getNext(_code));
		//	request.setAttribute("files",noticeFiles);

			/*String date = notice.getRegdate().toString();
			request.setAttribute("date",date);*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//DAO:data access object 즉 data service 하는 클래스를 분리해서 재사용하도록.
		//다른 서블릿을 불러야 한다 JSP를 불러
		//1. 그냥 부르기 : 네가 새로 해라 (일을 새로 분배할때)
		//response.sendRedirect("notice.jsp");
		//2. 자원을 공유하면서 부르기 : 일을 이어서 계속 해라 
		request.getRequestDispatcher("/WEB-INF/views/customer/notice-detail.jsp").forward(request, response);
	}
}


/*
@WebServlet("/customer/notice-detail")
public class NoticeDetailController extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //사용자 입력
      String _code = request.getParameter("code");
      NoticeDao noticeDao = new MyBatisNoticeDao();
      NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();

      Notice notice;
      List<NoticeFile> noticeFiles;

      notice=noticeDao.get(_code);
      noticeFiles = noticeFileDao.getList(_code);

      request.setAttribute("n", notice);
      request.setAttribute("files", noticeFiles);

      request.getRequestDispatcher("/WEB-INF/views/customer/notice-detail.jsp").forward(request, response);


   }
 */


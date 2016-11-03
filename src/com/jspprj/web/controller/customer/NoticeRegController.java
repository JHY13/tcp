package com.jspprj.web.controller.customer;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspprj.web.dao.NoticeDao;
import com.jspprj.web.dao.NoticeFileDao;
import com.jspprj.web.dao.mybatis.MyBatisNoticeDao;
//mport com.jspprj.web.dao.mybatis.MyBatisNoticeFileDao;
import com.jspprj.web.entities.Notice;
//import com.jspprj.web.entities.NoticeFile;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/customer/notice-reg")
public class NoticeRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/customer/notice-reg.jsp").forward(request, response);
	}   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*request.setCharacterEncoding("UTF-8");

      String title = request.getParameter("title");
      String content = request.getParameter("content");*/
		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/customer/upload"); /*물리경로 내가 업로드할 파일 경로*/
		System.out.println(path);

		MultipartRequest req = new MultipartRequest(request,
				path,
				1024*1024*100,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		String title = req.getParameter("title"); //단일값 지정. 겟파라미터
		System.out.println(title);
		String content = req.getParameter("content");

		/*String[] titles = req.getParameterValues("title"); //여러개의 값을 보내줄 때,
      for(String title : titles)
    	  System.out.println(title);*/

		NoticeDao noticeDao= new MyBatisNoticeDao();

		Notice n= new Notice();
		n.setTitle(title);//담아주기위한 코드
		n.setContent(content);//담아주기위한 코드
		n.setWriter("Jang94");  
		noticeDao.insert(n);


		String lastCode = noticeDao.getLastCode();
		//     String fname=req.getFilesystemName("file");
		Enumeration en = req.getFileNames();
		// String f1= req.getParameter("file");
		// String f3=req.getOriginalFileName("file");

		//NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();
		
		int i=1;
		while(en.hasMoreElements()){
		//NoticeFile nf = new NoticeFile();
		String name = (String)en.nextElement();
		System.out.println(i+name);
		String fname = req.getFilesystemName(name);
		System.out.println(i+"f: "+fname);
		//nf.setSrc(fname); //경로명은 안 넣는 게 좋음
		//nf.setNoticeCode(noticeDao.getLastCode());
		//noticeFileDao.insert(nf);
		}


		response.sendRedirect("notice");
		//System.out.println("fname :" +fname);

	}
}
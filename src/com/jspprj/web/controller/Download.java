package com.jspprj.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class Download extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = "end1.png";//request.getParameter("f");
	      
	      response.setHeader("Content-Disposition"
	            , String.format("attatchment; filename=\"%s\"" , fname));
	      
	      //-------File stream----------------------------------------------------------
	      
	      ServletContext ctx = request.getServletContext();
	      
	      String path = "/customer/upload/"+fname;
	      path = ctx.getRealPath(path);
	      
	      try{
	         File file = new File(path);
	         byte[] buf = new byte[1024];

	         FileInputStream fis = new FileInputStream(file);
	         
	         ServletOutputStream wos = response.getOutputStream();
	         
	         int count = -1;
	         
	         while((count =fis.read(buf)) !=-1)
	            wos.write(buf, 0, count);
	         
	         wos.flush();
	         fis.close();
	         wos.close();
	      }catch(Exception e){
	         e.printStackTrace();
	      }
	}
}

		
		/*	
		//"/downlaod?f=test.png"
		String fname = "end1.png";
//		String fname = request.getParameter("f");
		
		//response.setHeader("Content-Disposion", "attatchment;filename=\"hey.png\"" );
		response.setHeader("Content-Disposion",  
				String.format("attatchment;filename=\"%s\"", fname));
	
		response.setHeader("Content-Disposition"
	            , String.format("attatchment; filename=\"%s\"" , fname));
		
		ServletContext ctx =request.getServletContext();
		
		String path = "/customer/upload/"+fname; //리얼 패스
		path = ctx.getRealPath(path);
		
//		PrintWriter out = response.getWriter();
//		out.println(fname);
		
		 try{
	         File file = new File(path);
	         byte[] buf = new byte[1024];

	         FileInputStream fis = new FileInputStream(file);
	         
	         ServletOutputStream wos = response.getOutputStream();
	         
	         int count = -1;
	         
	         while((count =fis.read(buf)) !=-1)
	            wos.write(buf, 0, count);
	         
	         wos.flush();
	         fis.close();
	         wos.close();
	      }catch(Exception e){
	         e.printStackTrace();
	      }
		
		
		
		File file = new File(path); //파일 자체 정보를 불러올 때,
		FileInputStream fis = new FileInputStream(file); // 입출력만 할 때,
		
		int count = 1;
		OutputStream wos = response.getOutputStream();
		
		byte[] buf = new byte[1024];
		while((count = fis.read(buf)) != -1)
			wos.write(buf, 0, count);
		
		fis.close();
		wos.close();
		//fis.read(buf);
					
		//System.out.println(path);
	}*/


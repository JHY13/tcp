package com.jspprj.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/down")
public class Down extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//"/downlaod?f=test.png"
		String fname = "end1.png";//request.getParameter("f");
	/*	
	    //response.setHeader("Content-Disposion", "attatchment;filename=\"hey.png\"" );
		response.setHeader("Content-Disposion",  String.format("attatchment;filename=\"%s\"", fname));
	
		ServletContext ctx =request.getServletContext();
		
		String path = "/customer/upload/"+fname; //리얼 패스
		path = ctx.getRealPath(path);
		*/
		PrintWriter out = response.getWriter();
		out.println(fname);
		out.println(fname);
		//System.out.println(path);
	}
}
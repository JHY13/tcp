package com.jspprj.web.dao.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class Download extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//"/downlaod?f=test.png"
		String fname = request.getParameter("f");
		
		response.setHeader("Content-Disposion",  String.format("attatchment;filename=\"%s\"", fname));
	
		ServletContext ctx =request.getServletContext();
		String path = "/customer/upload/"+fname;
		path = ctx.getRealPath(path);
		
		PrintWriter out = response.getWriter();
		out.println(path);
		System.out.println(path);
	}
}

package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		
		LoginService ls=new LoginServiceImpl();
		MyUser user=ls.validateUser(uname,password);
		if(user!=null && user.getRole().equals("admin")) {
			
			RequestDispatcher rd=request.getRequestDispatcher("showprod");
			rd.forward(request, response);
				
		}else {
			out.println("<h1>Wrong credentialsl!!!</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
			out.println("text below form");
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		doGet(request,response);
	}
	
}

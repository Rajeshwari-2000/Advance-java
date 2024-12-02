package com.demo.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		if(uname.equals("admin") && password.equals("admin")) {
			out.println("<h1>Login successful!!!</h1>");
			
				
		}else {
			out.println("<h1>Login unsuccessful!!!</h1>");
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		doGet(request,response);
	}
	
}


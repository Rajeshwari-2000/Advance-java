package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/validate")
public class ValidateServlet extends HttpServlet { 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		LoginService lservice=new LoginServiceImpl();
		MyUser user=lservice.validateUser(uname, password);
		System.out.println(user);
		if((user!=null) && user.getRole().equals("administrator")) {
			RequestDispatcher rd=request.getRequestDispatcher("showprod");
			rd.forward(request, response);
		}else {
			out.println("Invalid credentials");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	
	}

}

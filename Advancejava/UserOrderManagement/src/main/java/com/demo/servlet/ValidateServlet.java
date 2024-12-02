package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;


@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
   		PrintWriter out=response.getWriter();
   		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		LoginService lservice= new LoginServiceImpl();
		MyUser user=lservice.validateUser(uname,password);
		 if(user!=null && user.getRole().equals("user")) {
			 HttpSession sesh = request.getSession();
			 sesh.setAttribute("user",user );
			 RequestDispatcher rd= request.getRequestDispatcher("categories");
			 rd.forward(request, response);
		 }else {
			 out.println("Invalid Credentials");
			 RequestDispatcher rd= request.getRequestDispatcher("loginpage.jsp");
			 rd.include(request, response);
		 }
		
	}
	}



package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieservlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String btn=request.getParameter("btn");
		
		switch(btn) {
		
		case "add":
			String nm=request.getParameter("nm");
			String val=request.getParameter("val");
			Cookie c1=new Cookie(nm,val);
			response.addCookie(c1);
			out.println("Cookie Added!!!!");
			RequestDispatcher rd=request.getRequestDispatcher("cookiedemo.html");
			rd.include(request, response);
			break;
			
		case "show":
			Cookie[] arr=request.getCookies();
			
			for(Cookie c:arr) {
				out.println(c.getName()+"---->"+c.getValue()+"---->"+c.getMaxAge());
			}
			 rd=request.getRequestDispatcher("cookiedemo.html");
			rd.include(request, response);
			break;
			
		case "del":
			 nm=request.getParameter("nm");
			 arr=request.getCookies();
				for(Cookie c:arr) {
					
					if(c.getName().equals(nm)) {
						c.setMaxAge(0);
						response.addCookie(c);
						break;
					}
				}
				out.println("Cookie deleted successfully!!");
				 rd=request.getRequestDispatcher("cookiedemo.html");
				rd.include(request, response);
		}
	}

}

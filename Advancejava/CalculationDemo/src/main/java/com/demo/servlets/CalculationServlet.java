package com.demo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int num1=Integer.parseInt(request.getParameter("num1"));
		int num2=Integer.parseInt(request.getParameter("num2"));
		String btn=request.getParameter("btn");
		switch(btn) {
		case "add":
			out.println("<h1>Addition : "+(num1+num2)+"</h1>");
			break;
		
		case "sub":
			out.println("<h1>Subtraction : "+(num1-num2)+"</h1>");
			
			break;
		case "mult":
			out.println("<h1>Multiplication : "+(num1*num2)+"</h1>");
			break;
		case "div":
			out.println("<h1>Division : "+(num1/num2)+"</h1>");
			break;
		}

	}

}

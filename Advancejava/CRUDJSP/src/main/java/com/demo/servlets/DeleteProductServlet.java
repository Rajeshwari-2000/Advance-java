package com.demo.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/deleteprod")
public class DeleteProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid=Integer.parseInt(request.getParameter("pid"));
		ProductService pservice=new ProductServiceImpl();
		pservice.deletById(pid);
		RequestDispatcher rd=request.getRequestDispatcher("showprod");
		rd.forward(request, response);
		
	}

	
	

}

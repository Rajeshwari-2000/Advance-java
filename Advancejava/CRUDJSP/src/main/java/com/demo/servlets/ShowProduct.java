package com.demo.servlets;

import java.io.IOException;
import java.util.List;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/showprod")
public class ShowProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService pservice=new ProductServiceImpl();
		List<Product> plist=pservice.getAllProducts();
		request.setAttribute("plist", plist);
		RequestDispatcher rd=request.getRequestDispatcher("DisplayProducts.jsp");
		rd.forward(request, response);
	}

}

package com.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Category;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService pservice = new ProductServiceImpl();
		List<Category> clist=pservice.getAllCategory();
		request.setAttribute("clist",clist);
		RequestDispatcher rd= request.getRequestDispatcher("categorypage.jsp");
		rd.forward(request, response);
	}
	
	}



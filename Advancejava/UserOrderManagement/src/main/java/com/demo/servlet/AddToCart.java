package com.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.CartItem;
import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet(name = "AddOrShowCart", urlPatterns = { "/addToCart" })
public class AddToCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String btn = request.getParameter("btn");
        switch (btn) {
            case "add":
                HttpSession sess = request.getSession();
                List<CartItem> clist = (List<CartItem>) sess.getAttribute("cart");

                if (clist == null) {
                    clist = new ArrayList<>();
                }

                String[] parr = request.getParameterValues("prod");

                if (parr != null) {
                    ProductService pservice = new ProductServiceImpl();
                    for (String id : parr) {
                        Product p1 = pservice.getById(Integer.parseInt(id));
                        if (p1 == null) {
                            System.out.println("Product not found for ID: " + id);
                            continue; // Skip this product
                        }

                        String qtyParam = request.getParameter("p" + id);
                        int ordQty = 0;
                        if (qtyParam != null && !qtyParam.isEmpty()) {
                            ordQty = Integer.parseInt(qtyParam);
                        } else {
                            System.out.println("No quantity provided for product ID: " + id);
                            continue; // Skip this product
                        }

                        if (ordQty > p1.getQty()) {
                            System.out.println("Requested quantity exceeds available stock for product ID: " + id);
                            request.setAttribute("errorMessage", "Requested quantity exceeds available stock for product: " + p1.getPname());
                            continue; // Skip adding this item
                        }

                        CartItem c = new CartItem(p1.getPid(), p1.getPname(), ordQty, p1.getPrice());
                        clist.add(c);
                    }
                    sess.setAttribute("cart", clist);
                    request.setAttribute("successMessage", "Items successfully added to the cart.");
                } else {
                    // Handle the case where no products were selected
                    System.out.println("No products selected to add to the cart.");
                    request.setAttribute("errorMessage", "No products selected.");
                }

                RequestDispatcher rd = request.getRequestDispatcher("categories");
                rd.forward(request, response);
                break;

            case "show":
                RequestDispatcher rdShow = request.getRequestDispatcher("showcart.jsp");
                rdShow.forward(request, response);
                break;

            default:
                // Handle unexpected button values
                System.out.println("Invalid button action.");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action.");
                break;
        }
    }
}
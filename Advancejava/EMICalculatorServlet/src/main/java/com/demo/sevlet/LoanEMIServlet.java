package com.demo.sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculateEMI")
public class LoanEMIServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        int years = Integer.parseInt(request.getParameter("years"));

       
        double rateOfInterest = 0.10; 
        double interestAmount = loanAmount * rateOfInterest;
        double totalAmount = loanAmount + interestAmount;
        double emi = totalAmount / (years * 12); 

       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        
        out.println("<html><body>");
        out.println("<h1>Loan EMI Calculation Result</h1>");
        out.println("<p>Loan Amount: " + loanAmount + "</p>");
        out.println("<p>Interest Rate: " + (rateOfInterest * 100) + "%</p>");
        out.println("<p>Interest Amount: " + interestAmount + "</p>");
        out.println("<p>Total Amount to be Paid: " + totalAmount + "</p>");
        out.println("<p>EMI: " + emi + "</p>");
        out.println("</body></html>");
    }
}
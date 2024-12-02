<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
</head>
<body>
    <h2>User Name: <%= user.getUsername() %></h2>
    <h3>Your Cart:</h3>
    <table border="1">
        <tr>
            <th>Book Id</th>
            <th>Book Name</th>
            <th>Author Name</th>
            <th>Price</th>
        </tr>
      
        <tr>
            <td><%= Book.getId() %></td>
            <td><%= Book.getName() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getPrice() %></td>
        </tr>
    
    </table>
  
    <form action="checkout" method="post">
        <input type="submit" value="Checkout" />
    </form>
    <a href="category">Continue Shopping</a>
    <a href="logout">Logout</a>
</body>
</html>
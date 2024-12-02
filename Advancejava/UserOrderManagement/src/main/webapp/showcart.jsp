<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.time.LocalDate, java.util.List, com.demo.beans.CartItem" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Select Products</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Select Products</h1>
    <form action="addToCart" method="get">
        <table>
            <thead>
                <tr>
                    <th></th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${plist}">
                    <tr>
                        <td><input type="checkbox" name="prod" value="${p.pid}"></td>
                        <td>${p.pname}</td>
                        <td>${p.price}</td>
                        <td><input type="number" name="p${p.pid}" min="1" id="${p.pid}" placeholder="0"></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="2">
                        <button type="submit" name="btn" value="add">Add to Cart</button>
                    </td>
                    <td colspan="2">
                        <button type="submit" name="btn" value="show">Show Cart</button>
                    </td>
                </tr>
            </tbody>
            <tfoot>
                
            </tfoot>
        </table>
    </form>
</body>
</html>
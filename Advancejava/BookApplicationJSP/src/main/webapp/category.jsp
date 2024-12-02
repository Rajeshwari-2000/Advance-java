<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
    <title>Select Category</title>
</head>
<body>
    
    <form action="books" method="post">
        <label for="category">Select Category:</label>
        <select name="category" id="category">
           
        </select>
        <input type="submit" value="Show Books" />
    </form>
    <a href="logout">Logout</a>
</body>
</html>
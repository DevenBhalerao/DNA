<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
</head>
<body>
<h1>Add Category</h1>
<c:out value="${msg }"></c:out>
<form action="<%=request.getContextPath() %>/Admin" method="post">
<input type="hidden" name="action" value="create-category1" >
Name: <input type="text" name="category" placeholder="Enter Category"/><br>

<br>

<input type="submit" name="submit" value="Create Category">


</form>
</body>
</html>
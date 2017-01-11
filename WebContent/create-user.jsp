<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add User Details</h1>
<c:out value="${msg }"></c:out>
<form action="<%=request.getContextPath() %>/Admin" method="post">
<input type="hidden" name="action" value="create-user1" >
Name: <input type="text" name="name" /><br>
Email: <input type="text" name="email" /><br>
Password: <input type="text" name="password" /><br>
City: <input type="text" name="city" /><br>
Contact: <input type="text" name="contact" /><br>

Priviledge:
<select name="priviledge">
<option value="1"> News Creator[Journalist]</option>
<option value="2"> Ad Executive</option>
</select>
<br>

<input type="submit" name="submit" value="Create user">


</form>
</body>
</html>
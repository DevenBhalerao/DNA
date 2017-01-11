<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Manage user</h1>


<sql:query dataSource="${ds}" var="result">
SELECT * from users;
</sql:query>   
<c:out value="${msg }"></c:out>
<table border="1" width="90%">
<tr>
<th>Name</th>
<th>Email</th>
<th>City</th>
<th>password</th>
<th>Contact</th>
<th>Priviledge</th>
<th>--</th>
<th>--</th>

</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.name}"/></td>
<td><c:out value="${row.email}"/></td>
<td><c:out value="${row.city}"/></td>
<td><c:out value="${row.password}"/></td>
<td><c:out value="${row.contact}"/></td>
<td><c:out value="${row.priviledge}"/></td>
<td><a href="<%=request.getContextPath() %>/Admin?action=user-delete&id=<c:out value="${row.id}"/>" >Delete</a></td>
<td><a href="<%=request.getContextPath() %>/Admin?action=user-edit&id=<c:out value="${row.id}"/>">Edit</a></td>

</tr>
</c:forEach>
</table>

</body>
</html>
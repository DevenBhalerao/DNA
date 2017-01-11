<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage category</title>
</head>
<body>
<h1>Manage Category</h1>


<sql:query dataSource="${ds}" var="result">
SELECT * from category;
</sql:query> 
<c:out value="${msg }"></c:out>
<table border="1" width="90%">
<tr>
<th>Name</th>
<th>--</th>
<th>--</th>

</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.name}"/></td>
<td><a href="<%=request.getContextPath() %>/Admin?action=category-delete&id=<c:out value="${row.id}"/>" >Delete</a></td>
<td><a href="<%=request.getContextPath() %>/Admin?action=category-edit&id=<c:out value="${row.id}"/>">Edit</a></td>

</tr>
</c:forEach>
</table>


</body>
</html>
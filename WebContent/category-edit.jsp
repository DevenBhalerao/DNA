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
  <sql:query dataSource="${ds}" var="result">
SELECT * from category where id = <c:out value="${id }"></c:out>;
</sql:query>   
<c:forEach var="row" items="${result.rows}">
<form action="<%=request.getContextPath() %>/Admin" method="post">
<input type="hidden" name="action" value="category-edit1" >
<input type="hidden" name="id" value="<c:out value="${row.id}"/>" >
Name: <input type="text" name="name" value="<c:out value="${row.name}"/>" /><br>

<br>

<input type="submit" name="submit" value="Edit Details">


</form>
</c:forEach>
</body>
</html>
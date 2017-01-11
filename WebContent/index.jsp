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
<h1>User Mgmt</h1>
<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/dna"
     user="root"  password="" scope="application"/>
     
<a href="<%=request.getContextPath() %>/Admin?action=create-user">Create User</a> <br>
<a href="<%=request.getContextPath() %>/Admin?action=manage-user">Manage User</a> <br>


<h1>Category Mgmt</h1>
<a href="<%=request.getContextPath() %>/Admin?action=create-category">Create Category</a> <br>
<a href="<%=request.getContextPath() %>/Admin?action=manage-category">Manage Category</a> <br>

</body>
</html>
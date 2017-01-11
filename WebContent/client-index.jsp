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
<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/dna"
     user="root"  password="" scope="application" />

<sql:query dataSource="${ds}" var="result">
SELECT * from category;
</sql:query>   

<table width="100%" height="100%" border="1">
<tr><td>Header</td><td align="right">
<c:choose>
<c:when test="${email == null }">
<a href="<%=request.getContextPath() %>/Controller?action=client-login">login</a>
</c:when>
<c:when test="${email != null }">
Welcome <c:out value="${email }"></c:out>
</c:when>
</c:choose>





</td></tr>

<tr>
<td width="20%">
  <c:forEach var="row" items="${result.rows}">
  <a href="<%=request.getContextPath() %>/Controller?action=show-news&id=<c:out value="${row.id }"></c:out>"><c:out value="${row.name }"></c:out></a> <br />
  </c:forEach>


</td>

<td>Rest of Data</td>
</tr>

<tr><td>Footer</td></tr>

</table>
</body>
</html>
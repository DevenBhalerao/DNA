<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "java.util.Date" %>
      <%@ page import = "java.text.*" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>News Creator</h1>
Welcome <%=session.getAttribute("email") %>
<br><br>
<c:out value="${msg }"></c:out>
<br>
<form  method="post" action="<%=request.getContextPath() %>/Admin">
<input type="hidden" name="email" value="<c:out value="${email}"></c:out>"/>
<input type="hidden" name="action" value="news-create1"/>

<select name="date"> 
<%
Date d1 = (Date)request.getAttribute("date");
%>
<option value="<%=DateFormat.getDateInstance().format(new Date()) %>"> <%=DateFormat.getDateInstance().format(new Date()) %></option>
<option value="<%=DateFormat.getDateInstance().format(d1) %>"><%=DateFormat.getDateInstance().format(d1) %></option>

</select>

<sql:query dataSource="${ds}" var="result">
SELECT * from category;
</sql:query>   
<br><br>
Category:
<select name="category">
<c:forEach var="row" items="${result.rows}">
<option value="<c:out value="${row.id}"/>"><c:out value="${row.name}"/></option>
</c:forEach>
</select>

<br><br>
Title :  <input type="text" name="title"/><br><br>
Price :  <input type="text" name="price"/><br><br> 
Short Description : <textarea name="short-description"></textarea><br><br>
Description : <textarea name="description"></textarea><br><br>
Credits :  <input type="text" name="credits"/><br><br> 

<br><br>
<input type="submit" name="submit" value="Add News" />
</form>
</body>
</html>
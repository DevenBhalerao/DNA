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
select * from news where category_id='<c:out value="${param.id }"></c:out>';
</sql:query> 


  
<br>
Select News:
<select id="news">

<c:forEach var="row" items="${result.rows}">
<sql:update dataSource="${ds}" >
Update temp set news_id = ? where id=1
<sql:param value="${row.id}" />

</sql:update>
<option value="<c:out value="${row.id }"></c:out>"><c:out value="${row.title }"></c:out> --- <c:out value="${row.date }"></c:out></option>
</c:forEach>
</select>
<input type="hidden" name="news" value="4" />
<br><br>

<input type="file" name="file" /><input type="submit" name="submit" value="Upload">
</body>
</html>
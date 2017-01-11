<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Application</title>
</head>
<body>

<sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/dna"
     user="root"  password="" scope="application" />

<c:out value="${msg }"></c:out>
<form method="post" action="<%=request.getContextPath() %>/Admin">
<input type="hidden" name="action" value="doLogin-user">
Email: <input type="text" name="email" value="${email }" />
<br /><br />
Password: <input type="password" name="password" />
<br /><br />
<input type="submit" name="submit" value="login" />
<input type="reset" name="reset" value="Reset" />
<br /><br />


</form>
</body>
</html>

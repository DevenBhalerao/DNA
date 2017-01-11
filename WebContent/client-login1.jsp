<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Client Login</h1>
<form method="post" action="<%=request.getContextPath() %>/Controller">
<input type="hidden" name="action" value="doLogin-client1">
Email: <input type="text" name="email" />
<br /><br />
Password: <input type="password" name="password" />
<br /><br />
<input type="submit" name="submit" value="login" />
<input type="reset" name="reset" value="Reset" />
<br /><br />
</form>
</body>
</html>
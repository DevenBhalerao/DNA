<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="Javascript">
function xmlhttpPost(strURL) {

//settings for browsers 

var xmlHttpReq = false;
var self = this;
// Mozilla/Safari
if (window.XMLHttpRequest) {
self.xmlHttpReq = new XMLHttpRequest();
}
// IE
else if (window.ActiveXObject) {
self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
}

//open the connection
self.xmlHttpReq.open('POST', strURL, true);

//setting header Info
self.xmlHttpReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

//check the ready state 4 and call function for updation of data
//initially the state is 0. 
//when the data comes from jsp, the state changes to 4 
// and den the function update gets called. 
self.xmlHttpReq.onreadystatechange = function() {
if (self.xmlHttpReq.readyState == 4) {
updatepage(self.xmlHttpReq.responseText); 
}
}
//send the value given by user to jsp.
self.xmlHttpReq.send(getquerystring()); 
}

//getquerystring function
function getquerystring() {
var form = document.forms['myForm'];
var id = form.category.value;
qstr = 'id=' + escape(id); // NOTE: no '?' before querystring
return qstr;
}

//update function
function updatepage(str){
document.getElementById("result").innerHTML = str;
}

</script>
</head>
<body>
<h1>Ad Exe</h1>
Welcome <%=session.getAttribute("email") %>
<br><br>

  <sql:query dataSource="${ds}" var="result">
SELECT * from category;
</sql:query>   

<form name="myForm" method="post" action="<%=request.getContextPath() %>/Admin?action=add-banner1" enctype="multipart/form-data">

Select Category: <select name="category" onchange='JavaScript:xmlhttpPost("fetch.jsp")'>
<option>--Select Category--</option>
<c:forEach var="row" items="${result.rows}">

<option value="<c:out value="${row.id }"></c:out>"><c:out value="${row.name }"></c:out> </option>
</c:forEach>
</select>
<br>
<div id="result" ></div>

</form>

</body>
</html>















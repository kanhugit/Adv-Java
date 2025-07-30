<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	HttpSession hs=request.getSession();
	int sq=(int)hs.getAttribute("square");
	int division=sq/2;

	out.println("<h1>The square  of number is :"+division+"</h1>");
	%>
</body>
</html>
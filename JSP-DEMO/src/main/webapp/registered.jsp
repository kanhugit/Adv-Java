<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

<!-- declaration tag -->	
 <%! int a=69; %>
 
 <!-- script-let tag  -->
 <%
 String name=request.getParameter("em");
 out.println(name);
 %>
 
 <!-- Expression Tag -->
 <%=a %>
	
	
</body>
</html>
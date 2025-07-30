<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));

	int sum = num1 + num2;
	out.println("<h1>The sum of number is :"+sum+"</h1>");
	out.println("<h1>click below to get sqaure </h1>");
	HttpSession hs=request.getSession();
	hs.setAttribute("hs",sum);
	
	%>
	<form action="Square.jsp">
		<button>get Square</button>
	</form>
</body>
</html>
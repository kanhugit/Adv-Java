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
HttpSession hs=request.getSession();
int sum=(int)hs.getAttribute("hs");
int square=sum*sum;
hs.setAttribute("sq", square);
out.println("<h1>The square  of number is :"+square+"</h1>");
out.println("<h1>Click below to divide </h1>");
%>
<form action="Division.jsp">
<button>Get division</button>
</form>

</body>
</html>
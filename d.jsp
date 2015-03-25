<%@page contentType="text/html" pageEncoding="GBK"%>
<html>
<head>
</head>
<body>
<center>
	<h1>Login Operate</h1>
	<hr>
	<%
		String name = request.getParameter("userid");
	%>
	<h3>welcome you,<%=name%></h3>
</center>
</body>
</html>
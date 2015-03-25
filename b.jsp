<%@page contentType="text/html" pageEncoding="GBK"%>
<%@page import="java.sql.*"%>
<html>
<head>
</head>
<body>
<center>
	<h1>Login Operate</h1>
	<hr>
	<form action="c.jsp" method="post">
		<table border="1">
			<tr>
				<td colspan="2"><center>Login</center></td>
			</tr>
			<tr>
				<td><center>userid</center></td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="submit">
				<input type="reset" value="reset">
				</td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>
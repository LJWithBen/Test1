<%@page contentType="text/html" pageEncoding="GBK"%>
<%@page import="java.sql.*"%>
<html>
<head>
</head>
<body>
<center>
	<h1>Login Operate</h1>
	<hr>
<%!
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver"	;
	public static final String DBURL = "jdbc:mysql://localhost:3306/user";
	public static final String DBNAME = "root";
	public static final String DBPASS = "1785766913";
	
%>
<%
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = "select name from user where userid=? and password=?";
	boolean flag = false;
	String  name = null;
%>
<%
	try{
		Class.forName(DBDRIVER)	;
		conn = DriverManager.getConnection(DBURL,DBNAME,DBPASS);
		ps = conn.prepareStatement(sql);
		ps.setString(1,request.getParameter("userid"));
		ps.setString(2,request.getParameter("password"));
		rs = ps.executeQuery();
		if(rs.next()){
			flag = true;
			name = rs.getString(1);
		}
		if(flag){
			%>
			<jsp:forward page="d.jsp">
				<jsp:param name="userid" value="<%=name%>"/>
			</jsp:forward>
			<%
		}else{
			%>
			<jsp:forward page="e.jsp"/>
			<%
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e){
				e.printStackTrace();
		}
	}
%>
</center>
</body>
</html>
<%@page contentType="text/html" pageEncoding="GBK"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="java.math.*"%>
<html>
<head>
<%!
	BigInteger count = null;
%>
</head>
<body>
<%
	synchronized(this){//同步
		if(session.isNew()){//判断是不是新用户
			String path = this.getServletContext().getRealPath("/")+"count.txt";//获得虚拟目录真实路径
			File file = new File(path);
			if(file.exists()){
				Scanner scan = new Scanner(new FileInputStream(file));//输入
				if(scan.hasNext()){
					count = new BigInteger(scan.next()).add(new BigInteger("1"));
					PrintStream ps = new PrintStream(new FileOutputStream(file));//输出
					ps.println(count);
					ps.close();
				}
				scan.close();
			}else{
				count = new BigInteger("0");
				PrintStream ps = new PrintStream(new FileOutputStream(file));
				ps.println(count);
				ps.close();
			}
		}
	}
%>
<h3>have <%=count%> people who have read</h3>
</body>
</html>
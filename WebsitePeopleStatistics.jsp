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
	synchronized(this){//ͬ��
		if(session.isNew()){//�ж��ǲ������û�
			String path = this.getServletContext().getRealPath("/")+"count.txt";//�������Ŀ¼��ʵ·��
			File file = new File(path);
			if(file.exists()){
				Scanner scan = new Scanner(new FileInputStream(file));//����
				if(scan.hasNext()){
					count = new BigInteger(scan.next()).add(new BigInteger("1"));
					PrintStream ps = new PrintStream(new FileOutputStream(file));//���
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
<%@page contentType="text/html" pageEncoding="GBK"%>
<%@page import="java.io.*,java.util.*"%>
<%@page import="org.lj.test.demo.IPTimeStamp"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%@page import="org.apache.commons.fileupload.disk.*"%>
<%@page import="org.apache.commons.fileupload.servlet.*"%>
<html>
<head>
</head>
<body>
<%
	DiskFileItemFactory factory = new DiskFileItemFactory();
	factory.setRepository(new File(this.getServletContext().getRealPath("/")+"uploadtemp"));
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setFileSizeMax(1024sss*1024);
	List<FileItem> items = upload.parseRequest(request);
	IPTimeStamp stamp = new IPTimeStamp();
	Iterator<FileItem> iter = items.iterator();
	while(iter.hasNext()){
		FileItem item = (FileItem)iter.next();
		if(!item.isFormField()){
			File fileSave = new File(this.getServletContext().getRealPath("/")+"upload"+File.separator+stamp.IPTimeRand()+"."+item.getName().split("\\.")[1]);
			InputStream input = null;
			OutputStream output = null;
			input = item.getInputStream();
			output = new FileOutputStream(fileSave);
			byte data[] = new byte[512];
			int temp = 0;
			while((temp=input.read(data,0,512))!=-1){
				output.write(data);
			}
			input.close();
			output.close();
		}else{
			String value = item.getString();
			%><h3><%=value%></h3><%
		}
	}
%>
</body>
</html>
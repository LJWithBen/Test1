package org.lj.test.demo;

import java.io.*;
import org.jdom.*;
import org.jdom.output.*;

public class Test1{
	public static void main(String[]agre){
		try{
			Element addresslist = new Element("addresslist");
			Element linkman = new Element("linkman");
			Element name = new Element("name");
			Element email = new Element("email");
			Attribute id = new Attribute("id","18");
			name.setText("LJF");
			email.setText("691287671@qq.com");
			name.setAttribute(id);
			linkman.addContent(name);
			linkman.addContent(email);
			addresslist.addContent(linkman);
			Document doc = new Document(addresslist);
			XMLOutputter output = new XMLOutputter();
			output.setFormat(output.getFormat().setEncoding("GBK"));
			output.output(doc,new FileOutputStream(new File("F:"+File.separator+"hehe.xml")));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
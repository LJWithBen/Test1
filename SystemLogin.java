package lj.test.demo;
import java.lang.reflect.*;
import java.lang.annotation.*;
import java.io.*;
@Retention(value = RetentionPolicy.RUNTIME)
@interface LoginInfo{
	public String name();
	public String password();
}

class Person{
	private BufferedReader buf = null;
	private String n = null;
	private String p = null;
	public String getN(){
		return this.n;
	}
	public String getP(){
		return this.p;
	}
	public Person(){
		buf =  new BufferedReader(new InputStreamReader(System.in));
	}
	public void input(){
		System.out.print("please input the name:");
		try{
			n = buf.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.print("\n please input the password:");
		try{
			p = buf.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void check(){
		Class<?> c = null;
		try{
			c = Class.forName("lj.test.demo.Person");
		}catch(Exception e){
			e.printStackTrace();
		}
		Method m = null;
		try{
			m = c.getMethod("login");
		}catch(Exception e){
			e.printStackTrace();
		}
		if(m.isAnnotationPresent(LoginInfo.class)){
			LoginInfo li = m.getAnnotation(LoginInfo.class);
			String na = li.name();
			String pa = li.password();
			if(na.equals(n)&&pa.equals(p)){
				System.out.println("welcome "+ n );
				//return true;
			}else {
				System.out.println("Error");
				//return false;
			}
		}else{
			System.out.println("Error");
			//return false;
		}
	}
	@LoginInfo(name = "LJF",password = "A1785766913")
	public void login(){//String name,String password
		//name = this.n;
		//password = this.p;
		
	}
}

public class SystemLogin{
	public static void main(String[]agre){
		Person p = new Person();
		p.input();
		p.check();
	}
}
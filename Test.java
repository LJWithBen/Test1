//package org.lj.demo;
class Info{
	private String name;
	private String content;
	private boolean flag = true;
	public synchronized void set(String name,String content){
		if (flag){
			this.setName(name);
			try{
				Thread.sleep(90);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			this.setContent(content);
			flag = false;
			super.notify();
		}
			try{
				super.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
}
	public synchronized void get(){
		if(flag){
			try{
				super.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		try{
			Thread.sleep(90);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(this.getName()+"--->"+this.getContent());
		flag = true;
		super.notify();
}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return this.content;
	}
}

class Producter implements Runnable{
	private Info info = null;
	public Producter(Info info){
		this.info = info;
	}
	public void run(){
		boolean flag = false;
		for (int i=0;i<20;i++){
			if(!flag){
				this.info.set("ljf","is a fool");
				flag = true;
			}else {
				this.info.set("sf","is not the strike freedom");
				flag = false;
			}
		}
	}
}


class Consumer implements Runnable{
	private Info info;
	public Consumer(Info info){
		this.info = info;
	}
	public void run(){
		for(int i=0;i<20;i++){
			this.info.get();
		}
	}
}


public class Test{
	public static void main(String[]agre){
		Info info = new Info();
		Producter pro = new Producter(info);
		Consumer con = new Consumer(info);
		new Thread(pro).start();
		new Thread(con).start();
	}
}
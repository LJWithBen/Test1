import java.util.*;

class Temp{
	private String name;
	private int age;
	private float score;
	Student stu[] =null;
	public Temp(String a){
		String s[] = a.split("\\|");
		stu = new Student[s.length];
		for(int i=0;i<s.length;i++){
			String x[] = s[i].split("\\:");
			for(int j=0;j<x.length;j++){
				//System.out.println(x[j]);
				if(j==0){
					name = x[j];
					//System.out.println(name+"1");
				}
				if(j==1){
					age = Integer.parseInt(x[j]);
					//System.out.println(age+"2");
					}
				if(j==2){
					score = Float.parseFloat(x[2]);
					//System.out.println(score+"3");
				}
			}
			stu[i] = new Student(name,age,score);
		}
	}
	public Student[] print(){
		return this.stu;
	}
}
class Student implements Comparable<Student>{
	private String name;
	private int age;
	private float score;
	public Student(String name,int age,float score){
		this.name = name;
		this.age = age;
		this.score  = score;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	public void setScore(float score){
		this.score = score;
	}
	public float getScore(){
		return this.score;
	}
	public String toString(){
		return this.getName()+"\t"+this.getAge()+"\t"+this.getScore();
	}
	public int compareTo(Student s){
		if(this == s){
			return 0;
		}
		if(this.score>s.score){
			return -1;
		}else if(this.score<s.score){
			return 1;
		}else if(this.age>s.age){
			return -1;
		}else if(this.age<s.age){
			return 1;
		}else{
			return 0;
		}
	}
} 


public class Demo{
	public static void main(String[]agre){
		Temp t = new Temp("zhangsan:21:98|lisi:22:89|wangwu:20:70");
		java.util.Arrays.sort(t.print());
		for(int i=0;i<t.print().length;i++){
			System.out.println((t.print())[i]);
		}
	}
}
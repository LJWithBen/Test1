abstract class Shape{
	public abstract double area();
	public abstract double perimeter();
}

class Rectangular extends Shape{
	private String str1 ;
	private String str2 ;
	private double x ;
	private double y ;
	public double area(){
		return x*y;
	}
	public double perimeter(){
		return 2*(x+y);
	}
	public Rectangular(String str1,String str2){
		this.str1 = str1;
		this.str2 = str2;
		x = Double.parseDouble(str1);
		y = Double.parseDouble(str2);
	}
}

class Triangle extends Shape{
	private String str1 ;
	private String str2;
	private String str3;
	private double x ;
	private double y ;
	private double z ;
	private double p ;
	public Triangle(String str1,String str2,String str3){
		this.str1 = str1;
		this.str2 = str2;
		this.str3 = str3;
		x = Double.parseDouble(str1);
		y = Double.parseDouble(str2);
		z = Double.parseDouble(str3);
		p = (x+y+z)/2;
	}
	public double area(){
		return Math.sqrt(p*(p-x)*(p-y)*(p-z));
	}
	public double perimeter(){
		return p*2;
	}

}

class Circle extends Shape{
	private String str ;
	private double r ;
	public Circle(String str){
		this.str = str;
		r = Double.parseDouble(this.str);
		System.out.println(this.str);
	}
	public double area(){
		return 3.14*r*r;
	}
	public double perimeter(){
		return 2*3.14*r;
	}
	
}

class Operate{
	private String info[];
	public Operate(String info[]){
		this.info = info;
	}
	public void judge(){
		if (info.length<1||info.length>3){
			System.out.println("ERROR,please input ONE to THREE number");
			System.exit(1);
		}else if (info.length==1){
			if (login(info[0])){
				Shape s =new Circle(info[0]);
				Circle c = (Circle)s;
				System.out.println("This is a circle and its area is "+c.area()+"\t"+"its perimeter is "+c.perimeter());
			}else {
				System.out.println("ERROR,please input ONE to THREE number-------1");
				System.exit(1);
			}
		}else if (info.length==2){
				if(login(info[0])){
					if(login(info[1])){
						Shape s = new Rectangular(info[0],info[1]);
						Rectangular r = (Rectangular)s;
						System.out.println("This is a Rectangular and its area is "+r.area()+"\t"+"its perimeter is "+r.perimeter());
					}else {
						System.out.println("ERROR,please input ONE to THREE number-------2");
						System.exit(1);
					}
				}else{
					System.out.println("ERROR,please input ONE to THREE number-------2");
					System.exit(1);
				}
			}else  if(info.length==3){
			if (login(info[0])){
				if(login(info[1])){
					if(login(info[2])){
						Shape s = new Triangle(info[0],info[1],info[2]);
						Triangle t = (Triangle)s;
						System.out.println("This is a Triangle and its area is "+t.area()+"\t"+"its perimeter is " +t.perimeter());
		}else{
			System.out.println("ERROR,please input ONE to THREE number---------3");
			System.exit(1);
		}
					}else{
						System.out.println("ERROR,please input ONE to THREE number---------3");
						System.exit(1);
					}}else{
						System.out.println("ERROR,please input ONE to THREE number---------3");
						System.exit(1);
					}}else{
						System.out.println("ERROR,please input ONE to THREE number---------3");
						System.exit(1);
					}
	}
	public boolean login(String str){
		char a = 48;
		char b = 57;
		if (str == null){
			return false;
		}else{
		char c[] = str.toCharArray();
		for (int i=0;i<=c.length-1;i++){
			if (c[i]<a||c[i]>b){
				return false;
			}
		}
		}
		return true;
		
		}
}


public class TestBackUp{
	public static void main(String[]agre){
		Operate o = new Operate(agre);
		o.judge();	
	}	
}







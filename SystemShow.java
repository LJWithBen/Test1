import java.io.*;
class Operate{
	public static void add(){
		System.out.println("ѡ��ӷ�����");
		System.out.println();
	}
	public static void delete(){
		System.out.println("ѡ��ɾ������");
		System.out.println();
	}
	public static void update(){
		System.out.println("ѡ����²���");
		System.out.println();
	}
	public static void find(){
		System.out.println("ѡ����Ҳ���");
		System.out.println();
	}
}

class Menu{
	public void show(){
		System.out.println("==== Xxxϵͳ ====");
		System.out.println("	1~�ӷ�����");
		System.out.println("	2~ɾ������");
		System.out.println("	3~���²���");
		System.out.println("	4~���Ҳ���");
		System.out.println("	0~�˳�����");
		int temp = 0;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("please choose the number:");
		String str = null;
		try{
			str = buf.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			temp = Integer.parseInt(str);
		}catch(Exception e){
			e.printStackTrace();
		}
		switch(temp){
		case 1:		
			Operate.add();
			break;
		case 2:
			Operate.delete();
			break;
		case 3:
			Operate.update();
			break;
		case 4:
			Operate.find();
			break;
		case 0:
			System.out.println("System will exit soon");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.exit(1);
		default:
			System.out.println("please input the number in 0~4");
		}
	}
	public Menu(){
		while(true){
			this.show();
		}
	}
}

public class SystemShow{
	public static void main(String[]agre){
		Menu m = new Menu();
	}
}
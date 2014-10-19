import java.io.*;
class Student implements Serializable{//Serializable have not know how to  use
	private String name = null;
	private int number = 0;
	private int ticket = 0;
	public Student(String name,int number,int ticket){
		this.setName(name);
		this.setNumber(number);
		this.setTicket(ticket);
	}
	public void setName(String name){
		this.name = name;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public void setTicket(int ticket){
		this.ticket = ticket;
	}
	public String getName(){
		return this.name;
	}
	public int getNumber(){
		return this.number;
	}
	public int getTicket(){
		return this.ticket;
	}
	public String toString(){
		return this.getNumber()+":"+this.getName()+"\u3010"+this.getTicket()+"\u7968\u3011";
	}
}

class OutputStudent{
	Student stu[] = {new Student("\u5f20\u4e09",1,0),new Student("\u674e\u56db",2,0),new Student("\u738b\u4e94",3,0),new Student("\u8d75\u516d",4,0)};
	private BufferedReader buf = null;
	public OutputStudent(){
		buf = new BufferedReader(new InputStreamReader(System.in));
	}      
	public void show(){
		int len[] = new int[stu.length];
		for(int i=0;i<stu.length;i++){
			System.out.println(stu[i]);
		}
		boolean flag = true;
		int temp = 0;
		while(flag){
			System.out.print("\u8bf7\u8f93\u5165\u73ed\u957f\u5019\u9009\u4eba\u4ee3\u53f7(\u6570\u5b570\u7ed3\u675f):");
			String str = null;
			try{
				str  =  buf.readLine();
			}catch(IOException e){
				e.printStackTrace();
			}
			if(str.matches("^[0-4]{1}$")){
				try{
					temp = Integer.parseInt(str);
				}catch(Exception e){
					e.printStackTrace();
				}
				switch(temp){
				case 1:
					len[0]++;
					break;
				case 2:
					len[1]++;
					break;
				case 3:
					len[2]++;
					break;
				case 4:
					len[3]++;
					break;
				case 0:
					flag = false;
					break;
					default:
						System.out.println("\u6b64\u9009\u7968\u65e0\u6548,\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u5019\u9009\u4eba\u4ee3\u53f7!");
						break;
				}
			}else{
				System.out.println("\u6b64\u9009\u7968\u65e0\u6548,\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u5019\u9009\u4eba\u4ee3\u53f7!");
			}
		}
		int temp1 = 0;
		for(int j=0;j<stu.length;j++){
			stu[j].setTicket(len[j]);
			int max = len[0];
			if(j>0){
				if(len[j]>max){
					max = len[j];
					temp1 = j;
				}
			}
		}
		for(int k=0;k<stu.length;k++){
			System.out.println(stu[k]);
		}
		System.out.println("\u6295\u7968\u6700\u7ec8\u7ed3\u679c:"+stu[temp1].getName()+",\u6700\u540e\u4ee5"+stu[temp1].getTicket()+"\u7968\u5f53\u9009\u73ed\u957f\uff01");
	}
}

//
public class MonitorContest{
	public static void main(String[]agre){
		OutputStudent os = new OutputStudent();
		os.show();
	}
}
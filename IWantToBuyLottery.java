import java.util.*;
public class IWantToBuyLottery{
	public static void main(String[]agre){
		Random r = new Random();
		int sum[] = new int[7] ;
		
		for (int i=0;i<7;i++){
			sum[i] = r.nextInt(37);
			while(sum[i]==0){
				sum[i] = r.nextInt(37);
			}
			boolean flag = false;
				if(i>1){
					while(!flag){
						for(int j=0;j<i;j++){
							if(sum[j]==sum[i]){
								sum[i] = r.nextInt(37);
								while(sum[i]==0){
									sum[i] = r.nextInt(37);
								}
								flag = false;
								break;
							}else{
								flag = true;
							}
						}
					}
				}
			}
		for(int i=0;i<7;i++){
			System.out.print(sum[i]+"\t");
		}
	}
}
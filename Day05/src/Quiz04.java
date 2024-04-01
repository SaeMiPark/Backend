import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//int[] arr=new int[3];
		/*arr[0]=(int)(Math.random()*5+1);
		for(int i=1; i<3; i++) {
			//1,2,3,4,5
			//난수 중첩 x
			if(arr[i-1]!=arr[i]) {
				//1과 0
				//2와 1
				arr[i]=(int)(Math.random()*5+1);
			}
		}
		for(int x: arr) {
			System.out.println(x + " ");
		}*/
		
		//셔플링==섞는다
		//카드섞기 알고리즘
		int[] arr=new int[] {1,2,3,4,5};
		
		for(int i=0; i<50; i++) {
			int x=(int)(Math.random()*5);
			int y=(int)(Math.random()*5);
			
			int tmp=arr[x];
			arr[x]=arr[y];
			arr[y]=tmp;	
		}
		
		System.out.println(arr[0]+" : "+arr[1]+" : "+arr[2]+" : "+arr[3]+" : "+arr[4]+" : ");

}
}

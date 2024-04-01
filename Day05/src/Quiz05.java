import java.util.Scanner;

public class Quiz05 {
	public static void main(String[] args) {
		//1~45사이의 난수 6개를 중복없이 출력하세요.
		Scanner sc=new Scanner(System.in);
		
		int[] arr=new int[45];
		
		//0~44, 1~45
		for(int i=0; i<arr.length; i++) {
			arr[i]=i+1;
		}
		
		for(int j=0; j<300; j++) {
			int x=(int)(Math.random()*45);//index값으로 돌리기
			int y=(int)(Math.random()*45);//0~44
			
			int tmp=arr[x];
			arr[x]=arr[y];
			arr[y]=tmp;
		}
		
		
		System.out.println("로또 번호입니다.");
		for(int i=1; i<=6;i++) {
			System.out.print(arr[i]+" ");
		}

	}

}

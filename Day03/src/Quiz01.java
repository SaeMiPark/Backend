import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		for(int i=1; i<=100; i++) {
//			System.out.println(i);
//		}
		
//		for(int i=100; i>=1; i--) {
//			System.out.println(i);
//		}
		
		
//		for(int i=1; i<=100; i++) {
//			System.out.print(i+" ");
//			if(i%10==0) {
//				System.out.println();
//			}
//		}
		
		System.out.print("Hello를 몇 번 출력하시겠습니까? >>");
		int n=Integer.parseInt(sc.nextLine());
		
		
		for(int i=1; i<=n; i++) {
			System.out.println("Hello");
		}
		
	}

}

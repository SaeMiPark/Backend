import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("1~100사이의 값을 입력하세요. >>");
		int num=Integer.parseInt(sc.nextLine());
		
		//!(num<1||num>100) == (num>=1&&num<=100)
		if(num<1||num>100) { //범위 초과가 아니라면 (if-else if-else) 덩어리를 벗어나 버린다.
			System.out.println("범위 초과");
		}
		
		else if(num%2==0) {
			System.out.println("짝수입니다.");
		}
		
		else{
			System.out.println("홀수입니다.");
		}
	}

}

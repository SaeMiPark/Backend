import java.util.Scanner;

public class Quiz02 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	System.out.print("첫번째 숫자 입력 : ");
	int num1=Integer.parseInt(sc.nextLine());
	System.out.print("두번째 숫자 입력 : ");
	int num2=Integer.parseInt(sc.nextLine());
	
	if(num1>num2) {
		System.out.println("첫번쨰 입력한 값이 더 크다.");
	}
	
	else if(num1<num2) {
		System.out.println("두번쨰 입력한 값이 더 크다.");
	}
	
	else {
		System.out.println("두 수가 같다.");
	}
	
	
	
}
}

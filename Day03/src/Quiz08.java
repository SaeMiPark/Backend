import java.util.Scanner;

public class Quiz08 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	

		String op;
		int num1, num2, result=0;

		while(true) {
			System.out.print("==계산기 프로그램==\n"
					+"연산자 입력(+,-,*,/) : ");
			op=sc.nextLine();
			
			if(op.equals("q")) {
				break;
			}
			
			System.out.print("첫 번째 숫자 입력 : ");
			num1=Integer.parseInt(sc.nextLine());
			System.out.print("두 번째 숫자 입력 : ");
			num2=Integer.parseInt(sc.nextLine());

			switch(op) {
			case "+":
				result=num1+num2;
				break;
			case "-":
				result=num1-num2;
				break;
			case "*":
				result=num1*num2;
				break;
			case "/":
				result=num1/num2;
				break;
			default:
				System.out.println("다시 입력해주세요.");

			}
			System.out.println("====결과====");
			System.out.println(num1+op+num2+"="+result);

		}
	}
}

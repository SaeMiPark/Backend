import java.util.Scanner;

public class Exam03_calculator_trycatch {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	

		String op;
		int num1, num2;
		int result=0;

		while(true) {
			System.out.print("\n==계산기 프로그램==\n"
					+"연산자 입력(+,-,*,/) : ");
			op=sc.nextLine();

			if(op.equals("q")) {
				System.out.println("계산기를 종료합니다.");
				System.exit(0);
			} 

			else if(!op.equals("+")&&!op.equals("-")&&!op.equals("*")&&!op.equals("/")) {
				System.out.println("연산자를 다시 확인해주세요.");
				continue;
			}
			
			while(true) {
				try {
					System.out.print("첫 번째 숫자 입력 : ");
					num1=Integer.parseInt(sc.nextLine());

					//숫자 잘 입력했을 때
					//break가 실행됐다는 것==1,2에서 예외가 발생하지 않았다는 것
					break;
					
				}catch(Exception e) {
					System.out.println("숫자만 입력 가능합니다.");
				}
				//catch가 끝난 후에 밑으로 내려가기 때문에 
				//숫자를 다시 입력하기 위해서는
				//while(true)를 해줘서 묶어줘서 위로 다시 올라갈 수 록 해준다.
			}
			while(true) {
				try {
					System.out.print("두 번째 숫자 입력 : ");

					//발생 시점2
					num2=Integer.parseInt(sc.nextLine());
					break;
				}

				catch(Exception e) {
					System.out.println("숫자만 입력 가능합니다.");
				}
			}


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
			}
			
			System.out.println("====결과====");
			System.out.println(num1+op+num2+"="+result);
		}
	}
}


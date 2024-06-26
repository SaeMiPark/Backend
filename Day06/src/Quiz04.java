import java.util.Scanner;

public class Quiz04 {
	public static Scanner sc=new Scanner(System.in);
	
	public static int validInput(String uimsg) { //이름 뜻: 유효한 입력
		while(true) {
			try {
				System.out.print(uimsg);
				int num=Integer.parseInt(sc.nextLine());
				return num;
			}catch(Exception e) {
				System.out.println("숫자만 입력 가능합니다.");
			}
		}
	}
	
	public static void main(String[] args) {	
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
			
			num1=validInput("첫 번째 숫자 입력 : ");
			num2=validInput("두 번째 숫자 입력 : ");
					

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



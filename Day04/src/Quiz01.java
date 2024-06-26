import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	

		String op;
		int num1, num2;
		int result=0;

		while(true) {
			System.out.print("\n==계산기 프로그램==\n"
					+"연산자 입력(+,-,*,/) : ");
			op=sc.nextLine();

			//실행 타이밍의 문제

			if(op.equals("q")) {
				System.out.println("계산기를 종료합니다.");
				System.exit(0);
			} 

			else if(!op.equals("+")&&!op.equals("-")&&!op.equals("*")&&!op.equals("/")) {
				System.out.println("연산자를 다시 확인해주세요.");
				continue;//해줌으로써 위로 올라간다.
			}
			//다른 방법
			//else if(op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/"))
			//else까지 하면서 감싸주기
			while(true) {
				try {
					System.out.print("첫 번째 숫자 입력 : ");
					//발생 시점1
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
				//default:
				//System.out.println("다시 입력해주세요.");
				//디폴트문은 case문을 제외한 항상 참인 경우이다.
				//이 경우에 다른 걸 입력한다면 default문이 실행되고,
				//switch를 빠져나오면서 
				//해당되지 않는 op에 대해 연산을 수행한 결과를 보여주게 된다.
				//이게 나오고 싶지 않은 경우에 배운 부분을 활용하면 된다.
				//배운 부분: 연산자를 다시 확인해주세요.

			}
			System.out.println("====결과====");
			System.out.println(num1+op+num2+"="+result);
		}
	}
}

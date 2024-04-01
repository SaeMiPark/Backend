import java.util.Scanner;

public class Exam01_trycatch {
	public static void main(String[] args) {

		//예외 처리 try-catch문
		Scanner sc=new Scanner(System.in);

		try {
			System.out.print("숫자만 입력하세요. :");
			Integer.parseInt(sc.nextLine());
			//정상 입력일 때만
			System.out.println("입력 확인");
		}catch(Exception e){
			//에러가 발생했을 때만
			System.out.println("숫자만 입력하세요!");
		}
		
		//문자와 숫자입력해도 둘 다 나옴
		System.out.println("정상 종료");
	}
}

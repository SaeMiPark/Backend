import java.util.Scanner;

public class Exam04 {
	public static void main(String[] args) {
		//String type의 비교는 equals를 사용한다.
		Scanner sc= new Scanner(System.in);
		
		System.out.print("과일 이름 입력 >> ");
		String fruits= sc.nextLine();
		
		if(fruits.equals("Apple")) {
			System.out.println("Apple은 사과");
		}
		else {
			System.out.println("다른 단어는 모릅니다.");
		}
		
	}

}

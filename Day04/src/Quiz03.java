import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("==동전 앞 뒤 맞추기==");
		System.out.print("숫자를 입력해주세요(1.앞면/2.뒷면): ");
		int user=Integer.parseInt(sc.nextLine());
		int computer=(int) (Math.random()*2+1);
		System.out.println("user 값 "+user);
		System.out.println("computer 값 "+computer);
		
		if(user==computer) {
			System.out.println("맞췄습니다.^^");
		}
		else {
			System.out.println("땡! 틀렸습니다!");
		}
			
	}

}

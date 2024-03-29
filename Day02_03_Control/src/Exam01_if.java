import java.util.Scanner;

public class Exam01_if {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("당신이 좋아하는 과일을 선택해주세요.");
		System.out.println("1. 사과 2. 딸기 3. 수박");
		System.out.print(">>");
		int menu=Integer.parseInt(sc.nextLine());
		
		if(menu==1) {
			System.out.println("사과입니다.");
		}
		else if(menu==2){ //그거 말고!!!!!!!!!!! 만약에 이거 라면 
			System.out.println("딸기입니다.");
		}
		else if(menu==3) {
			System.out.println("수박입니다.");
		}
		else {
			System.out.println("메뉴에 없습니다.");
		}
	}
}

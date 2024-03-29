import java.util.Scanner;

public class Quiz01_if {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("1~10사이의 수를 입력해주세요 >>");
		int num=Integer.parseInt(sc.nextLine());
		
		//첫번째 if문  
		if(num>=1&&num<=10) {
			System.out.println("통과");
		}
		
		//2번째 if문 (if-else if-else) 덩어리
		//else-if와 else는 바로 위에 if에게 종속된다.
		if(num==3) {
			System.out.println("난 3");
		}
		
		else if(num==4) { 
			System.out.println("난 4");
		}
		
		else {
			System.out.println("범위 초과");
		}
		
		//if 7의 경우  1번쨰 if에 해당 && 2번째 else에 종속되기 때문에
		//결과: 통과, 범위 초과
		//결과 값이 두가지가 나오게 된다.
		
	}

}

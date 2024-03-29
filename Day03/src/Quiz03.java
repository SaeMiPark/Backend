import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		System.out.print("2~9단 줄 선택 >>");
		int i=Integer.parseInt(sc.nextLine());

		if(i>=2&&i<=9) {
			for(int j=1; j<=9; j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
		}

	}

}

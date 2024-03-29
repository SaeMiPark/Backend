import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("국어 점수를 입력하세요: ");
		int kor=Integer.parseInt(sc.nextLine());
		
		System.out.println("영어 점수를 입력하세요: ");
		int eng=Integer.parseInt(sc.nextLine());
		
		System.out.println("수학 점수를 입력하세요: ");
		int mat=Integer.parseInt(sc.nextLine());
		
		double avg=(kor+eng+mat)/3.0;
		
		String level;
		
		// avg<90 중에서....
		
		if(avg>=90) {
			level="A";
		}
		else if(avg>=80) {
			level="B";
		}
		else if(avg>=70) {
			level="C";
		}
		else if(avg>=60) {
			level="D";
		}
		else {
			level="F";
		}
		
		System.out.println("평균 점수는 "+avg+", 등급은 "+level);
		
	}
}

import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		for(int i=0; i<10; i++) {
			double rand=Math.random();

			//난수*(y-x+1)+x
			int rand1=(int)(rand*10);
			int rand2=((int)(rand*10)+1);
			int rand3=((int)(rand*(35-20+1)+20));
			int rand4=(int)(rand*2);

			System.out.print("0~9까지의 랜덤 수: ");
			System.out.println(rand1);
			System.out.print("1~10까지의 랜덤 수: ");
			System.out.println(rand2);
			System.out.print("20~35까지의 랜덤 수: ");
			System.out.println(rand3);
			System.out.print("0 또는 1: ");
			System.out.println(rand4);
			System.out.println("===============");

		}	
	}

}

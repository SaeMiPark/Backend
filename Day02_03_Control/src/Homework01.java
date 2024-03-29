import java.util.Scanner;

public class Homework01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("가치관 테스트\n");
		System.out.println("당신은 사막에 있습니다. 당신은 혼자입니다.");
		System.out.println("당신에게 4마리의 동물이 주어집니다.\n"
				+ "밤이 되면 그중 \"한 마리를\" 버리거나 죽여야 합니다.\n"
				+ "\n"
				+ "즉, 두 번째 날엔 3마리만 데리고 갈 수 있습니다.\n"
				+ "그 다음날은 2마리, 마지막 날엔 1마리\n"
				+ "\n"
				+ "오직 한 마리만 가지고 통과할 수 있습니다.\n"
				+ "가장 먼저 버릴 동물과 마지막까지 함께 할 동물을 고르고 이유를 생각해보세요.");
		
		
		
		System.out.println("\n4가지 동물: 소, 사자, 양, 원숭이\n");
		
		System.out.print("Q1: 가장 먼저 버릴 동물은? ");
		String animal1=sc.nextLine();
		
		System.out.print("Q2: 마지막까지 함께할 동물은? ");
		String animal2=sc.nextLine();
		System.out.println();
		

		if(animal1.equals("양")) {
				System.out.println("양은 자식을 의미합니다.\n"
						+ "이유로는 양젖으로 갈증을 풀겠다\r\n"
						+ "죽여서 털옷으로 사용하겠다\r\n"
						+ "양고기로 식사와 사자의 먹이로 사용하겠다가 있습니다.\n");
			}
			else if(animal1.equals("소")) {
				System.out.println("소는 부를 의미합니다.\n"
						+ "이유로는 타고 가겠다\r\n"
						+ "짐을 싣겠다.\r\n"
						+ "죽여서 고기로 먹겠다가 있습니다.\n");
				
			}
			else if(animal1.equals("원숭이")) {
				System.out.println("원숭이는 배우자를 의미합니다.\n"
						+ "이유로는 아무 쓸모가 없다.\n"
						+ "까부는 게 보기 싫다가 있습니다.\n");
				
			}
			else if(animal1.equals("사자")) {
				System.out.println("사자는 자존심을 의미합니다.\n"
						+ "이유로는 다른 동물에게 위해가 된다가 있습니다.\n");
				
			}
			else {
				System.out.println("가장 먼저 버릴 동물을 다시 확인해 주세요.\n");
			}
		

		if(animal2.equals("양")) {
				System.out.println("양은 자식을 의미합니다.\n"
						+ "긍정적 이유로는 따뜻하다.\n"
						+ "포근하다.\n"
						+ "밤에 안고 자겠다가 있습니다가 있습니다가 있습니다.\n");
			}
			else if(animal2.equals("소")) {
				System.out.println("소는 부를 의미합니다.\n"
						+ "긍정적 이유로는 옆에 있으면 든든하다가 있습니다.\n");
				
			}
			else if(animal2.equals("원숭이")) {
				System.out.println("원숭이는 배우자를 의미합니다.\n"
						+ "긍정적 이유로는 함께 있으면 즐거울 것 같다.\n"
						+ "외롭지 않을 것 같다.\n"
						+ "심심하지 않을 것 같다가 있습니다가 있습니다.\n");
				
			}
			else if(animal2.equals("사자")) {
				System.out.println("사자는 자존심을 의미합니다.\n"
						+ "긍정적 이유로는 나를 지켜줄 것 같다가 있습니다.\n");
				
			}
			else {
				System.out.println("마지막까지 함께 할 동물을 다시 확인해 주세요.\n");
			}
		
	}

}

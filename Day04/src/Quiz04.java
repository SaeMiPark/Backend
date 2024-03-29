import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("== 가위 바위 보 게임 ==");
		System.out.print("숫자를 선택하세요(1.가위/2.바위/3.보): ");
		int user=Integer.parseInt(sc.nextLine());
		int com=(int)(Math.random()*3+1);
		String userhan = null, comhan=null;
		
		//한글 변경
		if(user==1) {
			userhan="가위";
		}
		else if(user==2) {
			userhan="바위";
		}
		else if(user==3){
			userhan="보";
		}
		else {
			System.out.println("다시 입력하세요.");
		}
		
		if(com==1) {
			comhan="가위";
		}
		else if(com==2) {
			comhan="바위";
		}
		else if(com==3){
			comhan="보";
		}
		else {
			System.out.println("다시 입력하세요.");
		}
		
		
		System.out.println("========결과========");
		System.out.println("당신은 "+userhan+"를 냈습니다.");
		System.out.println("컴퓨터는 "+comhan+"를 냈습니다.");
		System.out.println("===================");
		
		 if ((user == 1 && com == 3) || (user == 2 && com == 1) || (user == 3 && com == 2)) {
	           System.out.println("플레이어가 이겼습니다!");
	      } 
		 else if ((user == 1 && com == 2) || (user == 2 && com == 3) || (user == 3 && com == 1)) {
	           System.out.println("컴퓨터가 이겼습니다!");
	      } 
		 else if (user == com) {
	           System.out.println("비겼습니다!");
	      }	
		 //비긴 경우를 위에 올리는 것이 코드가 적고 효율적일 수 있다.
		
		
	}
}

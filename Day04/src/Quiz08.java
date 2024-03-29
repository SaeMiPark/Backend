import java.util.Scanner;
/*배팅 게임*/
public class Quiz08 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int balance=0, fill=0;
		
		while(true) {
			System.out.println("\n경마게임에 오신 것을 환영합니다.");
			System.out.println("1. 게임 시작");
			System.out.println("2. 잔액 충전");
			System.out.println("3. 잔액 조회");
			System.out.println("4. 종료");
			System.out.print(">> ");
			int menu=Integer.parseInt(sc.nextLine());
			
			if(menu==1) {
				System.out.println("1번 말: 우승경력이 많지만 은퇴시기를 앞둔 늙은 말");
				System.out.println("2번 말: 2월달 연습 기록이 가장 좋았던 젊은 말");
				System.out.println("3번 말: 떠오르는 신예 말");
				System.out.println("말들이 준비되었습니다. 배팅하고 싶은 말을 선택해주세요.");
				System.out.print(">> ");
				int select=Integer.parseInt(sc.nextLine());
				
				
				System.out.println(select+"말을 선택하셨습니다.");
				System.out.println("얼마를 배팅하시겠습니까?");
				System.out.print(">> ");
				int bet=Integer.parseInt(sc.nextLine());
				
				System.out.println(bet+"원 만큼의 금액이 배팅되었습니다.");
				System.out.println(select+"번 말이 승리하는 경우 배팅액의 50%를 가져가게 됩니다.");
				System.out.println("반대로 다른 말이 경주에 승리하는 경우, 배팅한 금액 전액을 잃게 됩니다.");
				
				//난수 생성
				int rand=(int)(Math.random()*3+1);
				
				//경우의 수 구분하기
				if(select==rand) {
					System.out.println("<<<배팅한 "+select+"말이 승리하였습니다!!!>>>");
					System.out.println("배팅액의 50%를 받았습니다!");
					
					int success=balance*50/100;
					System.out.println("배팅으로 얻은 금액은 "+success+"원 입니다.");
					balance+=success;
					System.out.println("현재 잔액은 "+balance+"원 입니다.");
				}
				else {
					System.out.println("<<<아.. 안타깝습니다. "+rand+"말이 승리하였습니다.>>>");
					System.out.println(balance+"원 만큼 읽으셨습니다. 현재 잔액은 0원 입니다.");
					balance=0;
				}
				
				
			}
			else if(menu==2) {
				System.out.print("얼마를 충전하시겠습니까? >>");
				fill=Integer.parseInt(sc.nextLine());
				balance+=fill;
				System.out.println(fill+"만큼 충전되었습니다.");
				System.out.println("현재 잔액은 다음과 같습니다 : "+balance);
			}
			else if(menu==3) {
				System.out.println("현재 잔액은 다음과 같습니다 : "+balance);
			}
			else if(menu==4) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
				
			}
			else {
				System.out.println("메뉴에 없는 옵션입니다.");
			}
			
			
			
			
			
			
			
			
			
			
		}//경마게임 오픈 while문
	}

}

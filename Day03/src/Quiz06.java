import java.util.Scanner;

public class Quiz06 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int menu;
		int balance=3000;
		int plus;
		int minus;

		while(true) {
			System.out.print("***ATM 시뮬레이터***\n"
					+"1. 잔액조회\n"
					+"2. 입금하기\n"
					+"3. 출금하기\n"
					+"4. 종료하기\n"
					+">>");
			
			menu=Integer.parseInt(sc.nextLine());
			
			if(menu==1) {
				System.out.println("현재 보유 잔액은 "+balance+"입니다.");
			}
			
			else if(menu==2) {
				System.out.println("얼마를 입금하시겠습니까?");
				plus=Integer.parseInt(sc.nextLine());
				balance+=plus;
				System.out.println("입금이 완료되었습니다.");
			}
			
			else if(menu==3) {
				System.out.println("얼마를 출금하시겠습니까?");
				minus=Integer.parseInt(sc.nextLine());
				if(balance>=minus) {
					balance-=minus;
					System.out.println("출금이 완료되었습니다.");
				}
				else {
					System.out.println("잔액이 부족합니다. 현재 잔액은 "+balance+"원 입니다.");
				}
				
			}
			
			else if(menu==4) {
				System.exit(0);
			}
			
			else {
				System.out.println("다시 입력하세요.");
			}
			
			
		}
		
	}

}

import java.util.Scanner;
/*ATM 시뮬레이터*/

public class Exam04_ATM {
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

			try {
				menu=Integer.parseInt(sc.nextLine());

				if(menu==1) {
					System.out.println("현재 보유 잔액은 "+balance+"입니다.");
				}

				else if(menu==2) {
					while(true) {
						try {
							System.out.println("얼마를 입금하시겠습니까?");
							//발생 시점
							plus=Integer.parseInt(sc.nextLine());

							balance+=plus;
							System.out.println("입금이 완료되었습니다.");
							break;
						}catch(Exception e){
							System.out.println("입금 금액을 확인해주세요.");
						}
					}
				}

				else if(menu==3) {
					while(true) {
						try {
							System.out.println("얼마를 출금하시겠습니까?");
							//발생 시점
							minus=Integer.parseInt(sc.nextLine());
							if(balance>=minus) {
								balance-=minus;
								System.out.println("출금이 완료되었습니다.");
							}
							else {
								System.out.println("잔액이 부족합니다. 현재 잔액은 "+balance+"원 입니다.");
							}
							break;

						}catch(Exception e) {
							System.out.println("출금 금액을 확인해주세요.");
						}
					}
				}

				else if(menu==4) {
					System.exit(0);
				}

				else { //1,2,3,4가 아닌 숫자가 메뉴로 입력됐을 때
					//왜 여기서 문자를 처리하지 못하는가?
					//parseInt로 이미 문자를 숫자로 변환해서 받았기 때문에
					//menu는 숫자이다.
					//숫자 안에서만 조건을 판별한다.
					//try-catch를 따로 쓰지 않고 menu를 String으로 받아서 처리하기도 한다.
					System.out.println("메뉴 번호를 확인해주세요.");
					continue;
				}

			}catch(Exception e) { 
				System.out.println("메뉴룰 다시 입력하세요"); //메뉴에 문자가 입력됐을 떄
			}


		}

	}

}


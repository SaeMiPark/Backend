import java.util.Scanner;

public class Quiz07 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int balance=3000;
		int coke=0, sida=0, masil=0;
		try {
			while(true) {
				System.out.println("===자판기 시뮬레이터===\n"
						+"1. 콜라(1200) 2. 사이다(800) 3. 매실차(1500) [0.소지품확인]");
				System.out.print(">>");
				int menu=Integer.parseInt(sc.nextLine());

				if(menu==1) {
					if(balance>=1200) {
						System.out.println("콜라를 구매했습니다.\n"
								+"콜라 +1");
						balance-=1200;
						coke++;
						System.out.println("소지금 - "+balance);
					}
					else {
						System.out.println("잔액이 부족합니다.");
					}


				}
				else if(menu==2) {
					if(balance>=800) {
						System.out.println("콜라를 구매했습니다.\n"
								+"사이다 +1");
						balance-=800;
						sida++;
						System.out.println("소지금 - "+balance);
					}
					else {
						System.out.println("잔액이 부족합니다.");
					}

				}
				else if(menu==3) {
					if(balance>=1500) {
						System.out.println("콜라를 구매했습니다.\n"
								+"매실차 +1");
						balance-=1500;
						masil++;
						System.out.println("소지금 - "+balance);
					}
					else {
						System.out.println("잔액이 부족합니다.");
					}

				}
				else if(menu==0) {
					System.out.println("====나의 소지품====\n"
							+"소지금:"+balance+"\n"
							+"콜라:"+coke+"\n"
							+"사이다:"+sida+"\n"
							+"매실차:"+masil+"\n");

				}
				else {
					System.out.println("다시 선택하세요.");
					System.exit(0);
				}
			}
		}catch(Exception e) {
			System.out.println("올바른 형식의 입력이 아닙니다. 숫자를 입력해주세요.");
		}
	}

}

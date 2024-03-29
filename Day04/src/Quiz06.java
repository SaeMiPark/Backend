import java.util.Scanner;
/*up&down게임 둘이서 하기*/
public class Quiz06 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	
		//score==현재 최고 기록==최솟값
		int minscore=100;
		String winner=new String();
		 
		ext: while(true) {
			System.out.println("== UP & DOWN Game ==");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print(">>");
			int menu=Integer.parseInt(sc.nextLine());

			switch(menu) {
			case 1:
				int countplayer1=0, countplayer2=0;
				int randnum=(int)(Math.random()*99+1);

				System.out.println("<< Game Start >>");
				while(true) {
					//player1
					System.out.print("\nInput Number player1 : ");
					int numplayer1=Integer.parseInt(sc.nextLine());
					countplayer1++;
					
					if(randnum>numplayer1) {
						System.out.println("<< U  P >>");
					}
					else if(randnum<numplayer1) {
						System.out.println("<< DOWN >>");
					}
					else if(randnum==numplayer1) {
						System.out.println("<< player 1 정 답 >>\n");
						winner="player1";
						//System.out.println("전:player 1 count"+countplayer1);
						//System.out.println("전:player 2 count"+countplayer2);
						//System.out.println("전:minscore"+minscore);
						if(minscore>countplayer1) {
							minscore=countplayer1;
							System.out.println("최고 기록 갱신입니다.");
						}
						//System.out.println("후:player 1 count"+countplayer1);
						//System.out.println("후:player 2 count"+countplayer2);
						//System.out.println("후:minscore"+minscore);
						continue ext;
					}
					
					//player2
					
					System.out.print("\nInput Number player2 : ");
					int numplayer2=Integer.parseInt(sc.nextLine());
					countplayer2++;
					
					if(randnum>numplayer2) {
						System.out.println("<< U  P >>");
					}
					else if(randnum<numplayer2) {
						System.out.println("<< DOWN >>");
					}
					else if(randnum==numplayer2) {
						System.out.println("<< player 2 정 답 >>\n");
						winner="player2";
						if(minscore>countplayer2) {
							minscore=countplayer2;
							System.out.println("최고 기록 갱신입니다.");
							//up, down에서 +1, 최고 기록에서 마지막에 +1;
						}
						continue ext;
					}
				}
	
			case 2:
				System.out.println("최고 기록을 세운 사람은 "+winner);
				System.out.println("현재 최고 기록은 "+minscore+"입니다.");
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("메뉴에 없습니다.");
			}
		}
	}

}


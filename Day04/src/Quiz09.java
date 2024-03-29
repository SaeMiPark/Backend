import java.util.Scanner;
/*up&down게임 컴퓨터와 대결하기*/
public class Quiz09 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	
		//score==현재 최고 기록==최솟값
		int minscore=100; 
		 
		ext: while(true) {
			System.out.println("== UP & DOWN Game ==");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print(">>");
			int menu=Integer.parseInt(sc.nextLine());

			switch(menu) {
			case 1:
				int nowcount=1, comcount=1, min=0, max=99;
				int randnum=(int)(Math.random()*99+1); //randnum 정답
				System.out.println("정답은 "+randnum+"입니다. ");
				System.out.println("<< Game Start >>");
				
				while(true) {
					System.out.print("\nInput Number : ");
					int usernum=Integer.parseInt(sc.nextLine());
					
					//up인 상황
					if(randnum>usernum) {
						System.out.println("<< U  P >>");
						nowcount++;
						min=usernum+1;
					}
					
					//down인 상황
					else if(randnum<usernum) {
						System.out.println("<< DOWN >>");
						nowcount++;
						max=usernum-1;
					}
					
					//맞춘 상황
					else if(randnum==usernum) {
						System.out.println("<< 정 답 >>");
						if(minscore>nowcount) {
							minscore=nowcount;
						}
						continue ext;
					}
					
					
					int computernum=(int)(Math.random()*(max-min+1)+min);
					System.out.print("\nComputer Number : "+computernum+"\n");
					
					//up인 상황
					if(randnum>computernum) {
						System.out.println("<< U  P >>");
						comcount++;
						min=computernum+1;
					}
					
					//down인 상황
					else if(randnum<computernum) {
						System.out.println("<< DOWN >>");
						comcount++;
						max=computernum-1;
					}
					
					//맞춘 상황
					else if(randnum==computernum) {
						System.out.println("<< 정 답 >>");
						
						if(minscore>comcount) {
							minscore=comcount;
						}
						continue ext;
					}
					
				}		
			case 2:
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


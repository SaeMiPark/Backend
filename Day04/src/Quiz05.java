import java.util.Scanner;
/*up&down게임 혼자하기*/
public class Quiz05 {
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
				int nowcount=1;
				int randnum=(int)(Math.random()*99+1);

				System.out.println("<< Game Start >>");
				while(true) {
					System.out.print("\nInput Number : ");
					int usernum=Integer.parseInt(sc.nextLine());
					if(randnum>usernum) {
						System.out.println("<< U  P >>");
						nowcount++;
					}
					else if(randnum<usernum) {
						System.out.println("<< DOWN >>");
						nowcount++;
					}
					else if(randnum==usernum) {
						System.out.println("<< 정 답 >>");
						
						if(minscore>nowcount) {
							minscore=nowcount;
						}
						//System.out.println("나우"+nowcount); //nowcount=9, minscore=9
						//System.out.println("누적"+minscore);
						continue ext;
						//break도 가능
						//break하면 바로 위에 무한 루프문을 빠져나오면서
						//case2,3을 거치고 맨 처음 무한 루프문으로 간다.
					}
//					밑에는 의미 없는 코드 문자가 입력되는 걸 막고 싶다면 try-catch
//					범위를 넘어서는 걸 막고 싶다면 if-else부분 추가
//					else {
//						System.out.println("숫자를 입력하세요.");
//						continue;
//					}
				}
				//break; unreachable code
				//각 문장은 continue와 while(input number)를 반복하기 때문에
				//이 코드까지 오지 않는다. 그래서 접근할 수 없는 코드라고 뜨는 것이다.		
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

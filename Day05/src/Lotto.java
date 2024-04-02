import java.util.Scanner;


public class Lotto {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int[] card=new int[45]; 
		int[] win=new int[6];
		int[] my=new int[6];

		//누적이 필요
		int totalcnt=0, firstcnt=0, secondcnt=0, thirdcnt=0, forthcnt=0, fivecnt=0;
		
		int firstamount=1600000000, secondamount=60000000, thirdamount=30000000;
		int forthamount=50000, fiveamount=5000;


		//0~44, 1~45
		for(int i=0; i<card.length; i++) {
			card[i]=i+1;
		}

		while(true) {
			totalcnt++;//while이 시도되는 순간 횟수 추가임
			int bonus=0;

			//로또 번호 갱신
			for(int j=0; j<card.length*10; j++) {
				int x=(int)(Math.random()*45);//index값으로 돌리기
				int y=(int)(Math.random()*45);//0~44

				int tmp=card[x];
				card[x]=card[y];
				card[y]=tmp;
			}
			//System.out.println("당첨 번호 예시입니다.");
			for(int i=0; i<6;i++) {//0~5, 1~6
				win[i]=card[i];
				//System.out.print(win[i]+" ");
			}//로또 번호 갱신

			//보너스 번호 넣기
			bonus=card[7];;
			
			//내 번호
			for(int j=0; j<card.length*10; j++) {
				int x=(int)(Math.random()*45);//index값으로 돌리기
				int y=(int)(Math.random()*45);//0~44

				int tmp=card[x];
				card[x]=card[y];
				card[y]=tmp;
			}
			//System.out.println("\n내 번호 예시입니다.");
			for(int i=0; i<6;i++) {
				my[i]=card[i];
				//System.out.print(+my[i]+" ");
			}//내 번호

			int correctcnt=0, bonuscnt=0;

			//당첨 갯수 확인하기
			for(int i=0; i<6; i++) {//0의 자리 하나
				if(my[i]==bonus) { //보너스자리 당첨여부
					bonuscnt++;
				}
				for(int j=0; j<6; j++) {//0~5번과 맞는 가?
					if(my[i]==win[j]) { //당첨 갯수
						correctcnt++;
					}
				}
			}//당첨 갯수 확인하기
			

			//공통 출력하기
			System.out.print("\n"+totalcnt+" 회차 : "+"("+win[0]+")"+"("+win[1]+")"+"("+win[2]+")"
					+"("+win[3]+")"+"("+win[4]+")"+"("+win[5]+")"+"+ ("+bonus+")");
			System.out.print("\n당첨횟수와 보너스 횟수 ");
			System.out.println(correctcnt + " : " + bonuscnt);
			
			//1등 당첨이라면
			if(correctcnt==6&&bonuscnt==0) {
				firstcnt++;
				System.out.println("----------> ★★★1등 당첨을 축하합니다!!!!★★★");
				System.out.println("=======================================");
				System.out.print(" 당첨 번호 : "+"("+win[0]+")"+"("+win[1]+")"+"("+win[2]+")"
						+"("+win[3]+")"+"("+win[4]+")"+"("+win[5]+")"+"+ ("+bonus+")");
				System.out.println();				
				System.out.println(totalcnt+"번 만에 1등에 당첨되셨습니다!\t:: 1등 수령액 "+firstamount+
						"\t:: 당첨 확률 "+1.0/totalcnt);
				
				System.out.println("2등 당첨 횟수: "+secondcnt+" 당첨 금액: "+(secondcnt*secondamount)+" 당첨 확률: "
						+(double)secondcnt/totalcnt);
				System.out.println("3등 당첨 횟수: "+thirdcnt+" 당첨 금액: "+(thirdcnt*thirdamount)+" 당첨 확률: "
						+(double)thirdcnt/totalcnt);
				System.out.println("4등 당첨 횟수: "+forthcnt+" 당첨 금액: "+(forthcnt*forthamount)+" 당첨 확률: "
						+(double)forthcnt/totalcnt);
				System.out.println("5등 당첨 횟수: "+fivecnt+" 당첨 금액: "+(fivecnt*fiveamount)+" 당첨 확률: "
						+(double)fivecnt/totalcnt);

				break;
			}

			else if(correctcnt==5&&bonuscnt==1) {
				secondcnt++;
				System.out.println("----------> 2등 당첨");

			}

			else if(correctcnt==5&&bonuscnt==0) {
				thirdcnt++;
				System.out.println("----------> 3등 당첨");
			}

			else if(correctcnt==4&&bonuscnt==0) {
				forthcnt++;
				System.out.println("----------> 4등 당첨");
			}

			else if(correctcnt==3&&bonuscnt==0) {
				fivecnt++;
				System.out.println("----------> 5등 당첨");
			}

			else {
				System.out.println("----------> 다음 기회에");
			}

		}//while문
	}//static
}

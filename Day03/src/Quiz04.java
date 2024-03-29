import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		System.out.print("n을 입력하세요. >>");
		int n=Integer.parseInt(sc.nextLine());
		int answer=1;

		if(n>=2&&n<=100) {
			for(int i=2; i<=n; i++) {
				answer+=i;
			}
			System.out.println(answer);
		}else {
			System.out.println("범위초과");
		}
	}
}

//int dp[]=new int[n+1];
//dp[1]=1;
//
////누적합
//for(int i=2; i<=n; i++) {
//	dp[i]=dp[i-1]+i;
//}
//
//System.out.println(dp[n]);

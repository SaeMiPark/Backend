import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int[] arr=new int[] {97,63,57,21}; 

		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("정렬 전");

		//정렬하기 길이는 4
		//n-1번까지 돈다.
		for(int i=0; i<arr.length-1; i++) {//0,1,2
			for(int j=i+1; j<=arr.length-1; j++)//1,2,3
				if(arr[i]>arr[j]) {
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
		}

		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

		System.out.println();
		System.out.println("정렬 후");


	}

}

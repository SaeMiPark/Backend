import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		int[] arr=new int[] {15,24,35,99,86,34,13,27,46,66};

		for(int i=0; i<arr.length-1; i++) {
			for(int j=i; j<arr.length-1; j++) {
				if(arr[i]>arr[j+1]) {
					int tmp=arr[i];
					arr[i]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}

		for(int x: arr) {
			System.out.print(x+" ");
		}

	}

}

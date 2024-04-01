import java.util.Scanner;

public class Quiz01 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	int[] arr=new int[3];
	
	for(int i=0; i<arr.length; i++) {
		System.out.print(">>");
		arr[i]=Integer.parseInt(sc.nextLine());
	}
	
	for(int i=0; i<arr.length; i++) {
		System.out.println(arr[i]);
	}
	
	
}
}

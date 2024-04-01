import java.util.Scanner;

public class Exam06_array {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		//배열 장소 선언 Step1. 참조변수 생성
		//정확히는 배열을 저장하기 위한 참조변수를 생성한 것.
		//int[] arr; //스택에 저장된다
		
		//배열 생성 Strp2. 배열 생성
		//new라는 의미는 == 메모리의 heap영역을 사용하겠다는 이야기이다.
		//new int[4]; //힙에 저장된다. 메모리 주소를 의미한다. ex.1000
		
		int[] arr=new int[4];
		arr[0]=5;
		arr[1]=10;
		arr[2]=15;
		arr[3]=20;
		
		
		//System.out.println(arr[0]);
		for(int i=0; i<4; i++) {
			//System.out.println(arr[i]);
		}
		
		//int[] arr2=new int[20000000000];
		//int[] arr2=new int[] {5, 10, 15,20};
		
		
		//자료형의 출력문의 차이로 인해서 처음 만든 사람들에 의해 적용된 것이다.
		char[] arr1=new char[] {'A','B','C','D'};
		//System.out.println(arr1); //출력: A,B,C,D
		String[] arr2=new String[] {"Hello", "Java", "Array"};
		//System.out.println(arr1); //출력: 주소쏼라쏼라
		
		
		//int형 변수 100개를 묶어 배열로 만들고, 0-99qjszksdp 1-100까지를 담아주세요
		int nint=100;
		int[] arr3=new int[nint];
		for(int i=0; i<arr3.length; i++) {
			arr3[i]=i+1;
		}
		
		System.out.println(arr3[0]);
		System.out.println(arr3[99]);
		
		//char형 변수 26개를 묶어 배열로 만들고, 0~25번 칸에 A~Z를 담아주세요
		int nch=26;
		char[] arr4=new char[nch];
		for(int i=0; i<arr4.length; i++) {
			arr4[i]=(char)(i+65);
		}
		
		System.out.println(arr4[0]);
		System.out.println(arr4[25]);
		
	}
}

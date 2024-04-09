
public class Exam01 {
	public static void main(String[] args) {
		String[] arr=new String[10];
		//삽입
		arr[0]="Hello";
		arr[1]="world";
		arr[2]="Java";
		//출력
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		//삭제
		for(int i=0; i<3; i++) {
			arr[i]=arr[i+1];
		}
		
		System.out.println("======");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		
		//비순차적 삽입
		arr[2]=arr[1];
		arr[1]="Collection";
		System.out.println("======");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		
		System.out.println(arr.length);
		
		
	}
}

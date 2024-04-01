
public class Exam08 {
	public static void main(String[] args) {
//		int a=10;
//		int b=20;
//		
//		System.out.println(a+" : "+b);
//		
//		//swap 기법 = 교환 기법
//		int tmp=a;
//		a=b;
//		b=tmp;
//		
//		System.out.println(a+" : "+b);
		
		int[] arr=new int[] {10,20};
		System.out.println(arr[0]+" : "+arr[1]);
		//swap
		int tmp=arr[0];
		arr[0]=arr[1];
		arr[1]=tmp;
		System.out.println(arr[0]+" : "+arr[1]);
	}

}

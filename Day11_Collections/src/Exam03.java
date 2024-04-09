
public class Exam03 {
	public static void main(String[] args) {
		String[] arr=new String[] {"Hello","World"};
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//변형 for, for-each문
		//장점 코드 짧다, i안써도 된다.
		//단점 무조건 전체 순회, i를 활용할 수 없음
		for(String str: arr) {
			System.out.println(str);
		}
		
	}

}

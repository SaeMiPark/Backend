
public class Exam02 {
	public static void main(String[] args) {
		//지역변수 == 중괄호
		
		//int a=10;
		//메인 지역에서 만들어진 변수는 하위 지역에서도 사용이 가능하다.
		{//가지역
			int a=10;
			System.out.println(a);
		}
		
		{//나지역
			int a=10; //서로 다른 지역이므로 가능
		}
	}

}

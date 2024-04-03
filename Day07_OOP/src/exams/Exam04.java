package exams;

public class Exam04 {
	//메소드 오버로딩
	//자바에서는 메소드의 이름이 같아도 
	//매개변수를 통해 구분할 수 있다면,
	//다른 메소드로 사용할 수 있음.
	
	
	public static void func() {
		System.out.println("Function입니다.");
	}
	
	public static void func(int num) {
		System.out.println("이건 다른 펑션입니다.");
	}
	
	public static void func(int num1, int num2) {
		System.out.println("이건 또 다른 펑션입니다.");
	}
	
	public static void main(String[] args) {
		func();
		
	}

}

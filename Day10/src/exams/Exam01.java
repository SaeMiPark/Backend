package exams;
class A{
	public void funcA() {
		System.out.println("A 클래스 메소드 입니다.");
	}
	
}
class B extends A{
	public void funcB() {
		System.out.println("B 클래스 메소드 입니다.");
	}
	
}

public class Exam01 {
	public static void main(String[] args) {
		A a=new B(); 
		B b=new B();
		a.funcA();
	
		//A형 변수에 A도 담을 수 있고, B도 담을 수 있다.
	}

}

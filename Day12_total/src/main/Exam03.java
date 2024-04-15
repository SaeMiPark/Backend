package main;

public class Exam03 {
	public int a; //인스턴스 멤버 필드, 객체 변수
	public static int b; //클래스 멤버 필드, 클래스 변수
	
	//funcA가 실행되는 시점에는 
	//a와 b가 둘다 존재한다.
	public void funcA() {
		a=10;
		b=10;	
	}
	
	//funcB가 실행되는 시점에는 
	//a는 존재하는지 모르기 때문에 에러
	//b는 존재한다.
	//즉, static 멤버 메소드에서는 non-static멤버를 사용할 수 없다.
	public static void funcB() {
		//a=10;
		b=10;
	}
	
	public static void main(String[] args) {
		//static 모든 메소드, 변수는 main이 실행됨과 동시에 같이 실행된다.
		Exam03.b=10; //클래스.static 사용
		
		Exam03 e1=new Exam03();
		Exam03 e2=new Exam03();
		
		e1.a=10; //e2.a=0;
		e1.b=10; //e2.b=10;
		
	}

}

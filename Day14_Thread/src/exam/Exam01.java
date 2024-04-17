package exam;

class Worker extends Thread {
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print(i+" ");
		}
	}
}

public class Exam01 {
	public static void main(String[] args) {
		//Thread-프로세스 내에서 작업을 처리하는 단위 (일꾼)
		
		//두개의 for문 같이 실행이 안 되는 문제를 해결하는 것이 Thread
		//하나의 thread로 동작하면 싱글쓰레기, 여러개로 동작하면 멀티쓰레드
		
		//Thread 사용법 steps
		//step1 thread 클래스를 상속받는 사용자 정의 클래스를 작성한다.
		//step2 thread 클래스로부터 상속받은 public void run메소드를 override한다.
		//step3 오버라이드 메소드 내에 병행처리 할 코드를 작성한다.
		//step4 사용자 정의 클래스로부터 인스턴스를 생성한다.
		//step5 생성된 메소드로부터 start메소드를 콜한다.★
		
		//메인쓰레드로 시작
		Worker worker=new Worker();
		worker.start(); //메인쓰레드가 워커쓰레드를 꺠운다.
		//메인은 main의 for문을 돌리고,
		//워커쓰레드는 워커쓰레드 for문을 돌리고 있음.
		
		for(int i=0; i<100; i++) {
			System.out.print(i+" ");
		}
		
	}

}

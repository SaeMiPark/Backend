package exam;

class Worker1 extends Thread {
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("@ ");
		}
	}

}

class Worker2 extends Thread {
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("$ ");
		}
	}

}

public class Exam02 { //대표 클래스 설정 클래스 앞에 public을 붙여야 한다. public은 대표 클래스 하나만 사용 가능.
	public static void main(String[] args) {
		Worker1 worker1=new Worker1();
		Worker2 worker2=new Worker2();

		worker1.start(); //스레드 시작 위치 중요.
		worker2.start(); //for문 밑에 있다면 싱글스레드와 다를바 없어질수도 있다.
		for(int i=0; i<100; i++) {
			System.out.print("# ");
		}
	}

}

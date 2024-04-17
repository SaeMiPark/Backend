package exam;

import javax.swing.JOptionPane;


class Countdown extends Thread{
	public static int i=10;
	
	private String msg;
	
	public Countdown() {};
	
	public Countdown(String msg) { //생성자에 받고 싶은걸 담아서 
		this.msg=msg; //다시 private멤버 변수로 보낸다.
	}
	
	public void run() {
		for(i=10; i>0; i--) {
			//result++;
			System.out.println(i);
			//뜨레드를 일정시간동안 멈추는 기능
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
		System.out.println("Game Over!");
		System.exit(0);
	}
}

public class Exam03 {
	public static void main(String[] args) throws InterruptedException {
		//10초 안에 입력하는 스레드를 만들어봐라

		new Countdown().start();
		
		String[] sts=new String[] {
				"메세지를 입력하세요.",
				"kdjaf;lsdjfoiawejflsdjilfjai",
				"djkfja;sjefo;wejfoi"
		};

		while(true) {
			int rand=(int)(Math.random()*3);

			String msg=JOptionPane.showInputDialog(sts[rand]);
			
			if(msg.equals(sts[rand])) {
				System.out.println("성공 +5");
				Countdown.i+=5;
				//System.exit(0);
			}else {
				System.out.println("오타 -2");
				Countdown.i-=2;
			}
			
			
		}

	}
}
package exams;
import java.awt.Robot;

public class Exam02 {
	public static void main(String[] args) throws Exception {
		//오토마우스?
		Robot robot=new Robot();
		robot.mouseMove(400, 400);
		for(int i=0; i<100; i++) {
			robot.mouseMove(400+i, 400);
			robot.delay(50);  //0.05초==50/1000
			//millisecond =1000분의 1초
			//1000을 쓰면 1초 delay
		}
	}

}

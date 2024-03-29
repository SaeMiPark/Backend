
public class Exam01 {
	public static void main(String[] args) {
		//난수
		double rand=Math.random();
		System.out.println((int)(rand*6)+1);
		//0~5사이 1~6
		//내가 마지막으로 원하는 수 +1==6
		//0.999*10=10을 넘지 못한다.
		
		//34~72
		//난수를 뽑아내기 위한 공식
		System.out.println((int)(rand*(72-34+1))+34);
	}

}

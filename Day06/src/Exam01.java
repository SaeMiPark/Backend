
public class Exam01 {
	
	public static int plus(int num1, int num2){
		int result=num1+num2;
		return result; //1.함수를 끝낸다 2. 리턴값을 보낸다.
	}
	
	
	public static void main(String[] args) {
		int result=plus(10,5);	//1. 함수 호출 2. 리턴 값 
		System.out.println(result);
		//Math.random();
	}
}

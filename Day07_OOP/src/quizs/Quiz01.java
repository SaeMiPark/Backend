package quizs;
import classes.Car;
import classes.Car2;
//import classes.Car; 다른 패키지에 있다면 import로 가져와야 한다!!

public class Quiz01 {
	public static void main(String[] args) {
		//참조변수에 인스턴스 생성해서 넣기
		Car genesis=new Car("Genesis GV80",80000000, new String[] {"Gray","Blue","Pink"});
		System.out.println(genesis.getModel());
		System.out.println(genesis.getPrice());
		System.out.println(genesis.getColor());
		
		Car2 reviewcar=new Car2("Genesis",8000,"Gray");
	}

}

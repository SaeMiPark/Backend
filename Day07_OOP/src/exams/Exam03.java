package exams;

import classes.Tv;

public class Exam03 {
	public static void main(String[] args) {
		Tv lg =new Tv(1000,16,20);
		//public상태 음수도 넣을 수 있어서 문제
		//private은 아예 접근을 막음
		//->어떻게 바꿀 수 있을까? getter, setter
		
		
		
		System.out.println(lg.getPrice());
		System.out.println(lg.getChannel());
		System.out.println(lg.getVolume());
		
		//체이닝 기법, 빌드업 기법
		//최근 패러다임에서 함수형 기법에서 사용
		//lg.getThis().getThis().getThis();
	
	
	}

}

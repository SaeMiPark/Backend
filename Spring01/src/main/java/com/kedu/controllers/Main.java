package com.kedu.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kedu.interfaces.TV;

public class Main {
	public static void main(String[] args) {
		//new가 결합도를 높이는 경우 예제
		//삼성tv 클래스가 라이브러리 클래스라고 가정한다면
		//근데 삼성쪽과 계약이 끝나서 이 라이브러리를 쓸 수 없는 상황
		//라이브러리를 교체할 때 기존 코드를 많이 고쳐야 한다.
		
		//SamsungTV tv= new SamsungTV();
		//LgTV tv=new LgTV();
		
		//new를 없앤 디자인 패턴 팩토리 패턴
		//의미 여기서 "samsung"은 외부에서 받아올 수 있다.
		//TV tv = TvFactory.getTv("samsung"); //다형성
		//TV tv2 = TvFactory.getTv(args[0]); //메인에서 받은 매개변수
		
		//tv.setChanel(5);
		//tv.setVolume(10);
		//tv.getChanel();
		//tv.getVolume();
		//tv.channelUp(); //추상메소드규칙
		//tv.channelDown();
		
		
		//IOC기법(Inversion Of control): 인스턴스의 생성 및 관리를 개발자가 아닌  Spring Container가 담당하는 기법
		ApplicationContext ctx=
				new GenericXmlApplicationContext("application-context.xml"); //모든일을 관장하는 인스턴스
		
		//사용 기법: Dependency Lookup(DL), Dependency Injection(DI)
		//Spring에 의해 관리되는 인스턴스를 개발자가 사용하기 위한 두 가지 기법
		//getBean쓰면 DL임
		
		
		TV tv=ctx.getBean(TV.class); //스프링! TV타입(인터페이스) 가져와! 삼성tv는 명확히 말하면 tv를 부모로 두기 때문에
		//싱글tone알아서 적용된다.		
		System.out.println(tv.getVolume()+":"+tv.getChannel());
		
	}
	
}

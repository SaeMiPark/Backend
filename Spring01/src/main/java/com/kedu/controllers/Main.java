package com.kedu.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kedu.interfaces.TV;

public class Main {
	public static void main(String[] args) {
		//new�� ���յ��� ���̴� ��� ����
		//�Ｚtv Ŭ������ ���̺귯�� Ŭ������� �����Ѵٸ�
		//�ٵ� �Ｚ�ʰ� ����� ������ �� ���̺귯���� �� �� ���� ��Ȳ
		//���̺귯���� ��ü�� �� ���� �ڵ带 ���� ���ľ� �Ѵ�.
		
		//SamsungTV tv= new SamsungTV();
		//LgTV tv=new LgTV();
		
		//new�� ���� ������ ���� ���丮 ����
		//�ǹ� ���⼭ "samsung"�� �ܺο��� �޾ƿ� �� �ִ�.
		//TV tv = TvFactory.getTv("samsung"); //������
		//TV tv2 = TvFactory.getTv(args[0]); //���ο��� ���� �Ű�����
		
		//tv.setChanel(5);
		//tv.setVolume(10);
		//tv.getChanel();
		//tv.getVolume();
		//tv.channelUp(); //�߻�޼ҵ��Ģ
		//tv.channelDown();
		
		
		//IOC���(Inversion Of control): �ν��Ͻ��� ���� �� ������ �����ڰ� �ƴ�  Spring Container�� ����ϴ� ���
		ApplicationContext ctx=
				new GenericXmlApplicationContext("application-context.xml"); //������� �����ϴ� �ν��Ͻ�
		
		//��� ���: Dependency Lookup(DL), Dependency Injection(DI)
		//Spring�� ���� �����Ǵ� �ν��Ͻ��� �����ڰ� ����ϱ� ���� �� ���� ���
		//getBean���� DL��
		
		
		TV tv=ctx.getBean(TV.class); //������! TVŸ��(�������̽�) ������! �Ｚtv�� ��Ȯ�� ���ϸ� tv�� �θ�� �α� ������
		//�̱�tone�˾Ƽ� ����ȴ�.		
		System.out.println(tv.getVolume()+":"+tv.getChannel());
		
	}
	
}

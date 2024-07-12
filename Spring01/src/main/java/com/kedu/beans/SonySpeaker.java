package com.kedu.beans;

import com.kedu.interfaces.Speaker;

public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
		super();
		System.out.println("�Ҵ� ����Ŀ ����");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void powerOn() {
		System.out.println("�Ҵ� ����Ŀ ��");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void powerOff() {
		System.out.println("소니스피커오프");
		// TODO Auto-generated method stub
		
	}
	
	

}

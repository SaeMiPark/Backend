package com.kedu.beans;

import com.kedu.interfaces.Speaker;

public class AppleSpeaker implements Speaker{

	@Override
	public void powerOn() {
		System.out.println("애플 스피커 온");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void powerOff() {
		System.out.println("애플 스피커 오프");
		// TODO Auto-generated method stub
		
	}
	

}

package com.kedu.beans;

import com.kedu.interfaces.TV;

public class LgTV implements TV{
	//추상클래스를 상속받음으로써 메소드 가이드라인 제시
	
	private int channel;
	private int volume;
	
	public LgTV(int channel, int volume) {
		super();
		this.channel = channel;
		this.volume = volume;
	}

	public LgTV() {
		super();
		System.out.println("LG티비 생성");
	}
	
	@Override
	public int getChannel() {
		return channel;
	}
	
	@Override
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	@Override
	public int getVolume() {
		return volume;
	}
	
	@Override
	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public void channelUp(int channel) {
		channel++;
	}


	@Override
	public void channelDown(int channel) {
		channel--;
	}
	
	@Override
	public void volumeUp(int volume) {
		volume++;
	}
	
	@Override
	public void volumeDown(int volume) {
		volume--;
		
	}
	

}

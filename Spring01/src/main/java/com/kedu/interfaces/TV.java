package com.kedu.interfaces;

public interface TV {

	public int getChannel(); 
	public void setChannel(int channel) ;
	public int getVolume(); 
	public void setVolume(int volume);
	
	//추상메소드 규칙
	public void channelUp(int channel);
	public void channelDown(int channel);
	public void volumeUp(int volume);
	public void volumeDown(int volume);

}

package com.kedu.beans;

import com.kedu.interfaces.Speaker;
import com.kedu.interfaces.TV;

public class SamsungTV implements TV{
	private int channel;
	private int volume;
	private Speaker speaker=new SonySpeaker();
	
	public SamsungTV() {
		super();
		System.out.println("伙己萍厚 积己");
		speaker.powerOn();
	}

	
	public SamsungTV(int channel, int volume, Speaker speaker) {
		super();
		this.channel = channel;
		this.volume = volume;
		this.speaker = speaker;
		System.out.println("伙己萍厚 积己");
		speaker.powerOn();
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	@Override
	public void channelUp(int channel) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void channelDown(int channel) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void volumeUp(int volume) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void volumeDown(int volume) {
		// TODO Auto-generated method stub
		
	}


}

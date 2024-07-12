package com.kedu.beans;

import com.kedu.interfaces.TV;

public class LgTV implements TV{
	//�߻�Ŭ������ ��ӹ������ν� �޼ҵ� ���̵���� ����
	
	private int channel;
	private int volume;
	
	public LgTV(int channel, int volume) {
		super();
		this.channel = channel;
		this.volume = volume;
	}

	public LgTV() {
		super();
		System.out.println("LGƼ�� ����");
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

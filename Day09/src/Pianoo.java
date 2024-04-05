import java.util.Scanner;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class Pianoo{
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		Synthesizer ss=MidiSystem.getSynthesizer();
		ss.open();
		
		System.out.println("====원하는 악기를 선택하세요====");
		System.out.println("1번 : 피아노");
		System.out.println("2번 : 하프");
		System.out.println("3번 : 트럼펫");
		System.out.println("4번 : 아코디언");
		System.out.println("5번 : 하모니카");
		System.out.print(">> ");
		int choiceNumber=Integer.parseInt(sc.nextLine());
		MidiChannel midiChannel = ss.getChannels()[0];
		int programNumber=0;
		
		if(choiceNumber==1) {
			programNumber=0;
		}else if(choiceNumber==2) {
			programNumber=3;
		}else if(choiceNumber==3) {
			programNumber=14;
		}else if(choiceNumber==4) {
			programNumber=21;
		}
		else if(choiceNumber==5) {
			programNumber=22;
		}else {
			System.out.println("메뉴 번호를 선택하세요.");
		}
		
		midiChannel.programChange(programNumber);
		
		System.out.println("연주를 시작합니다. 숫자를 이용해 연주해주세요.");
		
		int baseNote = 60;
		
		while(true) {
			int inputFromKeyboard=sc.nextInt();
			int note = baseNote + inputFromKeyboard-1;
			//60,61,62
            midiChannel.noteOn(note, 100);
            Thread.sleep(500);
            midiChannel.noteOff(note);
		}
		
	}
	

}


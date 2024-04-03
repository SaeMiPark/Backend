//정보은닉 / 접근제한자 / getter/setter/constructor/ static
//class 권고 사항
package classes;


public class Tv {
	
	//1. 멤버필드(속성)
	//default 접근 제한자는 package
	private int channel; //16
	private int volume; //20
	private int price; //멤버 필드는 모두 heap메모리에 만들어진다.
	
	//2. 멤버메소드(기능)
	public int getChannel() {
		return channel;
		//this: 자기 참조 변수
		//Exam03의 lg변수와 같은 주소 값을 가진다.
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int colume) {
		this.volume = colume;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Tv getThis() {
		return this;  //결국 this도 주소 값이다?
	}
	
	//3. 생성자
	//1. 메소드의 한 종류로 몇가지 특이한 규칙을 갖는다.
	//2. 메소드 호출 시점을 자유롭게 정할 수 없다.
	//3. 생성자 메소드는 리턴값 없다.
	//4. 기타 모든 규칙은 다른 메소드와 동일하다 ex매개변수
	
	public Tv(int price, int channel, int volume){
		System.out.println("Tv 클래스 생성자 입니다.");
		this.price=price;
		this.channel=channel;
		this.volume=volume;	
	}
	
	//Tv lg =new Tv(); 생성자 메소드 콜인 셈이다.
}

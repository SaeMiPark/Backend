package classes;

import java.util.Arrays;

public class Car {
	//멤버필드는 무조건 소문자!!
	private String model;
	private int price;
	private String[] color;
	
	//생성자
	public Car(String model, int price, String[] color) {
		this.model=model;
		this.price=price;
		this.color=color;
	}
	
	//setter 값을 셋팅하는
	public void setModel(String model) {
		this.model=model;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	public void setColor(String[] color) {
		this.color=color;
		
	}
	
	//getter 값을 내보내는
	public String getModel() {
		return this.model;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	//배열 출력 방법 1
	public String getColor(){
		String str="";
		for(int i=0; i<color.length; i++) {
			str+=color[i]+" ";
		}
		return str;
	}
	
	//배열 출력 방법2
	//color배열을 문자열로 변환하여 반환
	//public String getColorAsString() {
	//	return Arrays.toString(color);
	//}
	

}

package classes;

abstract public class Animal {
	private String name;
	
	//임플리먼트 메소드
	abstract public String sound(); 
	
	//생성자
	public Animal(){}
	
	public Animal(String name) {
		this.name=name;
	}
	
	//getter
	public String getName() {
		return name;
	}
	
	//setter
	public void setName(String name) {
		this.name=name;
	}
	
	
	
	


}

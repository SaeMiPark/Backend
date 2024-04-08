package classes;

public class Dog extends Animal{
	
	public Dog(){
		
	}
	
	public Dog (String name) {
		super(name); //수퍼가 맞나?
	}
	
	public String sound() {
		return this.getName()+" : BowWow";
	}

}

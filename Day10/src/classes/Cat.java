package classes;

public class Cat extends Animal{
	
	public Cat(){

	}

	public Cat(String name) {
		super(name); 
	}

	public String sound() {
		return this.getName()+" : Meow";
	}

}

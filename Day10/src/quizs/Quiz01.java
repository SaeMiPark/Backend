package quizs;

import classes.Animal;
import classes.Cat;
import classes.Dog;

public class Quiz01 {
	public static void main(String[] args) {
		Animal[] animals=new Animal[5];
		
		animals[0]=new Dog("Hodu");
		animals[1]=new Cat("Nabi");
		animals[2]=new Dog("Browny");
		
		for(int i=0; i<3; i++) {
			System.out.println(animals[i].sound());
		}
	}
}

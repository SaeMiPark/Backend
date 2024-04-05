package exams;
import classes.Student;

public class Exam02 {
	public static void main(String[] args) {
		Student[] students=new Student[3];

		students[0]=new Student(1001,"박새미",100,100,100);
		students[1]=new Student(1002,"박신비",50,50,50);
		students[2]=new Student(1003,"박대성",70,70,70);


		Student[] stu=new Student[] {
				new Student(1001,"박새미",100,100,100),
				new Student(1002,"박신비",50,50,50),
				new Student(1003,"박대성",70,70,70)
		};
				

		System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
		
		for(int i=0; i<students.length; i++) {
			System.out.println(students[i]);
		}

	}
}

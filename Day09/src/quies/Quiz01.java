package quies;
import java.util.Scanner;

import classes.Student;

public class Quiz01 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Student[] students=new Student[3];
		
		for(int i=0; i<students.length; i++) {
			String name="";
			int kor=0, eng=0, mat=0;
			
			System.out.print((i+1)+"번째 학생 이름 : ");
			name=sc.nextLine();
			System.out.print(name+"학생 국어 : ");
			kor=Integer.parseInt(sc.nextLine());
			System.out.print(name+"학생 영어 : ");
			eng=Integer.parseInt(sc.nextLine());
			System.out.print(name+"학생 수학 : ");
			mat=Integer.parseInt(sc.nextLine());
			
			students[i]=new Student(1000+(i+1),name,kor,eng,mat);
			
		}
		
		System.out.println("코드\t이름\t국어\t영어\t수학\t합계\t평균");
		for(int j=0; j<students.length; j++) {
			System.out.println(students[j]);
		}
		
	}

}

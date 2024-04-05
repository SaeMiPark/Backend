package models;

import classes.Student;

//데이터 전담 관리, 출력 역할은 안 한다.
public class StudentManager {
	private Student[] stds=new Student[10];
	private int index=0;
	
	//배열에 넣을 수 있는 메소드를 만들어야 한다.
	public void addStudent(Student std) {
		//배열 중 한 칸에 데이터를 집어넣자.
		//stds[Student.count]=std;
		stds[index++]=std;
	}
	
	public Student[] getStds() {
		return stds;
	}
	
	//배열 하나하나에 접근하는 것은 아직 어려움
	
	public int getIndex() {
		return index;
	}
	
	

}

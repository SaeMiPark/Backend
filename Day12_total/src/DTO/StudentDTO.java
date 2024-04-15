package DTO;

import java.util.Date;

public class StudentDTO {
	private String id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private Date date=new Date();
	
	//생성자
	public StudentDTO() {};
	public StudentDTO(String id, String name, int kor, int eng, int math, Date date) {
		this.id=id;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		this.date=date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getSum() {
		return kor+eng+math;
	}
	
	public double getAvg() {
		return (kor+eng+math)/3.0;
	}
	
	
	

}

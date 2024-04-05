package classes;

public class Student {
	private int id;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	//public static int count=0;
	
	//디폴트 생성자
	public Student() {
		//count++;
	}
	
	//생성자
	public Student(int id, String name, int kor, int eng, int mat) {
		//count++;
		this.id=id;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
	}
	
	
	//setter
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setKor(int kor) {
		this.kor=kor;
	}
	
	public void setEng(int eng) {
		this.eng=eng;
	}
	
	public void setMat(int mat) {
		this.mat=mat;
	}
	
	//getter
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getMat() {
		return mat;
	}
	
	public int getSum() {
		return kor+eng+mat;
	}
	
	public double getAvg() {
		return getSum()/3.0;
	}
	
	/*public String toString(){
		return getId()+"\t"+getName()+"\t"+getKor()+"\t"+getEng()+"\t"+getMat()+"\t"+getSum()+"\t"+getAvg();
	}*/	

}

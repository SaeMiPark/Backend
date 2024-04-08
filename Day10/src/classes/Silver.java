package classes;

public class Silver extends Member{
	public Silver() {};
	
	public Silver(String id, String name, int point) {
		super(id, name, point); //부모 생성자 부르기
	}
	
	public double getBonus() {
		return this.getPoint()*0.02; 
	}
	//1. setter
	//2. 접근 제한자 변경 (비추천: 정보은닉 위반)
	//3. constructor사용. 생성자
	//실버는 정보은닉때문에 값을 넣을 수 있는 힘이 없다.
}

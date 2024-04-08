package classes;

public class Gold extends Member{
	public Gold() {}; //무조건 해야한다.
	
	public Gold(String id, String name, int point) {
		super(id,name,point);
	}
	
	public double getBonus() {
		return this.getPoint()*0.03; 
	}
	

}

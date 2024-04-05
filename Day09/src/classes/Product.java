package classes;


public class Product {
	private String code;
	private String name;
	private int price;
	private int stock;
	
	public Product() {
		
	}
		
	//생성자
	public Product(String code, String name, int price, int stock) {
		this.code=code;
		this.name=name;
		this.price=price;
		this.stock=stock;
	}
	
	//setter
	public void setCode(String code) {
		this.code=code;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	public void setStock(int stock) {
		this.stock=stock;
	}
	
	//getter
	
	public String getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public String toString() {
		String strprint=this.getCode()+"\t"+this.getName()+"\t"+this.getPrice()+"\t"+this.getStock();
		return strprint;
	}
	
}


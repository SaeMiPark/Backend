package classes;

public class Contact {
	private String id;
	private String name;
	private String phone;
	//public static int count=0;
	
	//
	public Contact() {
		//count++;
	}
	
	public Contact(String id, String name, String phone) {
		//count++;
		this.id=id;
		this.name=name;
		this.phone=phone;
	}
	
	//setter
	public void setId(String id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	//getter
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phone;
	}
	

}

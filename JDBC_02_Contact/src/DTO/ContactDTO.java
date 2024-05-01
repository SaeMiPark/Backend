package DTO;

import java.sql.Timestamp;
import java.util.Date;

public class ContactDTO {
	private int id;
	private String name;
	private String phone;
	private Timestamp reg_date;
	
	//생성자
	public ContactDTO() {}
	
	public ContactDTO(int id,String name,String phone,Timestamp date) {
		this.id=id;
		this.name=name;
		this.phone=phone;
		this.reg_date=date;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getDate() { //timestamp가 부모이기 때문에 리턴타입 Date도 된다.
		return reg_date;
	}
	public void setDate(Timestamp date) {
		this.reg_date = date;
	}

}

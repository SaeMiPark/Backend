package com.kedu.dto;

public class CafeDTO {
	private int id;
	private String name;
	private int price;
	public CafeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CafeDTO(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}

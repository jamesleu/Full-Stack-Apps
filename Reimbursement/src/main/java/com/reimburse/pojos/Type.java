package com.reimburse.pojos;

public class Type {
	
	private int id;
	private String type;
	
	public Type () {}
	
	public Type(String type) {
		
		this.type = type;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
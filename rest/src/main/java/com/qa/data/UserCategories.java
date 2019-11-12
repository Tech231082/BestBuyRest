package com.qa.data;

public class UserCategories {
	
	String name;
	String id;
	String createdAt;
	String updatedAt;
	
	public UserCategories() {
		
	}
	
	public UserCategories(String name,String id) {
		this.name=name;
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}

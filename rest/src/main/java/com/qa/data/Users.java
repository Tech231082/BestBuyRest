package com.qa.data;

public class Users {
	String name;
	String type;
	int price;
	int shipping;
	String upc;
	String description;
	String manufacturer,model,url,image;
	String id;
	/*String message;
	String code;
	/*String updatedAt;
	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	String createdAt;*/
	
	



	



	public Users() {
		
	}
	
	

	public Users(String name,String type,int price,int shipping,String upc,String description,String manufacturer,
			String model,String url,String image) {
		this.name=name;
		this.type=type;
		this.price = price;
		this.shipping = (int) shipping;
		this.upc = upc;
		this.description = description;
		this.manufacturer = manufacturer;
		this.model = model;
		this.url = url;
		this.image = image;
	}
	/*
	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}
	*/
	/*
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getShipping() {
		return shipping;
	}
	public void setShipping(int shipping) {
		this.shipping = (int) shipping;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	

}

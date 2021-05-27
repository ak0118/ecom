package com.ecom.beans;

public class Product {
	
	private String prodId;
	private double price;
	private String name;
	
	public Product(String prodId, double price, String name) {
		this.prodId = prodId;
		this.price = price;
		this.name = name;
	}
	
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

package com.training.bean;

public class UNF_069Bean {
	
	private String productname;
	private String metatitle;
	private String model;
	private String price;
	private String quantity;
	private String category;
	
	

	public UNF_069Bean() {
	}

	public UNF_069Bean(String productname, String metatitle, String model, String price, String quantity, String category) {
		super();
		this.productname= productname;
		this.metatitle = metatitle;
		this.model=model;
		this.price=price;
		this.quantity=quantity;
		this.category=category;
		
	}

	public String getproductname() {
		return productname;
	}

	public void setproductname(String productname) {
		this.productname = productname;
	}

	public String getmetatitle() {
		return metatitle;
	}

	public void setmetatitle(String metatitle) {
		this.metatitle = metatitle;
	}
	
	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}
	
	public String getprice() {
		return price;
	}

	public void setprice(String price) {
		this.price = price;
	}
	
	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity = quantity;
	}
	public String getcategory() {
		return category;
	}

	public void setcategory(String category) {
		this.category = category;
	}
	
	
	
	
	@Override
	public String toString() {
		
		return "ProductBean [productname=" + productname + ", metatitle=" + metatitle + ", model=" + model + ", price=" + price + ", quantity=" + quantity + ", category = " + category +"]";
	}



}

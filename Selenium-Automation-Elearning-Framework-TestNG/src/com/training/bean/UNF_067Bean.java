package com.training.bean;

public class UNF_067Bean {
	//private String userName;
	//private String password;
	private String productname;
	private String price;
	private String status;
	private String model;
	private String quantity;

	public UNF_067Bean() {
	}

	public UNF_067Bean(String productname, String price, String status, String model, String quantity ) {
		super();
		this.productname= productname;
		this.price=price;
		this.status=status;
		this.model=model;
		this.quantity=quantity;
	}

	public String getproductname() {
		return productname;
	}

	public void setproductname(String productname) {
		this.productname = productname;
	}

	public String getprice() {
		return price;
	}

	public void setprice(String price) {
		this.price = price;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}
	
	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}
	
	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		
		return "ProductBean [productname=" + productname + ", price=" + price + ", status=" + status + ", model=" + model + ", quantity=" + quantity + "]";
	}

}

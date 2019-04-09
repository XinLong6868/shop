package com.fh.shop.backend.po.product;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 5306087749856060545L;
	
	private Integer id;
	
	private String productName;
	
	private Float productPrivace;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductPrivace() {
		return productPrivace;
	}

	public void setProductPrivace(Float productPrivace) {
		this.productPrivace = productPrivace;
	}
	

}

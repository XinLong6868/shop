package com.fh.shop.backend.po.photo;

import java.io.Serializable;

import com.fh.shop.backend.po.product.Product;

public class PhotoInfo implements Serializable {
	
    private static final long serialVersionUID = 5963742294708026579L;

	private int id;
    
    private String photoPath;
    
    private Product product=new Product();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
    
}

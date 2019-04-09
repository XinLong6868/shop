package com.fh.shop.backend.po.product;

import java.io.Serializable;

public class Product implements Serializable{
	
				private static final long serialVersionUID = 7522145459870537054L;
				
				
				
				
				
				private Integer id;
				private String productName;
				private Float privace;
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
				public Float getPrivace() {
					return privace;
				}
				public void setPrivace(Float privace) {
					this.privace = privace;
				}
				
}

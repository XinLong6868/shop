package com.fh.shop.api.product.po;

import com.fh.shop.api.brand.BrandText;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{

	private static final long serialVersionUID = 5306087749856060545L;
	
	private Integer id;
	//商品名称
	private String productName;
	//商品价格
	private Float productprivace;
	//商品相关图片
	private String productImagePath;
	//修改时间
	private Date updateTime;
	//创建时间
	private Date createTime;
	//品牌表外键
	private BrandText brandText=new BrandText();

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

	public Float getProductprivace() {
		return productprivace;
	}

	public void setProductprivace(Float productprivace) {
		this.productprivace = productprivace;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BrandText getBrandText() {
		return brandText;
	}

	public void setBrandText(BrandText brandText) {
		this.brandText = brandText;
	}
}

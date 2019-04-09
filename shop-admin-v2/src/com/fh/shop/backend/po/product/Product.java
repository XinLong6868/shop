package com.fh.shop.backend.po.product;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fh.shop.backend.po.Page;
import com.fh.shop.backend.po.brand.BrandText;

public class Product extends Page implements Serializable{

	private static final long serialVersionUID = 5306087749856060545L;
	
	private Integer id;
	private String productName;
	private Float productprivace;
	//区间查询
	private Float minprivace;
	private Float maxprivace;
	//时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date minupdateTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date maxupdateTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;
	//品牌表外键
	private BrandText brandText=new BrandText();
	
	public Float getMinprivace() {
		return minprivace;
	}
	public void setMinprivace(Float minprivace) {
		this.minprivace = minprivace;
	}
	public Float getMaxprivace() {
		return maxprivace;
	}
	public void setMaxprivace(Float maxprivace) {
		this.maxprivace = maxprivace;
	}
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
	public Date getMinupdateTime() {
		return minupdateTime;
	}
	public void setMinupdateTime(Date minupdateTime) {
		this.minupdateTime = minupdateTime;
	}
	public Date getMaxupdateTime() {
		return maxupdateTime;
	}
	public void setMaxupdateTime(Date maxupdateTime) {
		this.maxupdateTime = maxupdateTime;
	}
	public BrandText getBrandText() {
		return brandText;
	}
	public void setBrandText(BrandText brandText) {
		this.brandText = brandText;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productprivace=" + productprivace
				+ ", minprivace=" + minprivace + ", maxprivace=" + maxprivace + ", updateTime=" + updateTime
				+ ", minupdateTime=" + minupdateTime + ", maxupdateTime=" + maxupdateTime + ", createTime=" + createTime
				+ ", brandText=" + brandText + "]";
	}
	
	
				
}

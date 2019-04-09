package com.fh.shop.backend.brand.po;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Brand implements Serializable{
	private static final long serialVersionUID = 1L;
	//主键
	private Integer id;
	//品牌名
	private String brandName;
	//录入时间
	private Date brandEntryTime;
	//修改时间
	private Date brandUpdateTime;
	private String brandEntryTimeStr;
	private String brandUpdateTimeStr;
	//条件查询字段
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date minBrandEntryTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date maxBrandEntryTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date minBrandUpdateTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date maxBrandUpdateTime;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Date getBrandEntryTime() {
		return brandEntryTime;
	}
	public void setBrandEntryTime(Date brandEntryTime) {
		this.brandEntryTime = brandEntryTime;
	}
	public Date getBrandUpdateTime() {
		return brandUpdateTime;
	}
	public void setBrandUpdateTime(Date brandUpdateTime) {
		this.brandUpdateTime = brandUpdateTime;
	}
	public Date getMinBrandEntryTime() {
		return minBrandEntryTime;
	}
	public void setMinBrandEntryTime(Date minBrandEntryTime) {
		this.minBrandEntryTime = minBrandEntryTime;
	}
	public Date getMaxBrandEntryTime() {
		return maxBrandEntryTime;
	}
	public void setMaxBrandEntryTime(Date maxBrandEntryTime) {
		this.maxBrandEntryTime = maxBrandEntryTime;
	}
	public Date getMinBrandUpdateTime() {
		return minBrandUpdateTime;
	}
	public void setMinBrandUpdateTime(Date minBrandUpdateTime) {
		this.minBrandUpdateTime = minBrandUpdateTime;
	}
	public Date getMaxBrandUpdateTime() {
		return maxBrandUpdateTime;
	}
	public void setMaxBrandUpdateTime(Date maxBrandUpdateTime) {
		this.maxBrandUpdateTime = maxBrandUpdateTime;
	}
	
	public String getBrandEntryTimeStr() {
		return brandEntryTimeStr;
	}
	public void setBrandEntryTimeStr(String brandEntryTimeStr) {
		this.brandEntryTimeStr = brandEntryTimeStr;
	}
	public String getBrandUpdateTimeStr() {
		return brandUpdateTimeStr;
	}
	public void setBrandUpdateTimeStr(String brandUpdateTimeStr) {
		this.brandUpdateTimeStr = brandUpdateTimeStr;
	}

	@Override
	public String toString() {
		return "Brand{" +
				"id=" + id +
				", brandName='" + brandName + '\'' +
				", brandEntryTime=" + brandEntryTime +
				", brandUpdateTime=" + brandUpdateTime +
				", brandEntryTimeStr='" + brandEntryTimeStr + '\'' +
				", brandUpdateTimeStr='" + brandUpdateTimeStr + '\'' +
				", minBrandEntryTime=" + minBrandEntryTime +
				", maxBrandEntryTime=" + maxBrandEntryTime +
				", minBrandUpdateTime=" + minBrandUpdateTime +
				", maxBrandUpdateTime=" + maxBrandUpdateTime +
				'}';
	}
}

package com.fh.shop.backend.po.brand;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fh.shop.backend.po.Page;

public class BrandText extends Page implements Serializable{
			private static final long serialVersionUID = -8522674793360631288L;
			private Integer id;
			private String brandName;
			//修改品牌时间
			@DateTimeFormat(pattern="yyyy-MM-dd")
			private Date updateBrandTime;
			//录入时间查询
			@DateTimeFormat(pattern="yyyy-MM-dd")
			private Date createBrandTime;
			@DateTimeFormat(pattern="yyyy-MM-dd")
			private Date mincreateBrandTime;
			@DateTimeFormat(pattern="yyyy-MM-dd")
			private Date maxcreateBrandTime;
			
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
			public Date getUpdateBrandTime() {
				return updateBrandTime;
			}
			public void setUpdateBrandTime(Date updateBrandTime) {
				this.updateBrandTime = updateBrandTime;
			}
			public Date getCreateBrandTime() {
				return createBrandTime;
			}
			public void setCreateBrandTime(Date createBrandTime) {
				this.createBrandTime = createBrandTime;
			}
			public Date getMincreateBrandTime() {
				return mincreateBrandTime;
			}
			public void setMincreateBrandTime(Date mincreateBrandTime) {
				this.mincreateBrandTime = mincreateBrandTime;
			}
			public Date getMaxcreateBrandTime() {
				return maxcreateBrandTime;
			}
			public void setMaxcreateBrandTime(Date maxcreateBrandTime) {
				this.maxcreateBrandTime = maxcreateBrandTime;
			}
			@Override
			public String toString() {
				return "BrandText [id=" + id + ", brandName=" + brandName + ", updateBrandTime=" + updateBrandTime
						+ ", createBrandTime=" + createBrandTime + ", mincreateBrandTime=" + mincreateBrandTime
						+ ", maxcreateBrandTime=" + maxcreateBrandTime + "]";
			}
			
}

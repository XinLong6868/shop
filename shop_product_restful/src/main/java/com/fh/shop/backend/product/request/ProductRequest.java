package com.fh.shop.backend.product.request;

import com.fh.shop.backend.brand.po.Brand;
import com.fh.shop.backend.common.Page;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ProductRequest extends Page implements Serializable {

    private String productName;//商品名称

    private Float maxProductPrice;//商品价格
    private Float minProductPrice;//商品价格
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date minEntryTime;//录入时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date maxEntryTime;//录入时间'
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date minUpdateTime;//修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date maxUpdateTime;//修改时间

    private Integer brandId;
    private Brand brand = new Brand();

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getMaxProductPrice() {
        return maxProductPrice;
    }

    public void setMaxProductPrice(Float maxProductPrice) {
        this.maxProductPrice = maxProductPrice;
    }

    public Float getMinProductPrice() {
        return minProductPrice;
    }

    public void setMinProductPrice(Float minProductPrice) {
        this.minProductPrice = minProductPrice;
    }

    public Date getMinEntryTime() {
        return minEntryTime;
    }

    public void setMinEntryTime(Date minEntryTime) {
        this.minEntryTime = minEntryTime;
    }

    public Date getMaxEntryTime() {
        return maxEntryTime;
    }

    public void setMaxEntryTime(Date maxEntryTime) {
        this.maxEntryTime = maxEntryTime;
    }

    public Date getMinUpdateTime() {
        return minUpdateTime;
    }

    public void setMinUpdateTime(Date minUpdateTime) {
        this.minUpdateTime = minUpdateTime;
    }

    public Date getMaxUpdateTime() {
        return maxUpdateTime;
    }

    public void setMaxUpdateTime(Date maxUpdateTime) {
        this.maxUpdateTime = maxUpdateTime;
    }
}

package com.fh.shop.backend.product.vo;

import java.io.Serializable;
import java.util.Date;

public class ProductVo implements Serializable {

    private static final long serialVersionUID = -4932829647087244224L;
    private Integer id;//主键

    private String productName;//商品名称

    private Float productPrice;//商品价格

    private Date entryTime;//录入时间

    private Date updateTime;//修改时间

    private String brandName;//品牌



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

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


}

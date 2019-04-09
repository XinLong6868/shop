package com.fh.shop.backend.vo.productVo;

import java.io.Serializable;
import java.util.Date;

public class ProductVo implements Serializable {
    //生成唯一标识
    private static final long serialVersionUID = 4529117475321205661L;

    private Integer id;

    private String productName;

    private String productImagePath;

    private String brandName;

    private Float productprivace;

    private String updateTimeStr;

    private String createTimeStr;

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

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Float getProductprivace() {
        return productprivace;
    }

    public void setProductprivace(Float productprivace) {
        this.productprivace = productprivace;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }
}

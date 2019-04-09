package com.fh.shop.backend.api.product;

import java.io.Serializable;

public class ProductVoApi implements Serializable {
    private static final long serialVersionUID = -5869049957826242278L;

    private Integer id;

    private String productName;

    private Float productprivace;

    private String productImagePath;

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
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
}

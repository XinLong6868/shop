package com.fh.shop.prodal.product.response;

import java.util.List;

/**
 * @author DELL
 * @title: ProductResponse
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/1822:00
 */
public class ProductResponse {

    /**
     * code : 200
     * message : ojbk
     * data : [{"id":90,"productName":"X","productprivace":99.99,"productImagePath":"/images/73bdf672-c3a9-46ca-a41f-de1fdf886afd.jpg"},{"id":91,"productName":"Z","productprivace":3,"productImagePath":"/images/3342e12f-cad2-49a0-9aa0-f932fb187b72.jpg"},{"id":92,"productName":"C","productprivace":99.99,"productImagePath":"/images/8a5a4471-6ad5-4676-a653-3ad4e704c411.jpg"},{"id":93,"productName":"V","productprivace":99.99,"productImagePath":"/images/d7145a4e-f010-4a67-a289-355d94f9f8bb.jpg"}]
     */

    private int code;
    private String message;
    private List<ProductVo> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ProductVo> getData() {
        return data;
    }

    public void setData(List<ProductVo> data) {
        this.data = data;
    }

    /**
     * 内部类
     */
    public static class ProductVo {
        /**
         * id : 90
         * productName : X
         * productprivace : 99.99
         * productImagePath : /images/73bdf672-c3a9-46ca-a41f-de1fdf886afd.jpg
         */

        private int id;
        private String productName;
        private float productprivace;
        private String productImagePath;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public float getProductprivace() {
            return productprivace;
        }

        public void setProductprivace(float productprivace) {
            this.productprivace = productprivace;
        }

        public String getProductImagePath() {
            return productImagePath;
        }

        public void setProductImagePath(String productImagePath) {
            this.productImagePath = productImagePath;
        }
    }
}

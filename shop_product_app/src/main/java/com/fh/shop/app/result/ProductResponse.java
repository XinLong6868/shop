package com.fh.shop.app.result;

import java.util.Date;

public class ProductResponse {


    /**
     * code : 200
     * msg : ok
     * data : [{"id":234,"productName":"试点工作","productPrice":546,"brandName":"华为","productImagePath":"/images/product/0d4a2ad9-428e-47be-b98d-f3226182e819.jpg"},{"id":235,"productName":"ttt","productPrice":3456,"brandName":"小米","productImagePath":"/images/product/7f16404e-66f5-4d2e-a99e-3d4a17b55c88.jpg"},{"id":187,"productName":"wte","productPrice":2.5,"brandName":"小米","productImagePath":"/images/product/30c3f166-47e5-4441-ac73-dfce4d8c6e5b.jpg"},{"id":190,"productName":"高度","productPrice":45,"brandName":"联想","productImagePath":"/images/product/50a20d24-82be-42db-a6b8-6d298c926ade.bmp"},{"id":192,"productName":"人人人","productPrice":1233,"brandName":"华为","productImagePath":"/images/product/7fe22a8f-dcbd-4f9e-95e9-d49b6fb3485d.jpg"},{"id":193,"productName":"额嗡嗡人","productPrice":123,"brandName":"联想","productImagePath":"/images/product/fb4b3a6f-9779-4f4e-b64e-ff6d5a265d8b.bmp"},{"id":194,"productName":"的","productPrice":21,"brandName":"小米","productImagePath":"/images/product/7712c3ae-13bc-4b54-af6f-d9bbfaa024c8.bmp"},{"id":195,"productName":"ee","productPrice":214,"brandName":"魅族","productImagePath":"/images/product/1feb95ea-0ad0-4563-88b6-8e3e364ea821.jpg"},{"id":197,"productName":"文档","productPrice":3456,"brandName":"三星","productImagePath":"/images/product/76cef437-64c4-44a3-a9ec-747ff0a57284.jpg"},{"id":233,"productName":"的方式","productPrice":5676,"brandName":"联想","productImagePath":"/images/product/2e0a999a-1c63-4135-9939-5fbb3776cd2d.jpg"},{"id":231,"productName":"系统及能否","productPrice":657,"brandName":"三星","productImagePath":"/images/product/47279a51-6820-4ef0-b2ee-9233936b0c3b.jpg"}]
     */

    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static class productVO {
        /**
         * id : 234
         * productName : 试点工作
         * productPrice : 546
         */

        private int id;
        private String productName;
        private float productPrice;
        private Date entryTime;
        private Date updateTime;


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

        public float getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(float productPrice) {
            this.productPrice = productPrice;
        }



    }
}

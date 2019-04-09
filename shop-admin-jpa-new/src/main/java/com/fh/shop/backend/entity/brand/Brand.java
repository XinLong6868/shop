package com.fh.shop.backend.entity.brand;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Brand implements Serializable {

    private static final long serialVersionUID = 2111007266970844530L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String brandName;

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
}

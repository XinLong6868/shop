package com.fh.shop.api.brand;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fh.shop.api.brand.mapper")
public class ShopSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopSpringbootApplication.class, args);
    }

}

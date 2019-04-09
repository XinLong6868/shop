package com.fh.shop.backend.product;

import com.fh.shop.backend.biz.product.IProductService;
import com.fh.shop.backend.po.product.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-common.xml")
public class TestProduct extends AbstractJUnit4SpringContextTests {
    @Resource(name = "iProductService")
    private IProductService iProductService;
    //测试增加
    @Test
    public void testAddProduct(){
        Product product = new Product();
        product.setProductName("定时关机");
        product.setProductprivace((Float.valueOf(521)));
        iProductService.addProduct(product);
    }
    //测试删除
    @Test
    public void testDeleteProduct(){
        iProductService.deleteProductID(74);
    }
    //测试查询
    @Test
    public void testSelectProduct(){
        Product product = new Product();
        List<Product> products = iProductService.listProduct(product);
        System.out.println(products);
    }
    //测试修改
    @Test
    public void testUpdateProduct(){
        Product product = new Product();
        product.setId(74);
        product.setProductName("仨仨");
        iProductService.updateProduct(product);
    }
}

package com.fh.shop.backend;

import com.fh.shop.backend.entity.product.Product;
import com.fh.shop.backend.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-common-jpa.xml"})
public class TestProduct extends AbstractJUnit4SpringContextTests {

    @Autowired
    private ProductRepository productRepository;

    /**
     * 测试查询，并输出查询后的品牌产品价格
     */
    @Test
    public void test1() {
        List<Product> productList = productRepository.findAll();
        productList.forEach(a -> {
            System.out.println(a.getProductName()+":"+a.getPrice());
            System.out.println(a.getBrand().getBrandName());
        });
    }

    /**
     * 根据id进行查询
     */
    @Test
    public void test2() {
        Product product = productRepository.findOne(1);
        System.out.println("手机名称："+product.getProductName());
    }

    @Test
    public void test3() {
        List<Product> productList = productRepository.findByPriceBetween(1000, 3000);
        System.out.println(productList);
    }

    @Test
    public void test4() {
        List<Product> products = productRepository.findByPriceGreaterThanEqual(3000);
        System.out.println(products);
    }

    @Test
    public void test5() {
        List<Integer> integers = Arrays.asList(1, 3);
        List<Product> products = productRepository.findByProductNameLikeAndPriceGreaterThanAndPriceLessThanAndIdIn("%s%", 1000, 5000, integers);
        System.out.println(products);
    }

    @Test
    public void test6() {
        List<Integer> integers = Arrays.asList(1, 3);
        List<String> s = productRepository.selectProductList("s", 1000, 5000, integers);
        System.out.println(s);
    }

    @Test
    public void test7() {
        List<Integer> integers = Arrays.asList(1, 3);
        List s = productRepository.selectProductInfoList("s", 1000, 5000, integers);
        for (int i = 0; i < s.size(); i++) {
            Object[] productArr = (Object[]) s.get(i);
            System.out.println(productArr[0]+":"+productArr[1]);
        }
    }

    @Test
    public void test8() {
        List<Integer> integers = Arrays.asList(1, 3);List<Map<String, Object>> mapList = productRepository.selectProductInfoNewList("s", 1000, 5000, integers);
        mapList.forEach(x -> x.forEach((y, z) -> System.out.println(y+":"+z)));
    }




}

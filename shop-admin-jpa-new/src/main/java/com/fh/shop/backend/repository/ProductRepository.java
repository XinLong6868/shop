package com.fh.shop.backend.repository;

import com.fh.shop.backend.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findByPriceBetween(float minPrice, float maxPrice);

    public List<Product> findByPriceGreaterThanEqual(float price);

    public List<Product> findByProductNameLikeAndPriceGreaterThanAndPriceLessThanAndIdIn
            (String productName, float minPrice, float maxPrice, List<Integer> ids);

    @Query("select productName from Product where productName like concat('%',?1, '%') and price>=?2 and price<=?3 and id in (?4) ")
    public List<String> selectProductList(String productName, float minPrice, float maxPrice, List<Integer> ids);

    @Query("select productName,price from Product where productName like concat('%',:productName, '%') and price>=:minPrice and price<=:maxInfoPrice and id in (:idList) ")
    public List selectProductInfoList(@Param("productName") String productName, @Param("minPrice") float minPrice, @Param("maxInfoPrice") float maxPrice, @Param("idList") List<Integer> ids);


    @Query("select new Map" +
            "(productName as productNameInfo ,price as productPrice) from Product p where productName like concat('%',:productName, '%') and price>=:minPrice and price<=:maxInfoPrice and id in (:idList) ")
    public List<Map<String, Object>> selectProductInfoNewList(@Param("productName") String productName, @Param("minPrice") float minPrice, @Param("maxInfoPrice") float maxPrice, @Param("idList") List<Integer> ids);
}
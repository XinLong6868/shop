package com.fh.shop.backend.product.mapper;


import com.fh.shop.backend.product.po.Product;
import com.fh.shop.backend.product.request.ProductRequest;

import java.util.List;

public interface IProductMapper {
//条件查询
    List<Product> findProductList(ProductRequest product);
//获取总条数
    Long findProductCount(ProductRequest product);
//删除
    void deleteProduct(Integer id);
//添加
    void addProduct(Product product);
//修改回显
    Product findProduct(Integer id);
//修改
    void updateProduct(Product product);
//批量删除
    void deleteMany(List<Integer> idList);
}

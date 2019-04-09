package com.fh.shop.backend.product.biz;


import com.fh.shop.backend.common.DataTableResult;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.product.po.Product;
import com.fh.shop.backend.product.request.ProductRequest;

public interface IProductService {
    //条件查询
    DataTableResult findProductList(ProductRequest product);
    //删除
    ServerResponse deleteProduct(Integer id);
    //添加
    ServerResponse addProduct(Product product);
    //修改回显
    ServerResponse findProduct(Integer id);
    //修改
    ServerResponse updateProduct(Product product);
    //批量删除
    ServerResponse deleteMany(String ids);
}

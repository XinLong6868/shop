package com.fh.shop.app.product.biz;

import com.fh.shop.app.common.ServerResponse;

import java.util.Map;

public interface IProductService {
    //商品查看
    ServerResponse productList(Map product);
    //删除
    ServerResponse deleteProdute(Integer id);
    //添加
    ServerResponse addProduct(Map product);
    //修改回显
    ServerResponse findProduct(Integer id);
    //修改
    ServerResponse updateProduct(Map product);
    //批量删除
    ServerResponse deleteMany(String ids);
}

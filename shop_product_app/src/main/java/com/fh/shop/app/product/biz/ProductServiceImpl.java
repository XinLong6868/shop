package com.fh.shop.app.product.biz;

import com.alibaba.fastjson.JSONObject;
import com.fh.shop.app.common.ResponseEnum;
import com.fh.shop.app.common.ServerResponse;
import com.fh.shop.app.result.ProductResponse;
import com.fh.shop.app.util.HttpClientUtil;
import com.google.gson.Gson;
import com.sun.javafx.collections.MappingChange;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Value("${product.url}")
    private String product_Url;

    /**
     * 商品查看
     * @return
     */
    public ServerResponse productList(Map productMap) {
        String result = HttpClientUtil.sendGet(product_Url, null, productMap);
        //System.out.println(result);
        //转换json格式
        ProductResponse productResponse = JSONObject.parseObject(result, ProductResponse.class);
        return ServerResponse.success(productResponse.getData());
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public ServerResponse deleteProdute(Integer id) {
        //删除用？传参
        String result = HttpClientUtil.sendDelete(product_Url+"/"+id, null,null);
        Gson gson = new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        return serverResponse;
    }

    /**
     * 添加
     * @param product
     * @return
     */
    public ServerResponse addProduct(Map product) {
        String result = HttpClientUtil.sendPost(product_Url, null, product);
        Gson gson = new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        return serverResponse;
    }

    /**
     * 修改回显
     * @param id
     * @return
     */
    public ServerResponse findProduct(Integer id) {
        String result = HttpClientUtil.sendGet(product_Url+"/"+id, null, null);
        Gson gson = new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        return serverResponse;
    }

    /**
     * 修改
     * @param product
     * @return
     */
    public ServerResponse updateProduct(Map product) {
        String result = HttpClientUtil.sendPut(product_Url, null, product);
        Gson gson = new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        return serverResponse;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public ServerResponse deleteMany(String ids) {
        Map map = new HashMap();
        map.put("ids",ids);
        String result = HttpClientUtil.sendDelete(product_Url, null,map);
        Gson gson = new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        return serverResponse;
    }
}

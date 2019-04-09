package com.fh.shop.prodal.product.biz;

import com.fh.shop.prodal.product.response.ProductResponse;
import com.fh.shop.prodal.util.HttpClientUtil;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author DELL
 * @title: IProductServiceImpl
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/1820:40
 */
@Service("iProductService")
public class IProductServiceImpl implements IProductService{

    /**
     * 通过调用属性源文件进行路径添转
     * 并且通过'${}' key value 取值
     * @return
     */
    @Value("${product.url}")
    private String product_url;
    @Override
    public ProductResponse findList() {
        //发送请求获取内容
        String result = HttpClientUtil.sendPost(product_url,null,null);
        //将获取内容转换成java
        //将json数据转换成java对象
        Gson gson = new Gson();
        ProductResponse productResponse = gson.fromJson(result, ProductResponse.class);
        return productResponse;
    }
}

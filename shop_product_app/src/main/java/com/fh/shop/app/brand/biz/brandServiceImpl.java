package com.fh.shop.app.brand.biz;

import com.fh.shop.app.common.ServerResponse;
import com.fh.shop.app.util.HttpClientUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("brandService")
public class brandServiceImpl implements IBrandService{

    @Value("${brand.url}")
    private String brand_url;

    /**
     * 品牌查看
     * @return
     */
    public ServerResponse findBrandList() {
        String result = HttpClientUtil.sendGet(brand_url, null, null);
        Gson gson = new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        return serverResponse;
    }
}

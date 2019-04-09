package com.fh.shop.backend.api.product;


import com.fh.shop.backend.biz.product.IProductService;
import com.fh.shop.backend.common.ServerResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class ProductControllerAPI {
    /**
     * Service层的注入
     */
    @Autowired
    @Qualifier("iProductService")
    private IProductService iProductService;

    /**
     *  接口类（在普通接口中，充当后台，实现前后端的分离）
     * @param callback
     * @return
     * 此处的value = "localhost:8080/api/product/findList.action" 是json数据 并把从数据查出来的po转换vo
     * 此处的method = {RequestMethod.POST,RequestMethod.GET}
     * 是ajax中的请求方式.请求方式有很多：post get 只是其中比较常用
     * 此处有个细节注意：
     * 如果配置了拦截器 就需要在'白名单中把此处的请求放开' 或者注释拦截器
     */
    @RequestMapping(value = "/api/product/findList", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object findList(String callback){
        List<ProductVoApi> productList = iProductService.findAllProductList();
        if (StringUtils.isNotEmpty(callback)){
            //通过jsckson进行json数据转换
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(ServerResponse.success(productList));
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }else {
            return ServerResponse.success(productList);
        }

    }
}

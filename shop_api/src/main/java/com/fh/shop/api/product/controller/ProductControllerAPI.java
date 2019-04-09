package com.fh.shop.api.product.controller;


import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.product.biz.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ProductControllerAPI {
    @Autowired
    @Qualifier("iProductService")
    private IProductService iProductService;

    @RequestMapping(value = "/api/product/findList", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object findList(String callback){
        ServerResponse serverResponse = iProductService.findAllProductList();
        if (StringUtils.isNotEmpty(callback)){
            MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(serverResponse);
            mappingJacksonValue.setJsonpFunction(callback);
            return mappingJacksonValue;
        }else {
            return serverResponse;
        }

    }
}

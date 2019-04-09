package com.fh.shop.prodal.product.controller;


import com.fh.shop.prodal.product.biz.IProductService;
import com.fh.shop.prodal.product.response.ProductResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author DELL
 * @title: ProductController
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/3/1820:33
 */
@RestController
@RequestMapping("/protal/product")
public class ProductController {

    @Resource(name = "iProductService")
    private IProductService iProductService;

    @RequestMapping(value = "findList", method = RequestMethod.POST)
    public ProductResponse findList(){
        return iProductService.findList();
    }
}

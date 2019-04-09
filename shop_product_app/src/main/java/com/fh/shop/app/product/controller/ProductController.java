package com.fh.shop.app.product.controller;

import com.fh.shop.app.common.ServerResponse;
import com.fh.shop.app.product.biz.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import javax.annotation.Resource;

@RestController
@RequestMapping("/app")
public class ProductController {
    @Resource(name="productService")
    private IProductService productService;

    /**
     * 商品查看
     * @return
     */
    @PostMapping(value="/findProductList")
    public ServerResponse findProductList(@RequestParam Map product){
        ServerResponse serverResponse = productService.productList(product);
        //System.out.println(serverResponse);
        return serverResponse;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/deleteProdute")
    public ServerResponse deleteProdute(Integer id){
        return productService.deleteProdute(id);
    }

    /**
     * 添加
     */
    @PostMapping("addProduct")
    public ServerResponse addProduct(@RequestParam Map product){
         return productService.addProduct(product);
    }

    /**
     * 修改回显
     */
    @PostMapping("findProduct")
    public ServerResponse findProduct(Integer id){
        return productService.findProduct(id);
    }

    /**
     * 修改
     */
    @PostMapping("updateProduct")
    public ServerResponse updateProduct(@RequestParam Map product){
        return productService.updateProduct(product);
    }

    /**
     * 批量删除
     */
    @PostMapping("deleteMany")
    public ServerResponse deleteMany(String ids){
        return productService.deleteMany(ids);
    }

}

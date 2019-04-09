package com.fh.shop.backend.product.controller;

import com.fh.shop.backend.common.DataTableResult;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.product.biz.IProductService;
import com.fh.shop.backend.product.po.Product;
import com.fh.shop.backend.product.request.ProductRequest;
import com.fh.shop.backend.product.vo.ProductVo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/")
@Api(tags = "商品接口") //swagger分类标题注解
public class ProductController {

    @Resource(name="productService")
    public IProductService productService;

    /**
     * 条件查询
     */
    @GetMapping(value = "/products")
    @ApiOperation("产品查询")
    public ServerResponse findProductList(ProductRequest product){
        DataTableResult productList = productService.findProductList(product);
        return ServerResponse.success(productList);
    }

    /**
     * 删除
     */
    @DeleteMapping("/products/{id}")
    @ApiOperation("删除产品")
    public ServerResponse deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }

    /**
     * 添加
     */
    @PostMapping("/products")
    @ApiOperation("添加")
    public ServerResponse addProduct(Product product){
        return productService.addProduct(product);
    }

    /**
     * 修改回显
     */
    @GetMapping("/products/{id}")
    @ApiOperation("修改回显")
    public ServerResponse findProduct(@PathVariable Integer id){
        return productService.findProduct(id);
    }

    /**
     * 修改
     */
    @PutMapping("/products")
    @ApiOperation("修改")
    public ServerResponse updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    /**
     * 批量删除
     * @return
     */
    @DeleteMapping ("/products")
    @ApiOperation("批量修改")
    public ServerResponse deleteMany(String ids){
        return productService.deleteMany(ids);
    }


}

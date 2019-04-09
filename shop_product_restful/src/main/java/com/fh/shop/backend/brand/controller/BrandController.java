package com.fh.shop.backend.brand.controller;


import com.fh.shop.backend.brand.biz.IBrandService;
import com.fh.shop.backend.common.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/")
@Api(tags = "品牌接口") //swagger分类标题注解
public class BrandController {

    @Resource(name="brandService")
    private IBrandService brandService;

    /**
     * 品牌查看
     * @return
     */
    @GetMapping("/brands")
    @ApiOperation("品牌查看")
    public ServerResponse findBrandList(){
        ServerResponse brandList = brandService.findBrandList();
        return brandList;
    }




}

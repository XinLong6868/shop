package com.fh.shop.app.brand.controller;

import com.fh.shop.app.brand.biz.IBrandService;
import com.fh.shop.app.common.ServerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/app/")
public class BrandController {
    @Resource(name="brandService")
    private IBrandService brandService;
    /**
     * 品牌查看
     * @return
     */
    @PostMapping("findBrandList")
    public ServerResponse findBrandList(){
        return brandService.findBrandList();
    }


}

package com.fh.shop.api.brand.controller;

import com.fh.shop.api.brand.biz.IBrandService;
import com.fh.shop.api.brand.po.Brand;
import com.fh.shop.api.common.ServerResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class BrandController {

    @Resource(name = "iBrandService")
    private IBrandService iBrandService;

    /**
     * 查询
     * @return
     */
    @GetMapping("/brands")
    public ServerResponse findBrandList(){
        return iBrandService.findBrandList();
    }

    /**
     * 增加
     * @param brand
     * @return
     */
    @PostMapping("/brands")
    public ServerResponse addBrand(@RequestBody Brand brand){
        return iBrandService.addBrand(brand);
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/brands/{id}")
    public ServerResponse deleteBrand(@PathVariable Integer id){
        return iBrandService.deleteBrand(id);
    }

    /**
     * 修改
     * @param brand
     * @return
     */
    @PutMapping("/brands")
    public ServerResponse updateBrand(@RequestBody Brand brand){
        return iBrandService.updateBrand(brand);
    }
}

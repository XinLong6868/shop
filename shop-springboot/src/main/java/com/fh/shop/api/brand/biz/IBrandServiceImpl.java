package com.fh.shop.api.brand.biz;

import com.fh.shop.api.brand.mapper.IBrandMapper;
import com.fh.shop.api.brand.po.Brand;
import com.fh.shop.api.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DELL
 * @title: IBrandServiceImpl
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/4/218:43
 */
@Service("iBrandService")
public class IBrandServiceImpl implements IBrandService{

    @Autowired
    private IBrandMapper iBrandMapper;

    @Override
    public ServerResponse findBrandList() {
        List<Brand>list = iBrandMapper.findBrandList();
        return ServerResponse.success(list);
    }

    @Override
    public ServerResponse deleteBrand(Integer id) {
        iBrandMapper.deleteBrand(id);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse addBrand(Brand brand) {
        iBrandMapper.addBrand(brand);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse updateBrand(Brand brand) {
        iBrandMapper.updataBrand(brand);
        return ServerResponse.success();
    }

}

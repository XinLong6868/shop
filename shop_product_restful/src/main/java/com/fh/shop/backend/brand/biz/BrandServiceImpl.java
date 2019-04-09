package com.fh.shop.backend.brand.biz;


import com.fh.shop.backend.brand.mapper.IBrandMapper;
import com.fh.shop.backend.brand.po.Brand;
import com.fh.shop.backend.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("brandService")
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandMapper brandMapper;

    /**
     * 品牌查看
     * @return
     */
    public ServerResponse findBrandList() {
       List<Brand> brandList = brandMapper.findBrandList();
        return ServerResponse.success(brandList);
    }


}

package com.fh.shop.api.brand.biz;


import com.fh.shop.api.brand.po.Brand;
import com.fh.shop.api.common.ServerResponse;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IBrandService {

    ServerResponse findBrandList();

    ServerResponse deleteBrand(Integer id);

    ServerResponse addBrand(Brand brand);

    ServerResponse updateBrand(Brand brand);
}

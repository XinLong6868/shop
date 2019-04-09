package com.fh.shop.api.brand.mapper;

import com.fh.shop.api.brand.po.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author DELL
 * @title: IBrandMapper
 * @projectName shop-1808-Xinlong
 * @description: TODO
 * @date 2019/4/218:52
 */
public interface IBrandMapper {

    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "brandName", property = "brandName")
    })
    /**
     * 查询
     */
    @Select("select id,brandName from t_brand")
    List<Brand> findBrandList();

    /**
     * 删除
     * @param id
     */
    @Delete("delete from t_brand where id = #{v}")
    void deleteBrand(Integer id);

    /**
     * 增加
     * @param brand
     */
    @Insert("insert into t_brand (brandName) values (#{brandName})")
    void addBrand(Brand brand);

    /**
     * 修改
     * @param brand
     */
    @Update("update t_brand set brandName=#{brandName} where id=#{id}")
    void updataBrand(Brand brand);
}

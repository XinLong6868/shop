
package com.fh.shop.backend.mapper.brand;

import java.util.List;

import com.fh.shop.backend.po.brand.Brand;


public interface BrandMapper {


	public Long queryCount(Brand brand);


	public List<Brand> queryBrandList(Brand brand);


	public void addBrand(Brand brand);

	public void deleteProduct(Integer id);


	public Brand toUpdateBrand(Integer id);


	public void updateBrand(Brand brand);


	public void deleteAll(List idList);


	public List<Brand> brandList();

    List<Brand> findBrandList(Brand brand);
}

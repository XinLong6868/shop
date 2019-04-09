package com.fh.shop.backend.mapper.brand;



import java.util.List;

import com.fh.shop.backend.po.brand.BrandText;

public interface IBrandMapper {

	public void addBrand(BrandText brandText);

	public List<BrandText> listBrand(BrandText brandText);

	public void deleteBrandID(Integer id);

	public BrandText findbrand(Integer id);

	public void updateBrandText(BrandText brandText);

	public Long findBrandListCount(BrandText brandText);

	public void deleteBatchBrand(List<Integer> idList);

	public List<BrandText> findBradTextList();



}

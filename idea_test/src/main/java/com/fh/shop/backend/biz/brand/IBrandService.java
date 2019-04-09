package com.fh.shop.backend.biz.brand;

import java.util.List;

import com.fh.shop.backend.po.brand.BrandText;

public interface IBrandService {
	
	public void addBrand(BrandText brandText);

	public List<BrandText> listBrand(BrandText brandText);

	public void deleteBrandID(Integer id);

	public BrandText findbrand(Integer id);

	public void updateBrandText(BrandText brandText);

	public Long findBrandListCount(BrandText brandText);

	public void deleteBatchBrand(String ids);
	//商品表的添加+品牌2

	public List<BrandText> findBradTextList();

}

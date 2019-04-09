/** 
 * <pre>项目名称:shop_admin_v1 
 * 文件名称:BrandServiceImpl.java 
 * 包名:com.fh.shop.backend.biz.brand.impl 
 * 创建日期:2018年12月23日下午8:04:19 
 * Copyright (c) 2018, 1328055490@qq.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.biz.brand.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.fh.shop.backend.biz.brand.IBrandService;
import com.fh.shop.backend.mapper.brand.BrandMapper;
import com.fh.shop.backend.po.brand.Brand;
import com.fh.shop.backend.util.DateUtils;

/** 
 * <pre>项目名称：shop_admin_v1    
 * 类名称：BrandServiceImpl    
 * 类描述：    
 * 创建人：陈泽冉 1328055490@qq.com    
 * 创建时间：2018年12月23日 下午8:04:19    
 * 修改人：陈泽冉 1328055490@qq.com     
 * 修改时间：2018年12月23日 下午8:04:19    
 * 修改备注：       
 * @version </pre>    
 */
@Service("brandService")
public class BrandServiceImpl implements IBrandService{

	@Resource
	private BrandMapper brandMapper;
	/* (non-Javadoc)    
	 * @see com.fh.shop.backend.biz.brand.IBrandService#queryCount(com.fh.shop.backend.po.brand.Brand)    
	 */
	@Override
	public Long queryCount(Brand brand) {
		return brandMapper.queryCount(brand);
	}
	/* (non-Javadoc)    
	 * @see com.fh.shop.backend.biz.brand.IBrandService#queryBrandList(com.fh.shop.backend.po.brand.Brand)    
	 */
	@Override
	public List<Brand> queryBrandList(Brand brand) {
		return brandMapper.queryBrandList(brand);
	}
	/* (non-Javadoc)    
	 * @see com.fh.shop.backend.biz.brand.IBrandService#addBrand(com.fh.shop.backend.po.brand.Brand)    
	 */
	@Override
	public void addBrand(Brand brand) {
		brand.setCreateTime(DateUtils.getDateNow());
		brand.setUpdateTime(DateUtils.getDateNow());
		brandMapper.addBrand(brand);
	}
	/* (non-Javadoc)    
	 * @see com.fh.shop.backend.biz.brand.IBrandService#deleteProduct(java.lang.Integer)    
	 */
	@Override
	public void deleteProduct(Integer id) {
		brandMapper.deleteProduct(id);
	}
	/* (non-Javadoc)    
	 * @see com.fh.shop.backend.biz.brand.IBrandService#updateBrand(java.lang.Integer)    
	 */
	@Override
	public Brand toUpdateBrand(Integer id) {
		return brandMapper.toUpdateBrand(id);
	}
	/* (non-Javadoc)    
	 * @see com.fh.shop.backend.biz.brand.IBrandService#updateBrand(com.fh.shop.backend.po.brand.Brand)    
	 */
	@Override
	public void updateBrand(Brand brand) {
		brand.setUpdateTime(DateUtils.getDateNow());
		brandMapper.updateBrand(brand);
	}
	/* (non-Javadoc)    
	 * @see com.fh.shop.backend.biz.brand.IBrandService#deleteAll(java.lang.String)    
	 */
	@Override
	public void deleteAll(String ids) {
		if(StringUtils.isNotEmpty(ids)){
			List idList=new ArrayList();
			String[] idsArr= ids.split(",");
			for (String id : idsArr) {
				idList.add(id);
			}
			brandMapper.deleteAll(idList);
		}
	}
	/* (non-Javadoc)    
	 * @see com.fh.shop.backend.biz.brand.IBrandService#brandList()    
	 */
	@Override
	public List<Brand> brandList() {
		return brandMapper.brandList();
	}

	@Override
	public List<Brand> findBrandList(Brand brand) {
		return brandMapper.findBrandList(brand);
	}

}

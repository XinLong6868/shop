package com.fh.shop.backend.biz.brand;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.shop.backend.biz.DateUtils;
import com.fh.shop.backend.mapper.brand.IBrandMapper;
import com.fh.shop.backend.po.brand.BrandText;
@Service("iBrandService")
public class IBrandServiceImpl implements IBrandService{
	@Autowired
	private IBrandMapper iBrandMapper;
	@Override
	public void addBrand(BrandText brandText) {
		brandText.setUpdateBrandTime(DateUtils.getDateNow());
		brandText.setCreateBrandTime(DateUtils.getDateNow());
		iBrandMapper.addBrand(brandText);
	}

	@Override
	public List<BrandText> listBrand(BrandText brandText) {
		
		return iBrandMapper.listBrand(brandText);
	}

	@Override
	public void deleteBrandID(Integer id) {
		iBrandMapper.deleteBrandID(id);
	}

	@Override
	public BrandText findbrand(Integer id) {
		
		return iBrandMapper.findbrand(id);
	}

	@Override
	public void updateBrandText(BrandText brandText) {
		brandText.setUpdateBrandTime(DateUtils.getDateNow());
		brandText.setCreateBrandTime(DateUtils.getDateNow());
		iBrandMapper.updateBrandText(brandText);
	}

	@Override
	public Long findBrandListCount(BrandText brandText) {
		Long count=iBrandMapper.findBrandListCount(brandText);
		return count;
	}

	@Override
	public void deleteBatchBrand(String ids) {
		if(StringUtils.isNotEmpty(ids)){
			List<Integer>idList=new ArrayList<Integer>();
			String[]idArr=ids.split(",");
			for (String id: idArr) {
				idList.add(Integer.parseInt(id));
			}
			iBrandMapper.deleteBatchBrand(idList);
		}
	}


	@Override
	public List<BrandText> findBradTextList() {
		List<BrandText>branList=iBrandMapper.findBradTextList();
		return branList;
	}

}

package com.fh.shop.backend.biz.brand;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.fh.shop.backend.util.RedisPool;
import com.fh.shop.backend.util.RedisUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

	/**
	 * 增加
	 * @param brandText
	 */
	@Override
	public void addBrand(BrandText brandText) {
		brandText.setUpdateBrandTime(DateUtils.getDateNow());
		brandText.setCreateBrandTime(DateUtils.getDateNow());
		iBrandMapper.addBrand(brandText);
	}

	/**
	 * 查询
	 * @param brandText
	 * @return
	 */
	@Override
	public List<BrandText> listBrand(BrandText brandText) {

		return iBrandMapper.listBrand(brandText);
	}

	/**
	 * 删除
	 * @param id
	 */
	@Override
	public void deleteBrandID(Integer id) {
		iBrandMapper.deleteBrandID(id);
	}

	/**
	 * 回显
	 * @param id
	 * @return
	 */
	@Override
	public BrandText findbrand(Integer id) {
		
		return iBrandMapper.findbrand(id);
	}

	/**
	 * 修改
	 * @param brandText
	 */
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

	/**
	 * 批量删除
	 * @param ids
	 */
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

	/**
	 * 下拉列表框查询+redis缓存
	 * @return
	 */
	@Override
	public List<BrandText> findBradTextList() {

		String branListInfo = RedisUtil.get("branList");
        Gson gson = new Gson();
		if (StringUtils.isEmpty(branListInfo)){
            List<BrandText>branList=iBrandMapper.findBradTextList();

            String branListJson = gson.toJson(branList);
            RedisUtil.set("branList",branListJson);
            return branList;
        }else {
            Type type = new TypeToken<List<BrandText>>() {
            }.getType();
            List<BrandText> branList = gson.fromJson(branListInfo, type);
            return branList;
        }

	}

}

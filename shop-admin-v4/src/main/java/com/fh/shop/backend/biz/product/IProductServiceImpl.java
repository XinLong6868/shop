package com.fh.shop.backend.biz.product;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.shop.backend.biz.DateUtils;
import com.fh.shop.backend.mapper.product.IProductMapper;
import com.fh.shop.backend.po.product.Product;
@Service("iProductService")
public class IProductServiceImpl implements IProductService{
		@Autowired
		private IProductMapper iProductMapper;
	/**
	 * 
	 * <pre>项目名称：接口实现层   
	 * 类名称：IProductServiceImpl    
	 * 类描述：    
	 * 创建人：辛龙       2427776882@qq.com    
	 * 创建时间：2018年12月23日 下午7:08:47    
	 * 修改人：辛龙       2427776882@qq.com     
	 * 修改时间：2018年12月23日 下午7:08:47    
	 * 修改备注：       
	 * @version </pre>
	 */
	//<bean id="iProductServiceImpl" class="com.fh.shop.backend.biz.product.IProductServiceImpl"/>
				/**
				 * 增加
				 */
				@Override
				public void addProduct(Product product) {
					product.setUpdateTime(DateUtils.getDateNow());
					product.setCreateTime(DateUtils.getDateNow());
					iProductMapper.addProduct(product);
				}
				/**
				 *查询
				 */
				@Override
				public List<Product> listProduct(Product product) {
					
					return iProductMapper.listProduct(product);
				}
				/**
				 * 单个删除
				 */
				@Override
				public void deleteProductID(Integer id) {
					iProductMapper.deleteProductID(id);
				}
				/**
				 * 批量删除
				 */
				@Override
				public void deleteBatchProduct(String ids) {
					if(StringUtils.isNotEmpty(ids)){
						List<Integer>idList=new ArrayList<>();
						String[]idArr=ids.split(",");
						for (String id: idArr) {
							idList.add(Integer.parseInt(id));
						}
						iProductMapper.deleteBatchProduct(idList);
					}
				}
				/**
				 * 回填
				 */
				@Override
				public Product findproduct(Integer id) {
					Product product=iProductMapper.findproduct(id);
					return product;
				}
				/**
				 * 修改
				 */
				@Override
				public void updateProduct(Product product) {
					iProductMapper.updateProduct(product);
				}
				/**
				 * 开始 分页
				 */
				@Override
				public Long findProductListCount(Product product) {
					Long count=iProductMapper.findProductListCount(product);
					return count;
				}
				
}

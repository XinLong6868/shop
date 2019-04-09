package com.fh.shop.backend.biz.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
				@Override
				public void addProduct(Product product) {
					System.out.println(product.getProductName());
					iProductMapper.addProduct(product);
				}
}

package com.fh.shop.backend.biz.product;

import java.util.List;

import com.fh.shop.backend.po.product.Product;
/**
 * 
 * 接口  
 * 类名称：IProductService    
 * 类描述：    
 * 创建人：辛龙       2427776882@qq.com    
 * 创建时间：2018年12月23日 下午7:06:20    
 * 修改人：辛龙       2427776882@qq.com     
 * 修改时间：2018年12月23日 下午7:06:20    
 * 修改备注：       
 * @version </pre>
 */
//<bean id="iProductService" class="com.fh.shop.backend.biz.product.IProductService"/>
public interface IProductService {
			public void addProduct(Product product);

			public List<Product> findProduct();

			public void deleateProduct(Integer id);

			public void deleateProductAll(String ids);

}

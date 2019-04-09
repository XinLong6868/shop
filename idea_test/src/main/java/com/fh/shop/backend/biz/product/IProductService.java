package com.fh.shop.backend.biz.product;

import java.util.List;
import java.util.Map;

import com.fh.shop.backend.api.product.ProductVoApi;
import com.fh.shop.backend.common.DataTableResult;
import com.fh.shop.backend.po.product.Product;
import com.fh.shop.backend.vo.productVo.ProductVo;

public interface IProductService {
	public  DataTableResult buildProductDataTable(Integer start, Integer length, Integer draw, Product product, Map<String, String[]> parameterMap);
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
	
				public void addProduct(Product product);

				public void deleteProductID(Integer id);

				public void deleteBatchProduct(String ids);

				public Product findproduct(Integer id);

				public void updateProduct(Product product);

				public Long findProductListCount(Product product);

				public List<Product> listProduct(Product product);

				public List<Product> findProductList(Product product);

    			public  Integer selectMaxId();

				/**
				 * 普通接口
				 * @return
				 */

    			List<ProductVoApi> findAllProductList();
}

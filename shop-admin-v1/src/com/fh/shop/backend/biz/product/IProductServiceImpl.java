package com.fh.shop.backend.biz.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.shop.backend.mapper.product.IProductMapper;
import com.fh.shop.backend.po.product.Product;
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
@Service("iProductService")
public class IProductServiceImpl implements IProductService{
			@Autowired
			private IProductMapper iProductMapper;
			@Override
			public void addProduct(Product product) {
				System.out.println(product.getProductName());
				iProductMapper.addProduct(product);
			}
			@Override
			public List<Product> findProduct() {
				
				return iProductMapper.findProduct();
			}
			@Override
			public void deleateProduct(Integer id) {
				iProductMapper.deleateProduct(id);
			}
			@Override
			public void deleateProductAll(String ids) {
				if(StringUtils.isNotEmpty(ids)){
					List<Integer>idList=new ArrayList<>();
					String[] idArr = ids.split(",");
					for (String id : idArr) {
						idList.add(Integer.parseInt(id));
					}
					iProductMapper.deleateProductAll(idList);
				}
			}
			

}

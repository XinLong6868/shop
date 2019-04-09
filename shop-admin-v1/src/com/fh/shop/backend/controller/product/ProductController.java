package com.fh.shop.backend.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fh.shop.backend.biz.product.IProductService;
import com.fh.shop.backend.po.product.Product;

@Controller
//<bean id="productController" class="com.fh.shop.backend.controller.product.ProductController">
public class ProductController {
			@Autowired
			@Qualifier("iProductService")
			private IProductService iProductService;
			/**
			 * <pre>toAddProduct(跳转到增加页面)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月23日 下午6:40:29    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月23日 下午6:40:29    
			 * 修改备注： 
			 * @return</pre>
			 */
	
			@RequestMapping("/product/toAddProduct")
			public String toAddProduct(){
				return "product/add";
			}
			/**
			 * <pre>add(增加方法,增加完后跳转到)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月23日 下午6:46:27    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月23日 下午6:46:27    
			 * 修改备注： 
			 * @param product
			 * @return</pre>
			 */
			@RequestMapping("/product/add")
			public String add(Product product){
				System.out.println(product.getProductName()+":"+product.getPrivace());
				iProductService.addProduct(product);
				return "redirect:/product/toList.action";
			}
			/**
			 * <pre>toListproduct(跳查询)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月25日 下午2:31:15    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月25日 下午2:31:15    
			 * 修改备注： 
			 * @return</pre>
			 */
			@RequestMapping("/product/toList")
			public String toListproduct(){
				return "product/list";
			}
			/**
			 * <pre>findProduct(查询方法)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月25日 下午2:31:34    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月25日 下午2:31:34    
			 * 修改备注： 
			 * @return</pre>
			 */
			@RequestMapping("findProduct")
			@ResponseBody
			public List<Product> findProduct(){
				List<Product> listProduct=iProductService.findProduct();
				return listProduct;
			}
			/**
			 * <pre>deleateProduct(单个删除)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月25日 下午2:17:06    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月25日 下午2:17:06    
			 * 修改备注： 
			 * @param id
			 * @return</pre>
			 */
			@RequestMapping("deleateProduct")
			@ResponseBody
			public void deleateProduct(Integer id){
				iProductService.deleateProduct(id);
			}
			/**
			 * <pre>deleateProductAll(批量删除)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月25日 下午9:29:33    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月25日 下午9:29:33    
			 * 修改备注： 
			 * @param ids</pre>
			 */
			@RequestMapping("deleateProductAll")
			@ResponseBody
			public String deleateProductAll(String ids){
				iProductService.deleateProductAll(ids);
				return "product/list";
			}
}

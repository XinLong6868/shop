package com.fh.shop.backend.controller.product;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
/**
 * 
 * <pre>项目名称：shop-admin-v2    
 * 类名称：ProductController    
 * 类描述：    
 * 创建人：辛龙       2427776882@qq.com    
 * 创建时间：2018年12月23日 下午8:23:00    
 * 修改人：辛龙       2427776882@qq.com     
 * 修改时间：2018年12月23日 下午8:23:00    
 * 修改备注：       
 * @version </pre>
 */
//<bean id="productController" class="com.fh.shop.backend.controller.product.ProductController">
import org.springframework.web.bind.annotation.RequestMapping;

import com.fh.shop.backend.biz.product.IProductService;
import com.fh.shop.backend.po.product.Product;
@Controller
public class ProductController {
			@Autowired
			@Qualifier("iProductService")
			private IProductService iProductService;
			/**
			 * <pre>toAddProduct(跳转到增加页面)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月23日 下午8:27:44    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月23日 下午8:27:44    
			 * 修改备注： 
			 * @return</pre>
			 */
			@RequestMapping("/product/toAddProduct")
			public String toAddProduct(){
				return "product/addProduct";
			}
			/**
			 * <pre>addProduct(增加后跳转到查询页面)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月23日 下午8:30:09    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月23日 下午8:30:09    
			 * 修改备注： 
			 * @param product
			 * @return</pre>
			 */
			@RequestMapping("/product/addProduct")
			public String addProduct(Product product,HttpServletRequest request,String productName,Float productPrivace){
				System.out.println(product.getProductName()+":"+product.getProductPrivace());
				System.out.println(request.getParameter("productName")+":"+request.getParameter("productPrivace"));
				System.out.println(productName+":"+productPrivace);
				iProductService.addProduct(product);
				return "product/productList";
			}
}

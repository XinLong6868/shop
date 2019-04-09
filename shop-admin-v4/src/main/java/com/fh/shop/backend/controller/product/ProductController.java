package com.fh.shop.backend.controller.product;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.shop.backend.biz.brand.IBrandService;
import com.fh.shop.backend.biz.product.IProductService;
import com.fh.shop.backend.controller.BaseController;
import com.fh.shop.backend.po.brand.BrandText;
import com.fh.shop.backend.po.product.Product;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
public class ProductController extends BaseController{
			@Autowired
			@Qualifier("iProductService")
			private IProductService iProductService;
			@Autowired
			@Qualifier("iBrandService")
			private IBrandService iBrandService;
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
			public String toAddProduct(ModelMap map){
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
			public String addProduct(Product product){
				iProductService.addProduct(product);
				return "redirect:/product/list.action";
			}
			/**
			 * <pre>listProduct(普通查询)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月25日 下午3:35:53    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月25日 下午3:35:53    
			 * 修改备注： 
			 * @param map
			 * @return</pre>
			 */
			@RequestMapping("product/list")
			public String listProduct(ModelMap map,Product product,Integer flag){
				//获取总条数
				Long totalCount=iProductService.findProductListCount(product);
				//设置总条数
				product.setTotalCount(totalCount);
				//计算分页信息
				product.calculatePage();
				//获取分页列表
				List<Product> findProduct= iProductService.listProduct(product);
				
				//给page赋值
				map.put("page",product);
				map.put("findProduct", findProduct);
				
				if(flag==null){
					//跳转到主页面
					return "product/list";
				}else{
					//跳转到子页面
					return "product/productPage";
				}
			}
			/**
			 * <pre>deleteProductID(单个删除)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月26日 下午3:35:14    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月26日 下午3:35:14    
			 * 修改备注： 
			 * @param id</pre>
			 */
			@RequestMapping("deleteProductID")
			@ResponseBody
			public Map deleteProductID(Integer id,HttpServletResponse response){
				iProductService.deleteProductID(id);
				Map result=new HashMap<>();
				result.put("status", "ok");
				result.put("code",200);
				return result;
			}
			/**
			 * <pre>通过这个main方法来查看json与java对象之间的相互转化
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2019年1月9日 下午3:14:21    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2019年1月9日 下午3:14:21    
			 * 修改备注： 
			 * @param args</pre>
			 */
			/*public static void main(String[] args) {
				BrandText brand=new BrandText();
				brand .setId(1);
				brand.setBrandName("华为");
				
				BrandText brand1=new BrandText();
				brand1 .setId(1);
				brand1.setBrandName("华为1");
				
				List<BrandText>list=new ArrayList<>();
				list.add(brand);
				list.add(brand1);
				
				Map resutMap=new HashMap<>();
				resutMap.put("code",200);
				resutMap.put("ststus","ojbk");
				resutMap.put("data", list);*/
				//json转化
				/*[
				 {"data":
					 [
					  {"brandName":"华为","id":1},
					  {"brandName":"华为1","createBrandTime":null,"endPos":0,"id":1,"maxcreateBrandTime":null,"mincreateBrandTime":null,"pageCount":0,"pageIndex":1,"pageSize":5,"startPos":0,"totalCount":0,"updateBrandTime":null}],
				  "ststus":"ojbk",
				  "code":200}
				 ]*/
				/*String result = JSONArray.fromObject(resutMap).toString();
				System.out.println(result);
			}*/
			/**
			 * <pre>deleteBatchProduct(批量删除)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月26日 下午3:38:24    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月26日 下午3:38:24    
			 * 修改备注： 
			 * @param ids
			 * @return</pre>
			 */
			@RequestMapping("deleteBatchProduct")
			public void deleteBatchProduct(String ids,HttpServletResponse response){
				Map result=new HashMap<>();
				iProductService.deleteBatchProduct(ids);
				result.put("status", "ok");
				//将Java对象转换成json格式的字符串json-lib
				String json = JSONObject.fromObject(result).toString();
				//向客户端发出响应
				outJson(json, response);			
			}
			/**
			 * <pre>findproduct(回填)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月26日 下午9:02:52    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月26日 下午9:02:52    
			 * 修改备注： 
			 * @param id
			 * @return</pre>
			 */
			@RequestMapping("findproduct")
			public ModelAndView findproduct(Integer id,ModelMap map){
				ModelAndView modelAndView = new ModelAndView("product/update");
				Product product=iProductService.findproduct(id);
				modelAndView.addObject("product",product);
				return modelAndView;
			}
			/**
			 * <pre>updateProduct(修改)   
			 * 创建人：辛龙       2427776882@qq.com    
			 * 创建时间：2018年12月26日 下午9:06:11    
			 * 修改人：辛龙       2427776882@qq.com     
			 * 修改时间：2018年12月26日 下午9:06:11    
			 * 修改备注： 
			 * @param product
			 * @return</pre>
			 */
			@RequestMapping("/product/updateProduct")
			public String updateProduct(Product product){
				iProductService.updateProduct(product);
				//修改完后重定向到查询展示界面
				return "redirect:/product/list.action";
			} 
}

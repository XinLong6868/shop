package com.fh.shop.backend.controller.brand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.shop.backend.biz.brand.IBrandService;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.controller.BaseController;
import com.fh.shop.backend.po.brand.BrandText;

import net.sf.json.JSONObject;
@Controller
public class BrandController extends BaseController{
		//配置日志
		//LoggerFactory.getLogger(BrandController.class)导入slf4j的包
		//Logger导入slf4j的包
		private static final Logger LOG = LoggerFactory.getLogger(BrandController.class);
		
		@Autowired
		@Qualifier("iBrandService")
		private IBrandService iBrandService;
		/**
		 * <pre>toAddBrand(跳转到增加页面)   
		 * 创建人：辛龙       2427776882@qq.com    
		 * 创建时间：2018年12月27日 下午7:05:48    
		 * 修改人：辛龙       2427776882@qq.com     
		 * 修改时间：2018年12月27日 下午7:05:48    
		 * 修改备注： 
		 * @return</pre>
		 */
		@RequestMapping("/brand/toAddBrand")
		public String toAddBrand(){
			return "brand/addBrand";
		}
		/**
		 * <pre>addBrand(通过走增加方法，添加完成后跳转到查询界面,普通增加通过a标签的形式来进行跳转)   
		 * 创建人：辛龙       2427776882@qq.com    
		 * 创建时间：2018年12月27日 下午7:09:15    
		 * 修改人：辛龙       2427776882@qq.com     
		 * 修改时间：2018年12月27日 下午7:09:15    
		 * 修改备注： 
		 * @param brandText
		 * @return</pre>
		 *
		 */
		
		/*@RequestMapping("/brand/addBrand")
		public String addBrand(BrandText brandText){
			iBrandService.addBrand(brandText);
			return "redirect:/brand/listBrand.action";
		}*/
		/***
		 * <pre>addBrand(ajax增加,通过ajax的形式进行ajax增加提交)   
		 * 创建人：辛龙       2427776882@qq.com    
		 * 创建时间：2019年1月15日 下午9:34:49    
		 * 修改人：辛龙       2427776882@qq.com     
		 * 修改时间：2019年1月15日 下午9:34:49    
		 * 修改备注： 
		 * @param brandText
		 * @return</pre>
		 */
		@RequestMapping("/brand/addBrand")
		@ResponseBody
		public ServerResponse addBrand(BrandText brandText){
			try {
				iBrandService.addBrand(brandText);
				return ServerResponse.success();
			} catch (Exception e) {
				e.printStackTrace();
				return ServerResponse.error();
			}
		}
		/**
		 * <pre>listBrand(通过查询方法来进行跳转到查询页面)   
		 * 创建人：辛龙       2427776882@qq.com    
		 * 创建时间：2018年12月28日 下午1:58:42    
		 * 修改人：辛龙       2427776882@qq.com     
		 * 修改时间：2018年12月28日 下午1:58:42    
		 * 修改备注： 
		 * @param map
		 * @return</pre>
		 */
		@RequestMapping("/brand/listBrand")
		public String listBrand(ModelMap map,BrandText brandText,Integer flag){
			//获取总条数
			Long totalCount=iBrandService.findBrandListCount(brandText);
			//设置总条数
			brandText.setTotalCount(totalCount);
			//计算分页信息
			brandText.calculatePage();
			//获取分页列表
			List<BrandText> findBrand=iBrandService.listBrand(brandText);
			//给page赋值
			map.put("page",brandText);
			map.put("findBrand",findBrand);
			if(flag==null){
				//跳转到主页面
				return "brand/listBrand";
			}else{
				//跳转到子页面
				return "brand/brandPage";
			}
			
		}
		/**
		 * <pre>deleteBrandID(单个删除)   
		 * 创建人：辛龙       2427776882@qq.com    
		 * 创建时间：2018年12月28日 下午2:16:31    
		 * 修改人：辛龙       2427776882@qq.com     
		 * 修改时间：2018年12月28日 下午2:16:31    
		 * 修改备注： 
		 * @param id
		 * @param response</pre>
		 */
		@RequestMapping("deleteBrandID")
		public void deleteBrandID(Integer id,HttpServletResponse response){
			Map result=new HashMap<String,Object>();
			iBrandService.deleteBrandID(id);
			result.put("stuts","okk");
			//将Java对象转换成json格式的字符串json-lib
			String json = JSONObject.fromObject(result).toString();
			//向客户端发送响应
			outJson(json, response);
		}
		/**
		 * <pre>deleteBatchBrand(批量删除)   
		 * 创建人：辛龙       2427776882@qq.com    
		 * 创建时间：2018年12月28日 下午10:17:13    
		 * 修改人：辛龙       2427776882@qq.com     
		 * 修改时间：2018年12月28日 下午10:17:13    
		 * 修改备注： </pre>
		 */
		@RequestMapping("deleteBatchBrand")
		public void deleteBatchBrand(String ids,HttpServletResponse response){
			Map<String,Object> result=new HashMap<String,Object>();
			iBrandService.deleteBatchBrand(ids);
			result.put("status", "ok");
			//将Java对象转换成json格式的字符串json-lib
			String json = JSONObject.fromObject(result).toString();
			//向客户端发出响应
			outJson(json, response);	
		}
		/**
		 * <pre>findbrand(回填)   
		 * 创建人：辛龙       2427776882@qq.com    
		 * 创建时间：2018年12月28日 下午2:24:13    
		 * 修改人：辛龙       2427776882@qq.com     
		 * 修改时间：2018年12月28日 下午2:24:13    
		 * 修改备注： 
		 * @return</pre>
		 */
		@RequestMapping("findbrand")
		public ModelAndView findbrand(Integer id){
			ModelAndView modelAndView=new ModelAndView("brand/updateBrand");
			BrandText brandText=iBrandService.findbrand(id);
			modelAndView.addObject("brandText",brandText);
			return modelAndView;
		}
		/**
		 * <pre>updateBrandText(普通修改)   
		 * 创建人：辛龙       2427776882@qq.com    
		 * 创建时间：2018年12月28日 下午2:34:58    
		 * 修改人：辛龙       2427776882@qq.com     
		 * 修改时间：2018年12月28日 下午2:34:58    
		 * 修改备注： 
		 * @return</pre>
		 */
		/*@RequestMapping("/brand/updateBrandText")
		public String updateBrandText(BrandText brandText){
			iBrandService.updateBrandText(brandText);
			return "redirect:/brand/listBrand.action";
		}*/
		/**
		 * <pre>updateBrandText(同一个页面做修改，ajax)   
		 * 创建人：辛龙       2427776882@qq.com    
		 * 创建时间：2019年1月22日 下午3:01:27    
		 * 修改人：辛龙       2427776882@qq.com     
		 * 修改时间：2019年1月22日 下午3:01:27    
		 * 修改备注： 
		 * @param brandText
		 * @return</pre>
		 */
		@RequestMapping("/brand/updateBrandText")
		@ResponseBody
		public ServerResponse updateBrandText(BrandText brandText){
			LOG.info("进入com.fh.shop.backend.controller.brand.BrandController的updateBrandText()");
			try {
				iBrandService.updateBrandText(brandText);
				LOG.info("进入com.fh.shop.backend.controller.brand.BrandController的updateBrandText()成功");
				return ServerResponse.success();
			} catch (Exception e) {
				e.printStackTrace();
				LOG.info("进入com.fh.shop.backend.controller.brand.BrandController的updateBrandText()失败"+e.getMessage());
				return ServerResponse.error();
			}
		}
		/***
		 * <pre>下拉列表框查询 2  (ajax)
		 * 创建人：辛龙       2427776882@qq.com    
		 * 创建时间：2019年1月11日 下午1:58:10    
		 * 修改人：辛龙       2427776882@qq.com     
		 * 修改时间：2019年1月11日 下午1:58:10    
		 * 修改备注： 
		 * @return</pre>
		 * 给查询的下拉列表框配置日志记录
		 */
		@RequestMapping("/brand/list")
		@ResponseBody
		public ServerResponse list(){
				List<BrandText>brandListto=iBrandService.findBradTextList();
				return ServerResponse.success(brandListto);
		}
		
}

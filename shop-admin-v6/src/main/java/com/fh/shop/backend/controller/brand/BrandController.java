package com.fh.shop.backend.controller.brand;

import java.util.List;
;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fh.shop.backend.annotation.LogAnnotation;
import com.fh.shop.backend.common.ServerResponseDataTable;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fh.shop.backend.biz.brand.IBrandService;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.controller.BaseController;
import com.fh.shop.backend.po.brand.Brand;

@Controller
@RequestMapping("/brand")
public class BrandController extends BaseController{

	@Resource(name="brandService")
	private IBrandService brandService;

	@RequestMapping("toBueryBrandList")
	public String toBueryBrandList(){

		return "brand/brandList";
	}


	@RequestMapping("queryBrandList")
	@ResponseBody
	public ServerResponse queryBrandList(Brand brand, Integer start, Integer length, Integer draw, HttpServletRequest request){
		String order = request.getParameter("order[0][column]");
		String orderDir = request.getParameter("order[0][dir]");
		String orderName = request.getParameter("columns["+order+"][data]");
		brand.setField(orderName);
		brand.setSort(orderDir);
		brand.setStartPos(start);
		brand.setPageSize(length);
		Long totalCount=brandService.queryCount(brand);
		List<Brand> brandList=brandService.queryBrandList(brand);
        ServerResponseDataTable serverResponseDataTable = ServerResponseDataTable.success(draw, totalCount, totalCount, brandList);
		return ServerResponse.success(serverResponseDataTable);
	}

	@LogAnnotation("品牌添加")
	@RequestMapping("addBrand")
	@ResponseBody
	public ServerResponse addBrand(Brand brand){
			brandService.addBrand(brand);
		return ServerResponse.success();
	}

	@LogAnnotation("品牌删除")
	@RequestMapping("deleteBrand")
	@ResponseBody
	public ServerResponse deleteBrand(Integer id,HttpServletResponse response){
			brandService.deleteProduct(id);
		return ServerResponse.success();
	}

	@LogAnnotation("品牌修改")
	@RequestMapping("updateBrand")
	@ResponseBody
	public ServerResponse updateBrand(Brand brand){
			brandService.updateBrand(brand);
		return ServerResponse.success();
	}

	@LogAnnotation("品牌批量删除")
	@RequestMapping("deleteAll")
	@ResponseBody
	public ServerResponse deleteAll(String ids,HttpServletResponse response){
			brandService.deleteAll(ids);
		return ServerResponse.success();
	}

	@RequestMapping("brandList")
	public @ResponseBody ServerResponse brandList(){
		List<Brand> brandList=brandService.brandList();
		return ServerResponse.success(brandList);
	}

	@RequestMapping("toUpdateBrand")
	@ResponseBody
	public ServerResponse toUpdateBrand(Brand brand){
		Brand brandInfo = brandService.toUpdateBrand(brand.getId());
		return ServerResponse.success(brandInfo);
	}

	@RequestMapping("toBueryBrandJsp")
	public String toBueryBrandJsp(){
		return "brand/brandList";
	}
}

package com.fh.shop.backend.product.biz;


import com.fh.shop.backend.common.DataTableResult;
import com.fh.shop.backend.common.ResponseEnum;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.product.mapper.IProductMapper;
import com.fh.shop.backend.product.po.Product;
import com.fh.shop.backend.product.request.ProductRequest;
import com.fh.shop.backend.product.vo.ProductVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements IProductService {

   @Resource
    private IProductMapper productMapper;

    /**
     * 条件查询
     * @param product
     * @return
     */
    public DataTableResult findProductList(ProductRequest product) {
        //获取总条数
        Long totalCount=productMapper.findProductCount(product);
        //获取商品信息
        List<Product> productList=productMapper.findProductList(product);
        //包装产品vo
        List<ProductVo> ProductVoList = wrapperProductVO(productList);
        //重组数据
        DataTableResult dataTableResult = DataTableResult.dataTableResultData(ProductVoList, product.getDraw(), totalCount, totalCount);
        return  dataTableResult;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public ServerResponse deleteProduct(Integer id) {
        productMapper.deleteProduct(id);
        return ServerResponse.success();
    }

    /**
     * 添加
     * @param product
     * @return
     */
    public ServerResponse addProduct(Product product) {
        Date date = new Date();
        product.setEntryTime(date);
        product.setUpdateTime(date);
        productMapper.addProduct(product);
        return ServerResponse.success();
    }

    /**
     * 修改回显
     * @param id
     * @return
     */
    public ServerResponse findProduct(Integer id) {
        Product product = productMapper.findProduct(id);
        return ServerResponse.success(product);
    }

    /**
     * 修改
     * @param product
     * @return
     */
    public ServerResponse updateProduct(Product product) {
        product.setUpdateTime(new Date());
        productMapper.updateProduct(product);
        return ServerResponse.success();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public ServerResponse deleteMany(String ids) {
        if(StringUtils.isEmpty(ids)){
            return ServerResponse.error(ResponseEnum.PARAMS_IS_ERROR);
        }
        List<Integer> idList = new ArrayList<Integer>();
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            idList.add(Integer.valueOf(id));
        }
        productMapper.deleteMany(idList);

        return ServerResponse.success();
    }

    //包装产品vo
    private List<ProductVo> wrapperProductVO(List<Product> productList) {
        List<ProductVo> ProductVoList = new ArrayList<ProductVo>();
        for (Product productInfo : productList) {
            ProductVo productVo=new ProductVo();
            productVo.setId(productInfo.getId());
            productVo.setProductName(productInfo.getProductName());
            productVo.setProductPrice(productInfo.getProductPrice());
            productVo.setEntryTime(productInfo.getEntryTime());
            productVo.setUpdateTime(productInfo.getUpdateTime());
            productVo.setBrandName(productInfo.getBrand().getBrandName());
            ProductVoList.add(productVo);
        }
        return ProductVoList;
    }




}

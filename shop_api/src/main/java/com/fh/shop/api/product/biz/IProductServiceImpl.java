package com.fh.shop.api.product.biz;

import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.product.mapper.IProductMapper;
import com.fh.shop.api.product.po.Product;
import com.fh.shop.api.product.vo.ProductVoApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("iProductService")
public class IProductServiceImpl implements IProductService {
    /**
     * 调用接口
     * @return
     */
    @Resource
    private IProductMapper iProductMapper;
    @Override
    public ServerResponse findAllProductList() {
        List<Product> allProductList = iProductMapper.findAllProductList();

        List<ProductVoApi> productVoApiList = new ArrayList();
        for (Product Product : allProductList) {
            ProductVoApi productVoApi = new ProductVoApi();
            productVoApi.setId(Product.getId());
            productVoApi.setProductName(Product.getProductName());
            productVoApi.setProductprivace(Product.getProductprivace());
            productVoApi.setProductImagePath(Product.getProductImagePath());
            productVoApiList.add(productVoApi);
        }
        return ServerResponse.success(productVoApiList);
    }
}

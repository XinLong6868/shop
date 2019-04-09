package com.fh.shop.api.product.mapper;

import com.fh.shop.api.product.po.Product;
import java.util.List;

public interface IProductMapper {

	/**
	 * 普通接口查询
	 * @return
	 */
    List<Product> findAllProductList();
}

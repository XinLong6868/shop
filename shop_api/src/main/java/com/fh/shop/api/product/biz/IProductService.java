package com.fh.shop.api.product.biz;


import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.product.vo.ProductVoApi;

import java.util.List;

public interface IProductService {
	/**
	 * 普通接口查询
	 * @return
	 */

	ServerResponse findAllProductList();
}

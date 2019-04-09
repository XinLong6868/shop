package com.fh.shop.backend.mapper.product;

import java.util.List;

import com.fh.shop.backend.po.product.Product;

public interface IProductMapper {

	public void addProduct(Product product);

	public List<Product> findProduct();

	public void deleateProduct(Integer id);

	public void deleateProductAll(List<Integer> idList);

}
